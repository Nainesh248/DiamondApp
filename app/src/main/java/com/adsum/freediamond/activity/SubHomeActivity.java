package com.adsum.freediamond.activity;

import androidx.appcompat.app.AppCompatActivity;

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

public class SubHomeActivity extends AppCompatActivity {
    RelativeLayout tips, spindimand, basicd, normald, advanced;
    TextView txttips, txtspindimand, txtbasicd, txtnormald, txtadvanced, txtforfree;
    String ginurl, finurl, gburl, fburl, grewardedurl, frewardedburl,gnative,fnative;
    View adContainer;
    private AdView mAdView;
    private InterstitialAd interstitialAd;
    com.facebook.ads.InterstitialAd fbinterstitialAd;
    com.facebook.ads.AdView fbAdView;

    boolean tipsapp = false;
    boolean spinapp = false;
    boolean basicdapp = false;
    boolean normaldapp = false;
    boolean advancedapp = false;
    int i;
    boolean showAdds = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_home);

        adContainer = findViewById(R.id.adMobView);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdSettings.addTestDevice("4971f998-09b3-4c66-bb3d-e534b0e766f3");

        AudienceNetworkAds.initialize(this);
        Intent intent = getIntent();
        ginurl = intent.getStringExtra(Constants.GOOGLE_INTERITIAL_ID);
        gburl = intent.getStringExtra(Constants.GOOGLE_BANNER_ID);
        finurl = intent.getStringExtra(Constants.FACEBOOK_INTERITIAL_ID);
        fburl = intent.getStringExtra(Constants.FACEBOOK_BANNER_ID);
        grewardedurl = intent.getStringExtra(Constants.GOOGLE_REWARDED_ID);
        frewardedburl = intent.getStringExtra(Constants.FACEBOOK_REWARDED_ID);
        gnative= intent.getStringExtra(Constants.GOOGLE_NATIVEAD_ID);
        fnative = intent.getStringExtra(Constants.FACEBOOK_NATIVEAD_ID);

        mAdView = new AdView(this);
        mAdView.setAdSize(AdSize.LARGE_BANNER);
        i = 0;
        tips = (RelativeLayout) findViewById(R.id.rl_tips);
        spindimand = (RelativeLayout) findViewById(R.id.rl_spinner);
        basicd = (RelativeLayout) findViewById(R.id.rl_basicd);
        normald = (RelativeLayout) findViewById(R.id.rl_normald);
        advanced = (RelativeLayout) findViewById(R.id.rl_advanced);

        txttips = (TextView) findViewById(R.id.txt_tips);
        txtspindimand = (TextView) findViewById(R.id.txt_spinner);
        txtbasicd = (TextView) findViewById(R.id.txt_basicd);
        txtnormald = (TextView) findViewById(R.id.txt_normald);
        txtadvanced = (TextView) findViewById(R.id.txt_advanced);
        txtforfree = (TextView) findViewById(R.id.for_free);

        Shader shader = new LinearGradient(0, 0, 0, txttips.getTextSize(), getColor(R.color.appxolorlight), getColor(R.color.appcolor),
                Shader.TileMode.CLAMP);
        txttips.getPaint().setShader(shader);
        Shader shader1 = new LinearGradient(0, 0, 0, txttips.getTextSize(), getColor(R.color.appxolorlight), getColor(R.color.appcolor),
                Shader.TileMode.CLAMP);
        txtspindimand.getPaint().setShader(shader1);
        Shader shader2 = new LinearGradient(0, 0, 0, txttips.getTextSize(), getColor(R.color.appxolorlight), getColor(R.color.appcolor),
                Shader.TileMode.CLAMP);
        txtbasicd.getPaint().setShader(shader2);
        Shader shader3 = new LinearGradient(0, 0, 0, txttips.getTextSize(), getColor(R.color.appxolorlight), getColor(R.color.appcolor),
                Shader.TileMode.CLAMP);
        txtnormald.getPaint().setShader(shader3);
        Shader shader4 = new LinearGradient(0, 0, 0, txttips.getTextSize(), getColor(R.color.appxolorlight), getColor(R.color.appcolor),
                Shader.TileMode.CLAMP);
        txtadvanced.getPaint().setShader(shader4);
        Shader shader5 = new LinearGradient(0, 0, 0, txttips.getTextSize(), getColor(R.color.appxolorlight), getColor(R.color.appcolor),
                Shader.TileMode.CLAMP);
        txtforfree.getPaint().setShader(shader5);

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
            tips.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == tips) {
                        i++;
                        if (i == 4) {
                            tipsapp = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i = 0;
                        } else {
                            Intent i = new Intent(SubHomeActivity.this, DiamondGuideActivity.class);
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
            spindimand.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == spindimand) {
                        i++;
                        if (i == 4) {
                            spinapp = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i = 0;
                        } else {
                            Intent i = new Intent(SubHomeActivity.this, SpinnerActivity.class);
                            i.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                            i.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                            i.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                            i.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                            startActivity(i);
                        }

                    }
                }
            });
            basicd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == basicd) {
                        i++;
                        if (i == 4) {
                            basicdapp = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i = 0;
                        } else {
                            Intent i = new Intent(SubHomeActivity.this, BasicDiamondCalc.class);
                            i.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                            i.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                            i.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                            i.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                            i.putExtra(Constants.GOOGLE_REWARDED_ID, grewardedurl);
                            i.putExtra(Constants.FACEBOOK_REWARDED_ID, frewardedburl);
                            startActivity(i);
                        }

                    }
                }
            });
            normald.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == normald) {
                        i++;
                        if (i == 4) {
                            normaldapp = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i = 0;
                        } else {
                            Intent i = new Intent(SubHomeActivity.this, NormalDiamondCalc.class);
                            i.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                            i.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                            i.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                            i.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                            i.putExtra(Constants.GOOGLE_REWARDED_ID, grewardedurl);
                            i.putExtra(Constants.FACEBOOK_REWARDED_ID, frewardedburl);
                            startActivity(i);
                        }

                    }
                }
            });
            advanced.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == advanced) {
                        i++;
                        if (i == 4) {
                            advancedapp = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i = 0;
                        } else {
                            Intent i = new Intent(SubHomeActivity.this, AdvancedDiamondCalc.class);
                            i.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                            i.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                            i.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                            i.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                            i.putExtra(Constants.GOOGLE_REWARDED_ID, grewardedurl);
                            i.putExtra(Constants.FACEBOOK_REWARDED_ID, frewardedburl);
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
        fbAdView = new com.facebook.ads.AdView(SubHomeActivity.this, fburl, com.facebook.ads.AdSize.BANNER_HEIGHT_50);
        ((RelativeLayout) adContainer).addView(fbAdView);
        AdListener adListener = new AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Log.e("TAG", "onError-------- " + ad + "   " + adError);

                Toast.makeText(
                        SubHomeActivity.this,
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
        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
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

    public void setInterstitialAd() {
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
                if (tipsapp) {
                    Intent i = new Intent(SubHomeActivity.this, DiamondGuideActivity.class);
                    i.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    i.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    i.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    i.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    startActivity(i);
                } else if (spinapp) {
                    Intent i = new Intent(SubHomeActivity.this, SpinnerActivity.class);
                    i.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    i.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    i.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    i.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    startActivity(i);
                } else if (basicdapp) {
                    Intent i = new Intent(SubHomeActivity.this, BasicDiamondCalc.class);
                    i.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    i.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    i.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    i.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    startActivity(i);
                } else if (normaldapp) {
                    Intent i = new Intent(SubHomeActivity.this, NormalDiamondCalc.class);
                    i.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    i.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    i.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    i.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    startActivity(i);
                } else if (advancedapp) {
                    Intent i = new Intent(SubHomeActivity.this, AdvancedDiamondCalc.class);
                    i.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    i.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    i.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    i.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    startActivity(i);
                }
                tipsapp = false;
                spinapp = false;
                basicdapp = false;
                normaldapp = false;
                advancedapp = false;
            }
        });
    }

    public void googleinterstialadshow() {
        interstitialAd.show();
        setInterstitialAd();

    }

    public void fbinterstialadshow() {
        fbinterstitialAd.show();
        load_InterstitialAd_fb();

    }
}