package com.example.thesmileofluisa;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thesmileofluisa.adapter.AdapterMask;
import com.example.thesmileofluisa.models.Mask;
import com.example.thesmileofluisa.utils.CustomItemClick;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentMasks#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentMasks extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentMasks() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentMasks.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentMasks newInstance(String param1, String param2) {
        FragmentMasks fragment = new FragmentMasks();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    ArrayList<Mask> mask = new ArrayList();
    ArrayList<Mask> maskBuy = new ArrayList<>();
    AdapterMask adapterMask;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_masks, container, false);

        TextView tvPrint = view.findViewById(R.id.tvPrint);
        TextView tvEspecial = view.findViewById(R.id.tvEspecial);
        TextView tvSpring = view.findViewById(R.id.tvSpring);
        TextView tvSmooth = view.findViewById(R.id.tvSmooth);
        TextView tvColours = view.findViewById(R.id.tvColours);
        RecyclerView rvMask = view.findViewById(R.id.rvMask);
        TextView tvBuy = view.findViewById(R.id.tvBuy);

        adapterMask = new AdapterMask(view.getContext(), mask, new CustomItemClick() {
            @Override
            public void onItemClick(int position) {
                maskBuy.add(mask.get(position));
                Log.i("lista", maskBuy.toString());
                Toast toast = Toast.makeText(getContext(), "Mascarilla añadida al carrito", Toast.LENGTH_SHORT);
                toast.show();

            }
        });

        tvBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ListBuyActivity.class);
                intent.putExtra("mask", maskBuy);
                startActivity(intent);
            }
        });


        rvMask.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        rvMask.setLayoutManager(layoutManager);
        rvMask.setAdapter(adapterMask);

        tvPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupMaskprint();
            }
        });

        tvEspecial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupMaskEspecial();
            }
        });

        tvSpring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupMaskSpring();
            }
        });

        tvSmooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupMaskSmooth();

            }
        });

        tvColours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupMaskColours();

            }
        });



        return view;
    }

    public void setupMaskprint() {
        mask.clear();
        mask.add(new Mask("Mascarilla Print", "Colección Mascarillas Print", 6.99, R.drawable.animal_print_2));
        mask.add(new Mask("Mascarilla Print", "Colección Mascarillas Print", 6.49, R.drawable.animal_print_4));

        adapterMask.notifyDataSetChanged();
    }

    public void setupMaskEspecial() {

        mask.clear();
        mask.add(new Mask("Mascarillas especiales", "Colección eventos especiales", 4.99,R.drawable.especial));
        mask.add(new Mask("Mascarillas especiales", "Colección eventos especiales", 4.99,R.drawable.especial_2));
        mask.add(new Mask("Mascarillas especiales", "Colección eventos especiales", 4.99,R.drawable.especial_3));

        adapterMask.notifyDataSetChanged();

    }

    public void setupMaskSpring() {

        mask.clear();
        mask.add(new Mask("Mascarillas Spring", "Colección Mascarillas Spring", 5,R.drawable.flores));
        mask.add(new Mask("Mascarillas Spring", "Colección Mascarillas Spring", 5.50,R.drawable.flores_2));
        mask.add(new Mask("Mascarillas Spring", "Colección Mascarillas Spring", 3.55,R.drawable.flores_3));
        mask.add(new Mask("Mascarillas Spring", "Colección Mascarillas Spring", 4.65,R.drawable.flores_4));
        mask.add(new Mask("Mascarillas Spring", "Colección Mascarillas Spring", 3.50,R.drawable.flores_5));
        mask.add(new Mask("Mascarillas Spring", "Colección Mascarillas Spring", 7.50,R.drawable.flores_6));
        mask.add(new Mask("Mascarillas Spring", "Colección Mascarillas Spring", 5,R.drawable.flores_8));

        adapterMask.notifyDataSetChanged();
    }

    public void setupMaskSmooth() {

        mask.clear();
        mask.add(new Mask("Mascarillas lisas", "Colección mascarillas lisas para ellos y ellas", 4.45, R.drawable.lisa));
        mask.add(new Mask("Mascarillas lisas", "Colección mascarillas lisas para ellos y ellas", 4, R.drawable.lisa_1));
        mask.add(new Mask("Mascarillas lisas", "Colección mascarillas lisas para ellos y ellas", 4.50, R.drawable.lisa_2));
        mask.add(new Mask("Mascarillas lisas", "Colección mascarillas lisas para ellos y ellas", 4, R.drawable.lisa_3));

        adapterMask.notifyDataSetChanged();
    }

    public void setupMaskColours() {

        mask.clear();
        mask.add(new Mask("Mascarillas de lunares", "Colección de mascarillas de lunares", 4.60, R.drawable.lunares_1));
        mask.add(new Mask("Mascarillas de lunares", "Colección de mascarillas de lunares", 9.65, R.drawable.lunares_2));
        mask.add(new Mask("Mascarillas de lunares", "Colección de mascarillas de lunares", 6, R.drawable.lunares_3));
        mask.add(new Mask("Mascarillas de lunares", "Colección de mascarillas de lunares", 6.50, R.drawable.lunares_4));
        mask.add(new Mask("Mascarillas de lunares", "Colección de mascarillas de lunares", 3.60, R.drawable.lunares_5));

        adapterMask.notifyDataSetChanged();
    }
}


