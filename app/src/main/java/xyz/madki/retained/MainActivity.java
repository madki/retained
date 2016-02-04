package xyz.madki.retained;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import dagger.Component;
import xyz.madki.retained.base.ActivityComponent;
import xyz.madki.retained.base.RetainedActivity;

/**
 * Created by madki on 04/02/16.
 */
public class MainActivity extends RetainedActivity<MainPresenter, MainActivity.MainComponent> {
    @Inject
    MainPresenter presenter;

    @Override
    protected MainPresenter getPresenter() {
        return presenter;
    }

    @NonNull
    @Override
    protected MainComponent provideComponent() {
        return DaggerMainActivity_MainComponent.create();
    }

    @Component
    interface MainComponent extends ActivityComponent<MainActivity> {
        @Override
        void inject(MainActivity activity);
    }
}
