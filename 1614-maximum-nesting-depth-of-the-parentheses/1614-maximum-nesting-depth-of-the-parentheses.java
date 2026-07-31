class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int maxCount = Integer.MIN_VALUE; 
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                count++;
            }else if(ch == ')'){
                count--;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}