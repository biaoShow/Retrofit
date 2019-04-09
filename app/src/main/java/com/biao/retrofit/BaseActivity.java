package com.biao.retrofit;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BaseActivity extends AppCompatActivity {

    private Dialog dialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollecter.addActivity(this);
    }

    public void showLoadingDialog() {
        creatLoadingDialog().show();
    }

    public void hideLoadingDialog() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private Dialog creatLoadingDialog() {
        if (null == dialog) {
            dialog = new Dialog(this, R.style.MyLoadingDialog);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setContentView(R.layout.loading_dialog);
        }
        return dialog;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollecter.removeActivity(this);
    }
}
