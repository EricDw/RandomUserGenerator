package com.publicmethod.owner.randomusergenerator.viewmodels;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.view.View;

import com.publicmethod.owner.randomusergenerator.model.Result;
import com.publicmethod.owner.randomusergenerator.ui.UserDetailsEditorActivity;

/**
 * Created by Eric De Wildt on 2016-05-18.
 */

public class DetailsDialogActivityViewModel extends BaseObservable {


    private Result mResult;
    private Context mContext;

    public DetailsDialogActivityViewModel(Context context, Result result) {

        mContext = context;
        mResult = result;

    }

    public String getFormattedAddress() {

        return String.format("%s, %s, %s, %s",
                mResult.getLocation().getStreet(),
                mResult.getLocation().getCity(),
                mResult.getLocation().getState(),
                mResult.getLocation().getPostcode());
    }

    public String getFormattedName() {
        String inputFirstName = mResult.getName().getFirst();
        String inputLastName = mResult.getName().getLast();
        String capitalizedFirstName = inputFirstName.substring(0, 1).toUpperCase() + inputFirstName.substring(1);
        String capitalizedLastName = inputLastName.substring(0, 1).toUpperCase() + inputLastName.substring(1);

        return capitalizedFirstName + " " + capitalizedLastName;
    }

    public static String getFormattedName(Result result) {
        String inputFirstName = result.getName().getFirst();
        String inputLastName = result.getName().getLast();
        String capitalizedFirstName = inputFirstName.substring(0, 1).toUpperCase() + inputFirstName.substring(1);
        String capitalizedLastName = inputLastName.substring(0, 1).toUpperCase() + inputLastName.substring(1);

        return capitalizedFirstName + " " + capitalizedLastName;
    }

    public void startEditDetailsActivity(View view){
        Intent intent = UserDetailsEditorActivity.getStartIntent(view.getContext(), mResult);
        mContext.startActivity(intent);
    }
}
