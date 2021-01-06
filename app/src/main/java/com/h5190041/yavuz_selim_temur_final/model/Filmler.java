package com.h5190041.yavuz_selim_temur_final.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Filmler {

    @SerializedName("FilmAdi")
    @Expose
    private String filmAdi;
    @SerializedName("SeriYil")
    @Expose
    private String seriYil;
    @SerializedName("Turu")
    @Expose
    private String turu;
    @SerializedName("Yonetmen")
    @Expose
    private String yonetmen;
    @SerializedName("Butce")
    @Expose
    private String butce;
    @SerializedName("GiseGeliri")
    @Expose
    private String giseGeliri;
    @SerializedName("KucukLogoUrl")
    @Expose
    private String kucukLogoUrl;
    @SerializedName("BuyukResimUrl")
    @Expose
    private String buyukResimUrl;
    @SerializedName("Konusu")
    @Expose
    private String konusu;
    @SerializedName("ImdbPuani")
    @Expose
    private String imdbPuani;

    public String getFilmAdi() {
        return filmAdi;
    }

    public void setFilmAdi(String filmAdi) {
        this.filmAdi = filmAdi;
    }

    public String getSeriYil() {
        return seriYil;
    }

    public void setSeriYil(String seriYil) {
        this.seriYil = seriYil;
    }

    public String getTuru() {
        return turu;
    }

    public void setTuru(String turu) {
        this.turu = turu;
    }

    public String getYonetmen() {
        return yonetmen;
    }

    public void setYonetmen(String yonetmen) {
        this.yonetmen = yonetmen;
    }

    public String getButce() {
        return butce;
    }

    public void setButce(String butce) {
        this.butce = butce;
    }

    public String getGiseGeliri() {
        return giseGeliri;
    }

    public void setGiseGeliri(String giseGeliri) {
        this.giseGeliri = giseGeliri;
    }

    public String getKucukLogoUrl() {
        return kucukLogoUrl;
    }

    public void setKucukLogoUrl(String kucukLogoUrl) {
        this.kucukLogoUrl = kucukLogoUrl;
    }

    public String getBuyukResimUrl() {
        return buyukResimUrl;
    }

    public void setBuyukResimUrl(String buyukResimUrl) {
        this.buyukResimUrl = buyukResimUrl;
    }

    public String getKonusu() {
        return konusu;
    }

    public void setKonusu(String konusu) {
        this.konusu = konusu;
    }

    public String getImdbPuani() {
        return imdbPuani;
    }

    public void setImdbPuani(String imdbPuani) {
        this.imdbPuani = imdbPuani;
    }

}
