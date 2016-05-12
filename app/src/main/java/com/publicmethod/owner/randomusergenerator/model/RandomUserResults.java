
package com.publicmethod.owner.randomusergenerator.model;

import android.databinding.BaseObservable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RandomUserResults extends BaseObservable implements Parcelable {

    @SerializedName("results")
    @Expose
    private List<Result> results;
    @SerializedName("info")
    @Expose
    private Info info;
    public final static Parcelable.Creator<RandomUserResults> CREATOR = new Creator<RandomUserResults>() {



        public RandomUserResults createFromParcel(Parcel in) {
            RandomUserResults instance = new RandomUserResults();
            in.readList(instance.results, (com.publicmethod.owner.randomusergenerator.model.Result.class.getClassLoader()));
            instance.info = ((Info) in.readValue((Info.class.getClassLoader())));
            return instance;
        }

        public RandomUserResults[] newArray(int size) {
            return (new RandomUserResults[size]);
        }

    };


    public RandomUserResults() {
        results = new ArrayList<Result>();
    }

    /**
     * @return The results
     */
    public List<Result> getResults() {
        return results;
    }

    /**
     * @param results The results
     */
    public void setResults(List<Result> results) {
        this.results = results;
    }

    /**
     * @return The info
     */
    public Info getInfo() {
        return info;
    }

    /**
     * @param info The info
     */
    public void setInfo(Info info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "RandomUserResults{" +
                "results=" + results +
                ", info=" + info +
                '}';
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(results);
        dest.writeValue(info);
    }

    public int describeContents() {
        return 0;
    }

}
