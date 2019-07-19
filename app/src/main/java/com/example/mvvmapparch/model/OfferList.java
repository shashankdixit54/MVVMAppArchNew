
package com.example.mvvmapparch.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OfferList {

    @SerializedName("offer_name")
    @Expose
    private String offerName;

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

}
