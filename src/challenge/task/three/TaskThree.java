package challenge.task.three;

import java.util.ArrayList;
import java.util.Stack;

public class TaskThree {

	final static int REQUIRED_SUM_PATH = 21;
	final static int ROW_SIZE = 5;
	final static int COLUMN_SIZE = 5;

	public static void main(final String[] args) {
		final int[][] array = { { 6, 3, 5, 2, 0 }, { 4, 8, 5, 7, 1 }, { 3, 9, 4, 2, 3 }, { 4, 3, 7, 1, 1 },
		        { 5, 3, 5, 0, 7 } };

		final Node[][] nodeArray = new Node[ROW_SIZE][COLUMN_SIZE];

		final ArrayList<Path> pathsWithRequiredSum = new ArrayList<>();

		// create nodes
		for (int row = 0; row < ROW_SIZE; row++) {
			for (int column = 0; column < COLUMN_SIZE; column++) {
				final Node node = new Node(array[row][column], row, column);
				nodeArray[row][column] = node;
			}
		}

		final Stack<Path> possiblePaths = new Stack<>();

		// set neighbors
		for (int row = 0; row < ROW_SIZE; row++) {
			for (int column = 0; column < COLUMN_SIZE; column++) {
				final Node current = nodeArray[row][column];

				// north
				if (row - 1 >= 0) {
					final Node north = nodeArray[row - 1][column];
					current.setNorth(north);
				}

				// south
				if (row + 1 < ROW_SIZE) {
					final Node south = nodeArray[row + 1][column];
					current.setSouth(south);
				}

				// west
				if (column - 1 >= 0) {
					final Node west = nodeArray[row][column - 1];
					current.setWest(west);
				}

				// east
				if (column + 1 < COLUMN_SIZE) {
					final Node east = nodeArray[row][column + 1];
					current.setEast(east);
				}

				// adding to the list of possible paths
				final Path newPath = new Path();
				newPath.addNode(current);

				possiblePaths.add(newPath);
			}
		}

		while (!possiblePaths.isEmpty()) {

			final Path currentPath = possiblePaths.pop();
			final Node lastNode = currentPath.getLastNode();

			// north
			final Node north = lastNode.getNorth();
			addNodeToPath(possiblePaths, pathsWithRequiredSum, currentPath, north);

			// south
			final Node south = lastNode.getSouth();
			addNodeToPath(possiblePaths, pathsWithRequiredSum, currentPath, south);

			// west
			final Node west = lastNode.getWest();
			addNodeToPath(possiblePaths, pathsWithRequiredSum, currentPath, west);

			// east
			final Node east = lastNode.getEast();
			addNodeToPath(possiblePaths, pathsWithRequiredSum, currentPath, east);

		}

		for (int i = 0; i < pathsWithRequiredSum.size(); i++) {
			System.out.println(pathsWithRequiredSum.get(i));
		}

	}

	public static void addNodeToPath(final Stack<Path> possiblePaths, final ArrayList<Path> pathsWithRequiredSum,
	        final Path currentPath, final Node node) {
		final Path currentNorthPath = currentPath.clone();
		if (node != null) {
			final int sum = currentNorthPath.addNode(node);

			if (sum == REQUIRED_SUM_PATH) {
				pathsWithRequiredSum.add(currentNorthPath);
			} else if (sum < REQUIRED_SUM_PATH && sum > -1) {
				possiblePaths.push(currentNorthPath);
			}

		}
	}

}
