package xyz.madki.retained;

import javax.inject.Inject;

import xyz.madki.retained.base.PerRetainedActivity;
import xyz.madki.retained.base.Presenter;

/**
 * Created by madki on 04/02/16.
 */
@PerRetainedActivity
public class MainPresenter extends Presenter<MainActivity> {

    @Inject
    public MainPresenter() {

    }

    @Override
    protected void onViewAttached(MainActivity view) {

    }

    @Override
    protected void onDetachView(MainActivity view) {

    }
}
