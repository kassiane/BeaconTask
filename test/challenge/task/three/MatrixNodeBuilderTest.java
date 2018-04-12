package challenge.task.three;

import org.junit.Assert;
import org.junit.Test;

import challenge.task.three.interfaces.MatrixNodeBuilder;
import challenge.task.three.mocks.MatrixNodeBuilderMock;

/**
 * Class that tests {@link MatrixNodeBuilderImpl}.
 *
 * @author kassi
 *
 */
public class MatrixNodeBuilderTest {

    @Test
    public void createValidNodes() {
        final MatrixNodeBuilderImpl subject = new MatrixNodeBuilderImpl();

        final MatrixNodeBuilder matrixNodeBuilderMock = new MatrixNodeBuilderMock();
        final Node[][] expected = matrixNodeBuilderMock.createNodes(null, 0, 0);

        final int[][] randomNumbers = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        final int rowSize = 3;
        final int columnSize = 3;
        final Node[][] result = subject.createNodes(randomNumbers, rowSize, columnSize);

        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++) {
                final Node nodeExpected = expected[row][column];
                final Node nodeResult = result[row][column];
                Assert.assertEquals(nodeExpected, nodeResult);
                Assert.assertEquals(nodeExpected.getNorth(), nodeResult.getNorth());
                Assert.assertEquals(nodeExpected.getWest(), nodeResult.getWest());
                Assert.assertEquals(nodeExpected.getEast(), nodeResult.getEast());
                Assert.assertEquals(nodeExpected.getSouth(), nodeResult.getSouth());
            }
        }
    }

}
