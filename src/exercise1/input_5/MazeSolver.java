package exercise1.input_5;

import java.util.LinkedList;
import java.util.Queue;

public class MazeSolver {
    private int[][] matrix; // Ma trận
    private int m; // Số hàng
    private int n; // Số cột

    public MazeSolver(int[][] matrix) {
        this.matrix = matrix;
        this.m = matrix.length;
        this.n = matrix[0].length;
    }

    public void solve(int startX, int startY, int destX, int destY) {
        if (!isValid(startX, startY) || !isValid(destX, destY)) {
            System.out.println("Invalid start or destination point.");
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; // Các hướng đi (lên, trái, xuống, phải)

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x == destX && y == destY) {
                matrix[x][y] = 999; // Gán giá trị đặc biệt cho điểm đích để đánh dấu
                break;
            }

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (isValid(newX, newY) && matrix[newX][newY] == 0) {
                    queue.add(new int[]{newX, newY});
                    matrix[newX][newY] = matrix[x][y] + 1; // Gán giá trị từng điểm để đánh dấu
                }
            }
        }

        if (matrix[destX][destY] == 999) {
            System.out.println("Path found!");
            // In ma trận sau khi tìm được đường đi
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + "\t");
                }
                System.out.println();
            }
        } else {
            System.out.println("No path found!");
        }
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
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

