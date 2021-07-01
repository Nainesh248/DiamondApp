package com.adsum.freediamond.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

public class HomeActivity extends AppCompatActivity {
    CardView start;
    CardView share;
    CardView rating;
    CardView privacy;
    ImageView gift;
    private InterstitialAd interstitialAd;
    private AdView mAdView;
    com.facebook.ads.AdView fbAdView;
    com.facebook.ads.InterstitialAd fbinterstitialAd;
    RewardedVideoAd fbrewardedVideoAd;
    private RewardedAd rewardedAd;
    String google_banner, google_interitial, google_rewarded,google_native;
    String fb_banner, fb_interitial, fb_rewarded,fb_native;
    View adContainer;
    int i;
    boolean letsstartapp=false;
    boolean shareapp=false;
    boolean privacyapp=false;
    boolean ratingapp=false;
    boolean showAdds = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        adContainer = findViewById(R.id.adMobView);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdSettings.addTestDevice("4971f998-09b3-4c66-bb3d-e534b0e766f3");

        AudienceNetworkAds.initialize(this);

        google_banner = Splashscreen.appConfigModel.GOOGLE_BANNER_ID;
        google_interitial = Splashscreen.appConfigModel.GOOGLE_INTERITIAL_ID;
        google_rewarded = Splashscreen.appConfigModel.GOOGLE_REWARDED_ID;
        fb_banner = Splashscreen.appConfigModel.FACEBOOK_BANNER_ID;
        fb_interitial = Splashscreen.appConfigModel.FACEBOOK_INTERITIAL_ID;
        fb_rewarded = Splashscreen.appConfigModel.FACEBOOK_REWARDED_ID;
        fb_native = Splashscreen.appConfigModel.FACEBOOK_NATIVEAD_ID;
        google_native = Splashscreen.appConfigModel.GOOGLE_NATIVEAD_ID;

