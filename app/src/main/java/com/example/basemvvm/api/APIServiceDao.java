package com.example.basemvvm.api;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIServiceDao {
    @POST(ConstantApi.API_LOGIN)
    @FormUrlEncoded
    Call<ResponseBase> login(@Field("email") String email, @Field("password") String password,
                             @Field("app_ver") String app_ver, @Field("uu_id") String uu_id, @Field("os_type") String os_type);

    @POST(ConstantApi.API_CHECK_STATUS)
    @FormUrlEncoded
    Call<ResponseBase> checkStatus(@Field("token") String token,
                                   @Field("uu_id") String uu_id, @Field("app_ver") String app_ver, @Field("is_get_token") String is_get_token, @Field("os_type") String os_type);

    @POST(ConstantApi.API_GET_AVAILABLE)
    @FormUrlEncoded
    Call<Object> getAvaiableBeaconvoid(@Field("token") String token,
                                       @Field("fcm_token") String fcm_token,
                                       @Field("uu_id") String uu_id, @Field("app_ver") String app_ver, @Field("os_type") String os_type);

    @POST(ConstantApi.API_CHECKIN)
    @FormUrlEncoded
    Call<ResponseBase> checkIn(@Field("token") String token,
                               @Field("uu_id") String uu_id, @Field("app_ver") String app_ver,
                               @Field("serial_id") String serialId, @Field("os_type") String os_type);

    @POST(ConstantApi.API_CHECKOUT)
    @FormUrlEncoded
    Call<ResponseBase> checkOut(@Field("token") String token,
                                @Field("uu_id") String uu_id, @Field("app_ver") String app_ver, @Field("remove_book_desk") String typeRemove,
                                @Field("os_type") String os_type, @Field("is_checkout_gps") int is_checkout_gps);

    @POST(ConstantApi.API_CHANGE_STATUS)
    @FormUrlEncoded
    Call<ResponseBase> ChangeStatus(@Field("token") String token,
                                    @Field("uu_id") String uu_id,
                                    @Field("app_ver") String app_ver, @Field("status_code") String status_code, @Field("os_type") String os_type);

    @POST(ConstantApi.API_DEPARTMEN)
    @FormUrlEncoded
    Call<ResponseBase> getDepartment(@Field("token") String token,
                                     @Field("fcm_token") String fcm_token,
                                     @Field("uu_id") String uu_id, @Field("app_ver") String app_ver, @Field("os_type") String os_type);

    @POST(ConstantApi.API_GET_LIST_HISTORY)
    @FormUrlEncoded
    Call<ResponseBase> getListHistory(@Field("token") String token,
                                      @Field("uu_id") String uu_id, @Field("app_ver") String app_ver, @Field("page") String page, @Field("type_sort") String typeSort,
                                      @Field("cancel_history") int cancel_history);

    @POST(ConstantApi.API_GET_RESERVATION)
    @FormUrlEncoded
    Call<ResponseBase> getListReservation(@Field("token") String token,
                                          @Field("uu_id") String uu_id, @Field("app_ver") String app_ver, @Field("os_type") String os_type);

    @POST(ConstantApi.API_GET_MAPS)
    @FormUrlEncoded
    Call<ResponseBase> getListMaps(@Field("token") String token,
                                   @Field("uu_id") String uu_id, @Field("app_ver") String app_ver, @Field("os_type") String os_type);

    @POST(ConstantApi.API_GET_CATEGORIES)
    @FormUrlEncoded
    Call<ResponseBase> getListCategories(@Field("token") String token,
                                         @Field("uu_id") String uu_id, @Field("app_ver") String app_ver, @Field("os_type") String os_type);

    @POST(ConstantApi.API_GET_DESK)
    @FormUrlEncoded
    Call<ResponseBase> getListDesks(@Field("token") String token,
                                    @Field("uu_id") String uu_id, @Field("app_ver") String app_ver,
                                    @Field("parcel_id") String parcel_id, @Field("date") String date, @Field("category_id") String category_id, @Field("show_desks") String show_desks,
                                    @Field("os_type") String os_type);

    @POST(ConstantApi.API_GET_LIST_DESK)
    @FormUrlEncoded
    Call<ResponseBase> getListLocationDesks(@Field("token") String token,
                                            @Field("uu_id") String uu_id, @Field("app_ver") String app_ver, @Field("time_update") String time_update,
                                            @Field("is_first") int isFirst, @Field("os_type") String os_type);

    @POST(ConstantApi.API_BOOK_DESK)
    @FormUrlEncoded
    Call<ResponseBase> bookDesk(@Field("token") String token,
                                @Field("uu_id") String uu_id, @Field("app_ver") String app_ver,
                                @Field("desk_id") String desk_id, @Field("type_checkin") int type_checkin, @Field("time_start") String time_start,
                                @Field("time_end") String time_end, @Field("os_type") String os_type);

    @POST(ConstantApi.API_CANNCE_BOOK_DESK)
    @FormUrlEncoded
    Call<ResponseBase> canncelBookDesk(@Field("token") String token,
                                       @Field("uu_id") String uu_id, @Field("app_ver") String app_ver,
                                       @Field("desk_id") String desk_id, @Field("time_start") String time_start, @Field("time_end") String time_end, @Field("is_auto") int is_auto);

    @POST(ConstantApi.API_CHECK_OPTION_APP)
    @FormUrlEncoded
    Call<ResponseBase> checkOption(@Field("uu_id") String uu_id, @Field("app_ver") String app_ver, @Field("os_type") String os_type);


    @POST(ConstantApi.API_CHANGE_PASSWORD)
    @FormUrlEncoded
    Call<ResponseBase> changePassword(@Field("uu_id") String uu_id, @Field("app_ver") String app_ver, @Field("token") String token, @Field("old_password") String oldPass,
                                      @Field("new_password") String newPass, @Field("conf_password") String confirmPass, @Field("os_type") String os_type);

    @POST(ConstantApi.API_LIST_USER)
    @FormUrlEncoded
    Call<ResponseBase> listUser(@Field("token") String token, @Field("uu_id") String uu_id, @Field("app_ver") String app_ver,
                                @Field("page") String page, @Field("name") String name,
                                @Field("arr_department[]") ArrayList<Integer> arr_department,
                                @Field("is_get_like") int is_get_like, @Field("is_get_checkin") int is_get_checkin);

    @POST(ConstantApi.API_GET_DEPARTMENTS)
    @FormUrlEncoded
    Call<ResponseBase> getListDepartment(@Field("token") String token,
                                         @Field("uu_id") String uu_id, @Field("app_ver") String app_ver);

    @POST(ConstantApi.API_LIKE)
    @FormUrlEncoded
    Call<ResponseBase> setItemLike(@Field("token") String token, @Field("uu_id") String uu_id, @Field("app_ver") String app_ver,
                                   @Field("user_id") String user_id);

    @POST(ConstantApi.API_CHANGE_STATUS)
    @FormUrlEncoded
    Call<ResponseBase> setStatus(@Field("token") String token, @Field("uu_id") String uu_id, @Field("app_ver") String app_ver,
                                 @Field("type_checkin") int type_checkin);

    @POST(ConstantApi.API_CHECK_BEACON)
    @FormUrlEncoded
    Call<ResponseBase> checkBeacon(@Field("token") String token, @Field("uu_id") String uu_id, @Field("app_ver") String app_ver,
                                   @Field("serial_id") String serial_id);

    @POST(ConstantApi.API_QUICK_CHECKIN)
    @FormUrlEncoded
    Call<ResponseBase> quickCheckin(@Field("token") String token, @Field("uu_id") String uu_id, @Field("app_ver") String app_ver,
                                    @Field("serial_id") String serial_id, @Field("booking_id") String booking_id,
                                    @Field("time_start") String time_start, @Field("time_end") String time_end,
                                    @Field("type_checkin") int type_checkin);

    @POST(ConstantApi.API_EDIT_BOOK)
    @FormUrlEncoded
    Call<ResponseBase> editBook(@Field("token") String token, @Field("uu_id") String uu_id, @Field("app_ver") String app_ver,
                                @Field("booking_id") String booking_id, @Field("time_start") String time_start,
                                @Field("time_end") String time_end, @Field("type_checkin") int type_checkin);
}
