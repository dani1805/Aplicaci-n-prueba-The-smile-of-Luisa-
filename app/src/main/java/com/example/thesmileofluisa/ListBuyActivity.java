package com.example.thesmileofluisa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thesmileofluisa.adapter.AdapterCarBuy;
import com.example.thesmileofluisa.adapter.AdapterMask;
import com.example.thesmileofluisa.models.Mask;
import com.example.thesmileofluisa.utils.CustomItemClick;

import java.util.ArrayList;

public class ListBuyActivity extends AppCompatActivity {

    private RecyclerView rvListBuy;
    private ArrayList<Mask> maskBuy = new ArrayList();
    private AdapterCarBuy adapterCarBuy;
    private ArrayList<Mask> list = new ArrayList<>();

    private TextView tvCustom;
    private ImageView imgIcon;
    private double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_buy);

        rvListBuy = findViewById(R.id.rvListBuy);
        TextView tvPriceTotal = findViewById(R.id.tvPriceTotal);
        Button btnFinish = findViewById(R.id.btnFinish);

        rvListBuy.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        rvListBuy.setLayoutManager(layoutManager);
        ArrayList<Mask> list = (ArrayList<Mask>) getIntent().getSerializableExtra("mask");
        Log.i("hola", String.valueOf(list.size()));

        adapterCarBuy = new AdapterCarBuy(this, list, new CustomItemClick() {
            @Override
            public void onItemClick(int position) {


            }
        });

        rvListBuy.setAdapter(adapterCarBuy);

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCustomAlertDialog();

            }
        });

        for (int i = 0; i < list.size(); i++) {

            price = price + list.get(i).getPrice();
        }

        tvPriceTotal.setText(String.valueOf(price));

    }

    private void setCustomAlertDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.customalertdialog, null);
        tvCustom = findViewById(R.id.tvCustom);
        imgIcon = findViewById(R.id.imgIcon);

        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}