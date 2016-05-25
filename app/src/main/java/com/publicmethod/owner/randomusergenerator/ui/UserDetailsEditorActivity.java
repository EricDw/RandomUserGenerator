package com.publicmethod.owner.randomusergenerator.ui;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.publicmethod.owner.randomusergenerator.R;
import com.publicmethod.owner.randomusergenerator.databinding.ActivityUserDetailsBinding;
import com.publicmethod.owner.randomusergenerator.model.Result;
import com.publicmethod.owner.randomusergenerator.viewmodels.UserDetailsModelView;

public class UserDetailsEditorActivity extends AppCompatActivity {

    private static final String TAG = "UserDetailsEditorActivity";

    private Result mResult;


    /**
     * A helper method for starting UserDetailsEditorActivity.
     *
     * @param context The activity or fragment context starting {@link UserDetailsEditorActivity}.
     * @param result  The result required for populating {@link UserDetailsEditorActivity}.
     * @return Intent containing the provided Context, result extra, and {@link UserDetailsEditorActivity}.
     */
    public static Intent getStartIntent(Context context, @Nullable Result result) {
        Intent intent = new Intent(context, UserDetailsEditorActivity.class);
        if (result == null) {
            return intent;
        } else {
            intent.putExtra("result", result);
            return intent;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUserDetailsBinding activityUserDetailsBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_user_details);
        // Get the result from the intent
        mResult = getIntent().getParcelableExtra("result");
        // Bind result
        activityUserDetailsBinding.setViewModel(new UserDetailsModelView(this, mResult));
        activityUserDetailsBinding.setResult(mResult);
        setSupportActionBar(activityUserDetailsBinding.toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


}
