
package com.example.mvvmapparch.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Offer {

    @SerializedName("is_activated")
    @Expose
    private String isActivated;
    @SerializedName("offer_name")
    @Expose
    private String offerName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("bar_name")
    @Expose
    private String barName;
    @SerializedName("offer_id")
    @Expose
    private String offerId;
    @SerializedName("bar_id")
    @Expose
    private String barId;
    @SerializedName("offer_for")
    @Expose
    private String offerFor;
    @SerializedName("type_offer")
    @Expose
    private String typeOffer;
    @SerializedName("start_date")
    @Expose
    private String startDate;
    @SerializedName("end_date")
    @Expose
    private String endDate;
    @SerializedName("days")
    @Expose
    private String days;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    @SerializedName("end_time")
    @Expose
    private String endTime;
    @SerializedName("avg_rating")
    @Expose
    private String avgRating;
    @SerializedName("not_valid_dates")
    @Expose
    private Object notValidDates;
    @SerializedName("media")
    @Expose
    private String media;
    @SerializedName("discount_type")
    @Expose
    private String discountType;
    @SerializedName("discount_value")
    @Expose
    private String discountValue;
    @SerializedName("terms")
    @Expose
    private String terms;
    @SerializedName("is_happy_hour")
    @Expose
    private String isHappyHour;
    @SerializedName("distance")
    @Expose
    private String distance;

    public String getIsActivated() {
        return isActivated;
    }

    public void setIsActivated(String isActivated) {
        this.isActivated = isActivated;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBarName() {
        return barName;
    }

    public void setBarName(String barName) {
        this.barName = barName;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public String getBarId() {
        return barId;
    }

    public void setBarId(String barId) {
        this.barId = barId;
    }

    public String getOfferFor() {
        return offerFor;
    }

    public void setOfferFor(String offerFor) {
        this.offerFor = offerFor;
    }

    public String getTypeOffer() {
        return typeOffer;
    }

    public void setTypeOffer(String typeOffer) {
        this.typeOffer = typeOffer;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(String avgRating) {
        this.avgRating = avgRating;
    }

    public Object getNotValidDates() {
        return notValidDates;
    }

    public void setNotValidDates(Object notValidDates) {
        this.notValidDates = notValidDates;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public String getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(String discountValue) {
        this.discountValue = discountValue;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getIsHappyHour() {
        return isHappyHour;
    }

    public void setIsHappyHour(String isHappyHour) {
        this.isHappyHour = isHappyHour;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

}
