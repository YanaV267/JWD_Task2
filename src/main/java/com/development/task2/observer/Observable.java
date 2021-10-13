package com.development.task2.observer;

public interface Observable {
    void attach(SphereObserver observer);
    void detach(SphereObserver observer);
    void notifyObservers();
}
