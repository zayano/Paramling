package com.example.zayano.test;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "pangkasrambut.db";
    private static final int DATABESE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABESE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql = "create table penjasa(no integer primary key, nama text null, kawasan text null, no_hp char null, harga text null, jam_operasional text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO penjasa (no, nama, kawasan, no_hp, harga, jam_operasional) VALUES ('1', 'Luxo Barbershop', 'Jl. Margonda Raya No. 36 Depok', '081316620436','Rp 23.000,-', '12.00 - 20.30');";
        db.execSQL(sql);
        sql = "INSERT INTO penjasa (no, nama, kawasan, no_hp, harga, jam_operasional) VALUES ('2', 'Pangkas Rambut Pria', 'Jl. H. Muslih Raya No.89, Beji, Kota Depok', '082211092141','Rp 17.000,-', '09.00 - 20.00');";
        db.execSQL(sql);
        sql = "INSERT INTO penjasa (no, nama, kawasan, no_hp, harga, jam_operasional) VALUES ('3', 'Barber Bronze', 'Jl. Cinere Raya No.25, Cinere, Kota Depok', '083812105012','Rp 25.000,-', '09.00 - 21.00');";
        db.execSQL(sql);
        sql = "INSERT INTO penjasa (no, nama, kawasan, no_hp, harga, jam_operasional) VALUES ('4', 'Pangkas Rambut Pria Setia Kawan', ' Jl. Raya Citayam, Depok, Cipayung, Kota Depok', '081299041650','Rp 18.000,-', '09.00 - 21.00');";
        db.execSQL(sql);
        sql = "INSERT INTO penjasa (no, nama, kawasan, no_hp, harga, jam_operasional) VALUES ('5', 'Pangkas Rambut SMILE', 'Gg. Dukuh, Pancoran MAS, Kota Depok', '081210196982','Rp 20.000,-', '08.00 - 21.00');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}