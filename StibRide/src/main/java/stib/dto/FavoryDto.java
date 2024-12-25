/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stib.dto;

/**
 *
 * @author nadou
 */
public class FavoryDto extends Dto<String> {

    private String stationSource;
    private String stationDestination;

    public FavoryDto(String stationSource, String stationDestination, String key) {
        super(key);
        this.stationSource = stationSource;
        this.stationDestination = stationDestination;
    }

    public String getStationSource() {
        return stationSource;
    }

    public String getStationDest() {
        return stationDestination;
    }

    @Override
    public String toString() {
        return  "stationSource=" + stationSource + " , stationDestination=" + stationDestination + " favoriName "+ this.key;
    }
    
    

}
