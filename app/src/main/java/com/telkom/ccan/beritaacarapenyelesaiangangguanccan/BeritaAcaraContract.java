package com.telkom.ccan.beritaacarapenyelesaiangangguanccan;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public class BeritaAcaraContract {
    private BeritaAcaraContract(){}
    public static final String CONTENT_AUTHORITY = "com.telkom.ccan.beritaacarapenyelesaiangangguanccan";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://"+ CONTENT_AUTHORITY);
    public static final String PATH_BERITAACARA = "beritaacara";
    public static final class BeritaAcaraEntry implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_BERITAACARA);
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_BERITAACARA;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_BERITAACARA;
        public final static String TABLE_NAME = "beritaacara";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_HARI = "hari";
        public final static String COLUMN_TANGGAL = "tanggal";
        public final static String COLUMN_NOMORGANGGUAN = "nomorgangguan" ;
        public final static String COLUMN_NAMA= "nama";
        public final static String COLUMN_ALAMAT = "alamat";
        public final static String COLUMN_CONTACTPERSON= "contactperson";
        public final static String COLUMN_USERUSEE = "userusee";
        public final static String COLUMN_NOTELPON = "notelpon";
        public final static String COLUMN_KELUHAN = "keluhan";
        public final static String COLUMN_PERBAIKAN = "perbaikan";
        public final static String COLUMN_NAMAMATERIAL1 = "namamaterial1";
        public final static String COLUMN_SATUANMATERIAL1 = "satuanmaterial1";
        public final static String COLUMN_VOLUMEMATERIAL1 = "volumematerial1";
        public final static String COLUMN_KETERANGANMATERIAL1 = "keteranganmaterial1";
        public final static String COLUMN_NAMAMATERIAL2 = "namamaterial2";
        public final static String COLUMN_SATUANMATERIAL2 = "satuanmaterial2";
        public final static String COLUMN_VOLUMEMATERIAL2 = "volumematerial2";
        public final static String COLUMN_KETERANGANMATERIAL2 = "keteranganmaterial2";
        public final static String COLUMN_NAMAMATERIAL3 = "namamaterial3";
        public final static String COLUMN_SATUANMATERIAL3 = "satuanmaterial3";
        public final static String COLUMN_VOLUMEMATERIAL3 = "volumematerial3";
        public final static String COLUMN_KETERANGANMATERIAL3 = "keteranganmaterial3";
        public final static String COLUMN_NAMAMATERIALSTB = "namamaterialstb";
        public final static String COLUMN_MACLAMAMATERIALSTB= "maclamamaterialstb";
        public final static String COLUMN_MACBARUMATERIALSTB = "macbarumaterialstb";
        public final static String COLUMN_KETERANGANMATERIALSTB = "keteranganmaterialstb";
        public final static String COLUMN_NAMAMATERIALONT = "namamaterialont";
        public final static String COLUMN_MACLAMAMATERIALONT = "maclamamaterialont";
        public final static String COLUMN_MACBARUMATERIALONT = "macbarumaterialont";
        public final static String COLUMN_KETERANGANMATERIALONT = "keteranganmaterialont";
        public final static String COLUMN_NAMAMATERIALMODEM = "namamaterialmodem";
        public final static String COLUMN_MACLAMAMATERIALMODEM = "maclamamaterialmodem";
        public final static String COLUMN_MACBARUMATERIALMODEM = "macbarumaterialmodem";
        public final static String COLUMN_KETERANGANMATERIALMODEM = "keteranganmaterialmodem";
        public final static String COLUMN_KETERANGAN = "keterangan";
    }
}
