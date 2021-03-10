package com.mgn.mvp.model.load;

import com.mgn.mvp.bean.UserBean;
import com.mgn.mvp.presenter.load.ILoadListener;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Mi on 3/10/21
 */
public class LoadModel implements ILoadModel {

    private ILoadListener listener;
    private float sign = 0f;

    @Override
    public void login(UserBean userBean, ILoadListener listener) {
        //TODO 实现网络数据传递
        boolean res = true;
        if (!userBean.getUserName().equals("123") || userBean.getUserName() == null) {
            res = false;
        }
        if (!userBean.getPassWord().equals("123") || userBean.getPassWord() == null) {
            res = false;
        }
        if (res) {
            listener.success();
        } else {
            listener.error();
        }
    }

    @Override
    public void http(ILoadListener listener) {
        this.listener = listener;
        timer.schedule(task,100,100);
    }

    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            if (sign == 1) {
                timer.cancel();
            }
            sign += 0.005;
            listener.setProgress(sign);
        }
    };
}
