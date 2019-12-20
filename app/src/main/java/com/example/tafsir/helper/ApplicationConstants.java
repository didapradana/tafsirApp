package com.example.tafsir.helper;

public class ApplicationConstants {
    // package
    public static final String APPLICATION_PACKAGE = "com.cordoba.android.alqurancordoba";

    // activity codes
    public static final int DATA_CHECK_CODE        = 1;
    public static final int SETTINGS_CODE          = DATA_CHECK_CODE + 1;
    public static final int BOOKMARKS_CODE         = SETTINGS_CODE + 1;
    public static final int QURAN_VIEW_CODE        = BOOKMARKS_CODE + 1;

    public static final String PREF_TIME_BOOLEAN   = "downloadingTime";

    // Pages
    public static final int PAGES_FIRST            = 1;
    public static final int PAGES_LAST             = 604;
    public static final int SURAS_COUNT            = 114;
    public static final int JUZ2_COUNT             = 30;
    public static final int AYA_MIN                = 1;
    public static final int AYA_MAX                = 286;

    // language
    public static String PREF_USE_LANGUAGE2        = "language";

    public static String PREF_TEXT_UPLOAD          = "Text_Upload";

    public static String PREF_time_Bolean          = "DownlaodYesOrNo";

    // server
    //public static String BASE_SERVER               = "http://alqurancordoba.com/";
    public static String TRANSLATE_SERVER          = "http://www.alqurancordoba.com/";
    public static String BASE_SERVER               = "http://hijramedia.com/qurankemenag/";
//    public static String IMG_HOST                  = "http://www.alqurancordoba.com/indonesia/convert.php?filename=";
    public static String IMG_HOST                  = "http://www.alqurancordoba.com/convert.php?filename=";
    public static String TRANSLATE_HOST            = "http://www.alqurancordoba.com/";
    public static String ZIP_HOST                  = "http://www.alqurancordoba.com/images/archiver.php?juz=";
    //public static String ZIP_HOST                = "http://www.alqurancordoba.com/images/";
    // public static String IMG_HOST               = "http://10.0.2.2/cordoba/";
    // public static String IMG_HOST               = "http://192.168.43.142/cordoba/";

    // public static String IMG_HOST =
    // "http://dreamfighter.web.id/android/cordoba/";
    public static String JADWAL_SERVER             = "http://www.pkpu.or.id/adzan3/export.php";
    public static String TAFSIRNEW_SERVER          = "http://alqurancordoba.com/tafsir_new/";
    public static String INTERSTITIAL_SERVER       = "http://alqurancordoba.com/interstitial/interstitial.json";

    // public static String VIDEO_SERVER           = "http://alqurancordoba.com/video/";
    public static String VIDEO_SERVER              = "http://gdata.youtube.com/feeds/api/users/qurancordoba/uploads?alt=jsonc&v=2";
    public static String VIDEO_THUMB_SERVER        = "http://alqurancordoba.com/video/";
    public static String TIBBUN_NABAWI_SERVER      = "http://alqurancordoba.com/tibbun_nabawi/";
    // public static String VIDEO_SERVER =
    // "http://dreamfighter.web.id/android/cordoba/video/";
    // public static String VIDEO_THUMB_SERVER =
    // "http://dreamfighter.web.id/android/cordoba/video/";
    public static String QURAN_BASE                = "/Android/data/" + APPLICATION_PACKAGE + "/qurantajweedinternational/";
    // public static String MUROTTAL_SERVER =
    // "http://www.everyayah.com/data/Alafasy_128kbps/";
    public static String BLOCK_SERVER                   = "http://alqurancordoba.com/block_ayah/v3/";
    // public static String BLOCK_SERVER =
    // "http://dreamfighter.web.id/android/cordoba/block_ayah/";
    // public static String TAFSIR_SERVER =
    // "http://dreamfighter.web.id/android/cordoba/tafsir/";
    public static String TAFSIR_SERVER                  = "http://alqurancordoba.com/tafsir/";

    // database
    public static final String DATABASE_NAME            = "cordobatablet.db";
    public static final int DATABASE_VERSION            = 2;

    // image
    public static final int IMAGE_COUNT                 = 604;
    public static final int TAFSIR_IMAGE_WIDTH          = 1260;
    public static final int TAFSIR_IMAGE_HEIGHT         = 15570;
    public static final int IMAGE_HEIGHT                = 1200;
    public static final int IMAGE_WIDTH                 = 800;

    // Colors
    public static final String PAGE_BORDER_COLOR        = "#802A2A";

    // dialogs
    public static final int JUMP_DIALOG                 = 1;

    //ads
    public static final String AD_UNIT_ID               = "ca-app-pub-7924475903273236/4307047502";
    public static final String ADS_INTERSTITIAL_ID      = "ca-app-pub-7924475903273236/5928114306";
    // yang ini kamu tambahin sendiri dan? dan , iya mas ,
    public static final String CLIENT_ID                = "699990581109-4kfr5nn82n91orp2j8o38q1neiut1rqn.apps.googleusercontent.com";

    // Preferences Key
    public static final String PREFERNCES               = "cordoba_settings";

    // downloading time key
    public static final String PREF_Downloding_time     = "downloadTime";

    // Settings Key
    public static final String PREF_USE_ARABIC_NAMES    = "useArabicNames";
    public static final String PREF_FULL_SCREEN         = "fullScreen";
    public static final String PREF_SHOW_CLOCK          = "showClock";
    public static final String PREF_LAST_PAGE           = "lastPage";
    public static final String PREF_BOOKMARKS           = "bookmarks";
    public static final String PREF_KEEP_SCREEN_ON      = "keepScreenOn";
    public static final String PREF_USE_PROXY           = "useProxy";
    public static final String PREF_USE_AUTH_PROXY      = "useAuthProxy";
    public static final String PREF_PROXY_HOST_NAME     = "proxyHostName";
    public static final String PREF_PROXY_PORT_NUMBER   = "proxyPortName";
    public static final String PREF_PROXY_USERNAME      = "proxyUsername";
    public static final String PREF_PROXY_PASSWORD      = "proxyPassword";
    public static final String PREF_COUNTRY             = "country";
    public static final String PREF_ADZAN_CITY          = "adzanCity";
    public static final String PREF_FIRST_RUN           = "firstRun";
    public static final String PREF_TITLE_BAR_SIZE      = "titleBarSize";
    public static final String PREF_BOOKMARK_CURRENT_PAGE = "bookmarkCurrentPage";
    public static final String PREF_LONGITUDE           = "longitude";
    public static final String PREF_LATITUDE            = "latitude";
    public static final String PREF_MUROTTAL            = "murottal";
    public static final String PREF_MENU_HEIGHT         = "MenuHeight";
    public static final String PREF_REPEAT_MUROTTAL     = "repeatMurottal";
    public static final String PREF_NIGHT_MODE          = "nightMode";
    public static final String PREF_ENABLE_NOTIF        = "enable-notif";
    public static final String PREF_NOTIF_TIME          = "notif-time";
    public static final String PREF_ZIP_DOWNLOADED      = "zip-downloaded";


    public static final String PREF_OPENING_PAGE    = "last-opening-page";
    public static final String PREF_LAST_PAGE_READ  = "last-reading-page";
    public static final String PREF_LAST_DATE_READ  = "last-date-reading-page";
    public static final String PREF_PAGE_WIDTH      = "page-width";
    public static final String PREF_RECITATION      = "recitation";
}
