package com.myluco.tweet.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.myluco.tweet.listener.EndlessScrollListener;
import com.myluco.tweet.R;
import com.myluco.tweet.adapter.TweetsArrayAdapter;
import com.myluco.tweet.handler.HometimeResponseHandler;
import com.myluco.tweet.model.Tweet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcc on 2/28/16.
 */
public abstract class TweetsListFragment extends Fragment {


    protected TweetsArrayAdapter adTweet;
    protected ListView lvTweets;
    protected HometimeResponseHandler handler;
    protected ArrayList<Tweet> tweets;
    protected int count = 0;

    protected static final int PAGE_LIMIT = 5 ;
    public static final int PER_PAGE = 25 ;


        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_tweets_list,parent,false);
            lvTweets = (ListView)v.findViewById(R.id.lvTweets);
            lvTweets.setAdapter(adTweet);

            lvTweets.setOnScrollListener(new EndlessScrollListener() {
                @Override
                public boolean onLoadMore(int page, int totalItemsCount) {
                    // Triggered only when new data needs to be appended to the list
                    // Add whatever code is needed to append new items to your AdapterView
                    customLoadMoreDataFromApi(page);
                    // or customLoadMoreDataFromApi(totalItemsCount);
                    return true; // ONLY if more data is actually being loaded; false otherwise.
                }
            });
            return v;
        }
    private void customLoadMoreDataFromApi(int offset) {
        // This method probably sends out a network request and appends new data items to your adapter.
        // Use the offset value and add it as a parameter to your API request to retrieve paginated data.
        // Deserialize API response and then construct new objects to append to the adapter
        count++;
        if ((count < PAGE_LIMIT) || (moreTweets())){
            loadMorePages(count);
        }


    }
    abstract  void loadMorePages(int count);



    private boolean moreTweets() {
        if (tweets.size() == PER_PAGE) {
            return true;
        }
        return false;
    }

        @Override
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            tweets = new ArrayList<Tweet>();
            adTweet = new TweetsArrayAdapter(getActivity(), tweets);
            handler = new HometimeResponseHandler(adTweet);
        }





        public void addAll(List<Tweet> tweets) {
            adTweet.addAll(tweets);
        }

    public void notifyDataSetChanged() {
        adTweet.notifyDataSetChanged();
    }
}






