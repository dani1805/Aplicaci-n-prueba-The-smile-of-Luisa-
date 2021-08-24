package com.example.thesmileofluisa.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
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

public class AdapterMask extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List <Mask> maskList;
    private CustomItemClick listener;

    public AdapterMask(Context context, List<Mask> maskList, CustomItemClick listener) {
        this.context = context;
        this.maskList = maskList;
        this.listener = listener;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View pView = inflater.inflate(R.layout.my_holder, parent, false);
        return new myHolder(pView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        myHolder mHolder = (myHolder) holder;
        final Mask item = maskList.get(position);

        int img = item.getImg();
        String name = item.getName();
        String model = item.getModel();
        double price = item.getPrice();

        mHolder.setData(img, name, model, price);

        mHolder.btnAddBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(position);
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return maskList.size();
    }

    class myHolder extends RecyclerView.ViewHolder {

        private final ImageView imgMask;
        private final TextView tvNameMask;
        private final TextView tvModel;
        private final TextView tvPrice;
        private final Button btnAddBuy;

        myHolder(View view) {
            super(view);

            imgMask = view.findViewById(R.id.imgMask);
            tvNameMask = view.findViewById(R.id.tvNameMask);
            tvModel = view.findViewById(R.id.tvModel);
            tvPrice = view.findViewById(R.id.tvPrice);
            btnAddBuy = view.findViewById(R.id.btnAddBuy);

        }

        public void setData(int img, String name, String model, double price) {

            Drawable drawable = context.getResources().getDrawable(img);
            this.imgMask.setImageDrawable(drawable);
            this.tvNameMask.setText((CharSequence) name);
            this.tvModel.setText((CharSequence) model);
            this.tvPrice.setText((String.valueOf(price)));

        }
    }
}
