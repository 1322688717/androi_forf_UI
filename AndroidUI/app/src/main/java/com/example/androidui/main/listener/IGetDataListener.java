package com.example.androidui.main.listener;

public interface IGetDataListener<T> {
    public void onSuccess(T dataobj);
    public void onFailure(Object reasonOBJ);
}
