from collections import deque
import sys
input = sys.stdin.readline


def bfs(s_bomb):
    queue = deque()
    queue.append((s_bomb, 1))
    visited = set()
    visited.add(s_bomb)
    cnt = 1

    while queue:
        bomb, bomb_range = queue.popleft()
        for n_bomb in range(bomb - bomb_range, bomb):
            if 0 <= n_bomb <= max_bombs and n_bomb not in visited and n_bomb in bombs:
                queue.append((n_bomb, bomb_range + 1))
                visited.add(n_bomb)
                cnt += 1
                
        for n_bomb in range(bomb + bomb_range, bomb, -1):
            if 0 <= n_bomb <= max_bombs and n_bomb not in visited and n_bomb in bombs:
                queue.append((n_bomb, bomb_range + 1))
                visited.add(n_bomb)
                cnt += 1
                
    return cnt


N = int(input())
bombs = set(int(input()) for _ in range(N))
answer = 0
max_bombs = max(bombs)

for bomb in bombs:
    answer = max(answer, bfs(bomb))

print(answer)