package com.publicmethod.owner.randomusergenerator.viewmodels;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.view.View;

import com.publicmethod.owner.randomusergenerator.model.Result;
import com.publicmethod.owner.randomusergenerator.ui.UserDetailsActivity;

/**
 * Created by Eric De Wildt on 2016-05-15.
 */
public class MainActivityViewModel extends BaseObservable {

    private Context mContext;
    private Result mResult;

    public MainActivityViewModel(Context context, Result result) {
        mContext = context;
        mResult = result;
    }

    public void showDetails(View view) {
        Intent intent = new Intent(view.getContext(), UserDetailsActivity.class);
        intent.putExtra("result", mResult);
        view.getContext().startActivity(intent);
    }

    public String getFormattedName() {
        String inputFirstName = mResult.getName().getFirst();
        String inputLastName = mResult.getName().getLast();
        String captilzedFirstName = inputFirstName.substring(0, 1).toUpperCase() + inputFirstName.substring(1);
        String captilzedLastName = inputLastName.substring(0, 1).toUpperCase() + inputLastName.substring(1);

        return captilzedFirstName + " " + captilzedLastName;
    }
}