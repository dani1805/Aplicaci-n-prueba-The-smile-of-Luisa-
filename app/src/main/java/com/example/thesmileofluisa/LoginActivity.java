package com.example.thesmileofluisa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etPassword;
    private TextView tvForgotPasswd;
    private Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        tvForgotPasswd = findViewById(R.id.tvForgotPasswd);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = etName.getText().toString();
                String userPasswd = etPassword.getText().toString();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                if (userName.equals("rocio") && userPasswd.equals("foki")) {
                    startActivity(intent);
                } else if (userName.equals("luisa") && userPasswd.equals("zoraida")) {
                    startActivity(intent);
                } else if (userName.equals("paco") && userPasswd.equals("cardeñosa")) {
                    startActivity(intent);
                } else if (userName.equals("ana") && userPasswd.equals("lombarda")) {
                    startActivity(intent);

                } else if (userName.isEmpty()) {
                    etName.setError("El campo está vacío");
                } else if (userPasswd.isEmpty()) {
                    etPassword.setError("El campo está vacío");
                } else {

                    androidx.appcompat.app.AlertDialog.Builder otherBuilder = new androidx.appcompat.app.AlertDialog.Builder(LoginActivity.this);
                    otherBuilder.setTitle("Error");
                    otherBuilder.setMessage("Usuario y contraseña incorrectos. Vuelva a intentarlo");
                    otherBuilder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    androidx.appcompat.app.AlertDialog otherDialog = otherBuilder.create();
                    otherDialog.show();

                    etName.setError("Datos incorrectos");
                    etPassword.setError("Datos incorrectos");
                }
            }
        });

        tvForgotPasswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pattern pattern = Patterns.EMAIL_ADDRESS;

                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                View view = getLayoutInflater().inflate(R.layout.data,null);
                EditText userEmail = view.findViewById(R.id.emailData);
                builder.setView(view);

                builder.setPositiveButton("OK" , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(LoginActivity.this, "Enviado a " + userEmail.getText(),
                                Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(LoginActivity.this, "No se ha guardado ningún email.",
                                Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog dialog = builder.create();

                userEmail.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    // Pattern tiene un método estático compile(«…») por el cual se obtiene una instancia, dado un String que contiene la expresión regular. Este objeto debe reutilizarse entre usos de la misma expresión regular, para evitar incurrir en tiempos innecesarios al compilar una y otra vez la misma expresión.

                    @Override
                    public void afterTextChanged(Editable s) {
                        if (TextUtils.isEmpty(s)) {
                            userEmail.setError("Campo obligatorio");
                            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
                        } else if(!pattern.matcher(s).matches()) {
                            userEmail.setError("El texto introducido no tiene formato de correo electrónico");
                            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
                        } else {
                            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(true);
                        }
                    }
                });

                dialog.show();

            }
        });

    }
}