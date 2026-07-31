class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] prefix = new int[1001];
        for(int i=0;i<trips.length;i++){
            int val = trips[i][0];
            int s = trips[i][1];
            int e = trips[i][2];
            prefix[s] = prefix[s]  + val;
            prefix[e] = prefix[e] - val;
        }
        for(int i=0;i<prefix.length;i++){
            if(i!=0) prefix[i] = prefix[i-1] + prefix[i];
            if(prefix[i] > capacity) return false;
        }
        return true;
    }
}