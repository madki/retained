package xyz.madki.retained.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import in.workarounds.bundler.Bundler;
import in.workarounds.bundler.annotations.RequireBundler;

/**
 * Created by madki on 02/02/16.
 */
@RequireBundler
public abstract class Presenter<T> {
    private boolean created = false;
    private T view;

    public void onViewCreated(@Nullable Bundle savedState) {
        if(!created) {
            created = true;
            onCreate(savedState);
        }
    }

    @CallSuper
    protected void onCreate(@Nullable Bundle savedState) {
        Bundler.restoreState(this, savedState);
    }

    public final void takeView(T view) {
        if (view == null) throw new NullPointerException("new view must not be null");

        if(view != this.view) {
            if (this.view != null) dropView(view);
            this.view = view;
        }
    }

    public final void dropView(T view) {
        if (view == null) throw new NullPointerException("new view must not be null");
    }

    protected abstract void onViewAttached(T view);
    protected abstract void onDetachView(T view);

    public void onSave(@NonNull Bundle outState) {
        Bundler.saveState(this, outState);
    }
}
