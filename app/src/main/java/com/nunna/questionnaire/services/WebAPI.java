package com.nunna.questionnaire.services;


import com.nunna.questionnaire.model.RegisterUserRequest;
import com.nunna.questionnaire.model.RegisterUserResponse;
import com.nunna.questionnaire.model.ResponseData;
import com.nunna.questionnaire.model.StateResponse;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.mime.TypedFile;
import retrofit.mime.TypedString;

/**
 * Created by Sri Krishna on 02-02-2016.
 */
public interface WebAPI {

    @GET("/mobileapi/getstates")
    void getStateCodes(RestCallback<StateResponse> callback);

    @POST("/mobileapi/newuserreg")
    void registerUser(@Body RegisterUserRequest verifyEmailRequest, RestCallback<RegisterUserResponse> callback);

    @POST("/mobileapi/questionlist")
    void getQuestionList(@Body RegisterUserRequest verifyEmailRequest, RestCallback<RegisterUserResponse> callback);


//    @Multipart
//    @POST("/register")
//    void registerUser(@Part("filenames") TypedString data, @Part("userfile") TypedFile profilePhoto, RestCallback<ResponseData> callback);

//    @POST("/verifyemail")
//    void verifyEmail(@Body VerifyEmailRequest verifyEmailRequest, RestCallback<ResponseData> callback);
//
//    @POST("/login")
//    void loginUser(@Body LoginRequest loginRequest, RestCallback<LoginResponse2> callback);
//
//    @POST("/resetpassword")
//    void resetPassword(@Header("Authorization") String authorization, @Body ResetPasswordRequest resetPasswordRequest, RestCallback<ResponseData> callback);
//
//    @POST("/forgotpassword")
//    void forgotPassword(@Body ForgotPasswordRequest forgotPasswordRequest, RestCallback<ResponseData> callback);
//
//    @Multipart
//    @POST("/createpost")
//    void createPost(@Header("Authorization") String authorization, @Part("filenames") TypedString createPostRequest, @Part("userfile") TypedFile image, RestCallback<ResponseData> callback);
//
//    @POST("/dopostproperties")
//    void updateLikeAccepRateStatus(@Header("Authorization") String authorization, @Body RequestMarker Request, RestCallback<ResponseData> callback);
//    @POST("/getcomments")
//    void getComments(@Header("Authorization") String authorization, @Body GetCommentByPostRequest getCommentByPostRequest, RestCallback<GetCommentByPostResponse> callback);
//
//    @POST("/docomment")
//    void postComment(@Header("Authorization") String authorization, @Body PostCommentRequest getCommentByPostRequest, RestCallback<PostCommentResponse> callback);
//
//    // Default Time Line Posts.
//    @POST("/defaulttimelineposts")
//    void getDefaultTimeLinePosts(@Header("Authorization") String authorization, @Body SortedTimeLineRequest sortedTimeLineRequest, RestCallback<TimeLinePostResponse> callback);
//
//    @POST("/defaulttimelineposts")
//    void getDefaultTimeLinePosts(@Body SortedTimeLineRequest sortedTimeLineRequest, RestCallback<TimeLinePostResponse> callback);






}
