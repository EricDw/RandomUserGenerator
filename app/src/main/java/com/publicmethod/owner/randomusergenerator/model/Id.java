
package com.publicmethod.owner.randomusergenerator.model;

import android.databinding.BaseObservable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Id extends BaseObservable implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("value")
    @Expose
    private String value;
    public final static Parcelable.Creator<Id> CREATOR = new Creator<Id>() {


        public Id createFromParcel(Parcel in) {
            Id instance = new Id();
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.value = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Id[] newArray(int size) {
            return (new Id[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The value
     */
    public String getValue() {
        return value;
    }

    /**
     * 
     * @param value
     *     The value
     */
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Id{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(value);
    }

    public int describeContents() {
        return  0;
    }

}
