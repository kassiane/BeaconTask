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
		return value;
	}

	public Node getNorth() {
		return north;
	}

	public Node getSouth() {
		return south;
	}

	public Node getEast() {
		return east;
	}

	public Node getWest() {
		return west;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
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
		result = prime * result + column;
		result = prime * result + row;
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
		if (column != other.column) {
			return false;
		}
		if (row != other.row) {
			return false;
		}
		return true;
	}

}
