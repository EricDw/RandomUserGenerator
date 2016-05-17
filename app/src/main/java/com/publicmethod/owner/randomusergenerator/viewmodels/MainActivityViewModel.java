package com.publicmethod.owner.randomusergenerator.viewmodels;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.support.annotation.Nullable;
import android.view.View;

import com.publicmethod.owner.randomusergenerator.adapter.RandomResultsRecyclerViewBindingAdapter;
import com.publicmethod.owner.randomusergenerator.model.Result;
import com.publicmethod.owner.randomusergenerator.ui.UserDetailsActivity;

/**
 * Created by Eric De Wildt on 2016-05-15.
 */
public class MainActivityViewModel extends BaseObservable {

    private static final String TAG = MainActivityViewModel.class.getSimpleName();
    private Context mContext;
    private Result mResult;
    private RandomResultsRecyclerViewBindingAdapter mRandomResultsRecyclerViewBindingAdapter;

    public MainActivityViewModel(Context context, @Nullable Result result) {
        mContext = context;
        mResult = result;
    }

    public void showDetails(View view) {
        Intent intent = UserDetailsActivity.getStartIntent(mContext, mResult);
        mContext.startActivity(intent);
    }

    public String getFormattedName() {
        String inputFirstName = mResult.getName().getFirst();
        String inputLastName = mResult.getName().getLast();
        String capitalizedFirstName = inputFirstName.substring(0, 1).toUpperCase() + inputFirstName.substring(1);
        String capitalizedLastName = inputLastName.substring(0, 1).toUpperCase() + inputLastName.substring(1);

        return capitalizedFirstName + " " + capitalizedLastName;
    }


}