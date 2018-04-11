package challenge.task.three;

public class MatrixNodeBuilder {

	public Node[][] createNodes(final int[][] randomNumbers, final int rowSize, final int columnSize) {
		final Node[][] newNodeArray = new Node[rowSize][columnSize];

		// create nodes
		for (int row = 0; row < rowSize; row++) {
			for (int column = 0; column < columnSize; column++) {
				final Node node = new Node(randomNumbers[row][column], row, column);
				newNodeArray[row][column] = node;
			}
		}

		// set neighbors
		for (int row = 0; row < rowSize; row++) {
			for (int column = 0; column < columnSize; column++) {
				final Node current = newNodeArray[row][column];

				// north
				if (row - 1 >= 0) {
					final Node north = newNodeArray[row - 1][column];
					current.setNorth(north);
				}

				// south
				if (row + 1 < rowSize) {
					final Node south = newNodeArray[row + 1][column];
					current.setSouth(south);
				}

				// west
				if (column - 1 >= 0) {
					final Node west = newNodeArray[row][column - 1];
					current.setWest(west);
				}

				// east
				if (column + 1 < columnSize) {
					final Node east = newNodeArray[row][column + 1];
					current.setEast(east);
				}
			}
		}
		return newNodeArray;
	}

}