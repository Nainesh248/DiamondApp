package com.adsum.freediamond.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.adsum.freediamond.R;
import com.adsum.freediamond.Splashscreen;
import com.adsum.freediamond.config.Constants;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Random;

public class SpinnerActivity extends AppCompatActivity {
    ImageView back;
    String current_score;
    int degree = 0;
    int degree_old = 0;
    Random r;
    int score=0;
    Button spin;
    TextView txtscore;
    int intValue;
    ImageView wheel;
    public static final float FACTOR = 15f;
    String ginurl,finurl,gburl,fburl,grewardedurl,frewardedburl;
    View adContainer;
    private AdView mAdView;
    private InterstitialAd interstitialAd;
    com.facebook.ads.InterstitialAd fbinterstitialAd;
    com.facebook.ads.AdView fbAdView;
    boolean spinwheel=false;
    boolean showAdds = true;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        adContainer = findViewById(R.id.adMobView);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdSettings.addTestDevice("4971f998-09b3-4c66-bb3d-e534b0e766f3");

        AudienceNetworkAds.initialize(this);
        Intent intent = getIntent();
        ginurl= intent.getStringExtra(Constants.GOOGLE_INTERITIAL_ID);
        gburl= intent.getStringExtra(Constants.GOOGLE_BANNER_ID);
        finurl= intent.getStringExtra(Constants.FACEBOOK_INTERITIAL_ID);
        fburl= intent.getStringExtra(Constants.FACEBOOK_BANNER_ID);

        mAdView = new AdView(this);
        mAdView.setAdSize(AdSize.LARGE_BANNER);
        i = 0;

        back=(ImageView)findViewById(R.id.img_back);
        spin=(Button) findViewById(R.id.btn_spin);
        wheel=(ImageView) findViewById(R.id.imgspinner);
        txtscore=(TextView) findViewById(R.id.txt_score);



        current_score  = currentNumber(360 - (degree % 360));


        r = new Random();
        if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
            setInterstitialAd();
        } else {
            load_InterstitialAd_fb();
        }
