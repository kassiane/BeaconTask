package challenge.task.three.mocks;

import challenge.task.three.Node;
import challenge.task.three.interfaces.MatrixNodeBuilder;

/**
 * Class that mocks {@link MatrixNodeBuilder}.
 * 
 * @author kassi
 *
 */
public class MatrixNodeBuilderMock implements MatrixNodeBuilder {

    @Override
    public Node[][] createNodes(final int[][] randomNumbers, final int rowSize, final int columnSize) {

        // final int[][] array = { { 6, 3, 5, 2, 0 }, { 4, 8, 5, 7, 1 }, { 3, 9, 4, 2, 3
        // }, { 4, 3, 7, 1, 1 },
        // { 5, 3, 5, 0, 7 } };
        // [1 2 3]
        // [4 5 6]
        // [7 8 9]

        final Node nodeOne = new Node(1, 0, 0);
        final Node nodeTwo = new Node(2, 0, 1);
        final Node nodeThree = new Node(3, 0, 2);
        final Node nodeFour = new Node(4, 1, 0);
        final Node nodeFive = new Node(5, 1, 1);
        final Node nodeSix = new Node(6, 1, 2);
        final Node nodeSeven = new Node(7, 2, 0);
        final Node nodeEight = new Node(8, 2, 1);
        final Node nodeNine = new Node(9, 2, 2);

        nodeOne.setEast(nodeTwo);
        nodeOne.setSouth(nodeFour);

        nodeTwo.setWest(nodeOne);
        nodeTwo.setEast(nodeThree);
        nodeTwo.setSouth(nodeFive);

        nodeThree.setWest(nodeTwo);
        nodeThree.setSouth(nodeSix);

        nodeFour.setNorth(nodeOne);
        nodeFour.setEast(nodeFive);
        nodeFour.setSouth(nodeSeven);

        nodeFive.setNorth(nodeTwo);
        nodeFive.setWest(nodeFour);
        nodeFive.setEast(nodeSix);
        nodeFive.setSouth(nodeEight);

        nodeSix.setNorth(nodeThree);
        nodeSix.setWest(nodeFive);
        nodeSix.setSouth(nodeNine);

        nodeSeven.setNorth(nodeFour);
        nodeSeven.setEast(nodeEight);

        nodeEight.setNorth(nodeFive);
        nodeEight.setWest(nodeSeven);
        nodeEight.setEast(nodeNine);

        nodeNine.setNorth(nodeSix);
        nodeNine.setWest(nodeEight);

        final Node[][] nodes = { { nodeOne, nodeTwo, nodeThree }, { nodeFour, nodeFive, nodeSix },
                { nodeSeven, nodeEight, nodeNine } };

        return nodes;
    }

}
