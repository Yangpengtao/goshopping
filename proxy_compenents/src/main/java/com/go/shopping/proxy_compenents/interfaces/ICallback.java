package com.go.shopping.proxy_compenents.interfaces;


/**
 * Created by admin on 2017/6/22.
 * 参考 统一网络回调接口
 */
public interface ICallback {
    void onSuccess(String result);
    void onFailure(String e);
}
