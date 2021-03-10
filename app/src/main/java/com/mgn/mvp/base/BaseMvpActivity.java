package com.mgn.mvp.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by Mi on 3/10/21
 */
public abstract class BaseMvpActivity<O> extends AppCompatActivity {

    protected O presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
    }

    protected abstract O createPresenter();
}
