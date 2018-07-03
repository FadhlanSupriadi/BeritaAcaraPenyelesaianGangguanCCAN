package com.telkom.ccan.beritaacarapenyelesaiangangguanccan;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

public class BeritaAcaraProvider extends ContentProvider {
    public static final String LOG_TAG = BeritaAcaraProvider.class.getSimpleName();

    private static final int BERITAACARA=100;

    private static final int BERITAACARA_ID=101;

    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(BeritaAcaraContract.CONTENT_AUTHORITY,BeritaAcaraContract.PATH_BERITAACARA,BERITAACARA);
        sUriMatcher.addURI(BeritaAcaraContract.CONTENT_AUTHORITY,BeritaAcaraContract.PATH_BERITAACARA+"/#",BERITAACARA_ID);
    }

    private BeritaAcaraDBHelper mDbHelper;

    @Override
    public boolean onCreate() {
        mDbHelper = new BeritaAcaraDBHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {

        SQLiteDatabase database = mDbHelper.getReadableDatabase();

        Cursor cursor;

        int match = sUriMatcher.match(uri);
        switch (match){
            case BERITAACARA:
                cursor = database.query(BeritaAcaraContract.BeritaAcaraEntry.TABLE_NAME,projection,selection,selectionArgs,null,null,sortOrder);
                break;
            case BERITAACARA_ID:
                selection = BeritaAcaraContract.BeritaAcaraEntry._ID+"=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                cursor = database.query(BeritaAcaraContract.BeritaAcaraEntry.TABLE_NAME,projection,selection,selectionArgs,null,null,sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Cannot query unknown URI "+uri);
        }
        cursor.setNotificationUri(getContext().getContentResolver(),uri);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        final int match = sUriMatcher.match(uri);
        switch (match){
            case BERITAACARA:
                return BeritaAcaraContract.BeritaAcaraEntry.CONTENT_LIST_TYPE;
            case BERITAACARA_ID:
                return BeritaAcaraContract.BeritaAcaraEntry.CONTENT_ITEM_TYPE;
            default:
                throw new IllegalArgumentException("Unknown URI "+uri+" with match "+ match);
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        final int match = sUriMatcher.match(uri);
        switch (match){
            case BERITAACARA:
                return insertBeritaAcara(uri,values);
            default:
                throw new IllegalArgumentException("Insertion is not supported for "+uri);
        }
    }

    private Uri insertBeritaAcara(Uri uri, ContentValues values) {
        String mhari = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_HARI);
        if(mhari == null){
            throw new IllegalArgumentException("Masukkan Hari");
        }
        String mtanggal = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_TANGGAL);
        if (mtanggal==null){
            throw new IllegalArgumentException("Pilih Tanggal Perbaikan");
        }
        String mnomorgangguan = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NOMORGANGGUAN);
        if (mnomorgangguan==null){
            throw new IllegalArgumentException("Masukkan Nomor Gangguan");
        }
        String mnama = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NAMA);
        if (mnama==null){
            throw new IllegalArgumentException("Masukkan Nama");
        }
        String malamat = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_ALAMAT);
        if (malamat==null){
            throw new IllegalArgumentException("Masukan Alamat");
        }
        String mcontactperson = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_CONTACTPERSON);
        if (mcontactperson==null){
            throw new IllegalArgumentException("Masukan Contact Person");
        }
        String mnotelpon = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NOTELPON);
        if (mnotelpon==null){
            throw new IllegalArgumentException("Masukan Nomor Telpon");
        }
        String mkeluhan = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_KELUHAN);
        if (mkeluhan==null){
            throw new IllegalArgumentException("Masukkan Keluhan");
        }
        String mperbaikan = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_PERBAIKAN);
        if (mperbaikan==null){
            throw new IllegalArgumentException("Masukkan Penyelesaian Perbaikan");
        }
        String mnamamaterial1 = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NAMAMATERIAL1);
        if (mnamamaterial1==null){
            throw new IllegalArgumentException("Masukkan Nama Material 1");
        }
        String msatuanmaterial1 = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_SATUANMATERIAL1);
        if (msatuanmaterial1==null){
            throw new IllegalArgumentException("Masukkan Satuan Material 1");
        }
        String mvolumematerial1 = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_VOLUMEMATERIAL1);
        if (mvolumematerial1==null){
            throw new IllegalArgumentException("Masukkan Volume Material 1");
        }
        String mketeranganmaterial1 = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_KETERANGANMATERIAL1);
        if (mketeranganmaterial1==null){
            throw new IllegalArgumentException("Masukkan Keterangan Material 1");
        }
        String mnamamaterial2 = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NAMAMATERIAL2);
        if (mnamamaterial2==null){
            throw new IllegalArgumentException("Masukkan Nama Material 2");
        }
        String msatuanmaterial2 = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_SATUANMATERIAL2);
        if (msatuanmaterial2==null){
            throw new IllegalArgumentException("Masukkan Satuan Material 2");
        }
        String mvolumematerial2 = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_VOLUMEMATERIAL2);
        if (mvolumematerial2==null){
            throw new IllegalArgumentException("Masukkan Volume Material 2");
        }
        String mketeranganmaterial2 = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_KETERANGANMATERIAL2);
        if (mketeranganmaterial2==null){
            throw new IllegalArgumentException("Masukkan Keterangan Material 2");
        }
        String mnamamaterial3 = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NAMAMATERIAL3);
        if (mnamamaterial3==null){
            throw new IllegalArgumentException("Masukkan Nama Material 3");
        }
        String msatuanmaterial3 = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_SATUANMATERIAL3);
        if (msatuanmaterial3==null){
            throw new IllegalArgumentException("Masukkan Satuan Material 3");
        }
        String mvolumematerial3 = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_VOLUMEMATERIAL3);
        if (mvolumematerial3==null){
            throw new IllegalArgumentException("Masukkan Volume Material 3");
        }
        String mketeranganmaterial3 = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_KETERANGANMATERIAL3);
        if (mketeranganmaterial3==null){
            throw new IllegalArgumentException("Masukkan Keterangan Material 3");
        }
        String mnamamaterialstb = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NAMAMATERIALSTB);
        if (mnamamaterialstb==null){
            throw new IllegalArgumentException("Masukkan Nama Material STB");
        }
        String mmaclamamaterialstb = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_MACLAMAMATERIALSTB);
        if (mmaclamamaterialstb==null){
            throw new IllegalArgumentException("Masukkan MAC Lama Material STB");
        }
        String mmacbarumaterialstb = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_MACBARUMATERIALSTB);
        if (mmacbarumaterialstb==null){
            throw new IllegalArgumentException("Masukkan MAC Baru Material STB");
        }
        String mketeranganmaterialstb = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_KETERANGANMATERIALSTB);
        if (mketeranganmaterialstb==null){
            throw new IllegalArgumentException("Masukkan Keterangan Material STB");
        }
        String mnamamaterialont = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NAMAMATERIALONT);
        if (mnamamaterialont==null){
            throw new IllegalArgumentException("Masukkan Nama Material ONT");
        }
        String mmaclamamaterialont = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_MACLAMAMATERIALONT);
        if (mmaclamamaterialont==null){
            throw new IllegalArgumentException("Masukkan MAC Lama Material ONT");
        }
        String mmacbarumaterialont = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_MACBARUMATERIALONT);
        if (mmacbarumaterialont==null){
            throw new IllegalArgumentException("Masukkan MAC Baru Material ONT");
        }
        String mketeranganmaterialont = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_KETERANGANMATERIALONT);
        if (mketeranganmaterialont==null){
            throw new IllegalArgumentException("Masukkan Keterangan Material ONT");
        }
        String mnamamaterialmodem = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NAMAMATERIALMODEM);
        if (mnamamaterialmodem==null){
            throw new IllegalArgumentException("Masukkan Nama Material Modem");
        }
        String mmaclamamaterialmodem = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_MACLAMAMATERIALMODEM);
        if (mmaclamamaterialmodem==null){
            throw new IllegalArgumentException("Masukkan MAC Lama Material Modem");
        }
        String mmacbarumaterialmodem = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_MACBARUMATERIALMODEM);
        if (mmacbarumaterialmodem==null){
            throw new IllegalArgumentException("Masukkan MAC Baru Material Modem");
        }
        String mketeranganmaterialmodem = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_KETERANGANMATERIALMODEM);
        if (mketeranganmaterialmodem==null){
            throw new IllegalArgumentException("Masukkan Keterangan Material Modem");
        }
        String mketerangan = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_KETERANGAN);
        if (mketerangan==null){
            throw new IllegalArgumentException("Masukkan Keterangan");
        }
        SQLiteDatabase database = mDbHelper.getWritableDatabase();
        long id = database.insert(BeritaAcaraContract.BeritaAcaraEntry.TABLE_NAME,null,values);
        if (id==-1){
            Log.e(LOG_TAG,"Failed to insert row for "+uri);
            return null;
        }
        getContext().getContentResolver().notifyChange(uri,null);
        return ContentUris.withAppendedId(uri,id);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase database = mDbHelper.getWritableDatabase();

        int rowsDeleted;
        final int match = sUriMatcher.match(uri);
        switch (match){
            case BERITAACARA:
                rowsDeleted=database.delete(BeritaAcaraContract.BeritaAcaraEntry.TABLE_NAME,selection,selectionArgs);
                break;
            case  BERITAACARA_ID:
                selection = BeritaAcaraContract.BeritaAcaraEntry._ID+"=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                rowsDeleted =  database.delete(BeritaAcaraContract.BeritaAcaraEntry.TABLE_NAME,selection,selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Deletion is not supported for "+uri);
        }
        if (rowsDeleted!=0){
            getContext().getContentResolver().notifyChange(uri,null);
        }
        return rowsDeleted;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        final  int match = sUriMatcher.match(uri);
        switch (match){
            case BERITAACARA:
                return updateBeritaAcara(uri,values,selection,selectionArgs);
            case BERITAACARA_ID:
                selection = BeritaAcaraContract.BeritaAcaraEntry._ID+"=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                return updateBeritaAcara(uri,values,selection,selectionArgs);
            default:
                throw new IllegalArgumentException("Update is not supported for "+uri);
        }
    }

    private int updateBeritaAcara(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_HARI)){
            String mhari = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_HARI);
            if(mhari == null){
                throw new IllegalArgumentException("Masukkan Hari");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_TANGGAL)){
            String mtanggal = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_TANGGAL);
            if(mtanggal == null){
                throw new IllegalArgumentException("Masukkan Tanggal Perbaikan");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NOMORGANGGUAN)){
            String mnomorgangguan = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NOMORGANGGUAN);
            if(mnomorgangguan == null){
                throw new IllegalArgumentException("Masukkan Nomor Gangguan");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NAMA)){
            String mnama = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NAMA);
            if(mnama == null){
                throw new IllegalArgumentException("Masukkan Nama");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_ALAMAT)){
            String malamat = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_ALAMAT);
            if(malamat == null){
                throw new IllegalArgumentException("Masukkan Alamat");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_CONTACTPERSON)){
            String mcontactperson = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_CONTACTPERSON);
            if(mcontactperson == null){
                throw new IllegalArgumentException("Masukkan Contact Person");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NOTELPON)){
            String mnotelpon = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NOTELPON);
            if(mnotelpon == null){
                throw new IllegalArgumentException("Masukkan Nomor Telpon");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_KELUHAN)){
            String mkeluhan = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_KELUHAN);
            if(mkeluhan == null){
                throw new IllegalArgumentException("Masukkan Keluhan");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_PERBAIKAN)){
            String mperbaikan = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_PERBAIKAN);
            if(mperbaikan == null){
                throw new IllegalArgumentException("Masukkan Penyelesaian Perbaikan");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NAMAMATERIAL1)){
            String mnamamaterial1 = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NAMAMATERIAL1);
            if(mnamamaterial1 == null){
                throw new IllegalArgumentException("Masukkan Nama Material 1");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_SATUANMATERIAL1)){
            String msatuanmaterial1 = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_SATUANMATERIAL1);
            if(msatuanmaterial1 == null){
                throw new IllegalArgumentException("Masukkan Satuan Material 1");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_VOLUMEMATERIAL1)){
            String mvolumematerial1 = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_VOLUMEMATERIAL1);
            if(mvolumematerial1 == null){
                throw new IllegalArgumentException("Masukkan Volume Material 1");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_KETERANGANMATERIAL1)){
            String mketeranganmaterial1 = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_KETERANGANMATERIAL1);
            if(mketeranganmaterial1 == null){
                throw new IllegalArgumentException("Masukkan Keterangan Material 1");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NAMAMATERIAL2)){
            String mnamamaterial2 = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NAMAMATERIAL2);
            if(mnamamaterial2 == null){
                throw new IllegalArgumentException("Masukkan Nama Material 2");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_SATUANMATERIAL2)){
            String msatuanmaterial2 = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_SATUANMATERIAL2);
            if(msatuanmaterial2 == null){
                throw new IllegalArgumentException("Masukkan Satuan Material 2");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_VOLUMEMATERIAL2)){
            String mvolumematerial2 = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_VOLUMEMATERIAL2);
            if(mvolumematerial2 == null){
                throw new IllegalArgumentException("Masukkan Volume Material 2");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_KETERANGANMATERIAL2)){
            String mketeranganmaterial2 = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_KETERANGANMATERIAL2);
            if(mketeranganmaterial2 == null){
                throw new IllegalArgumentException("Masukkan Keterangan Material 2");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NAMAMATERIAL3)){
            String mnamamaterial3 = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NAMAMATERIAL3);
            if(mnamamaterial3 == null){
                throw new IllegalArgumentException("Masukkan Nama Material 3");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_SATUANMATERIAL3)){
            String msatuanmaterial3 = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_SATUANMATERIAL3);
            if(msatuanmaterial3 == null){
                throw new IllegalArgumentException("Masukkan Satuan Material 3");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_VOLUMEMATERIAL3)){
            String mvolumematerial3 = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_VOLUMEMATERIAL3);
            if(mvolumematerial3 == null){
                throw new IllegalArgumentException("Masukkan Volume Material 3");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_KETERANGANMATERIAL3)){
            String mketeranganmaterial3 = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_KETERANGANMATERIAL3);
            if(mketeranganmaterial3 == null){
                throw new IllegalArgumentException("Masukkan Keterangan Material 3");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NAMAMATERIALSTB)){
            String mnamamaterialstb = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NAMAMATERIALSTB);
            if(mnamamaterialstb == null){
                throw new IllegalArgumentException("Masukkan Nama Material STB");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_MACLAMAMATERIALSTB)){
            String mmaclamamaterial1stb= values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_MACLAMAMATERIALSTB);
            if(mmaclamamaterial1stb == null){
                throw new IllegalArgumentException("Masukkan MAC Lama Material STB");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_MACBARUMATERIALSTB)){
            String  mmacbarumaterial1stb = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_MACBARUMATERIALSTB);
            if(mmacbarumaterial1stb == null){
                throw new IllegalArgumentException("Masukkan MAC Baru Material STB");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_KETERANGANMATERIALSTB)){
            String mketeranganmaterialstb = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_KETERANGANMATERIALSTB);
            if(mketeranganmaterialstb == null){
                throw new IllegalArgumentException("Masukkan Keterangan Material STB");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NAMAMATERIALONT)){
            String mnamamaterialont = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NAMAMATERIALONT);
            if(mnamamaterialont == null){
                throw new IllegalArgumentException("Masukkan Nama Material ONT");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_MACLAMAMATERIALONT)){
            String mmaclamamaterial1ont= values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_MACLAMAMATERIALONT);
            if(mmaclamamaterial1ont == null){
                throw new IllegalArgumentException("Masukkan MAC Lama Material ONT");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_MACBARUMATERIALONT)){
            String  mmacbarumaterial1ont = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_MACBARUMATERIALONT);
            if(mmacbarumaterial1ont == null){
                throw new IllegalArgumentException("Masukkan MAC Baru Material ONT");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_KETERANGANMATERIALONT)){
            String mketeranganmaterialont = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_KETERANGANMATERIALONT);
            if(mketeranganmaterialont == null){
                throw new IllegalArgumentException("Masukkan Keterangan Material ONT");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NAMAMATERIALMODEM)){
            String mnamamaterialmodem = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_NAMAMATERIALMODEM);
            if(mnamamaterialmodem == null){
                throw new IllegalArgumentException("Masukkan Nama Material Modem");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_MACLAMAMATERIALMODEM)){
            String mmaclamamaterial1modem= values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_MACLAMAMATERIALMODEM);
            if(mmaclamamaterial1modem == null){
                throw new IllegalArgumentException("Masukkan MAC Lama Material Modem");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_MACBARUMATERIALMODEM)){
            String  mmacbarumaterial1modem = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_MACBARUMATERIALMODEM);
            if(mmacbarumaterial1modem == null){
                throw new IllegalArgumentException("Masukkan MAC Baru Material Modem");
            }
        }
        if (values.containsKey(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_KETERANGANMATERIALMODEM)){
            String mketeranganmaterialmodem = values.getAsString(BeritaAcaraContract.BeritaAcaraEntry.COLUMN_KETERANGANMATERIALMODEM);
            if(mketeranganmaterialmodem == null){
                throw new IllegalArgumentException("Masukkan Keterangan Material Modem");
            }
        }
        if (values.size() == 0){
            return 0;
        }
        SQLiteDatabase database = mDbHelper.getWritableDatabase();
        int rowsUpdated =database.update(BeritaAcaraContract.BeritaAcaraEntry.TABLE_NAME,values,selection,selectionArgs);

        if(rowsUpdated!=0){
            getContext().getContentResolver().notifyChange(uri,null);
        }
        return rowsUpdated;
    }
}
