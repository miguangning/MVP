package com.mgn.mvp.model.load;

import com.mgn.mvp.bean.UserBean;
import com.mgn.mvp.presenter.load.ILoadListener;

/**
 * Created by Mi on 3/10/21
 */
public interface ILoadModel {
    void login(UserBean userBean, ILoadListener listener);

    void http(ILoadListener listener);
}
