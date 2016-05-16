package com.publicmethod.owner.randomusergenerator.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.publicmethod.owner.randomusergenerator.R;
import com.publicmethod.owner.randomusergenerator.adapter.RandomResultsRecyclerViewBindingAdapter;
import com.publicmethod.owner.randomusergenerator.model.RandomUserResults;
import com.publicmethod.owner.randomusergenerator.model.Result;
import com.publicmethod.owner.randomusergenerator.utils.RandomUserClient;
import com.publicmethod.owner.randomusergenerator.utils.ServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private RandomResultsRecyclerViewBindingAdapter mRandomResultsRecyclerViewBindingAdapter;
    private ArrayList<Result> mRandomUserResults = new ArrayList<Result>();

    // TODO: 2016-05-12 Implement Data Binding on this class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Set up the stuff
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeCallToRandomUser();
            }
        });


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_contacts);
        mRandomResultsRecyclerViewBindingAdapter = new RandomResultsRecyclerViewBindingAdapter(this);
        mLinearLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mRandomResultsRecyclerViewBindingAdapter);
        mRecyclerView.setHasFixedSize(false);

        // Do the logical

    }

    private void makeCallToRandomUser() {

        // Create the REST adapter which points to the randomuser.me API endpoint.
        RandomUserClient randomUserClient = ServiceGenerator.createService(RandomUserClient.class);


        //Fetch the response
        randomUserClient.multipleResultsCall(20).enqueue(new Callback<RandomUserResults>() {

            @Override
            public void onResponse(Call<RandomUserResults> call, Response<RandomUserResults> response) {
                    mRandomResultsRecyclerViewBindingAdapter.setRandomUserResults(response.body().getResults());
                    mRandomResultsRecyclerViewBindingAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<RandomUserResults> call, Throwable t) {
                Log.d(TAG, "onResponse() called with: " + "call = [" + call + "], response = [" + t + "]");

            }

        });
    }

    private void addResultsToList(List<Result> results) {
        for (int i = 0; i < results.size(); i++) {
            mRandomUserResults.add(results.get(i));
            mRandomResultsRecyclerViewBindingAdapter.notifyItemInserted(i);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // TODO: 2016-05-10 persist list of random users using Firebase offline features
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("results", mRandomUserResults);
        onSaveInstanceState(bundle);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("results", mRandomUserResults);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ArrayList<Result> results = savedInstanceState.getParcelableArrayList("results");
        for (Result result : results) {
            mRandomUserResults.add(result);
            mRandomResultsRecyclerViewBindingAdapter.notifyDataSetChanged();
            Log.d(TAG, "onRestoreInstanceState: " + results.toString());
        }

    }
}
