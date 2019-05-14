package com.example.zayano.test;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button layanan, exit, model;
    TextView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layanan = (Button) findViewById(R.id.btn_layanan);
        exit = (Button) findViewById(R.id.btn_keluar);
        model = (Button) findViewById(R.id.btn_link);
        user = (TextView) findViewById(R.id.namauser);

        layanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent layarstore = new Intent(getApplicationContext(), pilih_layanan.class);
                startActivity(layarstore);

            }
        });

        model.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move = new Intent(getApplicationContext(), ModelGayaRambut.class);
                startActivity(move);
            }
        });

        String emailFromIntent = getIntent().getStringExtra("EMAIL");
        user.setText(emailFromIntent);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertexit = new AlertDialog.Builder(MainActivity.this);
                alertexit.setMessage("Anda Yakin ingin Logout?")
                        .setTitle("Logout")
                        .setCancelable(false)
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                System.exit(2);
                            }
                        }).setNegativeButton("Tidak",
                        new AlertDialog.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog a = alertexit.create();
                a.show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertexit = new AlertDialog.Builder(MainActivity.this);
        alertexit.setMessage("Anda Yakin ingin Logout?")
                .setTitle("Logout")
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        System.exit(2);
                    }
                }).setNegativeButton("Tidak",
                new AlertDialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog a = alertexit.create();
        a.show();
    }
}




