package com.h5190041.yavuz_selim_temur_final.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.h5190041.yavuz_selim_temur_final.R;
import com.h5190041.yavuz_selim_temur_final.model.Filmler;
import com.h5190041.yavuz_selim_temur_final.util.GlideUtil;
import java.util.List;

public class FilmAdaptor extends RecyclerView.Adapter<FilmViewHolder> {
    OnItemClickListener listener;
    List<Filmler> filmler;
    Context context;

    public interface OnItemClickListener {
        void onClik(int position);
    }

    public FilmAdaptor(List<Filmler> filmler, Context context,OnItemClickListener listener) {
        this.filmler = filmler;
        this.context = context;
        this.listener=listener;
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_filmler,parent,false);
        return new FilmViewHolder(itemView,listener);
    }



    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder viewHolder, int position) {

        viewHolder.txtFilmAdi.setText(filmler.get(position).getFilmAdi());
        viewHolder.txtFilmTuru.setText(filmler.get(position).getTuru());
        viewHolder.txtButce.setText(filmler.get(position).getButce());
        GlideUtil.resimleriNetworkGetir(context,filmler.get(position).getKucukLogoUrl(),viewHolder.imgLogo);

    }

    @Override
    public int getItemCount() {
        return filmler.size();
    }
}
