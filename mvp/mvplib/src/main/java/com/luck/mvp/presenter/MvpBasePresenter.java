package com.luck.mvp.presenter;

import android.support.annotation.Nullable;

import com.luck.mvp.ui.view.MvpView;

import java.lang.ref.WeakReference;

/**
 * A base implementation of a {@link MvpPresenter} that uses a <b>WeakReference</b> for referring
 * to the attached view.
 * <p>
 * You should always check {@link #isViewAttached()} to check if the view is attached to this
 * presenter before calling {@link #getView()} to access the view.
 * </p>
 * <p/>
 * Created by geek on 2015/7/31.
 */
public class MvpBasePresenter<V extends MvpView> implements MvpPresenter<V> {

    /**
     * use weak reference save mvp view instance
     */
    private WeakReference<V> mWeakReference;

    @Override
    public void attachView(V view) {
        mWeakReference = new WeakReference<V>(view);
    }

    @Override
    public void detachView(boolean retainInstance) {
        if (mWeakReference != null) {
            mWeakReference.clear();
            mWeakReference = null;
        }
    }

    /**
     * Get the attached view. You should always call {@link #isViewAttached()} to check if the view
     * is
     * attached to avoid NullPointerExceptions.
     *
     * @return <code>null</code>, if view is not attached, otherwise the concrete view instance
     */
    @Nullable
    protected V getView() {
        return mWeakReference == null ? null : mWeakReference.get();
    }

    /**
     * Checks if a view is attached to this presenter. You should always call this method before
     * calling {@link #getView()} to get the view instance.
     *
     * @return check result for view attached
     */
    protected boolean isViewAttached() {
        return mWeakReference != null && mWeakReference.get() != null;
    }
}
