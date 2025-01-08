from collections import deque

def main():
    import sys
    input = sys.stdin.read #한번에 읽기 
    commands = input().splitlines() #input 줄로 쪼개기
    num=int(commands[0])
    queue=deque()
    
    for i in range(1,num+1):
        inst = commands[i]
        if inst.startswith("push"):
            _, value = inst.split()
            queue.append(int(value))
        elif inst=='front': 
            print(queue[0] if queue else -1)
        elif inst=='back':
            print(queue[-1] if queue else -1)
        elif inst=='pop':
            print(queue.popleft() if queue else -1)
        elif inst=='size':
            print(len(queue))
        elif inst=='empty':
            print(1 if not queue else 0)

if __name__=="__main__":
    main()