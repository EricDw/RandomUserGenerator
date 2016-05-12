
package com.publicmethod.owner.randomusergenerator.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Result extends BaseObservable implements Parcelable {

    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("name")
    @Expose
    private Name name;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("login")
    @Expose
    private Login login;
    @SerializedName("registered")
    @Expose
    private int registered;
    @SerializedName("dob")
    @Expose
    private int dob;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("cell")
    @Expose
    private String cell;
    @SerializedName("id")
    @Expose
    private Id id;
    @SerializedName("picture")
    @Expose
    @Bindable
    private Picture picture;
    @SerializedName("nat")
    @Expose
    private String nat;
    public final static Parcelable.Creator<Result> CREATOR = new Creator<Result>() {


        public Result createFromParcel(Parcel in) {
            Result instance = new Result();
            instance.gender = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((Name) in.readValue((Name.class.getClassLoader())));
            instance.location = ((Location) in.readValue((Location.class.getClassLoader())));
            instance.email = ((String) in.readValue((String.class.getClassLoader())));
            instance.login = ((Login) in.readValue((Login.class.getClassLoader())));
            instance.registered = ((int) in.readValue((int.class.getClassLoader())));
            instance.dob = ((int) in.readValue((int.class.getClassLoader())));
            instance.phone = ((String) in.readValue((String.class.getClassLoader())));
            instance.cell = ((String) in.readValue((String.class.getClassLoader())));
            instance.id = ((Id) in.readValue((Id.class.getClassLoader())));
            instance.picture = ((Picture) in.readValue((Picture.class.getClassLoader())));
            instance.nat = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Result[] newArray(int size) {
            return (new Result[size]);
        }

    };

    /**
     * @return The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return The name
     */
    public Name getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * @return The location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @param location The location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * @return The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return The login
     */
    public Login getLogin() {
        return login;
    }

    /**
     * @param login The login
     */
    public void setLogin(Login login) {
        this.login = login;
    }

    /**
     * @return The registered
     */
    public int getRegistered() {
        return registered;
    }

    /**
     * @param registered The registered
     */
    public void setRegistered(int registered) {
        this.registered = registered;
    }

    /**
     * @return The dob
     */
    public int getDob() {
        return dob;
    }

    /**
     * @param dob The dob
     */
    public void setDob(int dob) {
        this.dob = dob;
    }

    /**
     * @return The phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone The phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return The cell
     */
    public String getCell() {
        return cell;
    }

    /**
     * @param cell The cell
     */
    public void setCell(String cell) {
        this.cell = cell;
    }

    /**
     * @return The id
     */
    public Id getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Id id) {
        this.id = id;
    }

    /**
     * @return The picture
     */
    public Picture getPicture() {
        return picture;
    }

    /**
     * @param picture The picture
     */
    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    /**
     * @return The nat
     */
    public String getNat() {
        return nat;
    }

    /**
     * @param nat The nat
     */
    public void setNat(String nat) {
        this.nat = nat;
    }

    @Override
    public String toString() {
        return "Result{" +
                "gender='" + gender + '\'' +
                ", name=" + name +
                ", location=" + location +
                ", email='" + email + '\'' +
                ", login=" + login +
                ", registered=" + registered +
                ", dob=" + dob +
                ", phone='" + phone + '\'' +
                ", cell='" + cell + '\'' +
                ", id=" + id +
                ", picture=" + picture +
                ", nat='" + nat + '\'' +
                '}';
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(gender);
        dest.writeValue(name);
        dest.writeValue(location);
        dest.writeValue(email);
        dest.writeValue(login);
        dest.writeValue(registered);
        dest.writeValue(dob);
        dest.writeValue(phone);
        dest.writeValue(cell);
        dest.writeValue(id);
        dest.writeValue(picture);
        dest.writeValue(nat);
    }

    public int describeContents() {
        return 0;
    }

}
