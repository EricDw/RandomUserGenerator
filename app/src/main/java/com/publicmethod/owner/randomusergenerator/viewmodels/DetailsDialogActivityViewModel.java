package com.publicmethod.owner.randomusergenerator.viewmodels;

import android.content.Context;
import android.databinding.BaseObservable;

import com.publicmethod.owner.randomusergenerator.model.Result;

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
}
