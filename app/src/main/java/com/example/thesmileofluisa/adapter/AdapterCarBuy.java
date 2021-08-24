package com.example.thesmileofluisa.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thesmileofluisa.R;
import com.example.thesmileofluisa.models.Mask;
import com.example.thesmileofluisa.utils.CustomItemClick;

import java.util.List;


public class AdapterCarBuy extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List <Mask> listBuy;
    private CustomItemClick listener;

    public AdapterCarBuy(Context context, List<Mask> listBuy, CustomItemClick listener) {
        this.context = context;
        this.listBuy = listBuy;
        this.listener = listener;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View bView = inflater.inflate(R.layout.holder_buy, parent, false);
        return new bHolder(bView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        bHolder bHolder = (bHolder) holder;
        final Mask itemBuy = listBuy.get(position);

        int imgBuy = itemBuy.getImg();
        String nameBuy = itemBuy.getName();
        String modelBuy = itemBuy.getModel();
        double priceBuy = itemBuy.getPrice();

        bHolder.setData(imgBuy, nameBuy, modelBuy, priceBuy);

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return listBuy.size();
    }

    class bHolder extends RecyclerView.ViewHolder {

        private final ImageView imgCar;
        private final TextView tvCarName;
        private final TextView tvCarModel;
        private final TextView tvCarPrice;

        bHolder(View view) {
            super(view);

            imgCar = view.findViewById(R.id.imgCar);
            tvCarName = view.findViewById(R.id.tvCarName);
            tvCarModel = view.findViewById(R.id.tvCarModel);
            tvCarPrice = view.findViewById(R.id.tvCarPrice);

        }

        public void setData(int imgB, String nameB, String modelB, double priceB) {

            Drawable drawable = context.getResources().getDrawable(imgB);
            this.imgCar.setImageDrawable(drawable);
            this.tvCarName.setText((CharSequence) nameB);
            this.tvCarModel.setText((CharSequence) modelB);
            Log.i("precio", String.valueOf(priceB));
            this.tvCarPrice.setText((String.valueOf(priceB)));

        }
    }
}
