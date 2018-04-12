package challenge.task.three;

import org.junit.Test;

import challenge.task.three.interfaces.MatrixValidator;

/**
 * Class that tests {@link MatrixValidatorImpl}.
 * 
 * @author kassi
 *
 */
public class MatrixValidatorTest {
    @Test(expected = IllegalArgumentException.class)
    public void createNodesWithZeroRows() {
        final MatrixValidator subject = new MatrixValidatorImpl();

        subject.validateMatrix(0, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createNodesWithZeroColumns() {
        final MatrixValidator subject = new MatrixValidatorImpl();

        subject.validateMatrix(2, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createNodesWithNegativeRow() {
        final MatrixValidator subject = new MatrixValidatorImpl();

        subject.validateMatrix(-2, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createNodesWithNegativeColumn() {
        final MatrixValidator subject = new MatrixValidatorImpl();

        subject.validateMatrix(2, -1);
    }

}
