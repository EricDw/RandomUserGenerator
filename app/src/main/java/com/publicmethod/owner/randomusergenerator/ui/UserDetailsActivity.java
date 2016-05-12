package com.publicmethod.owner.randomusergenerator.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.publicmethod.owner.randomusergenerator.R;
import com.publicmethod.owner.randomusergenerator.databinding.ActivityUserDetailsBinding;
import com.publicmethod.owner.randomusergenerator.model.Location;
import com.publicmethod.owner.randomusergenerator.model.Result;
import com.publicmethod.owner.randomusergenerator.utils.UserDetailsClickHandler;

public class UserDetailsActivity extends AppCompatActivity implements UserDetailsClickHandler {

    private static final String TAG = "UserDetailsActivity";

    private Result mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUserDetailsBinding activityUserDetailsBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_user_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get the result from the intent
        mResult = getIntent().getParcelableExtra("result");

        // Bind result
        activityUserDetailsBinding.setResult(mResult);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public String formattedAddress(View view) {
        Location resultLocation = mResult.getLocation();
        return String.format("%s, %s, %s, %s",
                resultLocation.getStreet(),
                resultLocation.getCity(),
                resultLocation.getState(),
                resultLocation.getPostcode());

    }
}
