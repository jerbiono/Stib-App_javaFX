/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stib.model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author nadou
 */
public class Graph {

    private Set<Node> nodes = new HashSet<>();

    /**
     * Allows to add node.
     * @param nodeA the given node.
     */
    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }

    public Set<Node> getNodes() {
        return nodes;
    }
/**
 * Simple setter of nodes
 * @param nodes the given list of nodes.
 */
    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

}
