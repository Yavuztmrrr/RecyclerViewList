package com.h5190041.yavuz_selim_temur_final.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.h5190041.yavuz_selim_temur_final.R;

public class GlideUtil {

    public  static  void resimleriNetworkGetir(Context context, String url, ImageView img)
    {
        Glide.with(context)
                .load(url)
                .error(R.drawable.error)
                .centerCrop()
                .into(img);
    }
}
