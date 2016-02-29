package com.myluco.tweet.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.activeandroid.util.Log;
import com.astuetz.PagerSlidingTabStrip;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.myluco.tweet.R;
import com.myluco.tweet.TwitterApplication;
import com.myluco.tweet.TwitterClient;
import com.myluco.tweet.fragment.HomeTimelineFragment;
import com.myluco.tweet.fragment.MentionsTimelineFragment;
import com.myluco.tweet.handler.RateLimitHandler;
import com.myluco.tweet.model.Tweet;
import com.myluco.tweet.model.User;

import org.apache.http.Header;
import org.json.JSONObject;

import java.util.ArrayList;

public class TimelineActivity extends AppCompatActivity {

    private TwitterClient client;

    public static final int COMPOSE_ACTIVITY = 1;
    private User user;
    private ArrayList<Tweet> tweets;
    private Tweet newTweet;
    private HomeTimelineFragment fragmentTweetsList;

    private GoogleApiClient client2;

//    private HometimeResponseHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        //For the sliding Tabs
        //get view pager
        ViewPager vp = (ViewPager) findViewById(R.id.viewpager);
        //set the adapter
        vp.setAdapter(new TweetsPagerAdapter(getSupportFragmentManager()));

        //populate view pager indicator
        PagerSlidingTabStrip tabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        //attach tab strip to view pager
        tabStrip.setViewPager(vp);
        //end of sliding tabs

        client = TwitterApplication.getRestClient();
//        getRateLimits();
//        populate();
//        populateTimeline(count);
        populateUser();


    }


    //send API; fill listView


    private void populateUser() {
        client.getUser(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Log.i("DEBUG", response.toString());
//                Toast.makeText(getApplicationContext(), "SUCCESS 1", Toast.LENGTH_LONG).show();
                user = new User(response);
            }

            //FAILURE
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.i("DEBUG-R", errorResponse.toString());
//                Toast.makeText(getApplicationContext(), "FAILURE 1", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

                Log.i("DEBUG-R", responseString);
//                Toast.makeText(getApplicationContext(), "FAILURE 3", Toast.LENGTH_LONG).show();
            }


            @Override
            public void onUserException(Throwable error) {
                Log.i("DEBUG-R", error.toString());
//                Toast.makeText(getApplicationContext(), "FAILURE 4", Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.timeline_menu, menu);
        return true;
    }


    private void getRateLimits() {

        client.getRateLimit(new RateLimitHandler(getApplicationContext()));

    }

    public void onComposeSelected(MenuItem item) {
//        Toast.makeText(getApplicationContext(),"COMPOSE",Toast.LENGTH_LONG).show();
        Intent i = new Intent(getApplicationContext(), ComposeActivity.class);
        i.putExtra("user", user);
        startActivityForResult(i, COMPOSE_ACTIVITY);
    }

    public void onSettingsSelected(MenuItem item) {
        Toast.makeText(getApplicationContext(), "SETTINGS", Toast.LENGTH_LONG).show();
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == COMPOSE_ACTIVITY) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                newTweet = (Tweet) data.getSerializableExtra("tweet");
                tweets.add(0, newTweet);
//                adTweet.notifyDataSetChanged();
                fragmentTweetsList.notifyDataSetChanged();
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_compose:
                // User chose the Compose action, mark the current item
                // as a favorite...

                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }

    }

    public void onProfileSelected(MenuItem item) {
        //launch Profile
        Intent i = new Intent(this, ProfileActivity.class);
        i.putExtra("User", user);
        startActivity(i);

    }



    //returns the order of the fragments in View Pager
    public class TweetsPagerAdapter extends FragmentPagerAdapter {

        private String tabTitles[] = {"Home", "Mentions"};

        //how adapter gets the manager that insert/remove fragment from activity
        public TweetsPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }

        //order and creationg of fragments within the pager
        @Override
        public Fragment getItem(int pos) {
            if (pos == 0) return new HomeTimelineFragment();
            else if (pos == 1) return new MentionsTimelineFragment();
            return null;
        }

        @Override
        public int getCount() {
            return tabTitles.length;
        }
    }
}


