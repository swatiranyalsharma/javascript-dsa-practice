class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: t.toCharArray()){
            map.put(ch,map.getOrDefault(ch, 0) + 1);
        }
        int minLength = Integer.MAX_VALUE;
        int count = map.size();
        int i=0;
        int start =0;
        int j=0;
        while( j<s.length()){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch,map.getOrDefault(ch, 0) -1);
                if(map.get(ch) == 0){
                    count--;
                }
            }
            while(count == 0){
                if(j-i+1 < minLength){
                    minLength = j-i+1;
                    start = i;
                }
                char left = s.charAt(i);
                if(map.containsKey(left)){
                    map.put(left,map.getOrDefault(left, 0) +1);
                    if(map.get(left) == 1){
                        count++;
                    }
                }
                i++;
            }
            j++;
        }
        if(minLength == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start,start+ minLength);
    }
}