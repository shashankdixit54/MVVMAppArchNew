
package com.example.mvvmapparch.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Bar {

    @SerializedName("bar_name")
    @Expose
    private String barName;
    @SerializedName("bar_id")
    @Expose
    private String barId;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("open_hour")
    @Expose
    private String openHour;
    @SerializedName("close_hour")
    @Expose
    private String closeHour;
    @SerializedName("avg_rating")
    @Expose
    private String avgRating;
    @SerializedName("offer_list")
    @Expose
    private List<OfferList> offerList = null;
    @SerializedName("distance")
    @Expose
    private String distance;
    @SerializedName("bar_plan_id")
    @Expose
    private String barPlanId;
    @SerializedName("bar_address")
    @Expose
    private String barAddress;
    @SerializedName("media")
    @Expose
    private String media;

    public String getBarName() {
        return barName;
    }

    public void setBarName(String barName) {
        this.barName = barName;
    }

    public String getBarId() {
        return barId;
    }

    public void setBarId(String barId) {
        this.barId = barId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getOpenHour() {
        return openHour;
    }

    public void setOpenHour(String openHour) {
        this.openHour = openHour;
    }

    public String getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(String closeHour) {
        this.closeHour = closeHour;
    }

    public String getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(String avgRating) {
        this.avgRating = avgRating;
    }

    public List<OfferList> getOfferList() {
        return offerList;
    }

    public void setOfferList(List<OfferList> offerList) {
        this.offerList = offerList;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getBarPlanId() {
        return barPlanId;
    }

    public void setBarPlanId(String barPlanId) {
        this.barPlanId = barPlanId;
    }

    public String getBarAddress() {
        return barAddress;
    }

    public void setBarAddress(String barAddress) {
        this.barAddress = barAddress;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

}
