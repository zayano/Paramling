package com.example.zayano.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.widget.TextView;
import android.widget.Toast;

public class ProsesPemesanan extends AppCompatActivity {
TextView pelanggan,alamat_pelanggan,judul,pemangkas,hp_pemangkas;
    Bundle data;
    String PELANGGAN,ALAMAT_PELANGGAN,JUDUL,PEMANGKAS,HP_PEMANGKAS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proses_pemesanan);

        judul = (TextView) findViewById(R.id.tittle);
        pelanggan = (TextView) findViewById(R.id.nama_pelanggan);
        alamat_pelanggan = (TextView) findViewById(R.id.alamat_pelanggan);
        data = getIntent().getExtras();
        pemangkas = (TextView) findViewById(R.id.nama_pemangkas);
        hp_pemangkas = (TextView) findViewById(R.id.hp_pemangkas);

        PELANGGAN = data.getString("nama_pl");
        ALAMAT_PELANGGAN = data.getString("alamat_pl");
        JUDUL = data.getString("judul");
        PEMANGKAS = data.getString("nama_pemangkas");
        HP_PEMANGKAS = data.getString("hp_pemangkas");

        pelanggan.setText(PELANGGAN);
        alamat_pelanggan.setText(ALAMAT_PELANGGAN);
        judul.setText(JUDUL);
        pemangkas.setText(PEMANGKAS);
        hp_pemangkas.setText(HP_PEMANGKAS);


        sendSmsByManager(JUDUL +
                "\n\n" +
                "NAMA PELANGGAN : \n" + PELANGGAN +
                "\n" +
                "ALAMAT PELANGGAN : \n" + ALAMAT_PELANGGAN);


    }
    public void sendSmsByManager(String isipesan) {

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(HP_PEMANGKAS,null,isipesan, null, null);
            Toast.makeText(getApplicationContext(), "Pemesanan Berhasil!, Dimohon menunggu konfirmasi.",
                    Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),"Pemesanan Gagal!, Silahkan coba beberapa saat lagi!",
                    Toast.LENGTH_SHORT).show();
            ex.printStackTrace();
        }
    }
}
