package comparison;

/// ## "인접 행렬 vs 그래프 탐색"
/// ### 인접 행렬 `graph[i][j]`:
/// - 그래프를 "저장"하는 방식 (2차원 배열 맞음)
/// - `graph[1][2] = 1` 의미: "정점 1 → 정점 2 간선 존재"
/// ### 그래프 탐색:
/// - 그래프를 "순회"하는 방식
/// - "정점"을 방문하는 것이지, "배열의 칸"을 방문하는 게 아님
public class AdjacencyMatrixVsGraphSearch {

	/**
	 * 인접 행렬: 데이터 저장 방식
	 */
	public static void demonstrateAdjacencyMatrix() {
		System.out.println("=== 인접 행렬: 데이터 저장 ===\n");

		// 인접 행렬: 그래프를 2차원 배열로 저장
		int[][] graph = {
			{0, 1, 0},  // 정점 0 -> 정점 1
			{0, 0, 1},  // 정점 1 -> 정점 2
			{0, 0, 0}
		};

		System.out.println("인접 행렬 (2차원 배열):");
		print(graph);

		System.out.println("\n의미:");
		System.out.println("  graph[0][1] = 1 → 정점 0에서 정점 1로 간선 존재");
		System.out.println("  graph[0][2] = 0 → 정점 0에서 정점 2로 직접 간선 없음");
		System.out.println("  (하지만 0 -> 1 -> 2 경로는 존재)");
	}

	/**
	 * 그래프 탐색: 순회 방식
	 */
	public static void demonstrateGraphSearch() {
		System.out.println("\n=== 그래프 탐색: 순회 방식 ===\n");

		int[][] graph = {
			{0, 1, 0},
			{0, 0, 1},
			{0, 0, 0}
		};

		System.out.println("그래프 탐색 (BFS 예시):");
		System.out.println("  - 정점 0에서 시작");
		System.out.println("  - 정점 0 방문 → 인접 행렬 확인: graph[0][?]");
		System.out.println("  - graph[0][1] = 1 발견 → 정점 1로 이동");
		System.out.println("  - 정점 1 방문 → 인접 행렬 확인: graph[1][?]");
		System.out.println("  - graph[1][2] = 1 발견 → 정점 2로 이동");

		System.out.println("\n핵심 차이:");
		System.out.println("  - 인접 행렬: 데이터 저장 (2차원 배열)");
		System.out.println("  - 그래프 탐색: 정점을 방문하는 순회 (1차원 개념)");
		System.out.println("  - 배열의 칸을 방문하는 게 아니라, 정점을 방문함");
	}

	public static void main(String[] args) {
		demonstrateAdjacencyMatrix();
		demonstrateGraphSearch();
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
