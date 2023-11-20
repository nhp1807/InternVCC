package exercise1.input_5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MazeSolver {
    private int[][] matrix;
    private int rows;
    private int cols;

    public MazeSolver(int[][] matrix) {
        this.matrix = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
    }

    public void solve(int startX, int startY, int destX, int destY) {
        if (!isValid(startX, startY) || !isValid(destX, destY)) {
            System.out.println("Invalid start or destination point.");
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; // Up, Left, Down, Right

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x == destX && y == destY) {
                System.out.println("Shortest path found!");
                printPath(startX, startY, destX, destY);
                break;
            }

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (isValid(newX, newY) && matrix[newX][newY] == 0) {
                    queue.add(new int[]{newX, newY});
                    matrix[newX][newY] = matrix[x][y] + 1; // Set the distance from start
                }
            }
        }

        if (matrix[destX][destY] == 0) {
            System.out.println("No path found!");
        }
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    private void printPath(int startX, int startY, int destX, int destY) {
        Stack<int[]> stack = new Stack<>();
        int[] dest = {destX, destY};
        stack.push(dest);

        int x = destX;
        int y = destY;
        int dist = matrix[destX][destY];
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; // Up, Left, Down, Right

        while (!(x == startX && y == startY)) {
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (isValid(newX, newY) && matrix[newX][newY] == dist - 1) {
                    int[] current = {newX, newY};
                    stack.push(current);
                    x = newX;
                    y = newY;
                    dist--;
                    break;
                }
            }
        }

        System.out.println("Path from start to destination:");
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            System.out.println("(" + current[0] + ", " + current[1] + ")");
        }
    }

    public static void main(String[] args) {
        int[][] maze = {
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 2}
        };

        MazeSolver solver = new MazeSolver(maze);
        solver.solve(0, 0, 4, 4);
    }
}