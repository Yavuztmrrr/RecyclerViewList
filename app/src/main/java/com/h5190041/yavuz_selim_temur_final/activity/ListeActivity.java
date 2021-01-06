package com.h5190041.yavuz_selim_temur_final.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import com.cagataymuhammet.objectprinter.ObjectPrinter;
import com.h5190041.yavuz_selim_temur_final.R;
import com.h5190041.yavuz_selim_temur_final.adaptor.FilmAdaptor;
import com.h5190041.yavuz_selim_temur_final.model.Filmler;
import com.h5190041.yavuz_selim_temur_final.network.Servis;
import com.h5190041.yavuz_selim_temur_final.util.AlertCikisUtil;
import com.h5190041.yavuz_selim_temur_final.util.AlertNetworkKontrolUtil;
import com.h5190041.yavuz_selim_temur_final.util.Constants;
import com.h5190041.yavuz_selim_temur_final.util.NetworkUtil;
import com.h5190041.yavuz_selim_temur_final.util.ObjectUtil;
import com.h5190041.yavuz_selim_temur_final.util.ProgressDialogUtil;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListeActivity extends AppCompatActivity {
    TextView kapakAciklama;
    RecyclerView recyclerfilmlerliste;
    ProgressDialog myDialog;
    String clickFilm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);
        init();
    }
    private  void  init()
    {
        progressDialogCagirimi();
        initText();
        filmleriGetir();
    }

    private  void  progressDialogCagirimi()
    {
        myDialog= ProgressDialogUtil.showProgressDialog(ListeActivity.this,getResources().getString(R.string.progressAlertBaslik));
    }

    private  void  initText()
    {
        kapakAciklama=findViewById(R.id.txtKapakAciklama);
        kapakAciklama.setText(getResources().getString(R.string.kapakAciklama));
        kapakAciklama.setTextColor(getResources().getColor(R.color.white));
    }

    private void  filmleriGetir()
    {
        new Servis().getServisApi().filmleriGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Filmler>>() {
                    List<Filmler> filmler=new ArrayList<>();
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(List<Filmler> filmlerList) {
                        filmler=filmlerList;
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onComplete()
                    {
                        //progresdialog index sayısı film listinin boyutu bitince kapansın
                        for (int index =0; index<=filmler.size(); index++){
                                if(index==filmler.size()){
                                    myDialog.dismiss();
                                }
                            continue;
                        }
                        if(filmler.size()>0) {
                            ObjectPrinter.printJson(filmler);
                            initRecycleView(filmler);

                        }

                    }
                });
    }

    private  void  initRecycleView(List<Filmler> filmlerList)
    {
        recyclerfilmlerliste =findViewById(R.id.rcvFilmler);
        FilmAdaptor filmAdaptor =new FilmAdaptor(filmlerList, getApplicationContext(), new FilmAdaptor.OnItemClickListener() {
            @Override
            public void onClik(int position) {
                Filmler acilanFilm = filmlerList.get(position);
                detaySayfasiVeriGonderme(acilanFilm);
            }
        });
        recyclerfilmlerliste.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerfilmlerliste.setAdapter(filmAdaptor);
    }

    private void detaySayfasiVeriGonderme(Filmler film) {

        Intent detayActivity = new Intent(getApplicationContext(), DetayActivity.class);
        clickFilm= ObjectUtil.filmToJsonString(film);
        detayActivity.putExtra(Constants.CLICK_FILM_ADI,clickFilm);
        startActivity(detayActivity);

    }

    public boolean onKeyDown(int keyCode, KeyEvent event ) {
        //geri butonunu yakalıyoruz
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            AlertCikisUtil.alertCikisKontrol(ListeActivity.this,getResources().getString(R.string.alertTitleMesagge),getResources().getString(R.string.cikisMesagge),getResources().getString(R.string.alertIptal));
            return true;
        }
        else {
            return onKeyDown(keyCode, event);
        }
    }


}