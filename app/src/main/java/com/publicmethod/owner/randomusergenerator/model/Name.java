
package com.publicmethod.owner.randomusergenerator.model;

import android.databinding.BaseObservable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Name extends BaseObservable implements Parcelable {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("first")
    @Expose
    private String first;
    @SerializedName("last")
    @Expose
    private String last;
    @SerializedName("formattedName")
    @Expose
    private String formattedName;

    public final static Parcelable.Creator<Name> CREATOR = new Creator<Name>() {

        @SuppressWarnings({
                "unchecked"
        })
        public Name createFromParcel(Parcel in) {
            Name instance = new Name();
            instance.title = ((String) in.readValue((String.class.getClassLoader())));
            instance.first = ((String) in.readValue((String.class.getClassLoader())));
            instance.last = ((String) in.readValue((String.class.getClassLoader())));
            instance.formattedName = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Name[] newArray(int size) {
            return (new Name[size]);
        }

    };

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The first
     */
    public String getFirst() {
        return first;
    }

    /**
     * @param first The first
     */
    public void setFirst(String first) {
        this.first = first;
    }

    /**
     * @return The last
     */
    public String getLast() {
        return last;
    }

    /**
     * @param last The last
     */
    public void setLast(String last) {
        this.last = last;
    }

    public String getFormattedName() {
        return String.format("%s %s", getFirst(), getLast());
    }

    @Override
    public String toString() {
        return "Name{" +
                "title='" + title + '\'' +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(title);
        dest.writeValue(first);
        dest.writeValue(last);
        dest.writeValue(formattedName);
    }

    public int describeContents() {
        return 0;
    }

}
