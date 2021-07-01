package com.adsum.freediamond.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

public class TipsandTricks extends AppCompatActivity {
    ImageView back;
    CardView getdevice, exploremil, payattention, lookatthe, takecover, usethevehicle;
    TextView gtdevice, expemil, payation, lookthe, takcver, usevehicle;
    String gtdevce, exil, payaton, lookth, takcvr, usevhicl;

    String ginurl,finurl,gburl,fburl,grewardedurl,frewardedburl;
    View adContainer;
    private AdView mAdView;
    private InterstitialAd interstitialAd;
    com.facebook.ads.InterstitialAd fbinterstitialAd;
    com.facebook.ads.AdView fbAdView;

    boolean get=false;
    boolean exp=false;
    boolean pay=false;
    boolean look=false;
    boolean take=false;
    boolean use=false;
    boolean showAdds = true;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipsand_tricks);
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

        back = (ImageView) findViewById(R.id.img_back);

        getdevice = (CardView) findViewById(R.id.cv_getdevice);
        exploremil = (CardView) findViewById(R.id.cv_exploremil);
        payattention = (CardView) findViewById(R.id.cv_payattention);
        lookatthe = (CardView) findViewById(R.id.cv_lookatthe);
        takecover = (CardView) findViewById(R.id.cv_takecover);
        usethevehicle = (CardView) findViewById(R.id.cv_usethevehicle);

        gtdevice = (TextView) findViewById(R.id.txt_getdevice);
        expemil = (TextView) findViewById(R.id.txt_exploremil);
        payation = (TextView) findViewById(R.id.txt_payattention);
        lookthe = (TextView) findViewById(R.id.txt_lookatthe);
        takcver = (TextView) findViewById(R.id.txt_takecover);
        usevehicle = (TextView) findViewById(R.id.txt_usethevehicle);

        gtdevce = gtdevice.getText().toString();
        exil = expemil.getText().toString();
        payaton = payation.getText().toString();
        lookth = lookthe.getText().toString();
        takcvr = takcver.getText().toString();
        usevhicl = usevehicle.getText().toString();

        if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
            setInterstitialAd();
        } else {
            load_InterstitialAd_fb();
        }
        if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
            load_bannerAd_admob();
        } else {
            load_bannerAd_fb();
        }

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

            getdevice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == getdevice) {
                        i++;
                        if (i == 4)
                        {
                            get = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            Intent intent1 = new Intent(TipsandTricks.this, GuideDetailActivity.class);
                            Bundle data1 = new Bundle();
                            data1.putString(Constants.topic, gtdevce);
                            data1.putString(Constants.detail, "");
                            data1.putString(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                            data1.putString(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                            data1.putString(Constants.GOOGLE_BANNER_ID, gburl);
                            data1.putString(Constants.FACEBOOK_BANNER_ID, fburl);
                            intent1.putExtras(data1);
                            startActivity(intent1);
                        }

                    }

                }
            });
            exploremil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == exploremil) {
                        i++;
                        if (i == 4)
                        {
                            exp = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            Intent intent1 = new Intent(TipsandTricks.this, GuideDetailActivity.class);
                            Bundle data1 = new Bundle();
                            data1.putString(Constants.topic, exil);
                            data1.putString(Constants.detail, "");
                            data1.putString(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                            data1.putString(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                            data1.putString(Constants.GOOGLE_BANNER_ID, gburl);
                            data1.putString(Constants.FACEBOOK_BANNER_ID, fburl);
                            intent1.putExtras(data1);
                            startActivity(intent1);
                        }

                    }

                }
            });
            payattention.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == payattention) {
                        i++;
                        if (i == 4)
                        {
                            pay = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            Intent intent1 = new Intent(TipsandTricks.this, GuideDetailActivity.class);
                            Bundle data1 = new Bundle();
                            data1.putString(Constants.topic, payaton);
                            data1.putString(Constants.detail, "");
                            data1.putString(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                            data1.putString(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                            data1.putString(Constants.GOOGLE_BANNER_ID, gburl);
                            data1.putString(Constants.FACEBOOK_BANNER_ID, fburl);
                            intent1.putExtras(data1);
                            startActivity(intent1);
                        }

                    }

                }
            });
            lookatthe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == lookatthe) {
                        i++;
                        if (i == 4)
                        {
                            look = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            Intent intent1 = new Intent(TipsandTricks.this, GuideDetailActivity.class);
                            Bundle data1 = new Bundle();
                            data1.putString(Constants.topic, lookth);
                            data1.putString(Constants.detail, "");
                            data1.putString(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                            data1.putString(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                            data1.putString(Constants.GOOGLE_BANNER_ID, gburl);
                            data1.putString(Constants.FACEBOOK_BANNER_ID, fburl);
                            intent1.putExtras(data1);
                            startActivity(intent1);
                        }

                    }

                }
            });
            takecover.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == takecover) {
                        i++;
                        if (i == 4)
                        {
                            take = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            Intent intent1 = new Intent(TipsandTricks.this, GuideDetailActivity.class);
                            Bundle data1 = new Bundle();
                            data1.putString(Constants.topic, takcvr);
                            data1.putString(Constants.detail, "");
                            data1.putString(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                            data1.putString(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                            data1.putString(Constants.GOOGLE_BANNER_ID, gburl);
                            data1.putString(Constants.FACEBOOK_BANNER_ID, fburl);
                            intent1.putExtras(data1);
                            startActivity(intent1);
                        }

                    }

                }
            });
            usethevehicle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == usethevehicle) {
                        i++;
                        if (i == 4)
                        {
                            use = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            Intent intent1 = new Intent(TipsandTricks.this, GuideDetailActivity.class);
                            Bundle data1 = new Bundle();
                            data1.putString(Constants.topic, usevhicl);
                            data1.putString(Constants.detail, "");
                            data1.putString(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                            data1.putString(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                            data1.putString(Constants.GOOGLE_BANNER_ID, gburl);
                            data1.putString(Constants.FACEBOOK_BANNER_ID, fburl);
                            intent1.putExtras(data1);
                            startActivity(intent1);
                        }

                    }

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        fbAdView = new com.facebook.ads.AdView(TipsandTricks.this, fburl, com.facebook.ads.AdSize.BANNER_HEIGHT_50);
        ((RelativeLayout) adContainer).addView(fbAdView);
        AdListener adListener = new AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Log.e("TAG", "onError-------- " + ad + "   " + adError);

                Toast.makeText(
                        TipsandTricks.this,
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
                if(get){
                    Intent intent1 = new Intent(TipsandTricks.this, GuideDetailActivity.class);
                    Bundle data1 = new Bundle();
                    data1.putString(Constants.topic, gtdevce);
                    data1.putString(Constants.detail, "");
                    data1.putString(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    data1.putString(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    data1.putString(Constants.GOOGLE_BANNER_ID, gburl);
                    data1.putString(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(data1);
                    startActivity(intent1);
                }
                else if(exp){
                    Intent intent1 = new Intent(TipsandTricks.this, GuideDetailActivity.class);
                    Bundle data1 = new Bundle();
                    data1.putString(Constants.topic, exil);
                    data1.putString(Constants.detail, "");
                    data1.putString(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    data1.putString(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    data1.putString(Constants.GOOGLE_BANNER_ID, gburl);
                    data1.putString(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(data1);
                    startActivity(intent1);
                }
                else if(pay){
                    Intent intent1 = new Intent(TipsandTricks.this, GuideDetailActivity.class);
                    Bundle data1 = new Bundle();
                    data1.putString(Constants.topic, payaton);
                    data1.putString(Constants.detail, "");
                    data1.putString(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    data1.putString(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    data1.putString(Constants.GOOGLE_BANNER_ID, gburl);
                    data1.putString(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(data1);
                    startActivity(intent1);
                }
                else if(look){
                    Intent intent1 = new Intent(TipsandTricks.this, GuideDetailActivity.class);
                    Bundle data1 = new Bundle();
                    data1.putString(Constants.topic, lookth);
                    data1.putString(Constants.detail, "");
                    data1.putString(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    data1.putString(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    data1.putString(Constants.GOOGLE_BANNER_ID, gburl);
                    data1.putString(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(data1);
                    startActivity(intent1);
                }
                else if(take){
                    Intent intent1 = new Intent(TipsandTricks.this, GuideDetailActivity.class);
                    Bundle data1 = new Bundle();
                    data1.putString(Constants.topic, takcvr);
                    data1.putString(Constants.detail, "");
                    data1.putString(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    data1.putString(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    data1.putString(Constants.GOOGLE_BANNER_ID, gburl);
                    data1.putString(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(data1);
                    startActivity(intent1);
                }
                else if(use){
                    Intent intent1 = new Intent(TipsandTricks.this, GuideDetailActivity.class);
                    Bundle data1 = new Bundle();
                    data1.putString(Constants.topic, usevhicl);
                    data1.putString(Constants.detail, "");
                    data1.putString(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    data1.putString(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    data1.putString(Constants.GOOGLE_BANNER_ID, gburl);
                    data1.putString(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(data1);
                    startActivity(intent1);
                }
                get=false;
                exp=false;
                pay=false;
                look=false;
                take=false;
                use=false;
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