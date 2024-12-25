/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stib.model;

import Presenter.Observer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nadou
 */
public class Observable {

    List<Observer> pathObservers = new ArrayList<>();
    List<Observer> favoriteObserver = new ArrayList<>();

    /**
     * Allows to register observer to observe the observable.
     *
     * @param observer the given observer.
     */
    public void registerObserver(Observer observer) {
        if (!this.pathObservers.contains(observer)) {
            this.pathObservers.add(observer);
        }
       if (!this.favoriteObserver.contains(observer)) {
            this.favoriteObserver.add(observer);
        }
    }

    /**
     * Removes observer from the list of observers.
     *
     * @param observer the given observer.
     */
    public void removeObserver(Observer observer) {
        if (this.pathObservers.contains(observer)) {
            this.pathObservers.remove(observer);
        }
         if (this.favoriteObserver.contains(observer)) {
            this.favoriteObserver.remove(observer);
        }
    }

    /**
     * Allows to notify all observers of the new state of observable.
     *
     */
    public void notifyPathObservers() {
        for (Observer obs : this.pathObservers) {
            obs.updatePath();
        }
    }
    public void notifyFavoriteObservers(){
         for (Observer obs : this.favoriteObserver) {
            obs.updateFavorite();
        }
    }
}
