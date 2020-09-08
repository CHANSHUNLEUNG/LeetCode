package Questions.Math.question168;

public class ConvertToTitle {
    public String convertToTitle(int n) {
        if (n == 0) {
            return "";
        }
        n--;
        return convertToTitle(n / 26) + (char) (n % 26 + 'A');
    }

    public static void main(String[] argv) {
        System.out.println(new ConvertToTitle().convertToTitle(1));
        System.out.println(new ConvertToTitle().convertToTitle(26));
        System.out.println(new ConvertToTitle().convertToTitle(27));
        System.out.println(new ConvertToTitle().convertToTitle(28));
    }
}
