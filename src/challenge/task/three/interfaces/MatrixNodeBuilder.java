package challenge.task.three.interfaces;

import challenge.task.three.Node;

/**
 * Interface of MatrixNodeBuilder.
 *
 * @author kassi
 *
 */
public interface MatrixNodeBuilder {

    /**
     * Method that creates a matrix of nodes with each weight and its respective
     * neighbors.
     *
     * @param randomNumbers
     *            the list of weights
     * @param rowSize
     *            the row dimension of the matrix
     * @param columnSize
     *            the column dimension of the matrix
     * @return the matrix of nodes with each weight and its respective neighbors.
     */
    public Node[][] createNodes(final int[][] randomNumbers, final int rowSize, final int columnSize);
}
