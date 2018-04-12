package challenge.task.three;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import challenge.task.three.interfaces.MatrixNodeBuilder;
import challenge.task.three.mocks.MatrixNodeBuilderMock;

/**
 * Class that tests {@link PathCalculator}.
 * 
 * @author kassi
 *
 */
public class PathCalculatorTest {

    @Test
    public void calculatePathWithZeroReturns() {

        final MatrixNodeBuilder nodeBuilder = new MatrixNodeBuilderMock();
        final PathCalculator subject = new PathCalculator(nodeBuilder);

        final List<Path> result = subject.calculatePaths(200, 3, null);

        Assert.assertEquals(0, result.size());

    }

    @Test
    public void calculatePathWithFourReturns() {

        final MatrixNodeBuilder nodeBuilder = new MatrixNodeBuilderMock();
        final PathCalculator subject = new PathCalculator(nodeBuilder);

        final List<Path> result = subject.calculatePaths(5, 3, null);

        Assert.assertEquals(4, result.size());
    }

    @Test
    public void calculatePathWithTwoReturns() {

        final MatrixNodeBuilder nodeBuilder = new MatrixNodeBuilderMock();
        final PathCalculator subject = new PathCalculator(nodeBuilder);

        final List<Path> result = subject.calculatePaths(3, 3, null);

        Assert.assertEquals(2, result.size());
    }
}
