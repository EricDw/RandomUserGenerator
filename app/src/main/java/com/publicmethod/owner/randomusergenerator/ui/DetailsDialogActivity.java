package com.publicmethod.owner.randomusergenerator.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.publicmethod.owner.randomusergenerator.R;
import com.publicmethod.owner.randomusergenerator.databinding.ActivityDetailsDialogBinding;
import com.publicmethod.owner.randomusergenerator.model.Result;
import com.publicmethod.owner.randomusergenerator.viewmodels.DetailsDialogActivityViewModel;

public class DetailsDialogActivity extends AppCompatActivity {
    Result mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailsDialogBinding activityDetailsDialogBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_details_dialog);

        mResult = getIntent().getParcelableExtra("result");
        // TODO: 2016-05-18 Initialize result
        activityDetailsDialogBinding.setViewModel(new DetailsDialogActivityViewModel(this, mResult));
    }
}
