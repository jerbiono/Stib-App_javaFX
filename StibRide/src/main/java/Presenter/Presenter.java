/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import java.util.List;
import stib.dto.FavoryDto;
import stib.dto.StationDto;
import stib.model.InterfaceModel;
import stib.model.ModelApp;
import stib.model.Node;
import stib.view.FxmlController;

/**
 *
 * @author nadou
 */
public class Presenter implements Observer {

    private FxmlController view;
    private InterfaceModel model;

    public Presenter(FxmlController view, ModelApp model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void updatePath() {

        view.updateTableStationData();
    }
    
    @Override
    public void updateFavorite(){
        view.updateFavoryTable();
    }

    /**
     * Simple getter of ids and names of all stations.
     *
     * @return a the list of data.
     */
    public List<StationDto> getStationsData() {
        return this.model.getData();
    }

    /**
     * Allows to add a favory
     *
     * @param item the given favory.
     */
    public void AddFavory(FavoryDto item) {
        this.model.addFavoriteRouteToDb(item);
    }

    /**
     * Allows to delete a favory.
     *
     * @param key the given favorite key.
     * @return true if delete is done , otherwise return false.
     */
    public boolean deleteFavory(String key) {
       return this.model.DeleteFavoriteFromDb(key);
    }
    
     public void SearchAllFavorys(){
         this.model.SearchAllFavorys();
     }

    /**
     * Simple getter of favorys.
     *
     * @return a list of favorys.
     */
    public List<FavoryDto> getAllFavorys() {
        return this.model.getAllFavorys();
    }

    /**
     * Simple getter of the total number of stations.
     *
     * @return the total number of stations.
     */
    public int getStationCount() {
        return this.model.getStationCount();
    }

    /**
     * Simple getter of the list of station which represents the shortest path
     * from source to destination.
     *
     * @return the list of nodes which construct the shortest path.
     */
    public List<Node> getShortestPath() {
        return this.model.getShortestPath();
    }

    /**
     * Allows to calculate the shortest path.
     *
     * @param sourceStationName the given station source name.
     * @param desStationName the given destination name.
     */
    public void CalculatePath(String sourceStationName, String desStationName) {
        this.model.CalculatePath(sourceStationName, desStationName);
    }

}
