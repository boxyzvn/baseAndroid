/*
package com.example.basemvvm.api;

import android.content.Context;
import android.text.TextUtils;
import android.util.JsonReader;

import com.boxyz.baselibrary.net.ConnectionConfiguration;
import com.boxyz.baselibrary.net.ConnectionGateway;
import com.boxyz.baselibrary.utils.MLog;
import com.example.basemvvm.utils.ApiUtils;
import com.example.basemvvm.utils.UrlManager;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends ConnectionGateway {

    public JSONObject resultJson;
    String userName;
    String password;

    @Override
    public void initialize() {
        super.initialize();
        resultJson = null;
    }

    public void setData(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    protected String loadCacheFileName() {
        return "CheckIn";
    }

    */
/**
     * 接続構成を設定.
     *
     * @param context
     * @param args    パラメータの要素
     * @return ConnectionConfiguration 接続構成
     *//*

    @Override
    protected ConnectionConfiguration loadConfiguration(Context context, Object... args) {
        // 接続構成を設定
        ConnectionConfiguration.Builder connectionConfiguration = new ConnectionConfiguration.Builder()
                // APIのURLをセット
                .url(UrlManager.getURL(UrlManager.LOG_IN))
                // パラメータをセット
                .parameter(ApiUtils.Param.EMAIL.getValue() + "=boxyz@dev.vn" + "&" +
                        ApiUtils.Param.PASSWORD.getValue() + "=@4%a4vN90Zjkzz1-1boxyz123" + "&" +
                        ApiUtils.Param.UU_ID.getValue() + "=12321" + "&" +
                        ApiUtils.Param.APP_VER.getValue() + "=1.0.5" + "&" +
                        ApiUtils.Param.PASSWORD.getValue() + "=1"
                )
                // 接続のタイムアウトをセット
                .connectTimeout(ApiUtils.TIMEOUT)
                // データ取得のタイムアウトをセット
                .readTimeout(ApiUtils.TIMEOUT)
                //Postかどうか
                .isPost(true);
        return connectionConfiguration.build();
    }

    */
/**
     * APIのレスポンスが1MBを超えない場合のパース.
     *
     * @param context
     * @param json    jsonデータ
     * @return boolean パースの成否
     *//*

    @Override
    protected boolean readResponse(Context context, String json) {
        if (TextUtils.isEmpty(json)) {
            return false;
        }
        try {
            JSONObject jsonObject = new JSONObject(json);
            MLog.e("CHECK IN--" + jsonObject.toString(2));
            int result = jsonObject.optInt(ApiUtils.Param.RESULT.getValue(), -1);

            // 正常
            if (result == 0) {
                resultJson = jsonObject;

            } else {
                // エラー
                return false;
            }
        } catch (JSONException e) {
            MLog.w("", e);
            return false;
        }
        return true;
    }

    */
/**
     * APIのレスポンスが1MBを超える場合のパース.
     *
     * @param context
     * @param jsonReader jsonデータ
     * @return boolean パースの成否
     *//*

    @Override
    protected boolean readResponse(Context context, JsonReader jsonReader) {
        if (jsonReader == null) {
            return false;
        }
        try {
        } catch (Exception e) {
            MLog.w("", e);
            return false;
        }
        return true;
    }
}*/
