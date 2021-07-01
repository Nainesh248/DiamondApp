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

public class VehiclesGuide extends AppCompatActivity {
    ImageView back;
    CardView cv_sportscar, cv_monstercar, cv_moto, cv_amphibian, cv_jeep, cv_tuktuk,cv_van;
    ImageView img_sportscar, img_monstercar, img_moto, img_amphibian, img_jeep, img_tuktuk,img_van;
    Button txt_sportscar, txt_monstercar, txt_moto, txt_amphibian, txt_jeep, txt_tuktuk,txt_van;
    TextView topic_sportscar, topic_monstercar, topic_moto, topic_amphibian, topic_jeep, topic_tuktuk,topic_van;
    Boolean left,right;

    String ginurl,finurl,gburl,fburl,grewardedurl,frewardedburl,gnative,fnative;
    View adContainer;
    private AdView mAdView;
    private InterstitialAd interstitialAd;
    com.facebook.ads.InterstitialAd fbinterstitialAd;
    com.facebook.ads.AdView fbAdView;

    boolean sportscar=false;
    boolean monstercar=false;
    boolean moto=false;
    boolean amphibian=false;
    boolean jeep=false;
    boolean tuktuk=false;
    boolean van=false;
    int i;
    TemplateView templateView;
    // creating NativeAdLayout object
    private NativeAdLayout nativeAdLayout;
    // creating  LinearLayout object
    private LinearLayout adView;
    // creating  NativeAd object
    private NativeAd nativeAd;
    boolean showAdds = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicles_guide);

        adContainer = findViewById(R.id.adMobView);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        List<String> testDeviceIds = Arrays.asList("56B7DAB45BB2207A58B0759A167DA40E");
        RequestConfiguration configuration =
                new RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build();
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

        cv_sportscar = (CardView) findViewById(R.id.cv_sportscar);
        cv_monstercar = (CardView) findViewById(R.id.cv_monstercar);
        cv_moto = (CardView) findViewById(R.id.cv_moto);
        cv_amphibian = (CardView) findViewById(R.id.cv_amphibian);
        cv_jeep = (CardView) findViewById(R.id.cv_jeep);
        cv_tuktuk = (CardView) findViewById(R.id.cv_tuktuk);
        cv_van = (CardView) findViewById(R.id.cv_van);

        txt_sportscar = (Button) findViewById(R.id.txt_sportscar);
        txt_monstercar = (Button) findViewById(R.id.txt_monstercar);
        txt_moto = (Button) findViewById(R.id.txt_moto);
        txt_amphibian = (Button) findViewById(R.id.txt_amphibian);
        txt_jeep = (Button) findViewById(R.id.txt_jeep);
        txt_tuktuk = (Button) findViewById(R.id.txt_tuktuk);
        txt_van = (Button) findViewById(R.id.txt_van);

        topic_sportscar = (TextView) findViewById(R.id.txt_sportscartopic);
        topic_monstercar = (TextView) findViewById(R.id.txt_monstercartopic);
        topic_moto = (TextView) findViewById(R.id.txt_mototopic);
        topic_amphibian = (TextView) findViewById(R.id.txt_amphibiantopic);
        topic_jeep = (TextView) findViewById(R.id.txt_jeeptopic);
        topic_tuktuk = (TextView) findViewById(R.id.txt_tuktuktopic);
        topic_van = (TextView) findViewById(R.id.txt_vantopic);


        img_sportscar = (ImageView) findViewById(R.id.img_sportscar);
        img_monstercar = (ImageView) findViewById(R.id.img_monstercar);
        img_moto = (ImageView) findViewById(R.id.img_moto);
        img_amphibian = (ImageView) findViewById(R.id.img_amphibian);
        img_jeep = (ImageView) findViewById(R.id.img_jeep);
        img_tuktuk = (ImageView) findViewById(R.id.img_tuktuk);
        img_van = (ImageView) findViewById(R.id.img_van);

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

        LayoutInflater inflater = LayoutInflater.from(VehiclesGuide.this);

        // Inflate the Ad view.
        adView = (LinearLayout) inflater.inflate(R.layout.ad_unified, nativeAdLayout, false);

        // adding view
        nativeAdLayout.addView(adView);

        // Add the AdOptionsView
        LinearLayout adChoicesContainer = findViewById(R.id.ad_choices_container);
        AdOptionsView adOptionsView = new AdOptionsView(VehiclesGuide.this, nativeAd, nativeAdLayout);
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
    private void init() {
        try {
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            cv_sportscar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cv_sportscar) {
                        i++;
                        if (i == 4)
                        {
                            sportscar = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            left=true;
                            Intent intent1 = new Intent(VehiclesGuide.this, VehicleDetailActivity.class);
                            intent1.putExtra(Constants.topic, txt_sportscar.getText().toString());
                            intent1.putExtra(Constants.side, left.toString());
                            intent1.putExtra(Constants.detail, topic_sportscar.getText().toString());
                            intent1.putExtra(Constants.image, R.drawable.ic_sports_car);
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
            cv_monstercar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cv_monstercar) {
                        i++;
                        if (i == 4)
                        {
                            monstercar = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            left=false;
                            Intent intent1 = new Intent(VehiclesGuide.this, VehicleDetailActivity.class);
                            intent1.putExtra(Constants.topic, txt_monstercar.getText().toString());
                            intent1.putExtra(Constants.side, left.toString());
                            intent1.putExtra(Constants.detail, topic_monstercar.getText().toString() );
                            intent1.putExtra(Constants.image,R.drawable.ic_monster_car);
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
            cv_moto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cv_moto) {
                        i++;
                        if (i == 4)
                        {
                            moto = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            left=true;
                            Intent intent1 = new Intent(VehiclesGuide.this, VehicleDetailActivity.class);
                            intent1.putExtra(Constants.topic,  txt_moto.getText().toString());
                            intent1.putExtra(Constants.side, left.toString());
                            intent1.putExtra(Constants.detail,  topic_moto.getText().toString());
                            intent1.putExtra(Constants.image, R.drawable.ic_moto);
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
            cv_amphibian.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cv_amphibian) {
                        i++;
                        if (i == 4)
                        {
                            amphibian = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            left=false;
                            Intent intent1 = new Intent(VehiclesGuide.this, VehicleDetailActivity.class);
                            intent1.putExtra(Constants.topic,  txt_amphibian.getText().toString());
                            intent1.putExtra(Constants.side, left.toString());
                            intent1.putExtra(Constants.detail, topic_amphibian.getText().toString() );
                            intent1.putExtra(Constants.image, R.drawable.ic_amphibian);
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
            cv_jeep.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cv_jeep) {
                        i++;
                        if (i == 4)
                        {
                            jeep = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            left=true;
                            Intent intent1 = new Intent(VehiclesGuide.this, VehicleDetailActivity.class);
                            intent1.putExtra(Constants.topic,  txt_jeep.getText().toString());
                            intent1.putExtra(Constants.side, left.toString());
                            intent1.putExtra(Constants.detail,  topic_jeep.getText().toString());
                            intent1.putExtra(Constants.image, R.drawable.ic_military_jeep);
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
            cv_tuktuk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cv_tuktuk) {
                        i++;
                        if (i == 4)
                        {
                            tuktuk = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            left=false;
                            Intent intent1 = new Intent(VehiclesGuide.this, VehicleDetailActivity.class);
                            intent1.putExtra(Constants.topic,  txt_tuktuk.getText().toString());
                            intent1.putExtra(Constants.side, left.toString());
                            intent1.putExtra(Constants.detail, topic_tuktuk.getText().toString() );
                            intent1.putExtra(Constants.image, R.drawable.ic_tuktuk);
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
            cv_van.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cv_van) {
                        i++;
                        if (i == 4)
                        {
                            van = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            left=true;
                            Intent intent1 = new Intent(VehiclesGuide.this, VehicleDetailActivity.class);
                            intent1.putExtra(Constants.topic,  txt_van.getText().toString());
                            intent1.putExtra(Constants.side, left.toString());
                            intent1.putExtra(Constants.detail,  topic_van.getText().toString());
                            intent1.putExtra(Constants.image, R.drawable.ic_van);
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
        fbAdView = new com.facebook.ads.AdView(VehiclesGuide.this, fburl, com.facebook.ads.AdSize.BANNER_HEIGHT_50);
        ((RelativeLayout) adContainer).addView(fbAdView);
        AdListener adListener = new AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Log.e("TAG", "onError-------- " + ad + "   " + adError);

                Toast.makeText(
                        VehiclesGuide.this,
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
                if(sportscar){
                    left=true;
                    Intent intent1 = new Intent(VehiclesGuide.this, VehicleDetailActivity.class);
                    intent1.putExtra(Constants.topic, txt_sportscar.getText().toString());
                    intent1.putExtra(Constants.side, left.toString());
                    intent1.putExtra(Constants.detail, topic_sportscar.getText().toString());
                    intent1.putExtra(Constants.image, R.drawable.ic_sports_car);
                    intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(intent1);
                    startActivity(intent1);
                }
                else if(monstercar){
                    left=false;
                    Intent intent1 = new Intent(VehiclesGuide.this, VehicleDetailActivity.class);
                    intent1.putExtra(Constants.topic, txt_monstercar.getText().toString());
                    intent1.putExtra(Constants.side, left.toString());
                    intent1.putExtra(Constants.detail, topic_monstercar.getText().toString() );
                    intent1.putExtra(Constants.image,R.drawable.ic_monster_car);
                    intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(intent1);
                    startActivity(intent1);
                }
                else if(moto){
                    left=true;
                    Intent intent1 = new Intent(VehiclesGuide.this, VehicleDetailActivity.class);
                    intent1.putExtra(Constants.topic,  txt_moto.getText().toString());
                    intent1.putExtra(Constants.side, left.toString());
                    intent1.putExtra(Constants.detail,  topic_moto.getText().toString());
                    intent1.putExtra(Constants.image, R.drawable.ic_moto);
                    intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(intent1);
                    startActivity(intent1);
                }
                else if(amphibian){
                    left=false;
                    Intent intent1 = new Intent(VehiclesGuide.this, VehicleDetailActivity.class);
                    intent1.putExtra(Constants.topic,  txt_amphibian.getText().toString());
                    intent1.putExtra(Constants.side, left.toString());
                    intent1.putExtra(Constants.detail, topic_amphibian.getText().toString() );
                    intent1.putExtra(Constants.image, R.drawable.ic_amphibian);
                    intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(intent1);
                    startActivity(intent1);
                }
                else if(jeep){
                    left=true;
                    Intent intent1 = new Intent(VehiclesGuide.this, VehicleDetailActivity.class);
                    intent1.putExtra(Constants.topic,  txt_jeep.getText().toString());
                    intent1.putExtra(Constants.side, left.toString());
                    intent1.putExtra(Constants.detail,  topic_jeep.getText().toString());
                    intent1.putExtra(Constants.image, R.drawable.ic_military_jeep);
                    intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(intent1);
                    startActivity(intent1);
                }
                else if(tuktuk){
                    left=false;
                    Intent intent1 = new Intent(VehiclesGuide.this, VehicleDetailActivity.class);
                    intent1.putExtra(Constants.topic,  txt_tuktuk.getText().toString());
                    intent1.putExtra(Constants.side, left.toString());
                    intent1.putExtra(Constants.detail, topic_tuktuk.getText().toString() );
                    intent1.putExtra(Constants.image, R.drawable.ic_tuktuk);
                    intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(intent1);
                    startActivity(intent1);
                }
                else if(van){
                    left=true;
                    Intent intent1 = new Intent(VehiclesGuide.this, VehicleDetailActivity.class);
                    intent1.putExtra(Constants.topic,  txt_van.getText().toString());
                    intent1.putExtra(Constants.side, left.toString());
                    intent1.putExtra(Constants.detail,  topic_van.getText().toString());
                    intent1.putExtra(Constants.image, R.drawable.ic_van);
                    intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(intent1);
                    startActivity(intent1);
                }
                 sportscar=false;
                 monstercar=false;
                 moto=false;
                 amphibian=false;
                 jeep=false;
                 tuktuk=false;
                 van=false;
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