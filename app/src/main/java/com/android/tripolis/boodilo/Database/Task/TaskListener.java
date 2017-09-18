package com.android.tripolis.boodilo.Database.Task;

/**
 * Created by v.karyagin on 9/16/17.
 */

public interface TaskListener<T> {

    void onSuccess(T result);
    void onError();

}
