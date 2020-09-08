package Questions.Math.question204;

public class CountPrime {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        System.out.println(n);
        int count = 0;
        for (int number = 2; number < n; number++) {
            if (notPrime[number]) {
                continue;
            }
            count++;
            for (long factor = (long) number * number; factor < n; factor += number) {
                notPrime[(int) factor] = true;
            }
        }

        return count;
    }

    public static void main(String[] argv) {
        System.out.println(new CountPrime().countPrimes(100));
    }
}
