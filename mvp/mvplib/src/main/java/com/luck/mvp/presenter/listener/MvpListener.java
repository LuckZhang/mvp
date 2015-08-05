package com.luck.mvp.presenter.listener;

import com.luck.mvp.model.entity.MvpEntity;

/**
 * Created by geek on 2015/7/31.
 */
public interface MvpListener<E extends MvpEntity> {
    /**
     * Called when request succeeds
     *
     * @param entity
     */
    public void onSuccess(E entity);

    /**
     * Called when request fails
     *
     * @param throwable
     * @param errorMsg
     */
    public void onFailure(Throwable throwable, String errorMsg);

    /**
     * Fired when the request progress, override to handle in your own code
     *
     * @param bytesWritten
     * @param totalSize
     */
    public void onProgress(long bytesWritten, long totalSize);
}