        mAdView = new AdView(this);
        mAdView.setAdSize(AdSize.LARGE_BANNER);
        i = 0;
        start = (CardView)findViewById(R.id.cv_letstart);
        share = (CardView)findViewById(R.id.cv_share);
        privacy = (CardView)findViewById(R.id.cv_privacy);
        rating = (CardView)findViewById(R.id.cv_rating);
        gift = (ImageView)findViewById(R.id.img_gift);
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
        if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
            load_RewardedVideoAd_admob();
        } else {
            loadRewardedVideoAd_fb();
        }
        init();
    }

    private void init() {
        try {
            gift.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                        googRewardedVideoAdleadshow();
                    } else {
                        facebookRewardedVideoAdadshow();
                    }
                }
            });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == start) {
                        i++;
                        if (i == 4)
                        {
                            letsstartapp = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                               googleinterstialadshow();
                            } else {
                               fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            Intent i = new Intent(HomeActivity.this, SubHomeActivity.class);
                            i.putExtra(Constants.GOOGLE_INTERITIAL_ID, google_interitial);
                            i.putExtra(Constants.FACEBOOK_INTERITIAL_ID, fb_interitial);
                            i.putExtra(Constants.GOOGLE_BANNER_ID, google_banner);
                            i.putExtra(Constants.FACEBOOK_BANNER_ID, fb_banner);
                            i.putExtra(Constants.GOOGLE_REWARDED_ID, google_rewarded);
                            i.putExtra(Constants.FACEBOOK_REWARDED_ID, fb_rewarded);
                            i.putExtra(Constants.GOOGLE_NATIVEAD_ID, google_native);
                            i.putExtra(Constants.FACEBOOK_NATIVEAD_ID, fb_native);
                            startActivity(i);
                        }

                    }
            }
        });
            share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == share) {
                        i++;
                        if (i == 4)
                        {
                            shareapp = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            shareapp();
                        }

                    }

                }
            });
            privacy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == privacy) {
                        i++;
                        if (i == 4)
                        {
                            privacyapp = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            Intent i = new Intent(HomeActivity.this, PrivacyActivity.class);
                            i.putExtra(Constants.GOOGLE_INTERITIAL_ID, google_interitial);
                            i.putExtra(Constants.FACEBOOK_INTERITIAL_ID, fb_interitial);
                            i.putExtra(Constants.GOOGLE_BANNER_ID, google_banner);
                            i.putExtra(Constants.FACEBOOK_BANNER_ID, fb_banner);
                            i.putExtra(Constants.GOOGLE_REWARDED_ID, google_rewarded);
                            i.putExtra(Constants.FACEBOOK_REWARDED_ID, fb_rewarded);
                            startActivity(i);
                        }

                    }
                }
            });
            rating.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == rating) {
                        i++;
                        if (i == 4)
                        {
                            ratingapp = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            rateus();
                        }

                    }

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void shareapp() {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", getResources().getString(R.string.app_name));
            StringBuilder sb = new StringBuilder();
            sb.append("\nHey, I am using Daily Free Diamond Fire guide 2020 App.\n\n");
            sb.append("https://play.google.com/store/apps/details?id=");
            sb.append(getPackageName());
            sb.append("\n\n");
            intent.putExtra("android.intent.extra.TEXT", sb.toString());
            startActivity(Intent.createChooser(intent, "choose one"));
        } catch (Exception unused) {
        }
    }
    @SuppressLint("WrongConstant")
    private void rateus() {
        StringBuilder sb = new StringBuilder();
        sb.append("market://details?id=");
        sb.append(getPackageName());
        String str = "android.intent.action.VIEW";
        Intent intent = new Intent(str, Uri.parse(sb.toString()));
        intent.addFlags(1208483840);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("http://play.google.com/store/apps/details?id=");
            sb2.append(getPackageName());
            startActivity(new Intent(str, Uri.parse(sb2.toString())));
        }
    }
    private void load_bannerAd_admob() {
        mAdView = new AdView(this);
        mAdView.setAdSize(AdSize.BANNER);
        mAdView.setAdUnitId(google_banner);
        AdRequest adRequest = new AdRequest.Builder().build();

        if(this.showAdds) {
            ((RelativeLayout) adContainer).addView(mAdView);
            mAdView.loadAd(adRequest);
        }

    }
    private void load_bannerAd_fb() {
        fbAdView = new com.facebook.ads.AdView(HomeActivity.this, fb_banner, com.facebook.ads.AdSize.BANNER_HEIGHT_50);
        ((RelativeLayout) adContainer).addView(fbAdView);
        AdListener adListener = new AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Log.e("TAG", "onError-------- " + ad + "   " + adError);

                Toast.makeText(
                        HomeActivity.this,
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
        fbinterstitialAd = new com.facebook.ads.InterstitialAd(this, fb_interitial);
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
        interstitialAd.setAdUnitId(google_interitial);

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
                if(letsstartapp){
                    Intent i = new Intent(HomeActivity.this, SubHomeActivity.class);
                    i.putExtra(Constants.GOOGLE_INTERITIAL_ID, google_interitial);
                    i.putExtra(Constants.FACEBOOK_INTERITIAL_ID, fb_interitial);
                    i.putExtra(Constants.GOOGLE_BANNER_ID, google_banner);
                    i.putExtra(Constants.FACEBOOK_BANNER_ID, fb_banner);
                    startActivity(i);
                }
                else if(shareapp){
                    shareapp();
                }
                else if(privacyapp){
                    Intent i = new Intent(HomeActivity.this, PrivacyActivity.class);
                    i.putExtra(Constants.GOOGLE_INTERITIAL_ID, google_interitial);
                    i.putExtra(Constants.FACEBOOK_INTERITIAL_ID, fb_interitial);
                    i.putExtra(Constants.GOOGLE_BANNER_ID, google_banner);
                    i.putExtra(Constants.FACEBOOK_BANNER_ID, fb_banner);
                    startActivity(i);
                }
                else if(ratingapp){
                    rateus();
                }
                letsstartapp=false;
                shareapp=false;
                privacyapp=false;
                ratingapp=false;
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
    private void load_RewardedVideoAd_admob() {
        rewardedAd = new RewardedAd(this,
                google_rewarded);

        RewardedAdLoadCallback adLoadCallback = new RewardedAdLoadCallback() {
            @Override
            public void onRewardedAdLoaded() {
                // Ad successfully loaded.
                if (rewardedAd.isLoaded()) {

                } else {
                    Log.d("TAG", "The rewarded ad wasn't loaded yet.");
                }
            }

            @Override
            public void onRewardedAdFailedToLoad(LoadAdError adError) {
                // Ad failed to load.
            }
        };
        rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);
    }
    public void googRewardedVideoAdleadshow(){
        RewardedAdCallback adCallback = new RewardedAdCallback() {
            @Override
            public void onRewardedAdOpened() {
                // Ad opened.
            }

            @Override
            public void onRewardedAdClosed() {
                // Ad closed.
            }

            @Override
            public void onUserEarnedReward(@NonNull com.google.android.gms.ads.rewarded.RewardItem rewardItem) {
            }
        };
        rewardedAd.show(HomeActivity.this,adCallback);
        load_RewardedVideoAd_admob();
    }
    public void facebookRewardedVideoAdadshow(){
        fbrewardedVideoAd.show();
        loadRewardedVideoAd_fb();
    }
    private void loadRewardedVideoAd_fb() {
        fbrewardedVideoAd = new RewardedVideoAd(this, fb_rewarded);
        com.facebook.ads.RewardedVideoAdListener rewardedVideoAdListener = new RewardedVideoAdListener() {
            @Override
            public void onError(Ad ad, AdError error) {
                Log.e("TAG", "Rewarded video ad failed to load: " + error.getErrorMessage());
            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.d("TAG", "Rewarded video ad is loaded and ready to be displayed!");

            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.d("TAG", "Rewarded video ad clicked!");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Log.d("TAG", "Rewarded video ad impression logged!");
            }

            @Override
            public void onRewardedVideoCompleted() {
                Log.d("TAG", "Rewarded video completed!");
            }

            @Override
            public void onRewardedVideoClosed() {
                Log.d("TAG", "Rewarded video ad closed!");
            }
        };
        fbrewardedVideoAd.loadAd(
                fbrewardedVideoAd.buildLoadAdConfig()
                        .withAdListener(rewardedVideoAdListener)
                        .build());
    }
}