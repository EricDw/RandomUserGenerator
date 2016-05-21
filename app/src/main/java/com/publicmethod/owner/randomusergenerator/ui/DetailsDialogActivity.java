package com.publicmethod.owner.randomusergenerator.ui;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.publicmethod.owner.randomusergenerator.R;
import com.publicmethod.owner.randomusergenerator.databinding.ActivityDetailsDialogBinding;
import com.publicmethod.owner.randomusergenerator.model.Result;
import com.publicmethod.owner.randomusergenerator.viewmodels.DetailsDialogActivityViewModel;

public class DetailsDialogActivity extends AppCompatActivity {

    /**
     * A helper method for starting {@link com.publicmethod.owner.randomusergenerator.ui.DetailsDialogActivity}.
     *
     * @param context The activity or fragment context starting {@link DetailsDialogActivity}.
     * @param result  The result required for populating {@link DetailsDialogActivity}.
     * @return Intent containing the provided Context, result extra, and {@link DetailsDialogActivity}.
     */
    public static Intent getStartIntent(Context context, @Nullable Result result) {
        Intent intent = new Intent(context, DetailsDialogActivity.class);
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
        ActivityDetailsDialogBinding activityDetailsDialogBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_details_dialog);

        Result result = getIntent().getParcelableExtra("result");

        activityDetailsDialogBinding.setViewModel(new DetailsDialogActivityViewModel(this, result));
        activityDetailsDialogBinding.executePendingBindings();

        setTitle(DetailsDialogActivityViewModel.getFormattedName(result));
    }
}
