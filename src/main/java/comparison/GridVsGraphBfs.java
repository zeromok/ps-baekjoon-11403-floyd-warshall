package comparison;

import java.util.LinkedList;
import java.util.Queue;

/// ## "격자 탐색 vs 그래프 탐색"
/// ### 핵심 차이:
/// - 격자: 좌표 (행, 열) 기반
/// - 그래프: 정점 번호 기반
public class GridVsGraphBfs {

	/// ### "격자 BFS (미로)" 예시
	/// #### 특징:
	/// - 위치 표현: 좌표 (행, 열)
	/// - 이동 방향: 상하좌우
	/// - 큐 저장: (행, 열)
	/// - visited: `boolean[][]`
	public static void gridBfs(int[][] grid, int startX, int startY) {
		System.out.println("=== 격자 BFS (미로 탐색) ===\n");

		int rows = grid.length;
		int cols = grid[0].length;
		boolean[][] visited = new boolean[rows][cols];
		Queue<int[]> queue = new LinkedList<>();

		queue.offer(new int[]{startX, startY});  // 좌표 저장
		visited[startX][startY] = true;

		int[] dx = {-1, 1, 0, 0};  // 상하좌우
		int[] dy = {0, 0, -1, 1};

		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			int x = pos[0], y = pos[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < rows && ny >= 0 && ny < cols
					&& !visited[nx][ny] && grid[nx][ny] == 1) {
					queue.offer(new int[]{nx, ny});
					visited[nx][ny] = true;
				}
			}
		}
	}

	/// ### "그래프 BFS" 예시
	/// #### 특징:
	/// - 위치 표현: 정점 번호
	/// - 이동 방향: 인접 행렬 참조
	/// - 큐 저장: 정점 번호
	/// - visited: `boolean[]`
	public static void graphBfs(int[][] adjacencyMatrix, int start) {
		System.out.println("\n=== 그래프 BFS ===\n");

		int N = adjacencyMatrix.length;
		boolean[] visited = new boolean[N];
		Queue<Integer> queue = new LinkedList<>();

		queue.offer(start);  // 정점 번호 저장
		visited[start] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();

			// 인접 행렬 참조
			for (int next = 0; next < N; next++) {
				if (adjacencyMatrix[current][next] == 1 && !visited[next]) {
					queue.offer(next);
					visited[next] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		// 격자 예시
		int[][] grid = {
			{1, 1, 0},
			{0, 1, 1},
			{0, 0, 1}
		};
		gridBfs(grid, 0, 0);

		// 그래프 예시
		int[][] graph = {
			{0, 1, 0},
			{0, 0, 1},
			{0, 0, 0}
		};
		graphBfs(graph, 0);
	}
}