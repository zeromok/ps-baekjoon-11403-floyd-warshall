package impl;

/// ## 플로이드-워셜 구현
/// ### 핵심:
/// - i -> j 경로 = i -> k -> j (k를 중간 정점으로)
/// - if(i -> k 가능 && k -> j 가능) = i -> j 가능
public class FloydWarshall {

	/// ### 왜 k를 가장 바깥 루프에 두는지?
	/// k는 "중간 정점으로 사용 가능한 정점"을 점진적으로 확장
	/// k=0: 직접 연결만
	/// k=1: 정점 0을 거쳐갈 수 있는 경로 추가
	/// k=2: 정점 0,1을 거쳐갈 수 있는 경로 추가
	public static int[][] findAllPaths(int[][] graph) {
		int N = graph.length;
		int[][] result = new int[N][N];

		// 원본 복사 (포스트: "결과 배열 분리" 섹션)
		for (int i = 0; i < N; i++) {
			result[i] = graph[i].clone();
		}

		// k를 가장 바깥 루프
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (result[i][k] == 1 && result[k][j] == 1) {
						result[i][j] = 1;
					}
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[][] graph = {
			{0, 1, 0},
			{0, 0, 1},
			{0, 0, 0}
		};

		System.out.println("입력:");
		print(graph);

		System.out.println("\n플로이드-워셜 결과:");
		int[][] result = findAllPaths(graph);
		print(result);

		System.out.println("\n확인: result[0][2] = " + result[0][2] + " (0 -> 1 -> 2 경로 존재)");
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
