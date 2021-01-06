package com.h5190041.yavuz_selim_temur_final.util;

import com.google.gson.Gson;

import com.h5190041.yavuz_selim_temur_final.model.Filmler;

import java.util.List;

public class ObjectUtil {

    public  static String filmToJsonString(Filmler film)
    {
        Gson gson = new Gson();
        return   gson.toJson(film);
    }

    public  static Filmler jsonStringToFilmler(String jsonString)
    {
        Gson gson = new Gson();
        return  gson.fromJson(jsonString,Filmler.class);
    }
}
