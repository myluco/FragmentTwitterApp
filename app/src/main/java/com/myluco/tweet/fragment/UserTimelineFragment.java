package com.myluco.tweet.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myluco.tweet.R;
import com.myluco.tweet.TwitterApplication;
import com.myluco.tweet.TwitterClient;
import com.myluco.tweet.model.User;

public class UserTimelineFragment extends TweetsListFragment {

    protected User user;
    protected TwitterClient client;

     public static UserTimelineFragment newInstance(User user) {
         UserTimelineFragment fragment = new UserTimelineFragment();
         Bundle args = new Bundle();
         args.putSerializable("USER", user);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = TwitterApplication.getRestClient();
        user = (User)getArguments().getSerializable("USER");
        populateTimeline();
    }

    public  void populateTimeline() {

        populateTimeline(count);
    }

    private void populateTimeline(int count) {
        long maxId = 0;
        if (count > 0) maxId = tweets.get(tweets.size() - 1).getUid();
        client.getUserTimeline(handler, user.getScreenName(), maxId);

    }
    void loadMorePages(int count) {

        populateTimeline(count);
    }


}
