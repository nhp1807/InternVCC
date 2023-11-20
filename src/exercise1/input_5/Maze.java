package exercise1.input_5;

import java.awt.*;
import java.util.LinkedList;
import javax.swing.*;
import java.util.Queue;

public class Maze {
	public static void main(String[] args) {
		//
		JFrame frame = new JFrame();
		frame.setSize(650, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MazePanel mp = new MazePanel();
		frame.add(mp);
		frame.setVisible(true);
	}

	public static class MazePanel extends JPanel {
		private static final long serialVersionUID = -566807999447681130L;
		private int[][] maze = { // khởi tạo ma trận mảng 2 chiều
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
				{ 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
				{ 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1 },
				{ 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 2, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1 },
				{ 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
		private int sizeh, sizew, start, end;

		public MazePanel() {
			// Kích thước ma trận
			sizeh = 21;
			sizew = 31;
			start = 10;
			end = 0;
			solve();
			repaint(); // vẽ ma trận và lời giải
		}

		/**
		 * Implement một phương pháp tìm đường nào đó.
		 * <p>
		 * Yêu cầu : Vẽ đường đi từ điểm bắt đầu đến điểm kết thúc. Không hiện
		 * các phần thừa - là các phần đường cụt hoặc đường đi bị sai. Chỉ vẽ
		 * tuyến đường chính đi từ điểm đầu (màu vàng) đến màu đỏ.
		 * <p>
		 * Đường đi từ điểm đầu đến điểm cuối được tô màu xanh dương, để tô màu
		 * xanh dương hãy set giá trị của điểm trên ma trận sang một số > 2
		 */
		public void solve() {
			// Hàm này chứa phương pháp tìm đường từ điểm start đến vị
			// trí màu đỏ trên ma trận
			dfs(start, end);
//            boolean foundPath = dfs(start, end);
		}

		private boolean isValid(int x, int y) {
			return x >= 0 && x < sizeh && y >= 0 && y < sizew;
		}

		private boolean dfs(int x, int y) {
			// Kiểm tra xem đã đến điểm cuối chưa
			if (maze[x][y] == 2) {
//                maze[x][y] = 2; // Đánh dấu đường đi
				return true;
			}
			if (isValidMove(x, y)) {
				maze[x][y] = 3; // Đánh dấu đường đi
				//Dưới
				if (dfs(x + 1, y))
					return true;
				//Lên trên
				if (dfs(x - 1, y))
					return true;
				//Phải
				if (dfs(x, y + 1))
					return true;
				//Trái
				if (dfs(x, y - 1))
					return true;
				// Không có đường đi nào từ vị trí hiện tại thi quay lui
				maze[x][y] = 0;  // Bỏ đánh dấu
			}

			return false;
		}
		private boolean isValidMove(int x, int y) {
			if (maze[x][y] == 2) {
//                maze[x][y] = 2; // Đánh dấu đường đi
				return true;
			}
			// Kiểm tra xem vị trí có hợp lệ không
			return x >= 0 && x < sizeh && y >= 0 && y < sizew && maze[x][y] == 0;

		}

		public void paintComponent(Graphics g) // vẽ ma trận + lời giải
		{
			super.paintComponent(g);
			for (int j = 0; j < sizew; j++)
				for (int i = 0; i < sizeh; i++) {
					if (i == start && j == end)
						g.setColor(Color.yellow);
					else if (maze[i][j] == 0)
						g.setColor(Color.white);
					else if (maze[i][j] == 1)
						g.setColor(Color.black);
					else if (maze[i][j] == 2)
						g.setColor(Color.red);
					else
						g.setColor(Color.blue); // blue là màu của lời giải
					g.fillRect(j * 20, i * 20, 20, 20);
				}
		}
	}
}
