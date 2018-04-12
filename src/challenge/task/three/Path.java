package challenge.task.three;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Class that stores the path that is being evaluated.
 *
 * @author kassi
 *
 */
public class Path {

    private static final String LINE_SEPARATOR = "line.separator";
    private final ArrayList<Node> nodeList;
    private final Set<Node> nodeSet;
    private int totalSum;

    public Path() {
        this.nodeList = new ArrayList<>();
        this.nodeSet = new HashSet<>();
        this.totalSum = 0;
    }

    private Path(final ArrayList<Node> nodeList, final Set<Node> nodeSet, final int totalSum) {
        this.nodeList = nodeList;
        this.nodeSet = nodeSet;
        this.totalSum = totalSum;
    }

    /**
     * Adds a node to the path if it was not visited and returns the sum of the path
     * values.
     *
     * @param nodeToAdd
     *            that will be added to the path.
     * @return the sum of the path values.
     */
    public int addNode(final Node nodeToAdd) {
        if (this.nodeSet.contains(nodeToAdd)) {
            return -1;
        }

        this.nodeList.add(nodeToAdd);
        this.nodeSet.add(nodeToAdd);
        this.totalSum += nodeToAdd.getValue();

        return this.totalSum;
    }

    /**
     * Method that returns the size of the path.
     *
     * @return the list of nodes of the path.
     */
    public int getPathSize() {
        return this.nodeList.size();
    }

    /**
     * Method that returns the last node that was inserted to the path.
     *
     * @return the last node inserted to the path.
     */
    public Node getLastNode() {
        return this.nodeList.get(this.nodeList.size() - 1);
    }

    @Override
    public Path clone() {
        final ArrayList<Node> nodes = new ArrayList<>(this.nodeList);
        final HashSet<Node> setNodes = new HashSet<>(this.nodeSet);

        return new Path(nodes, setNodes, this.totalSum);
    }

    @Override
    public String toString() {
        final StringBuilder toString = new StringBuilder();
        toString.append(System.getProperty(LINE_SEPARATOR));
        toString.append("Path = ");
        for (int node = 0; node < this.nodeList.size(); node++) {
            final Node current = this.nodeList.get(node);
            toString.append(current.getValue());
            toString.append("(").append(current.getRow()).append(",").append(current.getColumn()).append(")");

            if (node != this.nodeList.size() - 1) {
                toString.append(" => ");
            }
        }
        toString.append(System.getProperty(LINE_SEPARATOR));

        return toString.toString();
    }

}
