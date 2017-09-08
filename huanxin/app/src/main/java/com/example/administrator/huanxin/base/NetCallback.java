package com.example.administrator.huanxin.base;

/**
 * Created by Administrator on 2017/7/27 0027.
 */

public interface NetCallback {
    void onSuccess(String xmlData);
    void onError(String errorMsg);
}
