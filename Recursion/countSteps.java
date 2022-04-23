public static int countSteps(int n) {
    if (n == 1) return 0;

    Integer divide2 = Integer.MAX_VALUE;
    Integer divide3 = Integer.MAX_VALUE;
    Integer sub1 = Integer.MAX_VALUE;

    if (n % 2 == 0) divide2 = countSteps(n / 2);
    if (n % 3 == 0) divide3 = countSteps(n / 3);

    sub1 = countSteps(n - 1);

    return 1 + Math.min(sub1, Math.min(divide2, divide3));
}