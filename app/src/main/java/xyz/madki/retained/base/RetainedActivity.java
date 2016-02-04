package xyz.madki.retained.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by madki on 02/02/16.
 */
public abstract class RetainedActivity<T extends Presenter, C extends ActivityComponent>
        extends AppCompatActivity {
    private RetainedFragment<C> retainedFragment;

    @Override
    @CallSuper
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainedFragment();
        retainedFragment.getComponent().inject(this);
        getPresenter().onViewCreated(savedInstanceState);

    }

    private void setRetainedFragment() {
        String tag = getRetainedFragmentTag();
        FragmentManager fm = getSupportFragmentManager();
        retainedFragment = (RetainedFragment<C>) fm.findFragmentByTag(tag);

        if(retainedFragment == null) {
            retainedFragment = new RetainedFragment<>();
            fm.beginTransaction().add(retainedFragment, tag).commit();
            retainedFragment.setComponent(provideComponent());
        }
    }

    private String getRetainedFragmentTag() {
        return this.getClass().getName() + "#rf";
    }

    @Override
    @CallSuper
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        getPresenter().onSave(savedInstanceState);
        super.onRestoreInstanceState(savedInstanceState);
    }

    @CallSuper
    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().takeView(this);
    }

    @Override
    @CallSuper
    protected void onPause() {
        getPresenter().dropView(this);
        super.onPause();
    }

    public C getComponent() {
        return retainedFragment.getComponent();
    }

    protected abstract T getPresenter();
    @NonNull
    protected abstract C provideComponent();
}
