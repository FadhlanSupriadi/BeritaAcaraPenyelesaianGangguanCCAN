package com.telkom.ccan.beritaacarapenyelesaiangangguanccan;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class BeritaAcaraCursorAdapter extends CursorAdapter {
    public BeritaAcaraCursorAdapter(Context context, Cursor c) {
        super(context, c,0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nomorgangguanTextView = (TextView) view.findViewById(R.id.);
        TextView tanggalTextView = (TextView) view.findViewById(R.id.);

        int nomorgangguanColumnIndex = cursor.getColumnIndex(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NOMORGANGGUAN);
        int tanggalColumnIndex = cursor.getColumnIndex(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_TANGGAL);

        String nomorgangguan = cursor.getString(nomorgangguanColumnIndex);
        String tanggal = cursor.getString(tanggalColumnIndex);

        nomorgangguanTextView.setText(nomorgangguan);
        tanggalTextView.setText(tanggal);
    }
}
