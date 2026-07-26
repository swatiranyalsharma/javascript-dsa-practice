class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int i=0;
        int j=0;
        HashSet<Character> set = new HashSet<>();
        while(i<s.length()){
            Character ch = s.charAt(i);
           
            if(!set.contains(ch)){
                length = Math.max(length, i-j+1);
            }else{
                
                while(s.charAt(j) != (ch)){
                    set.remove(s.charAt(j));
                    j++;
                }
                set.remove(s.charAt(j));
                j++;
            }
              set.add(ch);
            i++;
        }
        return length;
    }
}