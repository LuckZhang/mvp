package com.luck.mvp.ui.activity.delegate;

import com.luck.mvp.presenter.MvpPresenter;
import com.luck.mvp.ui.view.MvpView;

/**
 * The MvpDelegate callback that will be called from {@link ActivityMvpDelegate} or {@link
 * FragmentMvpDelegate} . This interface must be implemented by all
 * Activity,
 * Fragment or android.view.View that you want to support mosbys mvp.y
 *
 * Created by geek on 2015/7/31.
 */
public interface MvpDelegateCallback<V extends MvpView,P extends MvpPresenter<V>> {


    /**
     * Creates the presenter instance
     *
     * @return the created presenter instance
     */
    public P createPresenter();

    /**
     * Get the presenter. If null is returned, then a internally a new presenter instance gets
     * created
     * by calling {@link #createPresenter()}
     *
     * @return the presenter instance. can be null.
     */
    public P getPresenter();

    /**
     * Sets the presenter instance
     *
     * @param presenter The presenter instance
     */
    public void setPresenter(P presenter);

    /**
     * Get the MvpView for the presenter
     *
     * @return The view associated with the presenter
     */
    public V getMvpView();

    /**
     * Is the view retaining? This boolean flag is used for {@link MvpPresenter#detachView(boolean)}
     * as parameter.
     *
     * @return true if the view is retaining, hence the presenter should be retaining as well.
     */
    public boolean isRetainingInstance();
}
