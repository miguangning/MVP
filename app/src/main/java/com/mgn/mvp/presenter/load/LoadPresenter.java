package com.mgn.mvp.presenter.load;

import android.content.Context;
import android.widget.Toast;

import com.mgn.mvp.bean.UserBean;
import com.mgn.mvp.model.load.ILoadModel;
import com.mgn.mvp.model.load.LoadModel;
import com.mgn.mvp.view.load.ILoadView;

/**
 * Created by Mi on 3/10/21
 */
public class LoadPresenter implements ILoadPresenter, ILoadListener {

    private ILoadModel iLoadModel;
    private ILoadView iLoadView;

    public LoadPresenter(ILoadView iLoadView) {
        this.iLoadView = iLoadView;
        this.iLoadModel = new LoadModel();
    }

    @Override
    public void login(UserBean userBean) {
        iLoadModel.login(userBean,this);
    }

    @Override
    public void setProgress() {
        iLoadModel.http(this);
    }

    @Override
    public void onDestory(Context context) {
        iLoadView = null;
        Toast.makeText(context.getApplicationContext(), "销毁", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success() {
        if (iLoadView != null) iLoadView.success();
    }

    @Override
    public void error() {
        if (iLoadView != null) iLoadView.error();
    }

    @Override
    public void setProgress(float progress) {
        if (iLoadView != null) iLoadView.setProgress(progress);
    }
}
