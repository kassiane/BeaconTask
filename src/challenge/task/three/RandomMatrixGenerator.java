package challenge.task.three;

import java.util.Random;

/**
 * Class that creates a random matrix of numbers between 0 and 9.
 *
 * @author kassi
 *
 */
public class RandomMatrixGenerator {

    /**
     * Method that generates the random matrix.
     *
     * @param matrixDimension
     *            the dimension of row and column of the matrix.
     *
     * @return the random matrix of numbers between 0 and 9.
     */
    public int[][] generateRandomMatrix(final int matrixDimension) {
        final Random random = new Random();

        final int[][] array = new int[matrixDimension][matrixDimension];

        for (int row = 0; row < matrixDimension; row++) {
            for (int column = 0; column < matrixDimension; column++) {
                array[row][column] = random.nextInt(10);
            }
        }

        return array;
    }
}
