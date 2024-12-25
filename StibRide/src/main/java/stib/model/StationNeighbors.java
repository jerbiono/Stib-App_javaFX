/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stib.model;

import java.util.List;
import stib.dto.StationDto;

/**
 * Represents station sources with their neighbors.
 * @author nadou
 */
public class StationNeighbors {

    private StationDto stationSource;

    public List<Integer> getLinesNeighbors() {
        return linesNeighbors;
    }
    private StationDto stationNeighbor;
    private List<Integer> linesNeighbors;
    private List<Integer> linesSources;

    public List<Integer> getLinesSources() {
        return linesSources;
    }

    public StationNeighbors(StationDto stationSource, StationDto stationNeighbor, List<Integer> linesNeighbors, List<Integer> linesSources) {
        this.stationSource = stationSource;
        this.stationNeighbor = stationNeighbor;
        this.linesNeighbors = linesNeighbors;
        this.linesSources = linesSources;
    }

    /**
     * Simple getter of station sources.
     *
     * @return station source.
     */
    public StationDto getStationSource() {
        return stationSource;
    }

    /**
     * Simple getter of station neighbor.
     *
     * @return the station neighbor.
     */
    public StationDto getStationNeighbor() {
        return stationNeighbor;
    }
}
