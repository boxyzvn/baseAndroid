package com.example.basemvvm.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;



public class ApiUtils {
    public static final int ONE_SECOND = 1000;         // in millisecond
    public static final int TIMEOUT = 10 * ONE_SECOND;

    public static final String BASIC_AUTHENTICATION = "id:bl";

    private ApiUtils() {
    }

    public static String mGenerateCommonParam(Context context) {
        String uu_id = "uu_id";
        String app_ver;
        int os_type;
        StringBuffer params = new StringBuffer();
        if (uu_id.equals("") || uu_id.isEmpty())
            uu_id = "uu_id";
        try {
            app_ver = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            app_ver = "1.0.0";

            os_type = 0;
            params.append("uu_id");
            params.append("=");
            params.append(uu_id);

            params.append("&");
            params.append("app_ver");
            params.append("=");
            params.append(app_ver);

            params.append("&");
            params.append("os_type");
            params.append("=");
            params.append(os_type);
        }

        return params.toString();

    }

    public enum Param {
        RESULT("result"),
        EMAIL("email"),
        PASSWORD("password"),
        UU_ID("uu_id"),
        APP_VER("app_ver"),
        OS_TYPE_("os_type"),

        PUSH_KEY("push_key"),
        TEAM("team"),
        YEAR("year"),
        MONTH("month"),
        SITE_SHUBETU_LOWER("site_shubetu"),
        SITE_SHUBETU_UPPER("SITE_SHUBETU"),
        SPOT_ID("spot_id"),
        SPOT_GROUP_ID("spot_group_id"),
        TAGCAST_UUID("tagcast_uuid"),
        HAS_PUTMENU("has_putmenu");


        private final String value;

        Param(final String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

}
