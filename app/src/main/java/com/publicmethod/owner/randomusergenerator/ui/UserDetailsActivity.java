package com.publicmethod.owner.randomusergenerator.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.publicmethod.owner.randomusergenerator.R;
import com.publicmethod.owner.randomusergenerator.databinding.ActivityUserDetailsBinding;
import com.publicmethod.owner.randomusergenerator.model.Result;
import com.publicmethod.owner.randomusergenerator.utils.UserDetailsClickHandler;

public class UserDetailsActivity extends AppCompatActivity {

    private static final String TAG = "UserDetailsActivity";

    private Result mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUserDetailsBinding activityUserDetailsBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_user_details);

        activityUserDetailsBinding.setHandler(new UserDetailsClickHandler() {
            @Override
            public void fabClicked(View view) {
                Toast.makeText(UserDetailsActivity.this, "Favorite!", Toast.LENGTH_SHORT).show();
            }
        });
        Toolbar toolbar = activityUserDetailsBinding.toolbar;
        setSupportActionBar(toolbar);

        // Get the result from the intent
        mResult = getIntent().getParcelableExtra("result");

        // Bind result
        activityUserDetailsBinding.setResult(mResult);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



}
