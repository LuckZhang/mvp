package com.luck.mvp.ui.view;

import com.luck.mvp.model.entity.MvpEntity;

/**
 *  A {@link MvpView} that assumes that there are 3 display operation:
 * <ul>
 * <li>{@link #showLoading(boolean)}: Display a loading animation while loading data in background
 * by
 * invoking the corresponding presenter method</li>
 *
 * <li>{@link #showError(Throwable,String, boolean)}: Display a error view (a TextView) on the screen if
 * an error has occurred while loading data. You can distinguish between a pull-to-refresh error by
 * checking the boolean parameter and display the error message in another, more suitable way like
 * a
 * Toast</li>
 *
 * <li>{@link #showContent()}: After the content has been loaded the presenter calls {@link
 * #setupData(E extends MvpEntity)} to fill the view with data. Afterwards, the presenter calls {@link
 * #showContent()} to display the data</li>
 * </ul>
 *
 * <p>
 * To make everything work automatically the concre
 * </p>
 *
 * Created by geek on 2015/7/31.
 */
public interface MvpLceView<E extends MvpEntity> extends MvpView {
    /**
     *  Load the data. Typically invokes the presenter method to load the desired data.
     * <p>
     * <b>Should not be called from presenter</b> to prevent infinity loops. The method is declared
     * in
     * the views interface to add support for view state easily.
     * </p>
     * @param pullToRefresh
     */
    public void loadData(boolean pullToRefresh);

    /**
     * Display a loading view while loading data in background.
     * <b>The loading view must have the id = R.id.loadingView</b>
     *
     * @param pullToRefresh true, if pull-to-refresh has been invoked loading.
     */
    public void showLoading(boolean pullToRefresh);

    /**
     * Show the content view.
     *
     * <b>The content view must have the id = R.id.contentView</b>
     */
    public void showContent();

    /**
     * Show the error view.
     * <b>The error view must be a TextView with the id = R.id.errorView</b>
     * @param throwable
     * @param errorMsg
     * @param pullToRefresh
     */
    public void showError(Throwable throwable,String errorMsg, boolean pullToRefresh);

    /**
     * The data that should be displayed with {@link #showContent()}
     * @param entity
     */
    public void setupData(E entity);
}
