def main():
    import sys
    input=sys.stdin.read
    lines=input().splitlines()
    num=int(lines[0])
    result=[]

    ## result 초기화
    for i in range(1,num+1):
        if lines[i] in result: 
            continue
        result.append(lines[i])


    result.sort(key=lambda x: (len(x), x))

    ## 출력
    for word in result: 
        print(word)




if __name__ == '__main__':
    main()