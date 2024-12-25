/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

/**
 *
 * @author nadou
 */
public interface Observer {

    /**
     * Allows to update the path search of observer according to the state of
     * observable.
     */
    public void updateFavorite();

    /**
     * Allows to update the favorite path of observer according to the state of
     * observable.
     */
    public void updatePath();
}
