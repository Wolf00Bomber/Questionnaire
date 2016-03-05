package com.nunna.questionnaire.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Sri Krishna on 04-03-2016.
 */
public class QuestionnaireResponse {
    @SerializedName("errorcode")
    public String errorcode;

    @SerializedName("message")
    public String message;

    @SerializedName("questionlist")
    public ArrayList<QuestionDO> questionList;

}
