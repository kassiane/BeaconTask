package challenge.task.three;

import org.junit.Assert;
import org.junit.Test;

/**
 * Class that tests {@link MatrixNodeBuilder}.
 *
 * @author kassi
 *
 */
public class MatrixNodeBuilderTest {

    @Test(expected = IllegalArgumentException.class)
    public void createNodesWithZeroRows() {
        final MatrixNodeBuilder subject = new MatrixNodeBuilder();
        final int[][] randomNumbers = { { 0, 1, 2 }, { 2, 3, 4 } };

        subject.createNodes(randomNumbers, 0, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createNodesWithZeroColumns() {
        final MatrixNodeBuilder subject = new MatrixNodeBuilder();
        final int[][] randomNumbers = { { 0, 1, 2 }, { 2, 3, 4 } };

        subject.createNodes(randomNumbers, 2, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createNodesWithNullMatrix() {
        final MatrixNodeBuilder subject = new MatrixNodeBuilder();

        subject.createNodes(null, 2, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createNodesWithEmptyMatrix() {
        final MatrixNodeBuilder subject = new MatrixNodeBuilder();
        final int[][] randomNumbers = { {}, {} };

        subject.createNodes(randomNumbers, 2, 0);
    }

    @Test
    public void createValidNodes() {
        final MatrixNodeBuilder subject = new MatrixNodeBuilder();
        final Node[][] expected = createExpectedNodeMatrix();

        final int[][] randomNumbers = { { 0, 1, 2 }, { 2, 3, 4 } };
        final int rowSize = 2;
        final int columnSize = 3;
        final Node[][] result = subject.createNodes(randomNumbers, rowSize, columnSize);

        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++) {
                Assert.assertEquals(expected[row][column], result[row][column]);
            }
        }
    }

    private Node[][] createExpectedNodeMatrix() {
        final Node nodeZero = new Node(0, 0, 0);
        final Node nodeOne = new Node(1, 0, 1);
        final Node nodeTwo = new Node(2, 0, 2);
        final Node nodeThree = new Node(2, 1, 0);
        final Node nodeFour = new Node(3, 1, 1);
        final Node nodeFive = new Node(4, 1, 2);

        final Node[][] expected = { { nodeZero, nodeOne, nodeTwo }, { nodeThree, nodeFour, nodeFive } };
        return expected;
    }

}
