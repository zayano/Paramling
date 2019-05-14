package com.example.zayano.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Datadiri extends AppCompatActivity {

    TextView txt_nama, txt_biaya1, jam_operasi,txt_kontakpemangkas;
    EditText edt_nama, edt_alamat;
    String PEMANGKAS,BIAYA1,waktu,KONTAK;
    Button setuju;
    Bundle DataExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datadiri);

        edt_nama = (EditText) findViewById(R.id.editText);
        edt_alamat = (EditText) findViewById(R.id.editText2);
        setuju = (Button) findViewById(R.id.button);
        txt_nama = (TextView) findViewById(R.id.txt_pemangkas);
        txt_biaya1 = (TextView) findViewById(R.id.txt_dewasa);
        jam_operasi = (TextView) findViewById(R.id.txt_jam);
        txt_kontakpemangkas = (TextView) findViewById(R.id.txt_nomorpemangkas);
        DataExtra = getIntent().getExtras();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        PEMANGKAS = DataExtra.getString("nama");
        KONTAK = DataExtra.getString("hp_pemangkas");
        BIAYA1 = DataExtra.getString("biaya_dewasa");
        waktu = DataExtra.getString("jam_operasi");

        txt_nama.setText(PEMANGKAS);
        txt_kontakpemangkas.setText(KONTAK);
        txt_biaya1.setText(BIAYA1);
        jam_operasi.setText(waktu);


        setuju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (edt_nama.length() == 0 || edt_alamat.length() == 0) {
                    Toast.makeText(getApplication(),"Nama dan Alamat Anda tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                }
                if (edt_nama.length() == 0) {
                    Toast.makeText(getApplication(),"Nama Anda tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                }
                if (edt_alamat.length() == 0) {
                    Toast.makeText(getApplication(),"Alamat Anda tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                }

                else{
                Intent setuju = new Intent(getApplicationContext(), datapesanan.class);
                setuju.putExtra("nama_pl", edt_nama.getText().toString());
                setuju.putExtra("alamat_pl",edt_alamat.getText().toString());
                setuju.putExtra("nama",txt_nama.getText().toString());
                    setuju.putExtra("hp_pemangkas", txt_kontakpemangkas.getText().toString());
                setuju.putExtra("biaya_dewasa",txt_biaya1.getText().toString());
                setuju.putExtra("jam_operasi",jam_operasi.getText().toString());
                startActivity(setuju);

            }
    }
        });
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
