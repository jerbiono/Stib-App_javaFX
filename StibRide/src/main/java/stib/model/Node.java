
package stib.model;

/**
 * Represents the stationin the graph.
 *
 * @author nadou
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import stib.dto.StationDto;

public class Node {

    private StationDto station;
    private List<Integer> lines;
    private LinkedList<Node> shortestPath = new LinkedList<>();

    private Integer distance = Integer.MAX_VALUE;
    final int distanceBetweenAdjeecentNodes = 1;
    private Map<Node, Integer> adjacentNodes = new HashMap<>();

    public Node(StationDto station) {
        this.station = station;
    }

    /**
     * Simple setter of nodes lines.
     *
     * @param lines the given lines.
     */
    public void setLines(List<Integer> lines) {
        this.lines = lines;
    }

    public Node(StationDto station, List<Integer> lines) {
        this.station = station;
        this.lines = lines;
    }

    /**
     * Simple getter of the name of station.
     *
     * @returnthe station name.
     */
    public String getStationName() {
        return this.station.getStationName();
    }

    /**
     * Simple getter of node lines.
     *
     * @return lines of node
     */
    public String getLines() {
        String stationLines = "[";
        for (int i = 0; i < this.lines.size(); i++) {
            stationLines += this.lines.get(i) + "";
            if (!(i == this.lines.size() - 1)) {
                stationLines += ", ";
            }
        }
        stationLines += "]";
        return stationLines;
    }

    /**
     * Add the future destination of the adjacent node.
     *
     * @param destination the future node destination.
     */
    public void addDestination(Node destination) {
        adjacentNodes.put(destination, distanceBetweenAdjeecentNodes);
    }

    /**
     * Simple getter of adjacent nodes.
     *
     * @return adjacent nodes.
     */
    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    /**
     * Simple getter of distance.
     *
     * @return the distance.
     */
    public Integer getDistance() {
        return distance;
    }

    /**
     * Simple setter of distance.
     *
     * @param distance the given distance.
     */
    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    /**
     * Simple getter of shortest path.
     *
     * @return the shortest path.
     */
    public List<Node> getShortestPath() {
        return shortestPath;
    }

    /**
     * Simple setter of shortest path.
     *
     * @param shortestPath the given shortest path.
     */
    public void setShortestPath(LinkedList<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    @Override
    public String toString() {
        return "station=" + station.getStationName();
    }

}
