package xyz.madki.retained.base;

/**
 * Created by madki on 02/02/16.
 */
public interface ComponentProvider<T extends ActivityComponent> {
    T provideComponent();
}
