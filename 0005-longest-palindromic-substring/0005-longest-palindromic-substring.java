
class Solution {
    int start=-1;
    int max_s = -1;
    int max_e = -1;
    int end = -1;
    public String longestPalindrome(String s) {
        int maxCount =0;
        for(int k=0;k<s.length();k++){
            //odd centered length
            int oddLength = 2 * palindromeLength(k-1, k+1, s)+1;
            //even centerd length
            if(oddLength > maxCount){
                    maxCount = oddLength;
                    max_s = start;
                    max_e= end;
                }
            int evenLength = 2 * palindromeLength(k, k+1, s);
            if(evenLength > maxCount){
                maxCount = evenLength;
                max_s = start;
                max_e= end;
            }

        }
        StringBuffer sb = new StringBuffer();
        while(max_s<=max_e){     
            sb.append(s.charAt(max_s));
            max_s++;
        }
        return sb.toString();
    }

    public int palindromeLength(int i, int j, String s){
        int count =0;
        while(i>=0 && j< s.length() && s.charAt(i) == s.charAt(j)){
            count++;
            i--;
            j++;
        }
        start = i + 1;
        end = j - 1;
        return count;
    }
}