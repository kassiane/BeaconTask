package challenge.task.three;

/**
 * Class that represents each number of the matrix containing its north, south,
 * west and east neighbors.
 *
 * @author kassi
 *
 */
public class Node {

    private final int value;
    private final int row;
    private final int column;
    private Node north;
    private Node south;
    private Node east;
    private Node west;

    public Node(final int value, final int row, final int column) {
        this.value = value;
        this.row = row;
        this.column = column;
    }

    public int getValue() {
        return this.value;
    }

    public Node getNorth() {
        return this.north;
    }

    public Node getSouth() {
        return this.south;
    }

    public Node getEast() {
        return this.east;
    }

    public Node getWest() {
        return this.west;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public void setNorth(final Node north) {
        this.north = north;
    }

    public void setSouth(final Node south) {
        this.south = south;
    }

    public void setEast(final Node east) {
        this.east = east;
    }

    public void setWest(final Node west) {
        this.west = west;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.column + 13;
        result = prime * result + this.row + 11;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node other = (Node) obj;
        if (this.column != other.column) {
            return false;
        }
        if (this.row != other.row) {
            return false;
        }
        return true;
    }

}
