/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stib.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import stib.dto.FavoryDto;
import stib.repository.FavoryRepository;
import stib.repository.RepositoryException;

/**
 *
 * @author nadou
 */
public class FavoryManipulation {

    private FavoryRepository favoryFactory;
    private List<FavoryDto> favoryList;

    public FavoryManipulation() {
        favoryList = new ArrayList<>();
        try {
            this.favoryFactory = new FavoryRepository();
        } catch (RepositoryException ex) {
            Logger.getLogger(FavoryManipulation.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    /**
     * Allows to search all favorys on Db.
     */
    public void SearchAllFavorys() {
        try {
            favoryList = favoryFactory.getAll();
        } catch (RepositoryException ex) {
            Logger.getLogger(StationData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Allows to add Item to the Db.
     *
     * @param item the given item.
     */
    public void addNameToFavoryDb(FavoryDto item) {
        try {
            favoryFactory.add(item);
        } catch (RepositoryException ex) {
            Logger.getLogger(FavoryManipulation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Allowos to delete a favory from the db according to the key.
     *
     * @param key the given key.
     * @return true if the delete is done , otherwise return false.
     */
    public boolean deleteItemFromFavoryDb(String key) {
        boolean checkDone = false;
        try {
            checkDone = favoryFactory.remove(key);
        } catch (RepositoryException ex) {
            Logger.getLogger(FavoryManipulation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return checkDone;
    }

    /**
     * Simple getter of favorys.
     *
     * @return list of favorys.
     */
    public List<FavoryDto> getFavoryList() {
        return favoryList;
    }

}
