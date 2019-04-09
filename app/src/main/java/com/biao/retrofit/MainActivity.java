package com.biao.retrofit;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.biao.retrofit.Utils.GetMap;
import com.biao.retrofit.Utils.RetrofitHelper;
import com.biao.retrofit.model.RoomStatus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_get_status)
    Button btnGetStatus;
    @BindView(R.id.tv_result)
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private void getRoomStatus() {
        RetrofitHelper.getInstance(null).getRetrofitInterface()
                .getRoomStatus(GetMap.getRoomMap("2019-04-09 18:00:00", "2019-04-10 12:00:00"))
                .subscribeOn(Schedulers.io())//请求在io线程
                .observeOn(AndroidSchedulers.mainThread())//主线程显示数据
                .subscribe(new DefaultObserver<RoomStatus>() {
                    @Override
                    protected void onStart() {
                        super.onStart();
                        showLoadingDialog();
                    }

                    @Override
                    public void onNext(RoomStatus roomStatus) {
                        if (roomStatus.getStatus() == 1) {
                            Log.i("onNext", roomStatus.getData().get(0).getRoom_type());
                        } else {
                            Log.e("onNext错误", roomStatus.getReason());
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        hideLoadingDialog();
                        Log.e("onError", t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        hideLoadingDialog();
                    }
                });
    }

    @OnClick({R.id.btn_get_status, R.id.tv_result})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_get_status:
                getRoomStatus();
                break;
            case R.id.tv_result:
                break;
        }
    }
}
