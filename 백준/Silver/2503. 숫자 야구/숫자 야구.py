from itertools import permutations

def count_strike_and_ball(guess, target):
    """스트라이크와 볼 계산"""
    strike =0
    ball =0
    for i in range(3):
        ## 요 부분이 대조하는 중요 로직
        if guess[i]==target[i]:
            strike +=1
        elif guess[i] in target:
            ball+=1
    return strike, ball 

def main():
    import sys
    input = sys.stdin.read
    data= input().splitlines()
    n=int(data[0])
    questions=[]

    for i in range(1,n+1):
        question, s, b = data[i].split()
        questions.append((question, int(s), int(b)))

    # 가능한 숫자 조합의 생성
    ## 중복되지 앉는 3자리 숫자 조합 생성. 이를 문자열로 변환하여 리스트로 만들기
    possible_numbers=list(map(''.join, permutations('123456789',3)))

    ## 모든 가능한 숫자들과 질문들을 비교한 다음에, 답변의 strike, ball 과 모두 다 정확히 일치하는 경우 valid 숫자로 적용 
    valid_count =0
    for candidate in possible_numbers:
        valid = True
        for question, s, b in questions: 
            strike, ball = count_strike_and_ball(candidate, question)
            if strike != s or ball != b: 
                valid = False
                break
        if valid : 
            valid_count+=1

    print(valid_count)

if __name__=='__main__':
    main()