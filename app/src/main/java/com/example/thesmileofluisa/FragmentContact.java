package com.example.thesmileofluisa;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentContact#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentContact extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentContact() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentContact.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentContact newInstance(String param1, String param2) {
        FragmentContact fragment = new FragmentContact();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        EditText etNameContact;
        EditText etEmailContact;
        EditText etPhone;
        EditText etMessage;
        ImageView imgEmail;
        ImageView imgWhat;
        Button btnSend;

        etNameContact = view.findViewById(R.id.etNameContact);
        etEmailContact = view.findViewById(R.id.etEmailContact);
        etPhone = view.findViewById(R.id.etPhone);
        etMessage = view.findViewById(R.id.etMessage);
        imgEmail = view.findViewById(R.id.imgEmail);
        imgWhat = view.findViewById(R.id.imgWhat);
        btnSend = view.findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etNameContact.getText().toString();
                String email = etEmailContact.getText().toString();
                String phone = etPhone.getText().toString();
                String message = etMessage.getText().toString();

                if (name.isEmpty()) {
                    etNameContact.setError("Campo vacío");
                } else if (email.isEmpty()) {
                    etEmailContact.setError("Campo vacío");
                } else if (phone.isEmpty()) {
                    etPhone.setError("Campo vacío");
                } else if (message.isEmpty()) {
                    etMessage.setError("Campo vacío");
                } else {

                    AlertDialog.Builder builder = new AlertDialog.Builder(container.getContext());
                    builder.setTitle("Atención");
                    builder.setMessage("Vas a enviar estos datos por correo electrónico.¿Estás seguro de ello?");
                    builder.setNegativeButton("CANCELAR", null);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String [] adresses = {"rbc_1993@gmail.com"};
                            String subject = "Reclamaciones";
                            Intent intent = new Intent(Intent.ACTION_SEND);
                            intent.setDataAndType(Uri.parse("mailto"),"text/plain");
                            intent.putExtra(Intent.EXTRA_EMAIL, adresses);
                            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                            intent.putExtra(Intent.EXTRA_TEXT, "\nNombre: " + name + "\nEmail: " + email + "\nTeléfono: " + phone + "\nMensaje: " + message);

                            startActivity (Intent.createChooser(intent,"Elige un cliente de correo"));
                        }
                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();

                }

                }
        });

        imgEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String [] adress = {"rbc_1993@gmail.com"};
                String subject = "asunto";
                String text = "";
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, adress);
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, text);
                startActivity (Intent.createChooser(intent,"Elige un cliente de correo"));
            }
        });

        imgWhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://api.whatsapp.com/send?phone=34697246008");
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
                startActivity(intent);

            }
        });

        return view;
    }
}