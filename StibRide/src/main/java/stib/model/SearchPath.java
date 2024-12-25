/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stib.model;

import java.util.ArrayList;
import java.util.List;
import stib.dto.StationDto;

/**
 *
 * @author nadou
 */
public class SearchPath {

    private StationData stationsData;
    private List<Node> stationsPathResult;
    private final List<StationDto> stations;
    private Graph graph;
    private List<Node> stationNodes;
    private Node origineNode;
    private Node destNode;

    public SearchPath() {
        this.stationsData = new StationData();
        this.stations = stationsData.getData();

    }

    /**
     * Allows to execute the search of shortest path.
     *
     * @param sourceStationName the given source station.
     * @param destStationName the given destinated station.
     */
    public void executeSearchPath(String sourceStationName, String destStationName) {
        fillGraph();
        searchPathFromSource(sourceStationName, destStationName);
    }

    /**
     * Search the shortestpath according to source node and destination node.
     *
     * @param sourceStationName the given name of source node.
     * @param destStationName the given name of destination node.
     */
    private void searchPathFromSource(String sourceStationName, String destStationName) {

        this.origineNode = searchSameNode(sourceStationName);
        this.destNode = searchSameNode(destStationName);
        if (this.origineNode == null || this.destNode == null) {
            stationsPathResult = null;
        } else {
            if (!sourceStationName.equals(destStationName)) {
                CalculateShortestPath();
                stationsPathResult = destNode.getShortestPath();
                if (!stationsPathResult.get(stationsPathResult.size() - 1).equals(destNode)) {
                    stationsPathResult.add(destNode);
                }

            }
        }

    }

    /**
     * Prepares all nodes to be added to the graph.
     */
    private void fillListOfNodes() {
        for (int i = 0; i < this.stations.size(); i++) {
            Node nodeToAdd = new Node(this.stations.get(i));
            this.stationNodes.add(nodeToAdd);
        }
    }

    /**
     * Allows to fill the graph.
     */
    private void fillGraph() {
        this.graph = new Graph();
        this.stationNodes = new ArrayList();

        fillListOfNodes();
        for (int i = 0; i < this.stationNodes.size(); i++) {
            String stationName = this.stationNodes.get(i).getStationName();
            this.stationsData.searchStationNeighbors(stationName);
            List<StationNeighbors> neighborsList = this.stationsData.geStationsWithNeighbors();
            //search
            for (int j = 0; j < neighborsList.size(); j++) {
                Node NeighborNode = searchSameNode(neighborsList.get(j).getStationNeighbor().getStationName());
                NeighborNode.setLines(neighborsList.get(j).getLinesNeighbors());
                this.stationNodes.get(i).setLines(neighborsList.get(j).getLinesSources());
                this.stationNodes.get(i).addDestination(NeighborNode);
            }
            this.graph.addNode(this.stationNodes.get(i));
        }

    }

    /**
     * Calculates the shortest path from the node source.
     */
    private void CalculateShortestPath() {
        this.graph = Dijkstra.calculateShortestPathFromSource(this.graph, origineNode);

    }

    /**
     * Allows to search and get node in the used nodes list by it's name.
     *
     * @param Name the node's name.
     * @return the node otherwise return null.
     */
    private Node searchSameNode(String Name) {

        for (int j = 0; j < stationNodes.size(); j++) {
            String stationName = stationNodes.get(j).getStationName();
            if (stationName.equals(Name)) {
                return stationNodes.get(j);
            }
        }
        return null;
    }

    /**
     * Simple getter of station data.
     *
     * @return the stationData.
     */
    public StationData getStationsData() {
        return stationsData;
    }

    public List<Node> getStationsPathResult() {
        return stationsPathResult;
    }

}
