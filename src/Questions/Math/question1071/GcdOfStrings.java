package Questions.Math.question1071;

public class GcdOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        if (str2.length() > str1.length()) {
            return gcdOfStrings(str2, str1);
        }
        if (str2.equals("")) {
            return str1;
        }
        if (!str1.substring(0, str2.length()).equals(str2)) {
            return "";
        }
        return gcdOfStrings(str1.substring(str2.length()), str2);
    }
    public static void main(String[] argv){
        System.out.println();
    }
}
