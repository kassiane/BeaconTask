package challenge.task.three;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathCalculator {

    private final MatrixNodeBuilder matrixNodeBuilder;

    private List<Path> pathsWithRequiredSum;
    private Stack<Path> possiblePaths;
    private int requiredSumPath;

    public PathCalculator(final MatrixNodeBuilder matrixNodeBuilder) {
        this.matrixNodeBuilder = matrixNodeBuilder;
    }

    public List<Path> calculatePaths(final int requiredSumPath, final int rowSize, final int columnSize,
            final int[][] randomNumbers) {

        this.requiredSumPath = requiredSumPath;
        this.pathsWithRequiredSum = new ArrayList<>();
        this.possiblePaths = new Stack<>();

        final Node[][] nodes = this.matrixNodeBuilder.createNodes(randomNumbers, rowSize, columnSize);

        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++) {

                final Path newPath = new Path();
                final Node node = nodes[row][column];

                newPath.addNode(node);
                this.possiblePaths.add(newPath);
            }
        }

        while (!this.possiblePaths.isEmpty()) {

            final Path currentPath = this.possiblePaths.pop();
            final Node lastNode = currentPath.getLastNode();

            // north
            final Node north = lastNode.getNorth();
            createNewPath(currentPath, north);

            // south
            final Node south = lastNode.getSouth();
            createNewPath(currentPath, south);

            // west
            final Node west = lastNode.getWest();
            createNewPath(currentPath, west);

            // east
            final Node east = lastNode.getEast();
            createNewPath(currentPath, east);

        }

        return this.pathsWithRequiredSum;

    }

    private void createNewPath(final Path currentPath, final Node node) {
        final Path newPath = currentPath.clone();
        if (node != null) {
            final int sum = newPath.addNode(node);

            if (sum == this.requiredSumPath) {
                this.pathsWithRequiredSum.add(newPath);
            } else if (sum < this.requiredSumPath && sum > -1) {
                this.possiblePaths.push(newPath);
            }

        }
    }

}
