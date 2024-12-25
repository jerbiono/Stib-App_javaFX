/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stib.model;

import java.util.List;
import stib.dto.FavoryDto;
import stib.dto.StationDto;

/**
 *
 * @author nadou
 */
public class ModelApp extends Observable implements InterfaceModel {

    private SearchPath searchPath;
    private FavoryManipulation favoryManip;

    public ModelApp() {
        searchPath = new SearchPath();
        favoryManip = new FavoryManipulation();
    }

    @Override
    public List<FavoryDto> getAllFavorys() {
        return this.favoryManip.getFavoryList();
    }

    @Override
    public void addFavoriteRouteToDb(FavoryDto item) {
        this.favoryManip.addNameToFavoryDb(item);
        this.favoryManip.SearchAllFavorys();
        this.notifyFavoriteObservers();

    }

    @Override
    public boolean DeleteFavoriteFromDb(String key) {
        Boolean checkIqDone = this.favoryManip.deleteItemFromFavoryDb(key);
        if (checkIqDone) {
            this.favoryManip.SearchAllFavorys();
            this.notifyFavoriteObservers();
        }
        return checkIqDone;
    }

    @Override
    public void SearchAllFavorys() {
        this.favoryManip.SearchAllFavorys();
    }

    @Override
    public void CalculatePath(String sourceStationName, String destStationName) {
        this.searchPath.executeSearchPath(sourceStationName, destStationName);
        this.notifyPathObservers();
    }

    @Override
    public List<StationDto> getData() {
        return searchPath.getStationsData().getData();
    }

    @Override
    public int getStationCount() {
        return searchPath.getStationsData().getStationsCount();
    }

    @Override
    public List<Node> getShortestPath() {
        return this.searchPath.getStationsPathResult();
    }

}
