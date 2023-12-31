# [Codetree] 색맹

import sys
from collections import deque
input = sys.stdin.readline


def bfs(sy, sx, scb_type):
    queue = deque()
    queue.append((sy, sx, scb_type))

    while queue:
        y, x, cb_type = queue.popleft()
        
        for dy, dx in direction:
            ny, nx = y + dy, x + dx

            if 0 <= ny < N and 0 <= nx < N:
                if cb_type == "non_cb":
                    if not visited[ny][nx] and matrix[y][x] == matrix[ny][nx]:
                        visited[ny][nx] = True
                        queue.append((ny, nx, cb_type))
                else:
                    if not cb_visited[ny][nx]:
                        if (matrix[y][x] in ["R", "G"] and matrix[ny][nx] in ["R", "G"]) or matrix[y][x] == matrix[ny][nx]:
                            cb_visited[ny][nx] = True
                            queue.append((ny, nx, cb_type))

N = int(input())
matrix = [input() for _ in range(N)]
visited = [[False] * N for _ in range(N)]
cb_visited = [[False] * N for _ in range(N)]
cnt, cb_cnt = 0, 0

direction = [(-1, 0), (0, -1), (1, 0), (0, 1)]

for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            visited[i][j] = True
            bfs(i, j, "non_cb")
            cnt += 1
        
        if not cb_visited[i][j]:
            cb_visited[i][j] = True
            bfs(i, j, "cb")
            cb_cnt += 1

print(cnt, cb_cnt)