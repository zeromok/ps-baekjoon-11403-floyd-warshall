package attempts;

/// ## 실수:
/// "i -> j 간선 있으면 1, 없으면 0? 그럼 입력 그대로 출력?"
/// ## 문제:
/// "직접 연결"이 아니라 "경로 존재"를 요구함
public class DirectConnectionOnly {
	// 잘못된 접근: 인접 행렬을 그대로 반환
	public static int[][] solve(int[][] graph) {
		return graph;  // 중간 정점을 거치는 경로 고려 안 함
	}

	public static void main(String[] args) {
		// 포스트 예시: 0 -> 1 -> 2
		int[][] graph = {
			{0, 1, 0},  // 0 -> 1
			{0, 0, 1},  // 1 -> 2
			{0, 0, 0}
		};

		System.out.println("입력:");
		print(graph);

		System.out.println("\n잘못된 출력:");
		int[][] wrong = solve(graph);
		print(wrong);

		System.out.println("\n문제: result[0][2] = 0 (직접 연결 없음)");
		System.out.println("하지만 실제로는 0 -> 1 -> 2 경로 존재!");
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
