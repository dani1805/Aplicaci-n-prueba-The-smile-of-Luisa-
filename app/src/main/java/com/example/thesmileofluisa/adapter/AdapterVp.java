package com.example.thesmileofluisa.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.thesmileofluisa.R;
import com.example.thesmileofluisa.SlideLogo;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class AdapterVp extends RecyclerView.Adapter<AdapterVp.SliderViewHolder> {

    private List<SlideLogo> slideLogos;
    private ViewPager2 vpImgs;

    public AdapterVp(List<SlideLogo> slideLogos, ViewPager2 vpImgs) {
        this.slideLogos = slideLogos;
        this.vpImgs = vpImgs;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.slide_logo,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterVp.SliderViewHolder holder, int position) {

        holder.setImage(slideLogos.get(position));
        if(position == slideLogos.size() - 2){
            vpImgs.post(runnable);
        }
    }


    @Override
    public int getItemCount() {
        return slideLogos.size();
    }

    class SliderViewHolder extends RecyclerView.ViewHolder {
        private RoundedImageView roundedImageView;

        SliderViewHolder(@NonNull View itemView) {
            super(itemView);

            roundedImageView = itemView.findViewById(R.id.slide_logo);
        }

        void setImage(SlideLogo slideLogo) {

            roundedImageView.setImageResource(slideLogo.getImage());

        }
    }

    private  Runnable runnable = new Runnable() {
        @Override
        public void run() {
            slideLogos.addAll(slideLogos);
            notifyDataSetChanged();

        }
    };
}
