package com.mgn.mvp.presenter.load;

import android.content.Context;

import com.mgn.mvp.bean.UserBean;

/**
 * Created by Mi on 3/10/21
 */
public interface ILoadPresenter {
    void login(UserBean userBean);

    void setProgress();

    void onDestory(Context context);
}
