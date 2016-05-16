package com.publicmethod.owner.randomusergenerator.ui;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.publicmethod.owner.randomusergenerator.R;
import com.publicmethod.owner.randomusergenerator.databinding.ActivityUserDetailsBinding;
import com.publicmethod.owner.randomusergenerator.model.Result;
import com.publicmethod.owner.randomusergenerator.utils.handlers.UserDetailsClickHandler;

import org.jetbrains.annotations.Contract;

public class UserDetailsActivity extends AppCompatActivity {

    private static final String TAG = "UserDetailsActivity";

    private Result mResult;

    /**
     * A helper method for starting UserDetailsActivity.
     *
     * @param context The activity or fragment context starting UserDetailsActivity.class.
     * @return Intent containing the provided Context and UserDetailsActivity.class.
     */
    @Contract("_ -> !null")
    public static Intent getStartIntent(Context context) {
        return new Intent(context, UserDetailsActivity.class);
    }

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
