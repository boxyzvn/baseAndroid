package com.example.basemvvm.utils;

public class UrlManager {
    public static final int LOG_IN = 1;
    public static String getURL(int urlType) {
        switch (urlType) {
            default:
                return getApiUrl(urlType);
        }
    }

    private static String getApiUrl(int api) {
       // if (MarineApplication.DEV_MODE)
        {
            switch (api) {
                case LOG_IN:
                    return "https://swr-dev.azurewebsites.net/v1/api/login";

                default:
                    return "";
            }
        } /*else
            {
            switch (api) {
                case GET_STATUS:

                default:
                    return "";
          }  }*/

    }
}
