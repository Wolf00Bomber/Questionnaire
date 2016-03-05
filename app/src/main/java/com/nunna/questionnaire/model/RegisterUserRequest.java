package com.nunna.questionnaire.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Sri Krishna on 04-03-2016.
 */
public class RegisterUserRequest {
    @SerializedName("telnumber")
    public String telnumber;

    @SerializedName("stateid")
    public String stateid;

    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    public String getStateid() {
        return stateid;
    }

    public void setStateid(String stateid) {
        this.stateid = stateid;
    }
}
