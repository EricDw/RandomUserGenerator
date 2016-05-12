
package com.publicmethod.owner.randomusergenerator.model;

import android.databinding.BaseObservable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Login extends BaseObservable implements Parcelable
{

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("salt")
    @Expose
    private String salt;
    @SerializedName("md5")
    @Expose
    private String md5;
    @SerializedName("sha1")
    @Expose
    private String sha1;
    @SerializedName("sha256")
    @Expose
    private String sha256;
    public final static Parcelable.Creator<Login> CREATOR = new Creator<Login>() {



        public Login createFromParcel(Parcel in) {
            Login instance = new Login();
            instance.username = ((String) in.readValue((String.class.getClassLoader())));
            instance.password = ((String) in.readValue((String.class.getClassLoader())));
            instance.salt = ((String) in.readValue((String.class.getClassLoader())));
            instance.md5 = ((String) in.readValue((String.class.getClassLoader())));
            instance.sha1 = ((String) in.readValue((String.class.getClassLoader())));
            instance.sha256 = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Login[] newArray(int size) {
            return (new Login[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param username
     *     The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * @return
     *     The password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @param password
     *     The password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 
     * @return
     *     The salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 
     * @param salt
     *     The salt
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 
     * @return
     *     The md5
     */
    public String getMd5() {
        return md5;
    }

    /**
     * 
     * @param md5
     *     The md5
     */
    public void setMd5(String md5) {
        this.md5 = md5;
    }

    /**
     * 
     * @return
     *     The sha1
     */
    public String getSha1() {
        return sha1;
    }

    /**
     * 
     * @param sha1
     *     The sha1
     */
    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    /**
     * 
     * @return
     *     The sha256
     */
    public String getSha256() {
        return sha256;
    }

    /**
     * 
     * @param sha256
     *     The sha256
     */
    public void setSha256(String sha256) {
        this.sha256 = sha256;
    }

    @Override
    public String toString() {
        return "Login{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", md5='" + md5 + '\'' +
                ", sha1='" + sha1 + '\'' +
                ", sha256='" + sha256 + '\'' +
                '}';
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(username);
        dest.writeValue(password);
        dest.writeValue(salt);
        dest.writeValue(md5);
        dest.writeValue(sha1);
        dest.writeValue(sha256);
    }

    public int describeContents() {
        return  0;
    }

}
