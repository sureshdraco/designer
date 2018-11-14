package mosamimon.com.mosamimon.rest;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by suresh on 11/12/18.
 */

public class CustomerResponse implements Parcelable {
    @SerializedName("Customer_ID")
    @Expose
    public String customerID;
    @SerializedName("Role_ID")
    @Expose
    public String roleID;
    @SerializedName("Profession_IDs")
    @Expose
    public String professionIDs;
    @SerializedName("Fullname")
    @Expose
    public String fullname;

    @SerializedName("Name")
    @Expose
    public String companyNane;

    @SerializedName("Email")
    @Expose
    public String email;
    @SerializedName("Password")
    @Expose
    public String password;
    @SerializedName("Address")
    @Expose
    public String address;
    @SerializedName("Phone")
    @Expose
    public String phone;
    @SerializedName("Picture")
    @Expose
    public String picture;
    @SerializedName("Phone_Verified")
    @Expose
    public String phoneVerified;
    @SerializedName("Email_Verified")
    @Expose
    public String emailVerified;
    @SerializedName("Verify_Token")
    @Expose
    public String verifyToken;
    @SerializedName("Verify_Page_Token")
    @Expose
    public String verifyPageToken;
    @SerializedName("Reset_Token")
    @Expose
    public String resetToken;
    @SerializedName("Reset_Password")
    @Expose
    public String resetPassword;
    @SerializedName("Total_SMS_Sent")
    @Expose
    public String totalSMSSent;
    @SerializedName("Status")
    @Expose
    public String status;
    @SerializedName("Verified_Status")
    @Expose
    public String verifiedStatus;
    @SerializedName("HarfeenMember")
    @Expose
    public String harfeenMember;
    @SerializedName("Mobile_ID")
    @Expose
    public String mobileID;
    @SerializedName("Terms_Accepeted")
    @Expose
    public String termsAccepeted;
    @SerializedName("Registered_At")
    @Expose
    public String registeredAt;
    @SerializedName("TimeStamp")
    @Expose
    public String timeStamp;
    @SerializedName("Cron_Email_Flag")
    @Expose
    public String cronEmailFlag;


    public CustomerResponse() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.customerID);
        dest.writeString(this.roleID);
        dest.writeString(this.professionIDs);
        dest.writeString(this.fullname);
        dest.writeString(this.companyNane);
        dest.writeString(this.email);
        dest.writeString(this.password);
        dest.writeString(this.address);
        dest.writeString(this.phone);
        dest.writeString(this.picture);
        dest.writeString(this.phoneVerified);
        dest.writeString(this.emailVerified);
        dest.writeString(this.verifyToken);
        dest.writeString(this.verifyPageToken);
        dest.writeString(this.resetToken);
        dest.writeString(this.resetPassword);
        dest.writeString(this.totalSMSSent);
        dest.writeString(this.status);
        dest.writeString(this.verifiedStatus);
        dest.writeString(this.harfeenMember);
        dest.writeString(this.mobileID);
        dest.writeString(this.termsAccepeted);
        dest.writeString(this.registeredAt);
        dest.writeString(this.timeStamp);
        dest.writeString(this.cronEmailFlag);
    }

    protected CustomerResponse(Parcel in) {
        this.customerID = in.readString();
        this.roleID = in.readString();
        this.professionIDs = in.readString();
        this.fullname = in.readString();
        this.companyNane = in.readString();
        this.email = in.readString();
        this.password = in.readString();
        this.address = in.readString();
        this.phone = in.readString();
        this.picture = in.readString();
        this.phoneVerified = in.readString();
        this.emailVerified = in.readString();
        this.verifyToken = in.readString();
        this.verifyPageToken = in.readString();
        this.resetToken = in.readString();
        this.resetPassword = in.readString();
        this.totalSMSSent = in.readString();
        this.status = in.readString();
        this.verifiedStatus = in.readString();
        this.harfeenMember = in.readString();
        this.mobileID = in.readString();
        this.termsAccepeted = in.readString();
        this.registeredAt = in.readString();
        this.timeStamp = in.readString();
        this.cronEmailFlag = in.readString();
    }

    public static final Creator<CustomerResponse> CREATOR = new Creator<CustomerResponse>() {
        @Override
        public CustomerResponse createFromParcel(Parcel source) {
            return new CustomerResponse(source);
        }

        @Override
        public CustomerResponse[] newArray(int size) {
            return new CustomerResponse[size];
        }
    };
}
