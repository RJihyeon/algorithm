import sys

def main():
    input= sys.stdin.read
    commands=input().splitlines()
    num=int(commands[0])
    
    points=[]
    
    for i in range(num):
        x, y=map(int, commands[i+1].split())
        points.append((x,y))
    
    #정렬 시작
    points.sort() # x기준! 
    for x,y in points: 
        print(x, y)
        
        
if __name__=="__main__":
    main()