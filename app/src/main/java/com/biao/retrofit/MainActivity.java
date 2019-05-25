package com.biao.retrofit;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.biao.retrofit.Utils.GetMap;
import com.biao.retrofit.Utils.RetrofitHelper;
import com.biao.retrofit.Utils.RxUtil;
import com.biao.retrofit.model.RoomStatus;
import com.biao.retrofit.model.TestAppModel;

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
    @BindView(R.id.btn_get_test)
    Button btnGetTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private void getRoomStatus() {
        RetrofitHelper.getInstance(null).getRetrofitInterface()
                .getRoomStatus(GetMap.getRoomMap("2019-04-09 18:00:00", "2019-04-10 12:00:00"))
                .compose(RxUtil.<RoomStatus>rxIoToMain())
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

    private void testAppInterface() {
        RetrofitHelper.getInstance("http://172.16.60.57:8080").getRetrofitInterface()
                .testAppInterface(GetMap.testAppInterface())
                .compose(RxUtil.<TestAppModel>rxIoToMain())
                .subscribe(new DefaultObserver<TestAppModel>() {
                    @Override
                    protected void onStart() {
                        super.onStart();
                        showLoadingDialog();
                    }

                    @Override
                    public void onNext(TestAppModel roomStatus) {
                        if (roomStatus.getResult() == 1) {
                            Log.i("onNext", "name:" + roomStatus.getName() + "---password:" + roomStatus.getPwd());
                        } else {
                            Log.e("onNext错误", roomStatus.getResult() + "");
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

    @OnClick({R.id.btn_get_status, R.id.tv_result, R.id.btn_get_test})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_get_status:
                getRoomStatus();
                break;
            case R.id.tv_result:
                break;
            case R.id.btn_get_test:
                testAppInterface();
                break;
        }
    }
}
