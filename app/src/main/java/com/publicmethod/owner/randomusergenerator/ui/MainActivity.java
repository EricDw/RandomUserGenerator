package com.publicmethod.owner.randomusergenerator.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.publicmethod.owner.randomusergenerator.R;
import com.publicmethod.owner.randomusergenerator.adapter.RandomResultsRecyclerViewBindingAdapter;
import com.publicmethod.owner.randomusergenerator.databinding.ActivityMainBinding;
import com.publicmethod.owner.randomusergenerator.model.RandomUserResults;
import com.publicmethod.owner.randomusergenerator.utils.RandomUserClient;
import com.publicmethod.owner.randomusergenerator.utils.ServiceGenerator;
import com.publicmethod.owner.randomusergenerator.viewmodels.MainActivityViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private LinearLayoutManager mLinearLayoutManager;
    private static RandomResultsRecyclerViewBindingAdapter mRandomResultsRecyclerViewBindingAdapter;

    // TODO: 2016-05-12 Implement Data Binding on this class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(new MainActivityViewModel(this, null));
        activityMainBinding.setMainActivity(this);
        setSupportActionBar(activityMainBinding.toolbar);

        //Set up recyclerView
        mRandomResultsRecyclerViewBindingAdapter = new RandomResultsRecyclerViewBindingAdapter(this);
        mLinearLayoutManager = new LinearLayoutManager(this);

        activityMainBinding.recyclerViewContacts.setLayoutManager(mLinearLayoutManager);
        activityMainBinding.recyclerViewContacts.setAdapter(mRandomResultsRecyclerViewBindingAdapter);
        activityMainBinding.recyclerViewContacts.setHasFixedSize(false);
    }

    /**
     * Makes a call to randomuser.me then extracts the results and places them into the RandomResultsViewBindingAdapter.
     *
     * @param view Necessary for calling this method from the layout via Data Binding.
     */
    public void makeCallToRandomUser(View view) {

        // Create the REST adapter which points to the randomuser.me API endpoint.
        RandomUserClient randomUserClient = ServiceGenerator.createService(RandomUserClient.class);


        //Fetch the response
        randomUserClient.multipleResultsCall(20).enqueue(new Callback<RandomUserResults>() {

            @Override
            public void onResponse(Call<RandomUserResults> call, Response<RandomUserResults> response) {
                mRandomResultsRecyclerViewBindingAdapter.setRandomUserResults(response.body().getResults());
                mRandomResultsRecyclerViewBindingAdapter.notifyDataSetChanged();
                Log.d(TAG, "onResponse() called with: " + "call = [" + call + "], response = [" + response + "]");
            }

            @Override
            public void onFailure(Call<RandomUserResults> call, Throwable t) {
                Log.d(TAG, "onResponse() called with: " + "call = [" + call + "], response = [" + t + "]");

            }

        });
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
}
