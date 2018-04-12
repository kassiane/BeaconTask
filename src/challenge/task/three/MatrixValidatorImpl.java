package challenge.task.three;

import challenge.task.three.interfaces.MatrixValidator;

/**
 * Class that validates the data informed to the matrix.
 *
 * @author kassi
 *
 */
public class MatrixValidatorImpl implements MatrixValidator {

    @Override
    public void validateMatrix(final int rowSize, final int columnSize) {
        if (rowSize <= 0 || columnSize <= 0) {
            throw new IllegalArgumentException("The size of rows and columns should be greater than zero.");
        }
    }
}
