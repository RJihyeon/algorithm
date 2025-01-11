import sys 
input = sys.stdin.read
data = input().splitlines() 
K, N = map(int,data[0].split())
lan_cables = list(map(int,data[1:]))



# 이분 탐색 초기값 
start = 1
end = max(lan_cables)

result = 0 


while start<=end: 
    mid = (start+end)//2 # 중간길이 
    count = sum (cable // mid for cable in lan_cables) # mid 길이로 자른 랜선의 개수 계산하기 

    if count >=N: # 필요한 개수 이상일 경우 
        result = mid
        start = mid + 1
    else:  # 필요한 개수보다 적게 만들면 
        end =mid-1 # 더 짧은 길이 탐색해보기 

print(result)