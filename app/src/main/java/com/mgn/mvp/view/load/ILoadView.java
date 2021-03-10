package com.mgn.mvp.view.load;

/**
 * Created by Mi on 3/10/21
 */
public interface ILoadView {
    void success();

    void error();

    void setProgress(float progress);
}
