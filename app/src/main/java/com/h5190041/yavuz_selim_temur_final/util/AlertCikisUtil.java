package com.h5190041.yavuz_selim_temur_final.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.h5190041.yavuz_selim_temur_final.R;

public class AlertCikisUtil {

    public static void alertCikisKontrol(Context context, String message, String cikisMesagge, String iptalMessage) {
        final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setMessage(message);
        alertDialog.setCancelable(false);
        alertDialog.setButton2(cikisMesagge, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0);

            }
        });
        alertDialog.setButton(iptalMessage, new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.cancel();

            }
        });

        alertDialog.show();
    }
}
