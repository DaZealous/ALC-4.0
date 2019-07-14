package com.example.alcchallenge;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import util.UserModel;

public class ProfileActivity extends AppCompatActivity {

    TextView displayName, displayTrack, displayCountry, displayEmail, displayPhone, displaySlack;
    String display_name, track, country, email, phone_number, slack_username;
    CircleImageView profileImage;
    ActionBar bar;
    UserModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        bar = getSupportActionBar();
        bar.setTitle("My Profile");
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setDisplayShowHomeEnabled(true);
        bar.setDisplayShowTitleEnabled(true);

        displayName = findViewById(R.id.display_name);
        displayTrack = findViewById(R.id.display_track);
        displayCountry = findViewById(R.id.display_country);
        displayEmail = findViewById(R.id.display_email);
        displayPhone = findViewById(R.id.display_phone);
        displaySlack = findViewById(R.id.display_slack_username);
        profileImage = findViewById(R.id.profile_image);

        model = new UserModel("Oseni Adewale", "Android", "Nigeria",
                "adewaleoseni6@gmail.com", "+2348080872923", "Oseni Adewale", R.id.profile_image);

        display_name = model.getDisplayName();
        track = getResources().getString(R.string.track) +" "+model.getTrack();
        country = getResources().getString(R.string.country) +" "+model.getCountry();
        email = getResources().getString(R.string.email) +" "+model.getEmail();
        phone_number = getResources().getString(R.string.phone) + " "+model.getPhone();
        slack_username = getResources().getString(R.string.slack_username) +" "+model.getSlackUsername();

        displayName.setText(display_name);
        displayTrack.setText(track);
        displayCountry.setText(country);
        displayEmail.setText(email);
        displayPhone.setText(phone_number);
        displaySlack.setText(slack_username);

    }
}
