package com.h5190041.yavuz_selim_temur_final.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.h5190041.yavuz_selim_temur_final.R;

public class FilmViewHolder  extends RecyclerView.ViewHolder {
    ImageView imgLogo;
    TextView txtFilmAdi,txtFilmTuru,txtButce;

    public FilmViewHolder(@NonNull View itemView, FilmAdaptor.OnItemClickListener listener) {
        super(itemView);

        imgLogo =itemView.findViewById(R.id.imgLogo);
        txtFilmAdi =itemView.findViewById(R.id.txtFilmAdi);
        txtFilmTuru =itemView.findViewById(R.id.txtFilmTuru);
        txtButce =itemView.findViewById(R.id.txtButce);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClik(getAdapterPosition());
            }
        });
    }
}
