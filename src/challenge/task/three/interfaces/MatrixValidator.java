package challenge.task.three.interfaces;

/**
 * Interface of MatrixValidator.
 *
 * @author kassi
 *
 */
public interface MatrixValidator {

    /**
     * Method to validate if the data informed to the matrix is valid.
     *
     * @param rowSize
     *            of the matrix
     * @param columnSize
     *            of the matrix
     */
    public void validateMatrix(final int rowSize, final int columnSize);

}
