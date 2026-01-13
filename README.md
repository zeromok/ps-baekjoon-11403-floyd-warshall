# 백준 11403 - 경로 찾기: 플로이드-워셜의 본질

[![문제 링크](https://img.shields.io/badge/Baekjoon-11403-blue)](https://www.acmicpc.net/problem/11403)
[![블로그 포스트](https://img.shields.io/badge/Blog-Read%20Full%20Story-green)](https://b-mokk.tistory.com/88)

## 📊 알고리즘 비교

| 접근법 | 시간복잡도 | 공간복잡도 | 코드 길이 | 결과 |
|--------|-----------|-----------|----------|------|
| 직접 연결만 확인 | O(1) | O(N²) | 1줄 | ❌ 중간 정점 경로 누락 |
| BFS | O(N × (V + E)) = O(N³) | O(N²) + O(N) | ~20줄 | ✅ 통과 |
| 플로이드-워셜 | O(N³) | O(N²) | ~3줄 | ✅ 통과 |

**핵심: 직접 연결이 아닌 "경로 존재"를 구하는 문제**

## 🎯 핵심 개념

- **Floyd-Warshall Algorithm (플로이드-워셜)**
    - 모든 정점 쌍의 경로 존재 여부 계산
    - 중간 정점을 점진적으로 추가하며 경로 확장
    - k를 가장 바깥 루프에 두는 이유: 동적 프로그래밍의 점진적 확장

- **경로 존재 vs 직접 연결**
    - 직접 연결: `graph[i][j] = 1` (간선 존재)
    - 경로 존재: `i -> k -> j` (중간 정점을 거쳐도 됨)

## 📂 코드 구조

### 시행착오 과정
1. **[DirectConnectionOnly.java](src/main/java/attempts/DirectConnectionOnly.java)**
    - 첫인상 실수: "i -> j 간선 있으면 1, 없으면 0? 그럼 입력 그대로 출력?"
    - 실패 이유: 직접 연결만 확인하여 중간 정점을 거치는 경로 누락
    - 예시: `graph[0][1]=1, graph[1][2]=1` → `result[0][2]`는 1이어야 함

### 구현 비교
2. **[BfsPathFinder.java](src/main/java/impl/BfsPathFinder.java)**
    - BFS 기반 경로 탐색
    - 장점: 직관적, 레벨별 탐색
    - 단점: Queue + visited[] 필요, 코드 길이

3. **[FloydWarshall.java](src/main/java/impl/FloydWarshall.java)**
    - 플로이드-워셜 알고리즘
    - 장점: 간결한 코드, 인접 행렬만 사용
    - 단점: 시간복잡도 O(N³) (BFS와 동일)

### 개념 비교
4. **[AdjacencyMatrixVsGraphSearch.java](src/main/java/comparison/AdjacencyMatrixVsGraphSearch.java)**
    - 인접 행렬: 그래프를 "저장"하는 방식 (2차원 배열)
    - 그래프 탐색: 그래프를 "순회"하는 방식 (정점 방문)

5. **[GridVsGraphBfs.java](src/main/java/comparison/GridVsGraphBfs.java)**
    - 격자 탐색: 좌표 (행, 열) 기반, `Queue<int[]>`, `boolean[][]`
    - 그래프 탐색: 정점 번호 기반, `Queue<Integer>`, `boolean[]`

### 최종 해결
- **[FloydWarshall.java](src/main/java/solution/FloydWarshall.java)**
    - 백준 제출용 최종 솔루션
    - 원본 배열 직접 수정 (결과만 출력하므로 원본 보존 불필요)
    - 포인터 이동 순서: k(중간 정점) → i(시작) → j(끝)

## 💡 배운 것들

### 1. 문제 재해석
```
Before: "graph[i][j] = 1이면 경로 존재"
After:  "graph[i][j] = 1 또는 i -> k -> j 경로 존재"
```

### 2. k를 가장 바깥 루프에 두는 이유
```
k=0: 중간 정점 없이 직접 연결만
k=1: 정점 0을 거쳐갈 수 있는 경로 추가
k=2: 정점 0,1을 거쳐갈 수 있는 경로 추가
→ 점진적으로 경로 집합 확장 (동적 프로그래밍)
```

### 3. 인접 행렬 vs 그래프 탐색
- **인접 행렬**: 데이터 저장 (2차원 배열)
- **그래프 탐색**: 정점을 방문하는 순회 (1차원 개념)
- 배열의 칸을 방문하는 게 아니라, 정점을 방문함

### 4. 격자 탐색 vs 그래프 탐색
- **격자**: 좌표 (행, 열), `Queue<int[]>`, `boolean[][]`
- **그래프**: 정점 번호, `Queue<Integer>`, `boolean[]`

## 🔍 핵심 아이디어

### 플로이드-워셜 알고리즘
```java
// 핵심: i -> j 경로 = i -> k -> j (k를 중간 정점으로)
if (graph[i][k] == 1 && graph[k][j] == 1) {
    graph[i][j] = 1;  // i -> j 경로 존재
}
```

### 왜 k를 가장 바깥 루프에?
- k는 "중간 정점으로 사용 가능한 정점 집합"을 점진적으로 확장
- k를 안쪽에 두면 아직 계산되지 않은 경로를 참조할 수 있음
- 동적 프로그래밍의 점진적 확장 원칙

## 📝 전체 해결 과정

전체 문제 해결 과정은 블로그 포스트에서 확인할 수 있습니다:
👉 **[블로그 포스트](https://b-mokk.tistory.com/88)**

## 🔗 관련 링크

- [백준 11403번 문제](https://www.acmicpc.net/problem/11403)
- [블로그 포스트](https://b-mokk.tistory.com/88)

---

**Keywords**: `Floyd-Warshall`, `Graph Theory`, `Path Finding`, `Dynamic Programming`, `BFS`, `Adjacency Matrix`, `All Pairs Shortest Path`
