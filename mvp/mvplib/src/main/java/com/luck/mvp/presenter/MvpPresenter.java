package com.luck.mvp.presenter;

import com.luck.mvp.ui.view.MvpView;

/**
 * The base interface for each mvp presenter
 * Created by geek on 2015/7/31.
 */
public interface MvpPresenter<V extends MvpView> {

    /**
     * Set or attach the view to this presenter
     *
     * @param view can activity、fragment、view etc...
     */
    void attachView(V view);


    /**
     * Will be called if the view has been destroyed. Typically this method will be invoked from
     * <code>Activity.detachView()</code> or <code>Fragment.onDestroyView()</code>
     *
     * @param retainInstance
     */
    void detachView(boolean retainInstance);
}
