package com.myluco.tweet.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.myluco.tweet.R;
import com.myluco.tweet.fragment.UserTimelineFragment;
import com.myluco.tweet.model.User;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        user = (User) getIntent().getSerializableExtra("User");
        getSupportActionBar().setTitle("@"+user.getScreenName());
        populateProfileHeader();
        if (savedInstanceState == null) {

            UserTimelineFragment fragmentUserTimeline = UserTimelineFragment.newInstance(user);
            //display user time line - We need to insert dynamically
            //need to put a container
            android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fl_container, fragmentUserTimeline);

            ft.commit();
        }
    }

    private void populateProfileHeader() {
        ImageView ivUser = (ImageView)findViewById(R.id.ivProfileImage);
        TextView tvUser = (TextView)findViewById(R.id.tvUsername);
        TextView tvTagline = (TextView) findViewById(R.id.tvTagline);
        TextView tvFollowers = (TextView) findViewById(R.id.tvFollowers);
        TextView tvFollowing = (TextView)findViewById(R.id.tvFollowing);
        tvUser.setText(user.getName());
        tvTagline.setText(user.getTagLine());
        tvFollowers.setText(user.getFollowersCount()+" Followers");
        tvFollowing.setText(user.getFollowingCount()+" Following");
        Picasso.with(this).load(user.getProfileImageUrl()).into(ivUser);

    }

}
