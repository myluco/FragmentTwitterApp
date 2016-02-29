package com.myluco.tweet.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by lcc on 2/20/16.
 */
public class User implements Serializable{
    /*
    "user": {
      "name": "Taylor Singletary",
      "profile_image_url": "http://a0.twimg.com/profile_images/2546730059/f6a8zq58mg1hn0ha8vie_normal.jpeg",

      },
     */
    private String name;
    private long uid;
    private String profileImageUrl;
    private String screenName;
    private String tagLine;
    private int followersCount;
    private int followingCount;


    public long getUid() {
        return uid;
    }

    public String getScreenName() {
        return screenName;
    }

    public String getName() {
        return name;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }


    public String getTagLine() {
        return tagLine;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public int getFollowingCount() {
        return followingCount;
    }

    public User(JSONObject jsonUser) {
        try {
            name = jsonUser.getString("name");
            profileImageUrl = jsonUser.getString("profile_image_url");
            uid = jsonUser.getLong("id");
            screenName = jsonUser.getString("screen_name");
            tagLine = jsonUser.getString("description");
            followersCount = jsonUser.getInt("followers_count");
            followingCount = jsonUser.getInt("friends_count");

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public User() {

    }
}
