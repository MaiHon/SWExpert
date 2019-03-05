def battery(idx, cnt):
    if idx == N-1:
        ans.append(cnt-1)
        return
    else:
        for i in range(M[idx], 0, -1):
            if idx+i > N-1: continue
            if C[idx+i]: continue
            if idx+i< N-1: C[idx+i] = True
            battery(idx+i, cnt+1)


T = int(input())

for test_case in range(1, T + 1):

    total_list = [i for i in map(int, input().split())]

    N = total_list[0]
    M = total_list[1:len(total_list)]
    C = [False for i in range(N)]
    ans = []

    battery(0, 0)
    print("#" + str(test_case) + " " + str(min(ans)))
