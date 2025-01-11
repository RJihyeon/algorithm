from collections import deque # bfs 를 이용할 것이기 떄문에 queue collection 호출하기 
import sys

input = sys.stdin.read
data = input().splitlines()
N, M = map(int, data[0].split())
graph = [list(map(int, line)) for line in data[1:]]

# BFS 함수 정의 
def bfs(x,y):
    global N, M, graph
    queue = deque([(x,y)]) # 튜플쌍으로 리스트로 만들어서 넣어야함 
    dx = [-1, 1, 0, 0]  
    dy = [0, 0, -1, 1]

    while queue: 
        x, y = queue.popleft() 
        # 상하좌우 탐색하기 
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if 0 <=nx < N and 0 <= ny < M and graph[nx][ny] == 1: 
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx,ny))
    return graph[N-1][M-1]


print(bfs(0,0))