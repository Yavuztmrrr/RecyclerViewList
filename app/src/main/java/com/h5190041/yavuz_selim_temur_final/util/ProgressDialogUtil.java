package com.h5190041.yavuz_selim_temur_final.util;

import android.app.ProgressDialog;
import android.content.Context;

public class ProgressDialogUtil {
    public static ProgressDialog showProgressDialog(Context context, String message){
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(message);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.getListView();

        progressDialog.show();
        return progressDialog;
    }
}
