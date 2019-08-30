package com.example.basemvvm.api;

public interface ConstantApi {
    String BASE_URL_LIVE = "https://suwary.azurewebsites.net";
    String BASE_URL_DEV = "https://swr-dev.azurewebsites.net";
    String BASE_URL_STAG = "http://swr-staging.azurewebsites.net";
    String API_LOGIN = "/v1/api/login";
    String API_CHECK_STATUS = "v1/api/check-status";
    String API_GET_AVAILABLE = "/api/beacon/get-available-list";
    String API_CHECKIN = "/v1/api/check-in";
    String API_CHECKOUT = "/v1/api/check-out";
    String API_DEPARTMEN = "/api/department/list";

    String API_GET_LIST_HISTORY = "/v1/api/history-book";
    String API_GET_RESERVATION = "/v1/api/list-book";
    String API_GET_MAPS = "/v1/api/maps";
    String API_GET_CATEGORIES= "/v1/api/categories";
    String API_GET_DESK = "/v1/api/desks";
    String API_GET_LIST_DESK = "/v1/api/list-desk";
    String API_BOOK_DESK = "v1/api/book";
    String API_CANNCE_BOOK_DESK = "/v1/api/cancel-book";
    String API_CHECK_OPTION_APP = "/v1/api/check-option";
    String API_CHANGE_PASSWORD = "/v1/api/change-password";
    String API_LIST_USER = "/v1/api/list-user";
    String API_GET_DEPARTMENTS = "/v1/api/departments";
    String API_LIKE = "/v1/api/like";
    String API_CHANGE_STATUS = "/v1/api/change-status";
    String API_CHECK_BEACON = "/v1/api/check-beacon";
    String API_QUICK_CHECKIN = "/v1/api/quick-checkin";
    String API_EDIT_BOOK = "/v1/api/edit-book";
}
