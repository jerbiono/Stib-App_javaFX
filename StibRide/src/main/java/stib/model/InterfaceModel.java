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
 * Represents the façade of the model.
 *
 * @author nadou
 */
public interface InterfaceModel {

    /**
     * Simple getter of all favorys.
     *
     * @return a list of favorys.
     */
    public List<FavoryDto> getAllFavorys();

    /**
     * Allows to add a favorite route.
     *
     * @param item the item which contain the name of the favorite route.
     */
    public void addFavoriteRouteToDb(FavoryDto item);

    /**
     * Delete favorite route from Db.
     *
     * @param key the given key.
     * @return true if delete is done , otherwise return false.
     */
    public boolean DeleteFavoriteFromDb(String key);

    /**
     * Allows to search all favorys.
     */
    public void SearchAllFavorys();

    /**
     * Allows to calculate the path.
     *
     * @param sourceStationName the given source station.
     * @param destStationName the given destintated station.
     */
    public void CalculatePath(String sourceStationName, String destStationName);

    /**
     * Simple getter of stations data.
     *
     * @return the list of stations data.
     */
    public List<StationDto> getData();

    /**
     * Simple getter of the number of stations.
     *
     * @return the total number of stations.
     */
    public int getStationCount();

    /**
     * Simple getter of shortest path.
     *
     * @return a list of nodes representes the shortest path.
     */
    public List<Node> getShortestPath();
}
