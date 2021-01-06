package com.h5190041.yavuz_selim_temur_final.activity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;
import com.h5190041.yavuz_selim_temur_final.R;
import com.h5190041.yavuz_selim_temur_final.model.Filmler;
import com.h5190041.yavuz_selim_temur_final.util.Constants;
import com.h5190041.yavuz_selim_temur_final.util.GlideUtil;
import com.h5190041.yavuz_selim_temur_final.util.ObjectUtil;

public class DetayActivity extends AppCompatActivity {
    ImageView imgDetayKapakResim;
    TextView txtfilmBaslik,txtfilmSeriYil,txtFilmTuru,txtDetayYonetmen,txtDetayButce,txtDetayGiseGeliri,txtDetayImdbPuan,txtDetayKonusu;
    TextView txtDetayFilmSeriYilBaslik,txtDetayFilmTuruBaslik,txtDetayFilmYonetmenBaslik,txtDetayFilmButceBaslik,txtDetayFilmGiseGeliriBaslik
            ,txtDetayFilmImdbPuanBaslik,txtDetayFilmKonusuBaslik;
    String filmKonusu,filmImdbPuan,cagirilanFilm;
    Filmler filmler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        init();
    }

    private  void init(){
        txtFilmDetayBaslikInit();
        txtFilmDetayVerilerInit();
    }
    private void txtFilmDetayBaslikInit()
    {

        txtDetayFilmSeriYilBaslik =findViewById(R.id.txtDetayFilmSeriYilBaslik);
        txtDetayFilmTuruBaslik =findViewById(R.id.txtDetayFilmTuruBaslik);
        txtDetayFilmYonetmenBaslik =findViewById(R.id.txtDetayFilmYonetmenBaslik);
        txtDetayFilmButceBaslik =findViewById(R.id.txtDetayFilmButceBaslik);
        txtDetayFilmGiseGeliriBaslik =findViewById(R.id.txtDetayFilmGiseGeliriBaslik);
        txtDetayFilmImdbPuanBaslik =findViewById(R.id.txtDetayFilmImdbPuanBaslik);
        txtDetayFilmKonusuBaslik =findViewById(R.id.txtDetayFilmKonusuBaslik);
        txtFilmBaslikYazilari();
        txtFilmBaslikRenkleri();
    }
    private void txtFilmBaslikYazilari(){

        txtDetayFilmSeriYilBaslik.setText(getResources().getString(R.string.txtDetayFilmSeriYilBaslik));
        txtDetayFilmTuruBaslik.setText(getResources().getString(R.string.txtDetayFilmTuruBaslik));
        txtDetayFilmYonetmenBaslik.setText(getResources().getString(R.string.txtDetayFilmYonetmenBaslik));
        txtDetayFilmButceBaslik.setText(getResources().getString(R.string.txtDetayFilmButceBaslik));
        txtDetayFilmGiseGeliriBaslik.setText(getResources().getString(R.string.txtDetayFilmGiseGeliriBaslik));
        txtDetayFilmImdbPuanBaslik.setText(getResources().getString(R.string.txtDetayFilmImdbPuanBaslik));
        txtDetayFilmKonusuBaslik.setText(getResources().getString(R.string.txtDetayFilmKonusuBaslik));
    }
    private void txtFilmBaslikRenkleri(){

        txtDetayFilmSeriYilBaslik.setTextColor(getResources().getColor(R.color.black));
        txtDetayFilmTuruBaslik.setTextColor(getResources().getColor(R.color.black));
        txtDetayFilmYonetmenBaslik.setTextColor(getResources().getColor(R.color.black));
        txtDetayFilmButceBaslik.setTextColor(getResources().getColor(R.color.black));
        txtDetayFilmGiseGeliriBaslik.setTextColor(getResources().getColor(R.color.black));
        txtDetayFilmImdbPuanBaslik.setTextColor(getResources().getColor(R.color.black));
        txtDetayFilmKonusuBaslik.setTextColor(getResources().getColor(R.color.black));
    }
    private void txtFilmDetayVerilerInit()
    {
        cagirilanFilm =getIntent().getStringExtra(Constants.CLICK_FILM_ADI);
        filmler = ObjectUtil.jsonStringToFilmler(cagirilanFilm);

        imgDetayKapakResim =findViewById(R.id.imgDetayKapak);
        txtfilmBaslik =findViewById(R.id.txtDetayBaslik);
        txtfilmSeriYil =findViewById(R.id.txtDetayFilmSeriYil);
        txtFilmTuru =findViewById(R.id.txtDetayFilmTuru);
        txtDetayYonetmen =findViewById(R.id.txtDetayYonetmen);
        txtDetayButce =findViewById(R.id.txtDetayButce);
        txtDetayGiseGeliri =findViewById(R.id.txtDetayGiseGeliri);
        txtDetayImdbPuan =findViewById(R.id.txtDetayImdbPuan);
        txtDetayKonusu =findViewById(R.id.txtDetayKonusu);
        txtFilmVeriRenkleri();

        GlideUtil.resimleriNetworkGetir(getApplicationContext(),filmler.getBuyukResimUrl(),imgDetayKapakResim);
        txtfilmBaslik.setText(filmler.getFilmAdi());
        txtfilmSeriYil.setText(filmler.getSeriYil());
        txtFilmTuru.setText(filmler.getTuru());
        txtDetayYonetmen.setText(filmler.getYonetmen());
        txtDetayButce.setText(filmler.getButce());
        txtDetayGiseGeliri.setText(filmler.getGiseGeliri());
        txtDetayImdbPuan.setText(filmler.getImdbPuani());
        txtFilmHtmlVeri();

    }
    private void txtFilmHtmlVeri(){
        filmKonusu = filmler.getKonusu();
        filmImdbPuan=filmler.getImdbPuani();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N)
        {
            txtDetayKonusu.setText(Html.fromHtml(filmKonusu,Html.FROM_HTML_MODE_LEGACY));
            txtDetayImdbPuan.setText(Html.fromHtml(filmImdbPuan,Html.FROM_HTML_MODE_LEGACY));
        }
        else{
            txtDetayKonusu.setText(Html.fromHtml(filmKonusu));
            txtDetayImdbPuan.setText(Html.fromHtml(filmImdbPuan));
        }

    }
    private void txtFilmVeriRenkleri(){
        txtfilmBaslik.setTextColor(getResources().getColor(R.color.white));
        txtfilmSeriYil.setTextColor(getResources().getColor(R.color.white));
        txtFilmTuru.setTextColor(getResources().getColor(R.color.white));
        txtDetayYonetmen.setTextColor(getResources().getColor(R.color.white));
        txtDetayButce.setTextColor(getResources().getColor(R.color.white));
        txtDetayGiseGeliri.setTextColor(getResources().getColor(R.color.white));
        txtDetayImdbPuan.setTextColor(getResources().getColor(R.color.white));
        txtDetayKonusu.setTextColor(getResources().getColor(R.color.white));

    }

}