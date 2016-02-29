package com.myluco.tweet.handler;

import android.content.Context;
import android.widget.Toast;

import com.activeandroid.util.Log;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by lcc on 2/28/16.
 */
public class RateLimitHandler extends JsonHttpResponseHandler {
    Context context;
    public RateLimitHandler(Context context) {
        this.context = context;
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
        Log.i("DEBUG", response.toString());
        Toast.makeText(context, "SUCCESS 1", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
        Log.i("DEBUG", response.toString());
        Toast.makeText(context, "SUCCESS 2", Toast.LENGTH_LONG).show();
    }

    //FAILURE
    @Override
    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
        Log.i("DEBUG-R", errorResponse.toString());
//            Toast.makeText(getApplicationContext(),"FAILURE 1",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
        Log.i("DEBUG-R", errorResponse.toString());
//            Toast.makeText(getApplicationContext(),"FAILURE 2",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

        Log.i("DEBUG-R", responseString);
//            Toast.makeText(getApplicationContext(),"FAILURE 3",Toast.LENGTH_LONG).show();
    }


    @Override
    public void onUserException(Throwable error) {
        Log.i("DEBUG-R", error.toString());
//            Toast.makeText(getApplicationContext(),"FAILURE 4",Toast.LENGTH_LONG).show();
    }


}
