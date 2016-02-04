package xyz.madki.retained.base;

/**
 * Created by madki on 02/02/16.
 */
public interface ActivityComponent<T extends RetainedActivity> {
    void inject(T activity);
}
