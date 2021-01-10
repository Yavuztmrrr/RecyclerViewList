package com.h5190041.yavuz_selim_temur_final.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.os.CountDownTimer;

import android.util.Log;

import com.h5190041.yavuz_selim_temur_final.util.Constants;
import com.h5190041.yavuz_selim_temur_final.R;
import com.h5190041.yavuz_selim_temur_final.util.AlertNetworkKontrolUtil;
import com.h5190041.yavuz_selim_temur_final.util.NetworkUtil;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
    }
    private void init(){
        CountDownTimer countDownTimer =new CountDownTimer(Constants.GECIS_SURESI,Constants.COUNT_DOWN) {
            @Override
            public void onTick(long l) {

            }
            @Override
            public void onFinish() {
                sayfaGecisiAndInternetIzni();
            }
        }.start();
    }

    private void sayfaGecisiAndInternetIzni(){
        if(!NetworkUtil.internetBaglantisiKontrol(getApplicationContext())){
            AlertNetworkKontrolUtil.alertInternetKontrol(SplashActivity.this,getResources().getString(R.string.alertNetworkBaslik),getResources().getString(R.string.alertNetworKapat),  getResources().getString(R.string.alertNetworkInternetAc));
        }
        else{
            Intent splash=new Intent(getApplicationContext(), ListeActivity.class);
            startActivity(splash);
            finish();
        }
    }
}
