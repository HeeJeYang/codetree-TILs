import sys
input = sys.stdin.readline

n, m, k = map(int, input().split())
for i in range(n):
    answer_line = ""
    line = input()
    for j in range(m):
        answer_line += line[j] * k
    
    for _ in range(k):
        print(answer_line)