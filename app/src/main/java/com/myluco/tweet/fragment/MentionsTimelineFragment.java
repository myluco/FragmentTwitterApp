package com.myluco.tweet.fragment;

import android.os.Bundle;

import com.myluco.tweet.TwitterApplication;
import com.myluco.tweet.TwitterClient;

/**
 * Created by lcc on 2/28/16.
 */
public class MentionsTimelineFragment extends TweetsListFragment{
    protected TwitterClient client;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = TwitterApplication.getRestClient();
        populateTimeline();
    }

    public  void populateTimeline() {

        populateTimeline(count);
    }

    private void populateTimeline(int count) {
        long maxId = 0;
        if (count > 0) maxId = tweets.get(tweets.size() - 1).getUid();
        client.getMentionsTimeline(handler, maxId);

    }
    void loadMorePages(int count) {

        populateTimeline(count);
    }
}
