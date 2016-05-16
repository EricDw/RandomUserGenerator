package com.publicmethod.owner.randomusergenerator.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.publicmethod.owner.randomusergenerator.R;
import com.publicmethod.owner.randomusergenerator.databinding.ListItemCardBinding;
import com.publicmethod.owner.randomusergenerator.model.Result;
import com.publicmethod.owner.randomusergenerator.viewmodels.MainActivityViewModel;

import java.util.ArrayList;

/**
 * Created by Eric De Wildt on 2016-04-27.
 */
public class RandomResultsRecyclerViewBindingAdapter extends RecyclerView.Adapter<RandomResultsRecyclerViewBindingAdapter.ContactsViewHolder> {

    private ArrayList<Result> mRandomUserResults;
    private Context mContext;

    public RandomResultsRecyclerViewBindingAdapter(Context context) {
        mContext = context;
        mRandomUserResults = new ArrayList<>();
    }


    @Override
    public ContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ListItemCardBinding listItemCardBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.list_item_card,
                parent,
                false);

        return new ContactsViewHolder(listItemCardBinding);
    }

    @Override
    public void onBindViewHolder(ContactsViewHolder holder, final int position) {

        ListItemCardBinding listItemCardBinding = holder.mViewDataBinding;
        listItemCardBinding.setResult(mRandomUserResults.get(position));
        listItemCardBinding.setViewModel(new MainActivityViewModel(mContext, mRandomUserResults.get(position)));
        holder.mViewDataBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mRandomUserResults == null ? 0 : mRandomUserResults.size();

    }

    public void setRandomUserResults(ArrayList<Result> randomUserResults) {
        mRandomUserResults = randomUserResults;
        notifyDataSetChanged();

    }

    public void addResult(Result result) {
        if (!mRandomUserResults.contains(result)) {
            mRandomUserResults.add(result);
            notifyItemInserted(mRandomUserResults.size() - 1);
        } else {
            mRandomUserResults.set(mRandomUserResults.indexOf(result), result);
            notifyItemInserted(mRandomUserResults.indexOf(result));
        }
    }

    public static class ContactsViewHolder extends RecyclerView.ViewHolder {
        private ListItemCardBinding mViewDataBinding;

        public ContactsViewHolder(ListItemCardBinding listItemCardBinding) {
            super(listItemCardBinding.getRoot());
            mViewDataBinding = listItemCardBinding;
        }
    }
}
