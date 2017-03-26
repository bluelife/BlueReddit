package com.bluelife.bluereddit.view.main;

import com.hannesdorfmann.mosby3.mvp.MvpView;

import io.reactivex.Observable;

/**
 * Created by HiWin10 on 3/25/2017.
 */

public interface MainView extends MvpView {

    public Observable<Boolean> loadFirstPageIntent();

    /**
     * The intent to load the next page
     *
     * @return The emitted item boolean can be ignored because it is always true
     */
    public Observable<Boolean> loadNextPageIntent();

    /**
     * The intent to react on pull-to-refresh
     *
     * @return The emitted item boolean can be ignored because it is always true
     */
    public Observable<Boolean> pullToRefreshIntent();

    /**
     * The intent to load more items from a given group
     *
     * @return Observable with the name of the group
     */
    //public Observable<String> loadAllProductsFromCategoryIntent();

    /**
     * Renders the viewState
     */
    public void render(MainViewState viewState);
}
