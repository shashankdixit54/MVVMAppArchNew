
package com.example.mvvmapparch.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("popular_offer")
    @Expose
    private List<PopularOffer> popularOffer = null;

    @SerializedName("offer")
    @Expose
    private List<Offer> offer = null;

    @SerializedName("bar")
    @Expose
    private List<Bar> bar = null;

    @SerializedName("text")
    @Expose
    private String text;

    public List<PopularOffer> getPopularOffer() {
        return popularOffer;
    }

    public void setPopularOffer(List<PopularOffer> popularOffer) {
        this.popularOffer = popularOffer;
    }

    public List<Offer> getOffer() {
        return offer;
    }

    public void setOffer(List<Offer> offer) {
        this.offer = offer;
    }

    public List<Bar> getBar() {
        return bar;
    }

    public void setBar(List<Bar> bar) {
        this.bar = bar;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
