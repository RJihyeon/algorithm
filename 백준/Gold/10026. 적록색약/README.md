# [Gold V] 적록색약 - 10026 

[문제 링크](https://www.acmicpc.net/problem/10026) 

### 성능 요약

메모리: 16444 KB, 시간: 132 ms

### 분류

그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색, 격자 그래프

### 제출 일자

2025년 7월 2일 23:27:23

### 문제 설명

<p>적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못한다. 따라서, 적록색약인 사람이 보는 그림은 아닌 사람이 보는 그림과는 좀 다를 수 있다.</p>

<p>크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다. 그림은 몇 개의 구역으로 나뉘어져 있는데, 구역은 같은 색으로 이루어져 있다. 또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다. (색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 한다)</p>

<p>예를 들어, 그림이 아래와 같은 경우에</p>

<pre>RRRBB
GGBBB
BBBRR
BBRRR
RRRRR</pre>

<p>적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다. (빨강 2, 파랑 1, 초록 1) 하지만, 적록색약인 사람은 구역을 3개 볼 수 있다. (빨강-초록 2, 파랑 1)</p>

<p>그림이 입력으로 주어졌을 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100)</p>

<p>둘째 줄부터 N개 줄에는 그림이 주어진다.</p>

### 출력 

 <p>적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의 구역의 수를 공백으로 구분해 출력한다.</p>


### 배운 점
```markdown
💡 10026 DFS/BFS 구현 시 주의 포인트

[syntax]
✅ `new boolean[N][N]` 하면 `visited`는 자동으로 `false`로 초기화된다.  
✅ NullPointerException은 `new boolean[N][]` 같이 행을 초기화 안 하면 발생함.  
✅ `visited` 배열 초기화는 `Arrays.fill(visited[i], false)`로 각 행을 초기화하면 편하다.  

[semantic]
✅ DFS는 하나의 구역(connected component)을 탐색하는 함수로 설계해야 함.  
✅ 전체 map을 돌면서 방문 안 한 지점에서 DFS를 새로 시작해야 구역을 카운트할 수 있다.  
✅ ❗ DFS 메서드 내부에 전체 map을 순회하는 반복문을 넣으면 구조가 꼬이고 잘못된 탐색을 하게 된다.  
✅ 색약 처리 DFS에서는 `R/G`를 같은 색으로 취급하도록 조건문을 작성해야 한다.  
✅ ❗ `Point(Pointer)` 클래스는 BFS 같은 경우 유용하지만 DFS에서는 좌표 `int x, y`로 처리하면 충분하다.  
```

