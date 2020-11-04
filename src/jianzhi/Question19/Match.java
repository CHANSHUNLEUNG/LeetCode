package jianzhi.Question19;

public class Match {
    public boolean match(char[] str, char[] pattern)
    {
        int x = str.length-1;
        int y = pattern.length-1;
        while(x>=0 || y>=0){
            int c = str[x];
            int p = pattern[y];
            if(p == '.'){

            }else if(p == '*'){

            }else{
                x--;
                y--;
            }
        }

        return true;
    }
}
