package challenge.task.three;

import java.util.List;

import challenge.task.three.interfaces.MatrixValidator;

/**
 * Description In this task we'll try to solve a little algorithmic challenge.
 * 
 * Given a 2 dimensional array with n columns and n rows that contains random
 * numbers between 0 and 9.
 * 
 * You can use
 * 
 * In [0]: import numpy as np In [1]: matrix = np.random.randint(10, size=(5,
 * 5))
 * 
 * In [2]: matrix Out[2]: array([[6, 3, 5, 2, 0], [4, 8, 5, 7, 1], [3, 9, 4, 2,
 * 3], [4, 3, 7, 1, 1], [5, 3, 5, 0, 7]])
 * 
 * In [3]: to create the array
 * 
 * Task Connect neighboring fields in this matrix to find exactly one path that
 * sums up to 21. Print the matrix and the values and coordinates of the path on
 * the command line.
 * 
 * Example user@maya:~$ ./find_path 
 * 
 * 6, 3, 5, 2, 0 
 * 4, 8, 5, 7, 1 
 * 3, 9, 4, 2, 3 
 * 4, 3, 7, 1, 1 
 * 5, 3, 5, 0, 7
 * 
 * Path that sums up to 21: 8 (1/1), 9 (2/1), 4 (2/2) Requirements You are
 * allowed to connect only direct neighbors that are North, West, East or South
 * of the current element. The path must not intersect with itself. Entities
 * must not occur more than once in the path. TASK 3 Bonus: Find the Path II
 * Description The set up and the requirements of this task are the same as in
 * Task 2A.
 * 
 * Task Connect neighboring fields in this matrix to find the shortest path in
 * the matrix that sums up to 21.
 * 
 * Requirements See Task 3.
 * 
 * @author kassi
 *
 */
public class TaskThree {

    /**
     * Expected arguments:
     * 1) Task number (1 for any path; 2 for shortest path)
     * 2) Dimension of the matrix
     * 
     * @param args
     */
    public static void main(final String[] args) {
        validateArguments(args);

        final int task = Integer.parseInt(args[0]);
        final int matrixDimension = Integer.parseInt(args[1]);

        final RandomMatrixGenerator randomMatrixGenerator = new RandomMatrixGenerator();

        final MatrixValidator matrixValidator = new MatrixValidatorImpl();
        matrixValidator.validateMatrix(matrixDimension, matrixDimension);

        final int[][] array = randomMatrixGenerator.generateRandomMatrix(matrixDimension);

        final MatrixNodeBuilderImpl matrixNodeBuilder = new MatrixNodeBuilderImpl();
        final PathCalculator pathCalculator = new PathCalculator(matrixNodeBuilder);

        final List<Path> pathsWithRequiredSum = pathCalculator.calculatePaths(21, matrixDimension, array);

        printAnswer(task, matrixDimension, array, pathsWithRequiredSum);

    }

    private static void validateArguments(final String[] args) {
        if (args == null || args.length != 2) {
            throw new IllegalArgumentException(
                    "Please inform 1 for printing only one that sums up to 21 or 2 to print the shortest path and the matrix dimension.");
        }
    }

    private static void printAnswer(final int task, final int matrixDimension, final int[][] array,
            final List<Path> pathsWithRequiredSum) {
        printMatrix(matrixDimension, array);
        System.out.println("Path that sums up to 21:");

        if (pathsWithRequiredSum.size() < 1) {
            System.out.println("No paths were found for this matrix.");
            return;
        }

        final Path shortest = getShortestPath(pathsWithRequiredSum);

        if (task == 1 && pathsWithRequiredSum.size() >= 1) {
            System.out.println(pathsWithRequiredSum.get(0));
        } else if (task == 2) {
            System.out.println(shortest);
        }
    }

    private static void printMatrix(final int matrixDimension, final int[][] array) {
        final StringBuilder matrixString = new StringBuilder();
        for (int row = 0; row < matrixDimension; row++) {
            matrixString.append("[");
            for (int column = 0; column < matrixDimension; column++) {
                matrixString.append(" ").append(array[row][column]).append(" ");
            }
            matrixString.append("]");
            matrixString.append(System.getProperty("line.separator"));
        }
        System.out.println(matrixString);
    }

    private static Path getShortestPath(final List<Path> pathsWithRequiredSum) {
        Path shortest = pathsWithRequiredSum.get(0);
        for (int i = 1; i < pathsWithRequiredSum.size(); i++) {
            final Path current = pathsWithRequiredSum.get(i);
            if (shortest.getPathSize() > current.getPathSize()) {
                shortest = current;
            }
        }
        return shortest;
    }

}
