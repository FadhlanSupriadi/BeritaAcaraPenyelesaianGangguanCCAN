package com.telkom.ccan.beritaacarapenyelesaiangangguanccan;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BeritaAcaraDBHelper extends SQLiteOpenHelper {

    public   static final String LOG_TAG = BeritaAcaraDBHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "beritacara.db";

    private static final int DATABASE_VERSION = 1;

    public BeritaAcaraDBHelper(Context context){ super(context,DATABASE_NAME,null,DATABASE_VERSION); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_TRAVEL_TABLE = "CREATE TABLE " + BeritaAcaraContract.BeritaAcaraEntry.TABLE_NAME + " ("
                + BeritaAcaraContract.BeritaAcaraEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_HARI + " TEXT NOT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_TANGGAL + " TEXT NOT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NOMORGANGGUAN + " TEXT NOT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NAMA + " TEXT NOT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_ALAMAT + " TEXT, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_CONTACTPERSON + " TEXT NOT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_USERUSEE + " TEXT NOT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NOTELPON + " TEXT NOT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_KELUHAN + " TEXT NOT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_PERBAIKAN + " TEXT NOT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NAMAMATERIAL1 + " TEXT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_SATUANMATERIAL1 + " TEXT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_VOLUMEMATERIAL1 + " TEXT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_KETERANGANMATERIAL1 + " TEXT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NAMAMATERIAL2 + " TEXT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_SATUANMATERIAL2 + " TEXT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_VOLUMEMATERIAL2 + " TEXT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_KETERANGANMATERIAL2 + " TEXT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NAMAMATERIAL3 + " TEXT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_SATUANMATERIAL3 + " TEXT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_VOLUMEMATERIAL3 + " TEXT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_KETERANGANMATERIAL3 + " TEXT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NAMAMATERIALSTB + " TEXT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_MACLAMAMATERIALSTB + " TEXT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_MACBARUMATERIALSTB + " TEXT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_KETERANGANMATERIALSTB + " TEXT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NAMAMATERIALONT + " TEXT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_MACLAMAMATERIALONT + " TEXT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_MACBARUMATERIALONT + " TEXT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_KETERANGANMATERIALONT + " TEXT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NAMAMATERIALMODEM + " TEXT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_MACLAMAMATERIALMODEM + " TEXT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_MACBARUMATERIALMODEM + " TEXT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_KETERANGANMATERIALMODEM + " TEXT NULL, "
                + BeritaAcaraContract.BeritaAcaraEntry.COLUMN_KETERANGAN+ " TEXT NOT NULL DEFAULT 0);";

        db.execSQL(SQL_CREATE_TRAVEL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
