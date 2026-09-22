package websearch;

@FunctionalInterface
public interface QueryObserver {
    void queryFound(String query);
}