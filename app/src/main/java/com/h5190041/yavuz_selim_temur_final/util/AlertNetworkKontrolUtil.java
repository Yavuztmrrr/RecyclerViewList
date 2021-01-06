package com.h5190041.yavuz_selim_temur_final.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import android.view.KeyEvent;

import com.h5190041.yavuz_selim_temur_final.R;

public class AlertNetworkKontrolUtil {

    public static void alertInternetKontrol(Context context, String message ,String kapatMessage,String internetAcMesagge)
    {
        final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setMessage(message);
        alertDialog.setCancelable(false);

        alertDialog.setButton2(kapatMessage, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0);

            }
        });
        alertDialog.setButton(internetAcMesagge, new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                context.startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));

            }
        });
        alertDialog.show();
    }





}
