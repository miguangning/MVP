package com.mgn.mvp.presenter.load;

/**
 * Created by Mi on 3/9/21
 */
public interface ILoadListener {
    void success();

    void error();

    void setProgress(float progress);
}
