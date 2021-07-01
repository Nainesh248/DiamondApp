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

public class CharacterGuide extends AppCompatActivity {
    ImageView back;
    CardView cv_hayato, cv_moco, cv_wukong, cv_antonio, cv_andrew, cv_kelly,cv_olivia,cv_ford, cv_nikita, cv_misha, cv_maxim, cv_kla, cv_paloma,cv_miguel,cv_caroline;
    ImageView img_hayato, img_moco, img_wukong, img_antonio, img_andrew, img_kelly,img_olivia,img_ford,img_nikita, img_misha, img_maxim, img_kla, img_paloma, img_miguel,img_caroline;
    Button txt_hayato, txt_moco, txt_wukong, txt_antonio, txt_andrew, txt_kelly,txt_olivia,txt_ford,txt_nikita, txt_misha, txt_maxim, txt_kla, txt_paloma, txt_miguel,txt_caroline;
    TextView topic_hayato, topic_moco, topic_wukong, topic_antonio, topic_andrew, topic_kelly,topic_olivia,topic_ford,topic_nikita, topic_misha, topic_maxim, topic_kla, topic_paloma, topic_miguel,topic_caroline;
    Boolean left,right;
    String side;

    String ginurl,finurl,gburl,fburl,grewardedurl,frewardedburl,gnative,fnative;
    View adContainer;
    private AdView mAdView;
    private InterstitialAd interstitialAd;
    com.facebook.ads.InterstitialAd fbinterstitialAd;
    com.facebook.ads.AdView fbAdView;

    boolean hayato=false;
    boolean moco=false;
    boolean wukong=false;
    boolean antonio=false;
    boolean andrew=false;
    boolean kelly=false;
    boolean olivia=false;
    boolean ford=false;
    boolean nikita=false;
    boolean misha=false;
    boolean maxim=false;
    boolean kla=false;
    boolean paloma=false;
    boolean miguel=false;
    boolean caroline=false;
    int i;
    boolean showAdds = true;
    // creating NativeAdLayout object
    private NativeAdLayout nativeAdLayout;
    private NativeAdLayout nativeAdLayout1;
    private NativeAdLayout nativeAdLayout2;
    // creating  LinearLayout object
    private LinearLayout adView;
    // creating  NativeAd object
    private NativeAd nativeAd;

