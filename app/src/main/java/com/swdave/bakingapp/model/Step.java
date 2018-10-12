package com.swdave.bakingapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Step implements Parcelable {

    @SerializedName("id")
    private int stepId;
    @SerializedName("shortDescription")
    private String stepShortDesc;
    @SerializedName("description")
    private String stepDesc;
    @SerializedName("videoURL")
    private String videoURL;
    @SerializedName("thumbnailURL")
    private String thumbnailURL;

    public Step(int stepId, String stepShortDesc, String stepDesc, String videoURL, String thumbnailURL) {
        this.stepId = stepId;
        this.stepShortDesc = stepShortDesc;
        this.stepDesc = stepDesc;
        this.videoURL = videoURL;
        this.thumbnailURL = thumbnailURL;
    }

    public int getStepId() {
        return stepId;
    }

    public String getStepShortDesc() {
        return stepShortDesc;
    }

    public String getStepDesc() {
        return stepDesc;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.stepId);
        dest.writeString(this.stepShortDesc);
        dest.writeString(this.stepDesc);
        dest.writeString(this.videoURL);
        dest.writeString(this.thumbnailURL);
    }

    protected Step(Parcel in) {
        this.stepId = in.readInt();
        this.stepShortDesc = in.readString();
        this.stepDesc = in.readString();
        this.videoURL = in.readString();
        this.thumbnailURL = in.readString();
    }

    public static final Parcelable.Creator<Step> CREATOR = new Parcelable.Creator<Step>() {
        @Override
        public Step createFromParcel(Parcel source) {
            return new Step(source);
        }

        @Override
        public Step[] newArray(int size) {
            return new Step[size];
        }
    };
}
