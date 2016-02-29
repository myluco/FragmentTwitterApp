package com.myluco.tweet.handler;

import android.widget.Toast;

import com.activeandroid.util.Log;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.myluco.tweet.adapter.TweetsArrayAdapter;
import com.myluco.tweet.model.Tweet;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by lcc on 2/28/16.
 */
public class HometimeResponseHandler extends JsonHttpResponseHandler {
    //SUCCESS
    TweetsArrayAdapter adTweet;
    public HometimeResponseHandler(TweetsArrayAdapter adapter) {
        adTweet = adapter;
    }
    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
//                Log.i("DEBUG", response.toString());
        List<Tweet> localList = Tweet.ParseTweets(response);
        if (localList != null) {
            adTweet.addAll(localList);
        }
//                Toast.makeText(getApplicationContext(),tweets.get(0).getBody(),Toast.LENGTH_LONG).show();
    }

    //FAILURE
    @Override
    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
        Log.v("DEBUG", errorResponse.toString());
            Toast.makeText(adTweet.getContext(), "FAILURE 1", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {

    }


    @Override
    public void onUserException(Throwable error) {
        Log.v("DEBUG", error.toString());
               Toast.makeText(adTweet.getContext(),"FAILURE 4",Toast.LENGTH_LONG).show();
    }


}
