package com.adsum.freediamond;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.adsum.freediamond.activity.HomeActivity;
import com.adsum.freediamond.config.CommonFunctions;
import com.adsum.freediamond.config.Constants;
import com.adsum.freediamond.model.AppConfigModel;
import com.captaindroid.tvg.Tvg;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public class Splashscreen extends AppCompatActivity {
 Dialog dialog;
 Button refresh;
    public static AppConfigModel appConfigModel = new AppConfigModel();
    private FirebaseRemoteConfig mFirebaseRemoteConfig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        init();

    }
    private void init() {
        try {
            Tvg.change((TextView) findViewById(R.id.txt_appname), new int[]{
                    Color.parseColor("#0148A5"),
                    Color.parseColor("#0CB4E9"),
            });
            new Handler().postDelayed(new Runnable() {


                @Override
                public void run() {
                    try {
                         if (CommonFunctions.checkConnection(Splashscreen.this)) {
                             getremoteconfig();
                        }
                         else {
                             openfeedbackdiologue();
                         }
                    } catch (Exception e) {
                        e.printStackTrace();
                        CommonFunctions.destroyProgressBar();
                    }

                }
            }, 3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void getremoteconfig() {
        try {
            FirebaseApp.initializeApp(this);
            mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();

            FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                    .setMinimumFetchIntervalInSeconds(0)
                    .build();
            mFirebaseRemoteConfig.setConfigSettingsAsync(configSettings);

            mFirebaseRemoteConfig.fetchAndActivate()
                    .addOnCompleteListener(this, new OnCompleteListener<Boolean>() {
                        @Override
                        public void onComplete(@NonNull com.google.android.gms.tasks.Task<Boolean> task) {
                            if (task.isSuccessful()) {
                                appConfigModel.IS_GOOGLE = mFirebaseRemoteConfig.getString(Constants.IS_GOOGLE);
                                appConfigModel.IS_FACEBOOK = mFirebaseRemoteConfig.getString(Constants.IS_FACEBOOK);
                                appConfigModel.GOOGLE_BANNER_ID = mFirebaseRemoteConfig.getString(Constants.GOOGLE_BANNER_ID);
                                appConfigModel.FACEBOOK_BANNER_ID = mFirebaseRemoteConfig.getString(Constants.FACEBOOK_BANNER_ID);
                                appConfigModel.GOOGLE_INTERITIAL_ID = mFirebaseRemoteConfig.getString(Constants.GOOGLE_INTERITIAL_ID);
                                appConfigModel.FACEBOOK_INTERITIAL_ID = mFirebaseRemoteConfig.getString(Constants.FACEBOOK_INTERITIAL_ID);
                                appConfigModel.GOOGLE_REWARDED_ID= mFirebaseRemoteConfig.getString(Constants.GOOGLE_REWARDED_ID);
                                appConfigModel.FACEBOOK_REWARDED_ID= mFirebaseRemoteConfig.getString(Constants.FACEBOOK_REWARDED_ID);
                                appConfigModel.GOOGLE_NATIVEAD_ID= mFirebaseRemoteConfig.getString(Constants.GOOGLE_NATIVEAD_ID);
                                appConfigModel.FACEBOOK_NATIVEAD_ID= mFirebaseRemoteConfig.getString(Constants.FACEBOOK_NATIVEAD_ID);
                                Intent i = new Intent(Splashscreen.this, HomeActivity.class);
                                startActivity(i);
                                finish();
                            } else {
                                Toast.makeText(Splashscreen.this, "No Internet Connection",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void openfeedbackdiologue() {

        try {
            final Dialog dialog = new Dialog(Splashscreen.this, R.style.FullScreenDialogStyle);
            dialog.setContentView(R.layout.notinternetconnection);
            final Button finish = dialog.findViewById(R.id.txt_refresh);
            final TextView no = dialog.findViewById(R.id.txt_nointernet);
            final TextView getstart = dialog.findViewById(R.id.txt_get_start);
            Tvg.change(no, new int[]{
                    Color.parseColor("#0148A5"),
                    Color.parseColor("#0CB4E9"),
            });
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(false);
            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
            lp.copyFrom(dialog.getWindow().getAttributes());
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setAttributes(lp);
            finish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        Intent i = new Intent(Splashscreen.this, Splashscreen.class);
                      startActivity(i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            getstart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {

                        Intent i = new Intent(Splashscreen.this, HomeActivity.class);
                        startActivity(i);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}