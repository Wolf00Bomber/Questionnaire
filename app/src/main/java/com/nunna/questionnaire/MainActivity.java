package com.nunna.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.nunna.questionnaire.model.RegisterUserRequest;
import com.nunna.questionnaire.model.RegisterUserResponse;
import com.nunna.questionnaire.model.ResponseData;
import com.nunna.questionnaire.model.StateResponse;
import com.nunna.questionnaire.services.LocalJsonClient;
import com.nunna.questionnaire.services.RestCallback;
import com.nunna.questionnaire.services.RestClient;
import com.nunna.questionnaire.services.RestError;
import com.nunna.questionnaire.utils.ShPrefManager;
import com.nunna.questionnaire.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.http.GET;

public class MainActivity extends AppCompatActivity {

    public Spinner stateSpinner;
    public EditText etContactNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!Utils.validatePhone(etContactNumber.getText().toString()))
                {
                    Snackbar.make(view, "Please enter Valid Phone Number", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                else
                {


                    RegisterUserRequest registerUserRequest = new RegisterUserRequest();
                    registerUserRequest.setStateid("8484");
                    registerUserRequest.setTelnumber("7659092000");
                    RestClient.getAPI().registerUser(registerUserRequest, new RestCallback<RegisterUserResponse>() {
                        @Override
                        public void failure(RestError restError) {
                            String errorMessage = String.valueOf(restError.getErrorMessage());
                            Log.i("RestClient", errorMessage);
                            showToast("Services need to be corrected");
                        }

                        @Override
                        public void success(RegisterUserResponse registerUserResponse, Response response) {
                            if ("Success".equalsIgnoreCase(registerUserResponse.getMessage())) {
                                int userId = registerUserResponse.getUserid();
                                ShPrefManager.with(MainActivity.this).saveUserId(userId);

                                Intent i = new Intent(MainActivity.this, QuestionnaireActivity.class);
                                i.putExtra("userId", userId);
                                startActivity(i);
                            }
                        }
                    });

                }
            }
        });
        etContactNumber = (EditText) findViewById(R.id.etContactNumber);
        stateSpinner = (Spinner) findViewById(R.id.stateSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.states_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        stateSpinner.setAdapter(adapter);

        RestClient.getAPI().getStateCodes(new RestCallback<StateResponse>() {
            @Override
            public void failure(RestError restError) {
                String errorMessage = String.valueOf(restError.getErrorMessage());
                Log.i("RestClient", errorMessage);
                showToast("Services need to be corrected");
            }

            @Override
            public void success(StateResponse stateResponse, Response response) {
                if("Success".equalsIgnoreCase(stateResponse.getMessage()))
                {
                    String responseJSON = stateResponse.getMessage();
                    try {
                        JSONObject json = new JSONObject(responseJSON);
                        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this,
                                R.array.states_array, android.R.layout.simple_spinner_item);
                        // Specify the layout to use when the list of choices appears
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        // Apply the adapter to the spinner
                        stateSpinner.setAdapter(adapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

//        /**
//         * A Retrofit Client that reads JSON files from disk and returns them as the response (to be handled by GSON).
//         * Make sure the context you pass is from the instrumentation app and put your JSON files in res/raw in the
//         * instrumentation project. Inspired by Ruby's vcr gem.
//
//         A GET request to /articles will look for the JSON file res/raw/get_articles.json, a POST request to /articles/123/
//         will look for the JSON file res/raw/post_articles_123.json, etc.
//
//         We use setScenario() if we want to test alternate responses so that a failed login POST to /login will read from res/raw/failed_login_post_login.json (and the happy path can use post_login.json).
//         */
//
//        Request request = new Request("get", "/get_state_list", null, null);
//        try {
//            Response response = new LocalJsonClient(this).execute(request);
//            response.
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void showToast(final String message)
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}