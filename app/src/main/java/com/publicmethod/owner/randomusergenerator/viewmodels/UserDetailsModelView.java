package com.publicmethod.owner.randomusergenerator.viewmodels;

import android.content.Context;
import android.databinding.BaseObservable;
import android.view.View;
import android.widget.Toast;

import com.publicmethod.owner.randomusergenerator.model.Result;

/**
 * Created by Eric De Wildt on 2016-05-16.
 */
public class UserDetailsModelView extends BaseObservable {

    private Context mContext;
    private Result mResult;

    public UserDetailsModelView(Context context, Result result) {
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

    public void setFavorite(View view) {
        Toast.makeText(mContext, "Favorite!", Toast.LENGTH_SHORT).show();
    }
}
