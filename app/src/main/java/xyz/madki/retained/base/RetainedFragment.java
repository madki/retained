package xyz.madki.retained.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by madki on 01/02/16.
 */
public class RetainedFragment<C extends ActivityComponent> extends Fragment {
    private C component;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
    }

    public void setComponent(C component) {
        this.component = component;
    }

    public boolean hasComponent() {
        return this.component != null;
    }

    public  C getComponent() {
        return component;
    }

}
