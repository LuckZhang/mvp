package com.luck.mvp.ui.activity.delegate;

import com.luck.mvp.presenter.MvpPresenter;
import com.luck.mvp.ui.view.MvpView;

/**
 * This is just the internal implementation for the delegate. Don't use it by your own.
 *
 * Created by geek on 2015/7/31.
 */
public class MvpInternalDelegate<V extends MvpView, P extends MvpPresenter<V>> {
    protected MvpDelegateCallback<V, P> delegateCallback;

    public MvpInternalDelegate(MvpDelegateCallback<V, P> delegateCallback) {

        if (delegateCallback == null) {
            throw new NullPointerException("MvpDelegateCallback is null!");
        }

        this.delegateCallback = delegateCallback;
    }

    /**
     * Called  to create the presenter (if no other one already exisits)
     */
    public void createPresenter() {

        P presenter = delegateCallback.getPresenter();
        if (presenter == null) {
            presenter = delegateCallback.createPresenter();
        }
        if (presenter == null) {
            throw new NullPointerException("Presenter is null! Do you return null in createPresenter()?");
        }

        delegateCallback.setPresenter(presenter);
    }

    /**
     * Attaches the view to the presenter
     */
    public void attachView() {
        getPresenter().attachView(delegateCallback.getMvpView());
    }


    /**
     * Called to detach the view from presenter
     */
    public void detachView() {
        getPresenter().detachView(delegateCallback.isRetainingInstance());
    }


    private P getPresenter() {
        P presenter = delegateCallback.getPresenter();
        if (presenter == null) {
            throw new NullPointerException("Presenter returned from getPresenter() is null");
        }
        return presenter;
    }


}
