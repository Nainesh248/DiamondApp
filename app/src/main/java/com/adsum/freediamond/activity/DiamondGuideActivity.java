package com.adsum.freediamond.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

public class DiamondGuideActivity extends AppCompatActivity {
    CardView cvtips,cvweapon,cvcharacter,cvvehicle,cvdiamond;
    TextView txttips;

    String ginurl,finurl,gburl,fburl,grewardedurl,frewardedburl,gnative,fnative;
    View adContainer;
    private AdView mAdView;
    private InterstitialAd interstitialAd;
    com.facebook.ads.InterstitialAd fbinterstitialAd;
    com.facebook.ads.AdView fbAdView;

    boolean tips=false;
    boolean weapon=false;
    boolean character=false;
    boolean vehicle=false;
    boolean diamond=false;
    boolean showAdds = true;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diamond_guide);
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
        gnative= intent.getStringExtra(Constants.GOOGLE_NATIVEAD_ID);
        fnative = intent.getStringExtra(Constants.FACEBOOK_NATIVEAD_ID);

        mAdView = new AdView(this);
        mAdView.setAdSize(AdSize.LARGE_BANNER);
        i = 0;
        txttips = (TextView)findViewById(R.id.for_free);

        cvtips = (CardView)findViewById(R.id.cv_tips);
        cvweapon = (CardView)findViewById(R.id.cv_weapon);
        cvcharacter = (CardView)findViewById(R.id.cv_character);
        cvvehicle = (CardView)findViewById(R.id.cv_vehicle);
        cvdiamond = (CardView)findViewById(R.id.cv_diamond);


        Shader shader5 = new LinearGradient(0, 0, 0,txttips.getTextSize(),getColor(R.color.appxolorlight), getColor(R.color.appcolor),
                Shader.TileMode.CLAMP);
        txttips.getPaint().setShader(shader5);
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
            cvtips.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cvtips) {
                        i++;
                        if (i == 4)
                        {
                            tips = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            Intent i = new Intent(DiamondGuideActivity.this, TipsandTricks.class);
                            i.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                            i.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                            i.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                            i.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                            i.putExtra(Constants.GOOGLE_NATIVEAD_ID, gnative);
                            i.putExtra(Constants.FACEBOOK_NATIVEAD_ID, fnative);
                            startActivity(i);
                        }

                    }
                }
            });
            cvweapon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cvweapon) {
                        i++;
                        if (i == 4)
                        {
                            weapon = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            Intent i = new Intent(DiamondGuideActivity.this, WeaponsGuide.class);
                            i.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                            i.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                            i.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                            i.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                            i.putExtra(Constants.GOOGLE_NATIVEAD_ID, gnative);
                            i.putExtra(Constants.FACEBOOK_NATIVEAD_ID, fnative);
                            startActivity(i);
                        }

                    }
                }
            });
            cvcharacter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cvcharacter) {
                        i++;
                        if (i == 4)
                        {
                            character = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            Intent i = new Intent(DiamondGuideActivity.this, CharacterGuide.class);
                            i.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                            i.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                            i.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                            i.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                            i.putExtra(Constants.GOOGLE_NATIVEAD_ID, gnative);
                            i.putExtra(Constants.FACEBOOK_NATIVEAD_ID, fnative);
                            startActivity(i);
                        }

                    }
                }
            });
            cvvehicle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cvvehicle) {
                        i++;
                        if (i == 4)
                        {
                            vehicle = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            Intent i = new Intent(DiamondGuideActivity.this, VehiclesGuide.class);
                            i.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                            i.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                            i.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                            i.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                            i.putExtra(Constants.GOOGLE_NATIVEAD_ID, gnative);
                            i.putExtra(Constants.FACEBOOK_NATIVEAD_ID, fnative);
                            startActivity(i);
                        }

                    }
                }
            });
            cvdiamond.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cvdiamond) {
                        i++;
                        if (i == 4)
                        {
                            diamond = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            Intent i = new Intent(DiamondGuideActivity.this, DiamondGuide.class);
                            i.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                            i.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                            i.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                            i.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                            startActivity(i);
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
        fbAdView = new com.facebook.ads.AdView(DiamondGuideActivity.this, fburl, com.facebook.ads.AdSize.BANNER_HEIGHT_50);
        ((RelativeLayout) adContainer).addView(fbAdView);
        AdListener adListener = new AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Log.e("TAG", "onError-------- " + ad + "   " + adError);

                Toast.makeText(
                        DiamondGuideActivity.this,
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
                if(tips){
                    Intent i = new Intent(DiamondGuideActivity.this, TipsandTricks.class);
                    i.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    i.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    i.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    i.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    startActivity(i);
                }
                else if(weapon){
                    Intent i = new Intent(DiamondGuideActivity.this, WeaponsGuide.class);
                    i.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    i.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    i.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    i.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    startActivity(i);
                }
                else if(character){
                    Intent i = new Intent(DiamondGuideActivity.this, CharacterGuide.class);
                    i.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    i.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    i.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    i.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    startActivity(i);
                }
                else if(vehicle){
                    Intent i = new Intent(DiamondGuideActivity.this, VehiclesGuide.class);
                    i.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    i.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    i.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    i.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    startActivity(i);
                }
                else if(diamond){
                    Intent i = new Intent(DiamondGuideActivity.this, DiamondGuide.class);
                    i.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    i.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    i.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    i.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    startActivity(i);
                }
                tips=false;
                weapon=false;
                character=false;
                vehicle=false;
                diamond=false;
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