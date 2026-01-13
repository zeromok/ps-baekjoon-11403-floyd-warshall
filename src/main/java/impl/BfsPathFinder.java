package impl;

import java.util.LinkedList;
import java.util.Queue;

/// ## BFS 구현
/// ### 특징:
/// - `Queue + visited[]` 사용
/// - 각 정점에서 BFS 실행
/// - 레벨별로 탐색
public class BfsPathFinder {

	public static int[][] findAllPaths(int[][] graph) {
		int N = graph.length;
		int[][] result = new int[N][N];

		// 모든 정점에 대해 BFS 실행
		for (int start = 0; start < N; start++) {
			bfs(graph, start, result);
		}

		return result;
	}

	private static void bfs(int[][] graph, int start, int[][] result) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[graph.length];

		// start와 직접 연결된 정점들
		for (int j = 0; j < graph.length; j++) {
			if (graph[start][j] == 1) {
				queue.offer(j);
				visited[j] = true;
				result[start][j] = 1;
			}
		}

		// BFS 탐색
		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int next = 0; next < graph.length; next++) {
				if (graph[current][next] == 1 && !visited[next]) {
					queue.offer(next);
					visited[next] = true;
					result[start][next] = 1;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] graph = {
			{0, 1, 0},
			{0, 0, 1},
			{0, 0, 0}
		};

		System.out.println("BFS 결과:");
		int[][] result = findAllPaths(graph);
		print(result);
	}

	private static void print(int[][] matrix) {
		for (int[] row : matrix) {
			for (int val : row) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}
}
