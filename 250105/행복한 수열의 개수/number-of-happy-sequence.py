n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

answer = 0
# Write your code here!
for i in range(n):
    row = 0
    col = 0
    prev1 = [0, 0]
    prev2 = [0, 0]
    chk1 = 0
    chk2 = 0
    for j in range(n):
        if m == 1:
            chk1 = 1
            chk2 = 1
            continue
            
        if prev1[0] == 0:
            prev1[0] = grid[i][j]
            prev1[1] = 1

        else:
            if prev1[0] == grid[i][j]:
                prev1[1] += 1
                if prev1[1] == m:
                    chk1 = 1
        
            else:
                prev1[0] = grid[i][j]
                prev1[1] = 1

        if prev2[0] == 0:
            prev2[0] = grid[j][i]
            prev2[1] = 1

        else:
            if prev2[0] == grid[j][i]:
                prev2[1] += 1
                if prev2[1] == m:
                    chk2 = 1

            else:
                prev2[0] = grid[j][i]
                prev2[1] = 1

    answer += chk1 + chk2

print(answer)
