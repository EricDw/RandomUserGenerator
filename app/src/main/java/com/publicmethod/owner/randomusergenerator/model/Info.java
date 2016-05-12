
package com.publicmethod.owner.randomusergenerator.model;

import android.databinding.BaseObservable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info extends BaseObservable implements Parcelable
{

    @SerializedName("seed")
    @Expose
    private String seed;
    @SerializedName("results")
    @Expose
    private int results;
    @SerializedName("page")
    @Expose
    private int page;
    @SerializedName("version")
    @Expose
    private String version;
    public final static Parcelable.Creator<Info> CREATOR = new Creator<Info>() {



        public Info createFromParcel(Parcel in) {
            Info instance = new Info();
            instance.seed = ((String) in.readValue((String.class.getClassLoader())));
            instance.results = ((int) in.readValue((int.class.getClassLoader())));
            instance.page = ((int) in.readValue((int.class.getClassLoader())));
            instance.version = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Info[] newArray(int size) {
            return (new Info[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The seed
     */
    public String getSeed() {
        return seed;
    }

    /**
     * 
     * @param seed
     *     The seed
     */
    public void setSeed(String seed) {
        this.seed = seed;
    }

    /**
     * 
     * @return
     *     The results
     */
    public int getResults() {
        return results;
    }

    /**
     * 
     * @param results
     *     The results
     */
    public void setResults(int results) {
        this.results = results;
    }

    /**
     * 
     * @return
     *     The page
     */
    public int getPage() {
        return page;
    }

    /**
     * 
     * @param page
     *     The page
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * 
     * @return
     *     The version
     */
    public String getVersion() {
        return version;
    }

    /**
     * 
     * @param version
     *     The version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Info{" +
                "seed='" + seed + '\'' +
                ", results=" + results +
                ", page=" + page +
                ", version='" + version + '\'' +
                '}';
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(seed);
        dest.writeValue(results);
        dest.writeValue(page);
        dest.writeValue(version);
    }

    public int describeContents() {
        return  0;
    }

}
