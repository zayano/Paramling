package com.example.zayano.test;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class JasaDetail extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    TextView nama, kawasan, kontak, biaya_dewasa, jam_operasi;
    Button confirm;
    Bundle DataExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jasa_detail);

        dbHelper = new DataHelper(this);
        nama = (TextView) findViewById(R.id.txt_nama);
        kawasan = (TextView) findViewById(R.id.txt_kawasan);
        kontak = (TextView) findViewById(R.id.txt_hp);
        DataExtra = getIntent().getExtras();
        biaya_dewasa = (TextView) findViewById(R.id.txt_biayadewasa);
        jam_operasi = (TextView) findViewById(R.id.txt_jam);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cursor = db.rawQuery("SELECT * FROM penjasa WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            nama.setText(cursor.getString(1).toString());
            kawasan.setText(cursor.getString(2).toString());
            kontak.setText(cursor.getString(3).toString());
            biaya_dewasa.setText(cursor.getString(4).toString());
            jam_operasi.setText(cursor.getString(5).toString());
        }
        confirm = (Button) findViewById(R.id.setuju);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pesan = new Intent(getApplicationContext(), Datadiri.class);
                pesan.putExtra("nama",nama.getText().toString());
                pesan.putExtra("hp_pemangkas",kontak.getText().toString());
                pesan.putExtra("biaya_dewasa",biaya_dewasa.getText().toString());
                pesan.putExtra("jam_operasi",jam_operasi.getText().toString());
                startActivity(pesan);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
