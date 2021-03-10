package com.mgn.mvp.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.mgn.mvp.R;
import com.mgn.mvp.base.BaseMvpActivity;
import com.mgn.mvp.bean.UserBean;
import com.mgn.mvp.components.LoadView;
import com.mgn.mvp.presenter.load.LoadPresenter;
import com.mgn.mvp.view.load.ILoadView;

/**
 * Created by Mi on 3/9/21
 */
public class LoadActivity extends BaseMvpActivity<LoadPresenter> implements ILoadView, View.OnClickListener {

    private Button button;
    private EditText edit1, edit2;
    private LoadView loadView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        button = findViewById(R.id.button);
        edit1 = findViewById(R.id.edit_username);
        edit2 = findViewById(R.id.edit_password);
        loadView = findViewById(R.id.loadView);

        button.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestory(this);
    }

    @Override
    protected LoadPresenter createPresenter() {
        return new LoadPresenter(this);
    }

    @Override
    public void onClick(View v) {
        UserBean userBean = new UserBean(edit1.getText().toString(), edit2.getText().toString());
        presenter.login(userBean);
    }

    @Override
    public void success() {
        Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
        presenter.setProgress();
    }

    @Override
    public void error() {
        Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setProgress(float progress) {
        loadView.setProgress(progress);
    }
}
