
package stib.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import stib.dto.StationDto;
import stib.repository.RepositoryException;
import stib.repository.StationsRepository;

/**
 * Represents all data related to stations.
 *
 * @author nadou
 */
public class StationData {

    private List<StationDto> data;
    private int stationscount;
    private List<StationNeighbors> stationWithNeighbors;
    private StationsRepository stationFactory;
    public StationData() {
        this.data = new ArrayList<>();
        this.stationWithNeighbors = new ArrayList<>();    
            try {
                stationFactory = new StationsRepository();
            } catch (RepositoryException ex) {
                Logger.getLogger(StationData.class.getName()).log(Level.SEVERE, null, ex);
            }
        countStations();
        searchStationsData();
     
    }
  /**
   * Search all neighbor of the given station using it's name.
   * @param stationName the given station name.
   */
       public void searchStationNeighbors(String stationName){
       
        try {
            StationDto station = null ;
            for (int i = 0; i < stationscount; i++) {
                if(data.get(i).getStationName().equals(stationName)){
                    station = data.get(i);
                    break;
                }
            }

            stationWithNeighbors = stationFactory.getAdjacentNeighbors(station);
        } catch (RepositoryException ex) {
            Logger.getLogger(StationData.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }

    public List<StationNeighbors> geStationsWithNeighbors() {
        return stationWithNeighbors;
    }
    /**
     * Allows to get stations data.
     */
    private void searchStationsData() {
      
        try {
            List<StationDto> listStations = stationFactory.getAll();
            listStations.forEach((station) -> {
                data.add(station);
            });
        } catch (RepositoryException ex) {
            Logger.getLogger(StationData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Allows to calculates the total number of stations.
     */
    private void countStations() {
        try {
            this.stationscount = stationFactory.getTotalNumberOfStations();
        } catch (RepositoryException ex) {
            Logger.getLogger(StationData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<StationDto> getData() {
        return data;
    }

    public int getStationsCount() {
        return stationscount;
    }

}
