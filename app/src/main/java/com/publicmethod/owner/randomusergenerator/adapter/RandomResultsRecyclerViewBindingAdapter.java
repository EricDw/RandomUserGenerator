package com.publicmethod.owner.randomusergenerator.adapter;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.publicmethod.owner.randomusergenerator.BR;
import com.publicmethod.owner.randomusergenerator.databinding.ListItemCardBinding;
import com.publicmethod.owner.randomusergenerator.model.Result;
import com.publicmethod.owner.randomusergenerator.ui.UserDetailsActivity;
import com.publicmethod.owner.randomusergenerator.utils.ItemClickHandlers;

import java.util.List;

/**
 * Created by Eric De Wildt on 2016-04-27.
 */
public class RandomResultsRecyclerViewBindingAdapter extends RecyclerView.Adapter<RandomResultsRecyclerViewBindingAdapter.ContactsViewHolder> {

    private static List<Result> mRandomUserResults;

    public RandomResultsRecyclerViewBindingAdapter(List<Result> randomUserResults) {
        mRandomUserResults = randomUserResults;
    }


    public static class ContactsViewHolder extends RecyclerView.ViewHolder {
        private ListItemCardBinding mViewDataBinding;

        public ContactsViewHolder(View itemView) {
            super(itemView);

            mViewDataBinding = DataBindingUtil.bind(itemView);
        }

        public ViewDataBinding getViewDataBinding() {
            return mViewDataBinding;
        }
    }

    @Override
    public ContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListItemCardBinding listItemCardBinding = ListItemCardBinding.inflate(layoutInflater, parent, false);

        return new ContactsViewHolder(listItemCardBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(ContactsViewHolder holder, final int position) {

        final Result result = mRandomUserResults.get(position);
        holder.getViewDataBinding().setVariable(BR.result, result);
        holder.mViewDataBinding.setHandler(new ItemClickHandlers() {
            @Override
            public void passResultToNewActivity(View view) {
                Intent intent = new Intent(view.getContext(), UserDetailsActivity.class);
                intent.putExtra("result", result);
                view.getContext().startActivity(intent);
            }
        });
        holder.getViewDataBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mRandomUserResults == null ? 0 : mRandomUserResults.size();

    }
}