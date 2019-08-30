package com.example.basemvvm.utils;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class UIHelper {
    private static final String TAG = UIHelper.class.getSimpleName();


    public static void getScreenSize(WindowManager wm, int[] size) {
        if (wm == null || size == null || size.length < 2) {
            return;
        }
        DisplayMetrics displaymetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(displaymetrics);
        mScreenW = size[0] = displaymetrics.widthPixels;
        mScreenH = size[1] = displaymetrics.heightPixels;
    }

    private static int mScreenW = 0;
    private static int mScreenH = 0;
    public static int getScreenWidth(WindowManager wm) {
        if (mScreenW <= 0) {
            getScreenSize(wm, new int[2]);
        }
        return mScreenW;
    }
    public static int getScreenHeight(WindowManager wm) {
        if (mScreenH <= 0) {
            getScreenSize(wm, new int[2]);
        }
        return mScreenH;
    }

    private static ProgressDialog mDlg = null;

    private UIHelper() {}

    public static void showProgress(Context context) {
        hideProgress();
        showProgress(context, null);
    }

    public static void showProgress(Context context, String message) {
        try {
            hideProgress();
            mDlg = new ProgressDialog(context);
            mDlg.setMessage(message != null ? message : "情報を取得しています");
            mDlg.setCancelable(false);
            mDlg.show();
        } catch (Throwable throwable) {}
    }

    public static void hideProgress() {
        if (mDlg != null) {
            mDlg.dismiss();
            mDlg = null;
        }
    }

}
