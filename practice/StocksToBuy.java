package practice;

public class StocksToBuy {
    private static int findMinDay(int n, int m) {
        int days = 0, i = 0;
        while (m > n) {
            i += 1;
            n = n * 2;
            days = i > 1 ? days + 1 : days;
        }
        return days + n - m;

    }

    public static void main(String[] args) {
        System.out.println(findMinDay(3,4));
        System.out.println(findMinDay(10,1));
        System.out.println(findMinDay(3,35));
    }
}