    TemplateView templateView;
    TemplateView templateView1;
    TemplateView templateView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_guide);

        adContainer = findViewById(R.id.adMobView);
        List<String> testDeviceIds = Arrays.asList("56B7DAB45BB2207A58B0759A167DA40E");
        RequestConfiguration configuration =
                new RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build();
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

        back=(ImageView)findViewById(R.id.img_back);

        nativeAdLayout = findViewById(R.id.native_ad_container);
        nativeAdLayout1 = findViewById(R.id.native_ad_container1);
        nativeAdLayout2 = findViewById(R.id.native_ad_container2);

        templateView = findViewById(R.id.nativeTemplateView);
        templateView1 = findViewById(R.id.nativeTemplateView1);
        templateView2 = findViewById(R.id.nativeTemplateView2);

        cv_hayato = (CardView) findViewById(R.id.cv_hayato);
        cv_moco = (CardView) findViewById(R.id.cv_moco);
        cv_wukong = (CardView) findViewById(R.id.cv_wukong);
        cv_antonio = (CardView) findViewById(R.id.cv_antonio);
        cv_andrew = (CardView) findViewById(R.id.cv_andrew);
        cv_kelly = (CardView) findViewById(R.id.cv_kelly);
        cv_olivia = (CardView) findViewById(R.id.cv_olivia);
        cv_ford = (CardView) findViewById(R.id.cv_ford);
        cv_nikita = (CardView) findViewById(R.id.cv_nikita);
        cv_misha = (CardView) findViewById(R.id.cv_misha);
        cv_maxim = (CardView) findViewById(R.id.cv_maxim);
        cv_kla = (CardView) findViewById(R.id.cv_kla);
        cv_paloma = (CardView) findViewById(R.id.cv_paloma);
        cv_miguel = (CardView) findViewById(R.id.cv_miguel);
        cv_caroline = (CardView) findViewById(R.id.cv_caroline);

        txt_hayato= (Button) findViewById(R.id.txt_hayato);
        txt_moco = (Button) findViewById(R.id.txt_moco);
        txt_wukong = (Button) findViewById(R.id.txt_wukong);
        txt_antonio = (Button) findViewById(R.id.txt_antonio);
        txt_andrew = (Button) findViewById(R.id.txt_andrew);
        txt_kelly = (Button) findViewById(R.id.txt_kelly);
        txt_olivia = (Button) findViewById(R.id.txt_olivia);
        txt_ford = (Button) findViewById(R.id.txt_ford);
        txt_nikita = (Button) findViewById(R.id.txt_nikita);
        txt_misha = (Button) findViewById(R.id.txt_misha);
        txt_maxim= (Button) findViewById(R.id.txt_maxim);
        txt_kla = (Button) findViewById(R.id.txt_kla);
        txt_paloma = (Button) findViewById(R.id.txt_paloma);
        txt_miguel = (Button) findViewById(R.id.txt_miguel);
        txt_caroline = (Button) findViewById(R.id.txt_caroline);

        topic_hayato = (TextView) findViewById(R.id.txt_hayatotopic);
        topic_moco = (TextView) findViewById(R.id.txt_mocotopic);
        topic_wukong = (TextView) findViewById(R.id.txt_wukongtopic);
        topic_antonio = (TextView) findViewById(R.id.txt_antoniotopic);
        topic_andrew = (TextView) findViewById(R.id.txt_andrewtopic);
        topic_kelly = (TextView) findViewById(R.id.txt_kellytopic);
        topic_olivia = (TextView) findViewById(R.id.txt_oliviatopic);
        topic_ford = (TextView) findViewById(R.id.txt_fordtopic);
        topic_nikita = (TextView) findViewById(R.id.txt_nikitatopic);
        topic_misha = (TextView) findViewById(R.id.txt_mishatopic);
        topic_maxim = (TextView) findViewById(R.id.txt_maximtopic);
        topic_kla = (TextView) findViewById(R.id.txt_klatopic);
        topic_paloma = (TextView) findViewById(R.id.txt_palomatopic);
        topic_miguel = (TextView) findViewById(R.id.txt_migueltopic);
        topic_caroline = (TextView) findViewById(R.id.txt_carolinetopic);


        img_hayato = (ImageView) findViewById(R.id.img_hayato);
        img_moco = (ImageView) findViewById(R.id.img_moco);
        img_wukong= (ImageView) findViewById(R.id.img_wukong);
        img_antonio = (ImageView) findViewById(R.id.img_antonio);
        img_andrew = (ImageView) findViewById(R.id.img_andrew);
        img_kelly = (ImageView) findViewById(R.id.img_kelly);
        img_olivia = (ImageView) findViewById(R.id.img_olivia);
        img_ford= (ImageView) findViewById(R.id.img_ford);
        img_nikita = (ImageView) findViewById(R.id.img_nikita);
        img_misha = (ImageView) findViewById(R.id.img_misha);
        img_maxim = (ImageView) findViewById(R.id.img_maxim);
        img_kla = (ImageView) findViewById(R.id.img_kla);
        img_paloma = (ImageView) findViewById(R.id.img_paloma);
        img_miguel = (ImageView) findViewById(R.id.img_miguel);
        img_caroline = (ImageView) findViewById(R.id.img_caroline);

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
                    nativeAdLayout1.setVisibility(View.VISIBLE);
                    nativeAdLayout2.setVisibility(View.VISIBLE);
                    // Inflate Native Ad into Container
                    inflateAd(nativeAd);
                    inflateAd1(nativeAd);
                    inflateAd2(nativeAd);
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

        LayoutInflater inflater = LayoutInflater.from(CharacterGuide.this);

        // Inflate the Ad view.
        adView = (LinearLayout) inflater.inflate(R.layout.ad_unified, nativeAdLayout, false);

        // adding view
        nativeAdLayout.addView(adView);

        // Add the AdOptionsView
        LinearLayout adChoicesContainer = findViewById(R.id.ad_choices_container);
        AdOptionsView adOptionsView = new AdOptionsView(CharacterGuide.this, nativeAd, nativeAdLayout);
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
    private void inflateAd1(NativeAd nativeAd) {
        // unregister the native Ad View
        nativeAd.unregisterView();

        // Add the Ad view into the ad container.
        nativeAdLayout1 = findViewById(R.id.native_ad_container1);

        LayoutInflater inflater = LayoutInflater.from(CharacterGuide.this);

        // Inflate the Ad view.
        adView = (LinearLayout) inflater.inflate(R.layout.ad_unified, nativeAdLayout1, false);

        // adding view
        nativeAdLayout1.addView(adView);

        // Add the AdOptionsView
        LinearLayout adChoicesContainer = findViewById(R.id.ad_choices_container);
        AdOptionsView adOptionsView = new AdOptionsView(CharacterGuide.this, nativeAd, nativeAdLayout1);
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
    private void inflateAd2(NativeAd nativeAd) {
        // unregister the native Ad View
        nativeAd.unregisterView();

        // Add the Ad view into the ad container.
        nativeAdLayout2 = findViewById(R.id.native_ad_container2);

        LayoutInflater inflater = LayoutInflater.from(CharacterGuide.this);

        // Inflate the Ad view.
        adView = (LinearLayout) inflater.inflate(R.layout.ad_unified, nativeAdLayout2, false);

        // adding view
        nativeAdLayout2.addView(adView);

        // Add the AdOptionsView
        LinearLayout adChoicesContainer = findViewById(R.id.ad_choices_container);
        AdOptionsView adOptionsView = new AdOptionsView(CharacterGuide.this, nativeAd, nativeAdLayout2);
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
                    nativeAdLayout1.setVisibility(View.GONE);
                    nativeAdLayout2.setVisibility(View.GONE);

                    templateView.setVisibility(View.VISIBLE);
                    templateView1.setVisibility(View.VISIBLE);
                    templateView2.setVisibility(View.VISIBLE);

                    templateView.setNativeAd(unifiedNativeAd);
                    templateView1.setNativeAd(unifiedNativeAd);
                    templateView2.setNativeAd(unifiedNativeAd);
//                        Toast.makeText(HomePage.this, "LoadAd Successfully", Toast.LENGTH_LONG).show();

                }
            }).withAdListener(new com.google.android.gms.ads.AdListener() {
                @Override
                public void onAdFailedToLoad(LoadAdError loadAdError) {
                    nativeAdLayout.setVisibility(View.GONE);
                    nativeAdLayout1.setVisibility(View.GONE);
                    nativeAdLayout2.setVisibility(View.GONE);

                    templateView.setVisibility(View.GONE);
                    templateView1.setVisibility(View.GONE);
                    templateView2.setVisibility(View.GONE);
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
            cv_hayato.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cv_hayato) {
                        i++;
                        if (i == 4)
                        {
                            hayato = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            left=true;
                            Intent intent1 = new Intent(CharacterGuide.this, CharacterDetailActivity.class);
                            intent1.putExtra(Constants.topic, txt_hayato.getText().toString());
                            intent1.putExtra(Constants.side, left.toString());
                            intent1.putExtra(Constants.detail, topic_hayato.getText().toString());
                            intent1.putExtra(Constants.image, R.drawable.ic_hayato);
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
            cv_moco.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cv_moco) {
                        i++;
                        if (i == 4)
                        {
                            moco = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            left=false;
                            Intent intent1 = new Intent(CharacterGuide.this, CharacterDetailActivity.class);
                            intent1.putExtra(Constants.topic, txt_moco.getText().toString());
                            intent1.putExtra(Constants.side, left.toString());
                            intent1.putExtra(Constants.detail, topic_moco.getText().toString() );
                            intent1.putExtra(Constants.image,R.drawable.ic_moko);
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
            cv_wukong.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cv_wukong) {
                        i++;
                        if (i == 4)
                        {
                            wukong = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            left=true;
                            Intent intent1 = new Intent(CharacterGuide.this, CharacterDetailActivity.class);
                            intent1.putExtra(Constants.topic,  txt_wukong.getText().toString());
                            intent1.putExtra(Constants.side, left.toString());
                            intent1.putExtra(Constants.detail,  topic_wukong.getText().toString());
                            intent1.putExtra(Constants.image, R.drawable.ic_wukong);
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
            cv_antonio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cv_antonio) {
                        i++;
                        if (i == 4)
                        {
                            antonio = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            left=false;
                            Intent intent1 = new Intent(CharacterGuide.this, CharacterDetailActivity.class);
                            intent1.putExtra(Constants.topic,  txt_antonio.getText().toString());
                            intent1.putExtra(Constants.side, left.toString());
                            intent1.putExtra(Constants.detail, topic_antonio.getText().toString() );
                            intent1.putExtra(Constants.image, R.drawable.ic_ontonio);
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
            cv_andrew.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cv_andrew) {
                        i++;
                        if (i == 4)
                        {
                            andrew = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            left=true;
                            Intent intent1 = new Intent(CharacterGuide.this, CharacterDetailActivity.class);
                            intent1.putExtra(Constants.topic,  txt_andrew.getText().toString());
                            intent1.putExtra(Constants.side, left.toString());
                            intent1.putExtra(Constants.detail,  topic_andrew.getText().toString());
                            intent1.putExtra(Constants.image, R.drawable.ic_andrew);
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
            cv_kelly.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cv_kelly) {
                        i++;
                        if (i == 4)
                        {
                            kelly = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            left=false;
                            Intent intent1 = new Intent(CharacterGuide.this, CharacterDetailActivity.class);
                            intent1.putExtra(Constants.topic,  txt_kelly.getText().toString());
                            intent1.putExtra(Constants.side, left.toString());
                            intent1.putExtra(Constants.detail, topic_kelly.getText().toString() );
                            intent1.putExtra(Constants.image, R.drawable.ic_kelly);
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
            cv_olivia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cv_olivia) {
                        i++;
                        if (i == 4)
                        {
                            olivia = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            left=true;
                            Intent intent1 = new Intent(CharacterGuide.this, CharacterDetailActivity.class);
                            intent1.putExtra(Constants.topic,  txt_olivia.getText().toString());
                            intent1.putExtra(Constants.side, left.toString());
                            intent1.putExtra(Constants.detail,  topic_olivia.getText().toString());
                            intent1.putExtra(Constants.image, R.drawable.ic_olivia);
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
            cv_ford.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cv_ford) {
                        i++;
                        if (i == 4)
                        {
                            ford = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            left=false;
                            Intent intent1 = new Intent(CharacterGuide.this, CharacterDetailActivity.class);
                            intent1.putExtra(Constants.topic, txt_ford.getText().toString());
                            intent1.putExtra(Constants.side, left.toString());
                            intent1.putExtra(Constants.detail, topic_ford.getText().toString());
                            intent1.putExtra(Constants.image, R.drawable.ic_ford);
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
            cv_nikita.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cv_nikita) {
                        i++;
                        if (i == 4)
                        {
                            nikita = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            left=true;
                            Intent intent1 = new Intent(CharacterGuide.this, CharacterDetailActivity.class);
                            intent1.putExtra(Constants.topic, txt_nikita.getText().toString());
                            intent1.putExtra(Constants.side, left.toString());
                            intent1.putExtra(Constants.detail, topic_nikita.getText().toString() );
                            intent1.putExtra(Constants.image,R.drawable.ic_nikita);
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
            cv_misha.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cv_misha) {
                        i++;
                        if (i == 4)
                        {
                            misha = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            left=false;
                            Intent intent1 = new Intent(CharacterGuide.this, CharacterDetailActivity.class);
                            intent1.putExtra(Constants.topic,  txt_misha.getText().toString());
                            intent1.putExtra(Constants.side, left.toString());
                            intent1.putExtra(Constants.detail,  topic_misha.getText().toString());
                            intent1.putExtra(Constants.image, R.drawable.ic_misha);
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
            cv_maxim.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cv_maxim) {
                        i++;
                        if (i == 4)
                        {
                            maxim = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            left=true;
                            Intent intent1 = new Intent(CharacterGuide.this, CharacterDetailActivity.class);
                            intent1.putExtra(Constants.topic,  txt_maxim.getText().toString());
                            intent1.putExtra(Constants.side, left.toString());
                            intent1.putExtra(Constants.detail, topic_maxim.getText().toString() );
                            intent1.putExtra(Constants.image, R.drawable.ic_maxim);
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
            cv_kla.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cv_kla) {
                        i++;
                        if (i == 4)
                        {
                            kla = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            left=false;
                            Intent intent1 = new Intent(CharacterGuide.this, CharacterDetailActivity.class);
                            intent1.putExtra(Constants.topic,  txt_kla.getText().toString());
                            intent1.putExtra(Constants.side, left.toString());
                            intent1.putExtra(Constants.detail,  topic_kla.getText().toString());
                            intent1.putExtra(Constants.image, R.drawable.ic_kla);
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
            cv_paloma.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cv_paloma) {
                        i++;
                        if (i == 4)
                        {
                            paloma = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            left=true;
                            Intent intent1 = new Intent(CharacterGuide.this, CharacterDetailActivity.class);
                            intent1.putExtra(Constants.topic,  txt_paloma.getText().toString());
                            intent1.putExtra(Constants.side, left.toString());
                            intent1.putExtra(Constants.detail, topic_paloma.getText().toString() );
                            intent1.putExtra(Constants.image, R.drawable.ic_paloma);
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
            cv_miguel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cv_miguel) {
                        i++;
                        if (i == 4)
                        {
                            miguel = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            left=false;
                            Intent intent1 = new Intent(CharacterGuide.this, CharacterDetailActivity.class);
                            intent1.putExtra(Constants.topic,  txt_miguel.getText().toString());
                            intent1.putExtra(Constants.side, left.toString());
                            intent1.putExtra(Constants.detail,  topic_miguel.getText().toString());
                            intent1.putExtra(Constants.image, R.drawable.ic_miguel);
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
            cv_caroline.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == cv_caroline) {
                        i++;
                        if (i == 4)
                        {
                            caroline = true;
                            if (Splashscreen.appConfigModel.IS_GOOGLE.equalsIgnoreCase(Constants.VAL_TRUE)) {
                                googleinterstialadshow();
                            } else {
                                fbinterstialadshow();
                            }

                            i=0;
                        } else {
                            side="caro";
                            Intent intent1 = new Intent(CharacterGuide.this, CharacterDetailActivity.class);
                            intent1.putExtra(Constants.topic,  txt_caroline.getText().toString());
                            intent1.putExtra(Constants.side, side);
                            intent1.putExtra(Constants.detail,  topic_caroline.getText().toString());
                            intent1.putExtra(Constants.image, R.drawable.ic_coroline);
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
        fbAdView = new com.facebook.ads.AdView(CharacterGuide.this, fburl, com.facebook.ads.AdSize.BANNER_HEIGHT_50);
        ((RelativeLayout) adContainer).addView(fbAdView);
        AdListener adListener = new AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Log.e("TAG", "onError-------- " + ad + "   " + adError);

                Toast.makeText(
                        CharacterGuide.this,
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
                if(hayato){
                    left=true;
                    Intent intent1 = new Intent(CharacterGuide.this, CharacterDetailActivity.class);
                    intent1.putExtra(Constants.topic, txt_hayato.getText().toString());
                    intent1.putExtra(Constants.side, left.toString());
                    intent1.putExtra(Constants.detail, topic_hayato.getText().toString());
                    intent1.putExtra(Constants.image, R.drawable.ic_hayato);
                    intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(intent1);
                    startActivity(intent1);
                }
                else if(moco){
                    left=false;
                    left=false;
                    Intent intent1 = new Intent(CharacterGuide.this, CharacterDetailActivity.class);
                    intent1.putExtra(Constants.topic, txt_moco.getText().toString());
                    intent1.putExtra(Constants.side, left.toString());
                    intent1.putExtra(Constants.detail, topic_moco.getText().toString() );
                    intent1.putExtra(Constants.image,R.drawable.ic_moko);
                    intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(intent1);
                    startActivity(intent1);
                }
                else if(wukong){
                    left=true;
                    Intent intent1 = new Intent(CharacterGuide.this, CharacterDetailActivity.class);
                    intent1.putExtra(Constants.topic,  txt_wukong.getText().toString());
                    intent1.putExtra(Constants.side, left.toString());
                    intent1.putExtra(Constants.detail,  topic_wukong.getText().toString());
                    intent1.putExtra(Constants.image, R.drawable.ic_wukong);
                    intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(intent1);
                    startActivity(intent1);
                }
                else if(antonio){
                    left=false;
                    Intent intent1 = new Intent(CharacterGuide.this, CharacterDetailActivity.class);
                    intent1.putExtra(Constants.topic,  txt_antonio.getText().toString());
                    intent1.putExtra(Constants.side, left.toString());
                    intent1.putExtra(Constants.detail, topic_antonio.getText().toString() );
                    intent1.putExtra(Constants.image, R.drawable.ic_ontonio);
                    intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(intent1);
                    startActivity(intent1);
                }
                else if(andrew){
                    left=true;
                    Intent intent1 = new Intent(CharacterGuide.this, CharacterDetailActivity.class);
                    intent1.putExtra(Constants.topic,  txt_andrew.getText().toString());
                    intent1.putExtra(Constants.side, left.toString());
                    intent1.putExtra(Constants.detail,  topic_andrew.getText().toString());
                    intent1.putExtra(Constants.image, R.drawable.ic_andrew);
                    intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(intent1);
                    startActivity(intent1);
                }
                else if(kelly){
                    left=false;
                    Intent intent1 = new Intent(CharacterGuide.this, CharacterDetailActivity.class);
                    intent1.putExtra(Constants.topic,  txt_kelly.getText().toString());
                    intent1.putExtra(Constants.side, left.toString());
                    intent1.putExtra(Constants.detail, topic_kelly.getText().toString() );
                    intent1.putExtra(Constants.image, R.drawable.ic_kelly);
                    intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(intent1);
                    startActivity(intent1);
                }
                else if(olivia){
                    left=true;
                    Intent intent1 = new Intent(CharacterGuide.this, CharacterDetailActivity.class);
                    intent1.putExtra(Constants.topic,  txt_olivia.getText().toString());
                    intent1.putExtra(Constants.side, left.toString());
                    intent1.putExtra(Constants.detail,  topic_olivia.getText().toString());
                    intent1.putExtra(Constants.image, R.drawable.ic_olivia);
                    intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(intent1);
                    startActivity(intent1);
                }
                else if(ford){
                    left=false;
                    Intent intent1 = new Intent(CharacterGuide.this, CharacterDetailActivity.class);
                    intent1.putExtra(Constants.topic, txt_ford.getText().toString());
                    intent1.putExtra(Constants.side, left.toString());
                    intent1.putExtra(Constants.detail, topic_ford.getText().toString());
                    intent1.putExtra(Constants.image, R.drawable.ic_ford);
                    intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(intent1);
                    startActivity(intent1);
                }
                else if(nikita){
                    left=true;
                    Intent intent1 = new Intent(CharacterGuide.this, CharacterDetailActivity.class);
                    intent1.putExtra(Constants.topic, txt_nikita.getText().toString());
                    intent1.putExtra(Constants.side, left.toString());
                    intent1.putExtra(Constants.detail, topic_nikita.getText().toString() );
                    intent1.putExtra(Constants.image,R.drawable.ic_nikita);
                    intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(intent1);
                    startActivity(intent1);
                }
                else if(misha){
                    left=false;
                    Intent intent1 = new Intent(CharacterGuide.this, CharacterDetailActivity.class);
                    intent1.putExtra(Constants.topic,  txt_misha.getText().toString());
                    intent1.putExtra(Constants.side, left.toString());
                    intent1.putExtra(Constants.detail,  topic_misha.getText().toString());
                    intent1.putExtra(Constants.image, R.drawable.ic_misha);
                    intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(intent1);
                    startActivity(intent1);
                }
                else if(maxim){
                    left=true;
                    Intent intent1 = new Intent(CharacterGuide.this, CharacterDetailActivity.class);
                    intent1.putExtra(Constants.topic,  txt_maxim.getText().toString());
                    intent1.putExtra(Constants.side, left.toString());
                    intent1.putExtra(Constants.detail, topic_maxim.getText().toString() );
                    intent1.putExtra(Constants.image, R.drawable.ic_maxim);
                    intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(intent1);
                    startActivity(intent1);
                }
                else if(kla){
                    left=false;
                    Intent intent1 = new Intent(CharacterGuide.this, CharacterDetailActivity.class);
                    intent1.putExtra(Constants.topic,  txt_kla.getText().toString());
                    intent1.putExtra(Constants.side, left.toString());
                    intent1.putExtra(Constants.detail,  topic_kla.getText().toString());
                    intent1.putExtra(Constants.image, R.drawable.ic_kla);
                    intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(intent1);
                    startActivity(intent1);
                }
                else if(paloma){
                    left=true;
                    Intent intent1 = new Intent(CharacterGuide.this, CharacterDetailActivity.class);
                    intent1.putExtra(Constants.topic,  txt_paloma.getText().toString());
                    intent1.putExtra(Constants.side, left.toString());
                    intent1.putExtra(Constants.detail, topic_paloma.getText().toString() );
                    intent1.putExtra(Constants.image, R.drawable.ic_paloma);
                    intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(intent1);
                    startActivity(intent1);
                }
                else if(miguel){
                    left=false;
                    Intent intent1 = new Intent(CharacterGuide.this, CharacterDetailActivity.class);
                    intent1.putExtra(Constants.topic,  txt_miguel.getText().toString());
                    intent1.putExtra(Constants.side, left.toString());
                    intent1.putExtra(Constants.detail,  topic_miguel.getText().toString());
                    intent1.putExtra(Constants.image, R.drawable.ic_miguel);
                    intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(intent1);
                    startActivity(intent1);
                }
                else if(caroline){
                    side="caro";
                    Intent intent1 = new Intent(CharacterGuide.this, CharacterDetailActivity.class);
                    intent1.putExtra(Constants.topic,  txt_caroline.getText().toString());
                    intent1.putExtra(Constants.side, side);
                    intent1.putExtra(Constants.detail,  topic_caroline.getText().toString());
                    intent1.putExtra(Constants.image, R.drawable.ic_coroline);
                    intent1.putExtra(Constants.GOOGLE_INTERITIAL_ID, ginurl);
                    intent1.putExtra(Constants.FACEBOOK_INTERITIAL_ID, finurl);
                    intent1.putExtra(Constants.GOOGLE_BANNER_ID, gburl);
                    intent1.putExtra(Constants.FACEBOOK_BANNER_ID, fburl);
                    intent1.putExtras(intent1);
                    startActivity(intent1);
                }

                 hayato=false;
                 moco=false;
                 wukong=false;
                 antonio=false;
                 andrew=false;
                 kelly=false;
                 olivia=false;
                 ford=false;
                 nikita=false;
                 misha=false;
                 maxim=false;
                 kla=false;
                 paloma=false;
                 miguel=false;
                 caroline=false;
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