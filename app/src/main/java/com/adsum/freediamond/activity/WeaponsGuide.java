package com.adsum.freediamond.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.adsum.freediamond.R;
import com.adsum.freediamond.Splashscreen;
import com.adsum.freediamond.config.Constants;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeaponsGuide extends AppCompatActivity {
    ImageView back;
    CardView cv_an94, cv_m4a1, cv_m14, cv_ak47, cv_groza, cv_scarl,cv_famas;
    ImageView img_an94, img_m4a1, img_m14, img_ak47, img_groza, img_scarl,img_famas;
    Button txt_an94, txt_m4a1, txt_m14, txt_ak47, txt_groza, txt_scarl,txt_famas;
    TextView topic_an94, topic_m4a1, topic_m14, topic_ak47, topic_groza, topic_scarl,topic_famas;
    Boolean left,right;

    String ginurl,finurl,gburl,fburl,grewardedurl,frewardedburl,gnative,fnative;
    View adContainer;
    private AdView mAdView;
    private InterstitialAd interstitialAd;
    com.facebook.ads.InterstitialAd fbinterstitialAd;
    com.facebook.ads.AdView fbAdView;
    private static final String ADMOB_AD_UNIT_ID = "ca-app-pub-3940256099942544/2247696110";
    boolean an69=false;
    boolean m4a1=false;
    boolean ak47=false;
    boolean groza=false;
    boolean scarl=false;
    boolean m14=false;
    boolean famas=false;
    boolean showAdds = true;
    int i;
    TemplateView templateView;
    // creating NativeAdLayout object
    private NativeAdLayout nativeAdLayout;
    // creating  LinearLayout object
    private LinearLayout adView;
    // creating  NativeAd object
    private NativeAd nativeAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapons_guide);

        adContainer = findViewById(R.id.adMobView);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        List<String> testDeviceIds = Arrays.asList("56B7DAB45BB2207A58B0759A167DA40E");
        RequestConfiguration configuration =
                new RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build();
        MobileAds.setRequestConfiguration(configuration);
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

        back=(ImageView)findViewById(R.id.img_back);
        nativeAdLayout = findViewById(R.id.native_ad_container);
       templateView = findViewById(R.id.nativeTemplateView);

        cv_an94 = (CardView) findViewById(R.id.cv_an94);
        cv_m4a1 = (CardView) findViewById(R.id.cv_m4a1);
        cv_m14 = (CardView) findViewById(R.id.cv_m14);
        cv_ak47 = (CardView) findViewById(R.id.cv_ak47);
        cv_groza = (CardView) findViewById(R.id.cv_groza);
        cv_scarl = (CardView) findViewById(R.id.cv_scarl);
        cv_famas = (CardView) findViewById(R.id.cv_famas);

        txt_an94 = (Button) findViewById(R.id.txt_an94);
        txt_m4a1 = (Button) findViewById(R.id.txt_m4a1);
        txt_m14 = (Button) findViewById(R.id.txt_m14);
        txt_ak47 = (Button) findViewById(R.id.txt_ak47);
        txt_groza = (Button) findViewById(R.id.txt_groza);
        txt_scarl = (Button) findViewById(R.id.txt_scarl);
        txt_famas = (Button) findViewById(R.id.txt_famas);

        topic_an94 = (TextView) findViewById(R.id.txt_an94topic);
        topic_m4a1 = (TextView) findViewById(R.id.txt_m4a1topic);
        topic_m14 = (TextView) findViewById(R.id.txt_m14topic);
        topic_ak47 = (TextView) findViewById(R.id.txt_ak47topic);
        topic_groza = (TextView) findViewById(R.id.txt_grozatopic);
        topic_scarl = (TextView) findViewById(R.id.txt_scarltopic);
        topic_famas = (TextView) findViewById(R.id.txt_famastopic);


        img_an94 = (ImageView) findViewById(R.id.img_an94);
        img_m4a1 = (ImageView) findViewById(R.id.img_m4a1);
        img_m14 = (ImageView) findViewById(R.id.img_m14);
        img_ak47 = (ImageView) findViewById(R.id.img_ak47);
        img_groza = (ImageView) findViewById(R.id.img_groza);
        img_scarl = (ImageView) findViewById(R.id.img_scarl);
        img_famas = (ImageView) findViewById(R.id.img_famas);

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
            load_nativeAd_admob();
        } else {
            load_nativeAd_fb();
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
            cv_an94.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cv_an94) {
                        i++;
                        if (i == 4)
                        {
                            an69 = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            left=true;
                            Intent intent1 = new Intent(WeaponsGuide.this, WeapoDetailActivity.class);
                            intent1.putExtra(Constants.topic, txt_an94.getText().toString());
                            intent1.putExtra(Constants.side, left.toString());
                            intent1.putExtra(Constants.detail, topic_an94.getText().toString());
                            intent1.putExtra(Constants.image, R.drawable.ic_an94);
                            intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                            intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                            intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                            intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                            intent1.putExtras(intent1);
                            startActivity(intent1);
                        }

                    }
                }
            });
            cv_m4a1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cv_m4a1) {
                        i++;
                        if (i == 4)
                        {
                            m4a1 = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            left=false;
                            Intent intent1 = new Intent(WeaponsGuide.this, WeapoDetailActivity.class);
                            intent1.putExtra(Constants.topic, txt_m4a1.getText().toString());
                            intent1.putExtra(Constants.side, left.toString());
                            intent1.putExtra(Constants.detail, topic_m4a1.getText().toString() );
                            intent1.putExtra(Constants.image, R.drawable.ic_m4a1);
                            intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                            intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                            intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                            intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                            intent1.putExtras(intent1);
                            startActivity(intent1);
                        }

                    }
                }
            });
            cv_m14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cv_m14) {
                        i++;
                        if (i == 4)
                        {
                            m14 = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            left=true;
                            Intent intent1 = new Intent(WeaponsGuide.this, WeapoDetailActivity.class);
                            intent1.putExtra(Constants.topic,  txt_m14.getText().toString());
                            intent1.putExtra(Constants.side, left.toString());
                            intent1.putExtra(Constants.detail,  topic_m14.getText().toString());
                            intent1.putExtra(Constants.image, R.drawable.ic_m14);
                            intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                            intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                            intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                            intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                            intent1.putExtras(intent1);
                            startActivity(intent1);
                        }

                    }
                }
            });
            cv_ak47.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cv_ak47) {
                        i++;
                        if (i == 4)
                        {
                            ak47 = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            left=false;
                            Intent intent1 = new Intent(WeaponsGuide.this, WeapoDetailActivity.class);
                            intent1.putExtra(Constants.topic,  txt_ak47.getText().toString());
                            intent1.putExtra(Constants.side, left.toString());
                            intent1.putExtra(Constants.detail, topic_ak47.getText().toString() );
                            intent1.putExtra(Constants.image, R.drawable.ic_ak47);
                            intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                            intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                            intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                            intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                            intent1.putExtras(intent1);
                            startActivity(intent1);
                        }

                    }
                }
            });
            cv_groza.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cv_groza) {
                        i++;
                        if (i == 4)
                        {
                            groza = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            left=true;
                            Intent intent1 = new Intent(WeaponsGuide.this, WeapoDetailActivity.class);
                            intent1.putExtra(Constants.topic,  txt_groza.getText().toString());
                            intent1.putExtra(Constants.side, left.toString());
                            intent1.putExtra(Constants.detail,  topic_groza.getText().toString());
                            intent1.putExtra(Constants.image, R.drawable.ic_groza);
                            intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                            intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                            intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                            intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                            intent1.putExtras(intent1);
                            startActivity(intent1);
                        }

                    }
                }
            });
            cv_scarl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cv_scarl) {
                        i++;
                        if (i == 4)
                        {
                            scarl = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            left=false;
                            Intent intent1 = new Intent(WeaponsGuide.this, WeapoDetailActivity.class);
                            intent1.putExtra(Constants.topic,  txt_scarl.getText().toString());
                            intent1.putExtra(Constants.side, left.toString());
                            intent1.putExtra(Constants.detail, topic_scarl.getText().toString() );
                            intent1.putExtra(Constants.image, R.drawable.ic_scarl);
                            intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                            intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                            intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                            intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                            intent1.putExtras(intent1);
                            startActivity(intent1);
                        }

                    }
                }
            });
            cv_famas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cv_famas) {
                        i++;
                        if (i == 4)
                        {
                            famas = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            left=true;
                            Intent intent1 = new Intent(WeaponsGuide.this, WeapoDetailActivity.class);
                            intent1.putExtra(Constants.topic,  txt_famas.getText().toString());
                            intent1.putExtra(Constants.side, left.toString());
                            intent1.putExtra(Constants.detail,  topic_famas.getText().toString());
                            intent1.putExtra(Constants.image, R.drawable.ic_falas);
                            intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                            intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                            intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                            intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                            intent1.putExtras(intent1);
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
        fbAdView = new com.facebook.ads.AdView(WeaponsGuide.this, fburl, com.facebook.ads.AdSize.BANNER_HEIGHT_50);
        ((RelativeLayout) adContainer).addView(fbAdView);
        AdListener adListener = new AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Log.e("TAG", "onError-------- " + ad + "   " + adError);

                Toast.makeText(
                        WeaponsGuide.this,
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

        if(this.showAdds) {
            interstitialAd.loadAd(adRequest);
        }
        // Load ads into Interstitial Ads


        interstitialAd.setAdListener(new com.google.android.gms.ads.AdListener() {
            public void onAdLoaded() {
                if (interstitialAd.isLoaded()) {

                }

            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                if(an69){
                    left=true;
                    Intent intent1 = new Intent(WeaponsGuide.this, WeapoDetailActivity.class);
                    intent1.putExtra(Constants.topic, txt_an94.getText().toString());
                    intent1.putExtra(Constants.side, left.toString());
                    intent1.putExtra(Constants.detail, topic_an94.getText().toString());
                    intent1.putExtra(Constants.image, R.drawable.ic_an94);
                    intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(intent1);
                    startActivity(intent1);
                }
                else if(m4a1){
                    left=false;
                    Intent intent1 = new Intent(WeaponsGuide.this, WeapoDetailActivity.class);
                    intent1.putExtra(Constants.topic, txt_m4a1.getText().toString());
                    intent1.putExtra(Constants.side, left.toString());
                    intent1.putExtra(Constants.detail, topic_m4a1.getText().toString() );
                    intent1.putExtra(Constants.image, R.drawable.ic_m4a1);
                    intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(intent1);
                    startActivity(intent1);
                }
                else if(m14){
                    left=true;
                    Intent intent1 = new Intent(WeaponsGuide.this, WeapoDetailActivity.class);
                    intent1.putExtra(Constants.topic,  txt_m14.getText().toString());
                    intent1.putExtra(Constants.side, left.toString());
                    intent1.putExtra(Constants.detail,  topic_m14.getText().toString());
                    intent1.putExtra(Constants.image, R.drawable.ic_m14);
                    intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(intent1);
                    startActivity(intent1);
                }
                else if(ak47){
                    left=false;
                    Intent intent1 = new Intent(WeaponsGuide.this, WeapoDetailActivity.class);
                    intent1.putExtra(Constants.topic,  txt_ak47.getText().toString());
                    intent1.putExtra(Constants.side, left.toString());
                    intent1.putExtra(Constants.detail, topic_ak47.getText().toString() );
                    intent1.putExtra(Constants.image, R.drawable.ic_ak47);
                    intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(intent1);
                    startActivity(intent1);
                }
                else if(groza){
                    left=true;
                    Intent intent1 = new Intent(WeaponsGuide.this, WeapoDetailActivity.class);
                    intent1.putExtra(Constants.topic,  txt_groza.getText().toString());
                    intent1.putExtra(Constants.side, left.toString());
                    intent1.putExtra(Constants.detail,  topic_groza.getText().toString());
                    intent1.putExtra(Constants.image, R.drawable.ic_groza);
                    intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(intent1);
                    startActivity(intent1);
                }
                else if(scarl){
                    left=false;
                    Intent intent1 = new Intent(WeaponsGuide.this, WeapoDetailActivity.class);
                    intent1.putExtra(Constants.topic,  txt_scarl.getText().toString());
                    intent1.putExtra(Constants.side, left.toString());
                    intent1.putExtra(Constants.detail, topic_scarl.getText().toString() );
                    intent1.putExtra(Constants.image, R.drawable.ic_scarl);
                    intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(intent1);
                    startActivity(intent1);
                }
                else if(famas){
                    left=true;
                    Intent intent1 = new Intent(WeaponsGuide.this, WeapoDetailActivity.class);
                    intent1.putExtra(Constants.topic,  txt_famas.getText().toString());
                    intent1.putExtra(Constants.side, left.toString());
                    intent1.putExtra(Constants.detail,  topic_famas.getText().toString());
                    intent1.putExtra(Constants.image, R.drawable.ic_falas);
                    intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(intent1);
                    startActivity(intent1);
                }

                 an69=false;
                 m4a1=false;
                 ak47=false;
                 groza=false;
                 scarl=false;
                 m14=false;
                 famas=false;

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
    private void load_nativeAd_fb() {
        try {
            // initializing nativeAd object
            nativeAd = new NativeAd(this, fnative);

            // creating  NativeAdListener
            NativeAdListener nativeAdListener = new NativeAdListener() {

                @Override
                public void onMediaDownloaded(Ad ad) {
                    // showing Toast message

                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    // showing Toast message

                }

                @Override
                public void onAdLoaded(Ad ad) {

                    // showing Toast message


                    if (nativeAd == null || nativeAd != ad) {
                        return;
                    }
                    nativeAdLayout.setVisibility(View.VISIBLE);
                    // Inflate Native Ad into Container
                    inflateAd(nativeAd);
                }

                @Override
                public void onAdClicked(Ad ad) {
                    // showing Toast message

                }

                @Override
                public void onLoggingImpression(Ad ad) {
                    // showing Toast message

                }
            };
            if(this.showAdds) {
                nativeAd.loadAd(
                        nativeAd.buildLoadAdConfig()
                                .withAdListener(nativeAdListener)
                                .build());
            }
            // Load an ad

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void inflateAd(NativeAd nativeAd) {
        // unregister the native Ad View
        nativeAd.unregisterView();

        // Add the Ad view into the ad container.
        nativeAdLayout = findViewById(R.id.native_ad_container);

        LayoutInflater inflater = LayoutInflater.from(WeaponsGuide.this);

        // Inflate the Ad view.
        adView = (LinearLayout) inflater.inflate(R.layout.ad_unified, nativeAdLayout, false);

        // adding view
        nativeAdLayout.addView(adView);

        // Add the AdOptionsView
        LinearLayout adChoicesContainer = findViewById(R.id.ad_choices_container);
        AdOptionsView adOptionsView = new AdOptionsView(WeaponsGuide.this, nativeAd, nativeAdLayout);
        adChoicesContainer.removeAllViews();
        adChoicesContainer.addView(adOptionsView, 0);

        // Create native UI using the ad metadata.
        MediaView nativeAdIcon = adView.findViewById(R.id.native_ad_icon);
        TextView nativeAdTitle = adView.findViewById(R.id.native_ad_title);
        MediaView nativeAdMedia = adView.findViewById(R.id.native_ad_media);
        TextView nativeAdSocialContext = adView.findViewById(R.id.native_ad_social_context);
        TextView nativeAdBody = adView.findViewById(R.id.native_ad_body);
        TextView sponsoredLabel = adView.findViewById(R.id.native_ad_sponsored_label);
        Button nativeAdCallToAction = adView.findViewById(R.id.native_ad_call_to_action);

        // Setting  the Text.
        nativeAdTitle.setText(nativeAd.getAdvertiserName());
        nativeAdBody.setText(nativeAd.getAdBodyText());
        nativeAdSocialContext.setText(nativeAd.getAdSocialContext());
        nativeAdCallToAction.setVisibility(nativeAd.hasCallToAction() ? View.VISIBLE : View.INVISIBLE);
        nativeAdCallToAction.setText(nativeAd.getAdCallToAction());
        sponsoredLabel.setText(nativeAd.getSponsoredTranslation());

        // Create a list of clickable views
        List<View> clickableViews = new ArrayList<>();
        clickableViews.add(nativeAdTitle);
        clickableViews.add(nativeAdCallToAction);

        // Register the Title and  button to listen for clicks.
        nativeAd.registerViewForInteraction(adView, nativeAdMedia, nativeAdIcon, clickableViews);
    }
    private void load_nativeAd_admob() {
        try {
            AdLoader.Builder builder = new AdLoader.Builder(this,gnative);
            builder.forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
                @Override
                public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                    nativeAdLayout.setVisibility(View.GONE);
                    templateView.setVisibility(View.VISIBLE);
                    templateView.setNativeAd(unifiedNativeAd);
//                        Toast.makeText(HomePage.this, "LoadAd Successfully", Toast.LENGTH_LONG).show();

                }
            }).withAdListener(new com.google.android.gms.ads.AdListener() {
                @Override
                public void onAdFailedToLoad(LoadAdError loadAdError) {
                    nativeAdLayout.setVisibility(View.GONE);
                    templateView.setVisibility(View.GONE);
//                        Toast.makeText(HomePage.this, "Error", Toast.LENGTH_LONG).show();
                    Log.e("TAG", "ERROR" + loadAdError.toString());
                    super.onAdFailedToLoad(loadAdError);
                }
            })
                    .build();
            AdLoader adLoader = builder.build();
            if(this.showAdds) {
                adLoader.loadAd(new AdRequest.Builder().build());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}