import java.util.Scanner;

public class Main {
    static int recursiveCount = 0;

    // 재귀적으로 피보나치 수 계산 (n=1 또는 n=2 조건을 만날 때마다 호출 횟수를 증가)
    public static int fibRecursive(int n) {
        if (n == 1 || n == 2) {
            recursiveCount++;
            return 1;
        } else {
            return fibRecursive(n - 1) + fibRecursive(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 재귀적 방법으로 호출 횟수 계산 (코드1 실행 횟수)
        fibRecursive(n);

        // 동적 계획법 방법의 연산 횟수는 n-2로 고정 (코드2 실행 횟수)
        int dpCount = n - 2;

        // 결과 출력: 코드1 실행 횟수와 코드2 실행 횟수
        System.out.println(recursiveCount + " " + dpCount);
    }
}
