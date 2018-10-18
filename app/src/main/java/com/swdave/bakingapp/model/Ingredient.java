
package com.swdave.bakingapp.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Ingredient implements Parcelable
{

    public final static Parcelable.Creator<Ingredient> CREATOR = new Creator<Ingredient>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Ingredient createFromParcel(Parcel in) {
            return new Ingredient(in);
        }

        public Ingredient[] newArray(int size) {
            return (new Ingredient[size]);
        }
    }
            ;

    protected Ingredient(Parcel in) {
    }

    public void writeToParcel(Parcel dest, int flags) {
    }

    public int describeContents() {
        return 0;
    }

}