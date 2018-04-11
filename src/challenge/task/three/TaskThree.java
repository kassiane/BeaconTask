package challenge.task.three;

import java.util.List;

public class TaskThree {

    public static void main(final String[] args) {
        final int[][] array = { { 6, 3, 5, 2, 0 }, { 4, 8, 5, 7, 1 }, { 3, 9, 4, 2, 3 }, { 4, 3, 7, 1, 1 },
                { 5, 3, 5, 0, 7 } };

        final MatrixNodeBuilder matrixNodeBuilder = new MatrixNodeBuilder();
        final PathCalculator pathCalculator = new PathCalculator(matrixNodeBuilder);

        final List<Path> pathsWithRequiredSum = pathCalculator.calculatePaths(21, 5, 5, array);

        System.out.println("Size: " + pathsWithRequiredSum.size());
        for (int i = 0; i < pathsWithRequiredSum.size(); i++) {
            System.out.println(pathsWithRequiredSum.get(i));
        }
    }

}
