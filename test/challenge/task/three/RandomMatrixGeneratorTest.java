package challenge.task.three;

import org.junit.Assert;
import org.junit.Test;

/**
 * Class that tests {@link RandomMatrixGenerator}.
 * 
 * @author kassi
 *
 */
public class RandomMatrixGeneratorTest {

    @Test
    public void checkRandomMatrixCreation() {
        final RandomMatrixGenerator subject = new RandomMatrixGenerator();
        final int dimension = 3;

        final int[][] result = subject.generateRandomMatrix(dimension);

        for (int row = 0; row < dimension; row++) {
            for (int column = 0; column < dimension; column++) {
                final int number = result[row][column];
                Assert.assertTrue(number >= 0 && number <= 9);
            }
        }

    }
}
