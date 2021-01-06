package com.h5190041.yavuz_selim_temur_final.network;
import com.h5190041.yavuz_selim_temur_final.model.Filmler;
import java.util.List;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServisApi {

    @GET("SerilerJsonFinal.json")
    Observable<List<Filmler>> filmleriGetir();
}
