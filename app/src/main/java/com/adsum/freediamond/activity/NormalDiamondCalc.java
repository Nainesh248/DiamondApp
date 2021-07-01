package com.adsum.freediamond.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

public class NormalDiamondCalc extends AppCompatActivity {
    ImageView back;

    String ginurl, finurl, gburl, fburl, grewardedurl, frewardedburl;
    RelativeLayout calc;
    RewardedVideoAd fbrewardedVideoAd;
    private RewardedAd rewardedAd;
    private AdView mAdView;
    com.facebook.ads.AdView fbAdView;
    View adContainer;
    boolean showAdds = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_diamond_calc);
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

        back=(ImageView)findViewById(R.id.img_back);
        calc=(RelativeLayout)findViewById(R.id.rl_calc);
        if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
            load_RewardedVideoAd_admob();
        } else {
            loadRewardedVideoAd_fb();
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
            calc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                        googRewardedVideoAdleadshow();
                    } else {
                        facebookRewardedVideoAdadshow();
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
        fbAdView = new com.facebook.ads.AdView(NormalDiamondCalc.this, fburl, com.facebook.ads.AdSize.BANNER_HEIGHT_50);
        ((RelativeLayout) adContainer).addView(fbAdView);
        AdListener adListener = new AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Log.e("TAG", "onError-------- " + ad + "   " + adError);

                Toast.makeText(
                        NormalDiamondCalc.this,
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
    private void load_RewardedVideoAd_admob() {
        rewardedAd = new RewardedAd(this,
                grewardedurl);

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
        if(this.showAdds) {
            rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);
        }

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
        rewardedAd.show(NormalDiamondCalc.this,adCallback);
        load_RewardedVideoAd_admob();
    }
    public void facebookRewardedVideoAdadshow(){
        fbrewardedVideoAd.show();
        loadRewardedVideoAd_fb();
    }
    private void loadRewardedVideoAd_fb() {
        fbrewardedVideoAd = new RewardedVideoAd(this, frewardedburl);
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
        if(this.showAdds) {
            fbrewardedVideoAd.loadAd(
                    fbrewardedVideoAd.buildLoadAdConfig()
                            .withAdListener(rewardedVideoAdListener)
                            .build());
        }

    }
}