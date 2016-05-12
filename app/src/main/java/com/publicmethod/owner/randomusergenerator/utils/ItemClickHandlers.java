package com.publicmethod.owner.randomusergenerator.utils;

import android.view.View;

/**
 * This interface offers empty methods designed to be overridden.
 * Created by Eric De Wildt on 2016-05-12.
 */
public interface ItemClickHandlers {


    /**
     A helper method for passing results from one activity to the next.
     *
     * @param view   The view being clicked.
     */
    void passResultToNewActivity(View view);

}
