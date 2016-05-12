package com.publicmethod.owner.randomusergenerator.adapter;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.publicmethod.owner.randomusergenerator.BR;
import com.publicmethod.owner.randomusergenerator.R;
import com.publicmethod.owner.randomusergenerator.model.Result;
import com.publicmethod.owner.randomusergenerator.ui.UserDetailsActivity;

import java.util.List;

/**
 * Created by Eric De Wildt on 2016-04-27.
 */
public class RandomResultsRecyclerViewBindingAdapter extends RecyclerView.Adapter<RandomResultsRecyclerViewBindingAdapter.ContactsViewHolder> {

    private static List<Result> mRandomUserResults;

    public RandomResultsRecyclerViewBindingAdapter(List<Result> randomUserResults) {
        mRandomUserResults = randomUserResults;
    }


    public static class ContactsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ViewDataBinding mViewDataBinding;

        public ContactsViewHolder(View itemView) {
            super(itemView);

            mViewDataBinding = DataBindingUtil.bind(itemView);
        }

        public ViewDataBinding getViewDataBinding() {
            return mViewDataBinding;
        }

        @Override
        public void onClick(View v) {
            // Open UserDetailsActivity
            Intent intent = new Intent(v.getContext(), UserDetailsActivity.class);
            Result result = mRandomUserResults.get(getAdapterPosition());
            intent.putExtra("result", result);
            v.getContext().startActivity(intent);

        }
    }

    @Override
    public ContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View cardView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_card, parent, false);

        return new ContactsViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(ContactsViewHolder holder, int position) {

        final Result result = mRandomUserResults.get(position);
        holder.getViewDataBinding().setVariable(BR.result, result);
        holder.getViewDataBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mRandomUserResults == null ? 0 : mRandomUserResults.size();

    }
}