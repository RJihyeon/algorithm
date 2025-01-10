from collections import Counter

def main(): 
    import sys 
    data = sys.stdin.read().splitlines()

    # 숫자 카드 입력
    numbers=data[1].split()
    criteria = data[3].split()

    counter = Counter(numbers)

    # 결과를 필터링 해서 저장 
    result = [counter[c] for c in criteria]

    print(' '.join(map(str, result)))

if __name__ == '__main__':
    main()