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

public class DiamondGuide extends AppCompatActivity {
    ImageView back;
    CardView playgames, entergame, openfreebox;
    TextView plygams, enterthegame, opnfrebox;
    String plygms, entrgm, opnfrbx;

    String ginurl,finurl,gburl,fburl,grewardedurl,frewardedburl;
    View adContainer;
    private AdView mAdView;
    private InterstitialAd interstitialAd;
    com.facebook.ads.InterstitialAd fbinterstitialAd;
    com.facebook.ads.AdView fbAdView;

    boolean play=false;
    boolean enter=false;
    boolean open=false;
    boolean showAdds = true;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diamond_guide2);

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

        playgames = (CardView) findViewById(R.id.cv_playgames);
        entergame = (CardView) findViewById(R.id.cv_entergame);
        openfreebox = (CardView) findViewById(R.id.cv_openfreebox);

        plygams = (TextView) findViewById(R.id.txt_playgames);
        enterthegame = (TextView) findViewById(R.id.txt_entergame);
        opnfrebox = (TextView) findViewById(R.id.txt_openfreebox);

        plygms = plygams.getText().toString();
        entrgm = enterthegame.getText().toString();
        opnfrbx = opnfrebox.getText().toString();

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
            playgames.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == playgames) {
                        i++;
                        if (i == 4)
                        {
                            play = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            Intent intent1 = new Intent(DiamondGuide.this, GuideDetailActivity.class);
                            Bundle data1 = new Bundle();
                            data1.putString(Constants.topic, plygms);
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
            entergame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == entergame) {
                        i++;
                        if (i == 4)
                        {
                            enter = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            Intent intent1 = new Intent(DiamondGuide.this, GuideDetailActivity.class);
                            Bundle data1 = new Bundle();
                            data1.putString(Constants.topic, entrgm);
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
            openfreebox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == openfreebox) {
                        i++;
                        if (i == 4)
                        {
                            open = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            Intent intent1 = new Intent(DiamondGuide.this, GuideDetailActivity.class);
                            Bundle data1 = new Bundle();
                            data1.putString(Constants.topic, opnfrbx);
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
        fbAdView = new com.facebook.ads.AdView(DiamondGuide.this, fburl, com.facebook.ads.AdSize.BANNER_HEIGHT_50);
        ((RelativeLayout) adContainer).addView(fbAdView);
        AdListener adListener = new AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Log.e("TAG", "onError-------- " + ad + "   " + adError);

                Toast.makeText(
                        DiamondGuide.this,
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
                if(play){
                    Intent intent1 = new Intent(DiamondGuide.this, GuideDetailActivity.class);
                    Bundle data1 = new Bundle();
                    data1.putString(Constants.topic, plygms);
                    data1.putString(Constants.detail, "");
                    data1.putString(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    data1.putString(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    data1.putString(Constants.GOOGLE_BANNER_ID, gburl);
                    data1.putString(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(data1);
                    startActivity(intent1);
                }
                else if(enter){
                    Intent intent1 = new Intent(DiamondGuide.this, GuideDetailActivity.class);
                    Bundle data1 = new Bundle();
                    data1.putString(Constants.topic, entrgm);
                    data1.putString(Constants.detail, "");
                    data1.putString(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    data1.putString(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    data1.putString(Constants.GOOGLE_BANNER_ID, gburl);
                    data1.putString(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(data1);
                    startActivity(intent1);
                }
                else if(open){
                    Intent intent1 = new Intent(DiamondGuide.this, GuideDetailActivity.class);
                    Bundle data1 = new Bundle();
                    data1.putString(Constants.topic, opnfrbx);
                    data1.putString(Constants.detail, "");
                    data1.putString(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    data1.putString(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    data1.putString(Constants.GOOGLE_BANNER_ID, gburl);
                    data1.putString(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(data1);
                    startActivity(intent1);
                }

                play=false;
                enter=false;
                open=false;

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