//        if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
//            load_bannerAd_admob();
//        } else {
//            load_bannerAd_fb();
//        }
        init();
    }
    private void init() {
        try {
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            spin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == spin) {
                        i++;
                        if (i == 4)
                        {
                            spinwheel = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            wheelrotate();
                        }

                    }

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void wheelrotate(){
        degree_old = degree % 360;
        degree = r.nextInt(3600) + 720;

        RotateAnimation rotateAnimation = new RotateAnimation(degree_old, degree,
                RotateAnimation.RELATIVE_TO_SELF, .5f,
                RotateAnimation.RELATIVE_TO_SELF, .5f);


        rotateAnimation.setDuration(3600);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());


        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

                txtscore.setText("");
            }

            @Override
            public void onAnimationEnd(Animation animation) {



                txtscore.setText( currentNumber(360 - (degree % 360)));


                SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();

                int n =  intValue+score;
                editor.putInt("your_int_key", n);
                editor.commit();


                SharedPreferences spe = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                int  myIntValue = spe.getInt("your_int_key", 0);


//                            user_id_child.child("scores").setValue(+n);
                diaglog();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        wheel.startAnimation(rotateAnimation);
    }
    private String currentNumber(int degree){

        String text = "";



        if(degree>= (FACTOR*1) && degree<(FACTOR*3)  ){

            text = "ZERO";

            score = score+2;

        }


        if(degree>= (FACTOR*3) && degree<(FACTOR*5)  ){

            text = "2$";
            score = score+3;
        }

        if(degree>= (FACTOR*5) && degree<(FACTOR*7)  ){

            text = "50$";
            score = score+10;
        }

        if(degree>= (FACTOR*7) && degree<(FACTOR*9)  ){

            text = "1$";
            score = score+5;

        }

        if(degree>= (FACTOR*9) && degree<(FACTOR*11)  ){

            text = "5$";
            score = score+6;
        }

        if(degree>= (FACTOR*11) && degree<(FACTOR*13)  ){

            text = "20$";
            score = score+7;
        }

        if(degree>= (FACTOR*13) && degree<(FACTOR*15)  ){

            text = "JACKPOT";
            score = score+8;
        }

        if(degree>= (FACTOR*15) && degree<(FACTOR*17)  ){

            text = "15$";
            score = score+9;
        }

        if(degree>= (FACTOR*17) && degree<(FACTOR*19)  ){

            text = "100$";
            score = score+100;
        }

        if(degree>= (FACTOR*19) && degree<(FACTOR*21)  ){

            text = "1$";
            score = score+11;
        }

        if(degree>= (FACTOR*21) && degree<(FACTOR*23)  ){

            text = "5$";
            score = score+12;
        }

        if(degree>= (FACTOR*23) && degree<(360) || degree>=0 && degree <(FACTOR*1) ){

            text = "10$";

        }

        return text;

    }
    public void diaglog(){


        final Dialog dialog = new Dialog(SpinnerActivity.this);
        dialog.setContentView(R.layout.custom_dialog);
        Button dialogButton = (Button) dialog.findViewById(R.id.cool_id);
        TextView textView = (TextView)dialog.findViewById(R.id.dialog_score_id);
        String a = currentNumber(360 - (degree % 360));

        textView.setText(a+" ");






        // if button is clicked, close the custom dialog

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();


            }
        });
        dialog.show();

    }
    private void load_bannerAd_admob() {
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = new AdView(this);
        mAdView.setAdSize(AdSize.BANNER);
        mAdView.setAdUnitId(gburl);
        AdRequest adRequest = new AdRequest.Builder().build();
        if(this.showAdds) {
            ((RelativeLayout) adContainer).addView(mAdView);
            mAdView.loadAd(adRequest);
        }

    }
    private void load_bannerAd_fb() {
        fbAdView = new com.facebook.ads.AdView(SpinnerActivity.this, fburl, com.facebook.ads.AdSize.BANNER_HEIGHT_50);
        ((RelativeLayout) adContainer).addView(fbAdView);
        AdListener adListener = new AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Log.e("TAG", "onError-------- " + ad + "   " + adError);

                Toast.makeText(
                        SpinnerActivity.this,
                        "Error: " + adError.getErrorMessage(),
                        Toast.LENGTH_LONG)
                        .show();
            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.e("TAG", "onAdLoaded-------- " + ad);
                // Ad loaded callback
            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.e("TAG", "onAdClicked-------- " + ad);
                // Ad clicked callback
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Log.e("TAG", "onLoggingImpression-------- " + ad);
                // Ad impression logged callback
            }
        };
        if(this.showAdds) {
            fbAdView.loadAd(fbAdView.buildLoadAdConfig().withAdListener(adListener).build());
        }


    }
    private void load_InterstitialAd_fb() {
        fbinterstitialAd = new com.facebook.ads.InterstitialAd(this, finurl);
        InterstitialAdListener interstitialAdListener=new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {

            }

            @Override
            public void onInterstitialDismissed(Ad ad) {

            }

            @Override
            public void onError(Ad ad, AdError adError) {

            }

            @Override
            public void onAdLoaded(Ad ad) {

            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        };
    }
    public void setInterstitialAd(){
        interstitialAd = new InterstitialAd(this);

        // set the ad unit ID
        interstitialAd.setAdUnitId(ginurl);

        AdRequest adRequest = new AdRequest.Builder()
                .build();

        // Load ads into Interstitial Ads
        interstitialAd.loadAd(adRequest);

        interstitialAd.setAdListener(new com.google.android.gms.ads.AdListener() {
            public void onAdLoaded() {
                if (interstitialAd.isLoaded()) {

                }

            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                if(spinwheel){
                    wheelrotate();
                }
                spinwheel=false;

            }
        });
    }
    public void googleinterstialadshow(){
        interstitialAd.show();
        setInterstitialAd();

    }
    public void fbinterstialadshow(){
        fbinterstitialAd.show();
        load_InterstitialAd_fb();

    }
}