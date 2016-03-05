package com.nunna.questionnaire.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.nunna.questionnaire.model.UserDetails;

/**
 * Created by Sri Krishna on 02-02-2016.
 */
public class ShPrefManager
{
    private static final String TAG = ShPrefManager.class.getSimpleName();
    private static final String PREFS_NAME = "GoDingItPrefs";
    private static ShPrefManager instance;
    private SharedPreferences sharedPreferences;

    private ShPrefManager(Context context)
    {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public static ShPrefManager with(Context context)
    {
        if (instance == null)
        {
            instance = new ShPrefManager(context.getApplicationContext());
        }

        return instance;
    }

    public SharedPreferences.Editor edit() {
        return sharedPreferences.edit();
    }

    public boolean isUserLoggedIn() {
        return sharedPreferences.getBoolean("logged_in", false);
    }

    public String getUsername()
    {
        return sharedPreferences.getString("username", null);
    }

//    public String getUserId() {
//        return sharedPreferences.getString("user_id", null);
//    }




    public String getOfJID()
    {
        return sharedPreferences.getString("of_jid", null);
    }

    public String getBearerToken() {
        return sharedPreferences.getString("bearerToken", null);
    }

    public String getUserFullName() {
        return sharedPreferences.getString("full_name", null);
    }

    public void  setUserForgotPasswordFlag(String flag) {
         sharedPreferences.getString("forgotPasswordFlag", "false");

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("forgotPasswordFlag", String.valueOf(flag));

        // editor.apply();
        editor.commit();
    }


    public String getUserForgotPasswordFlag() {
        return sharedPreferences.getString("forgotPasswordFlag", "");
    }

    public void putUserDetails(UserDetails userDetails)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("logged_in", true);
        editor.putString("user_id", userDetails.getUserId());
        editor.putString("full_name", userDetails.getFullname());
        editor.putString("username", userDetails.getUsername());
        editor.putString("of_jid", userDetails.getOfJid());
        editor.putString("bearerToken", userDetails.getBearerToken());


        // editor.apply();
        editor.commit();
    }

    public void saveUserId(int userId)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("userId", userId);
        editor.commit();
    }

    public int getUserId()
    {
        return sharedPreferences.getInt("userId", 0);
    }

    public void saveDeliveryCoordinate(double lat, double lng)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("delivery_latitude", String.valueOf(lat));
        editor.putString("delivery_longitude", String.valueOf(lng));
        // editor.apply();
        editor.commit();
    }




    public String getDeliveryLat()
    {
        String lat = sharedPreferences.getString("delivery_latitude", "0d");
        return lat;
    }

    public String getDeliveryLng()
    {
        String lng = sharedPreferences.getString("delivery_longitude", "0d");
        return lng;
    }

    public void ClearUserDetails()
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("logged_in", false);
        editor.putString("user_id", "");
        editor.putString("full_name", "");
        editor.putString("username","");
        editor.putString("of_jid", "");
        editor.putString("bearerToken","");

        editor.apply();
    }
}
