package com.example.zayano.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class datapesanan extends AppCompatActivity {

    Bundle data;
    Button kirim;
    TextView pelanggan,alamat_pl,pemangkas,biaya1,jam_operasi,p_kontak,judul;
    String PELANGGAN,ALAMAT,PEMANGKAS,BIAYA1,waktu,P_KONTAK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datapesanan);

        pelanggan = (TextView) findViewById(R.id.nama_pelanggan);
        alamat_pl = (TextView) findViewById(R.id.alamat_pelanggan);
        pemangkas = (TextView) findViewById(R.id.nama_pangkas);
        p_kontak = (TextView) findViewById(R.id.kontak_pangkas);
        biaya1 = (TextView) findViewById(R.id.biaya_dewasa);
        jam_operasi = (TextView) findViewById(R.id.txt_jam);
        kirim = (Button) findViewById(R.id.send);
        judul = (TextView) findViewById(R.id.tittle);
        data = getIntent().getExtras();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        PELANGGAN = data.getString("nama_pl");
        ALAMAT = data.getString("alamat_pl");
        PEMANGKAS = data.getString("nama");
        P_KONTAK = data.getString("hp_pemangkas");
        BIAYA1 = data.getString("biaya_dewasa");
        waktu = data.getString("jam_operasi");

        pelanggan.setText(PELANGGAN);
        alamat_pl.setText(ALAMAT);
        pemangkas.setText(PEMANGKAS);
        p_kontak.setText(P_KONTAK);
        biaya1.setText(BIAYA1);
        jam_operasi.setText(waktu);

        kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mengirim = new Intent(getApplicationContext(), ProsesPemesanan.class);
                mengirim.putExtra("judul",judul.getText().toString());
                mengirim.putExtra("nama_pl",pelanggan.getText().toString());
                mengirim.putExtra("alamat_pl",alamat_pl.getText().toString());
                mengirim.putExtra("hp_pemangkas",p_kontak.getText().toString());
                mengirim.putExtra("nama_pemangkas",pemangkas.getText().toString());
                startActivity(mengirim);
            }});
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
