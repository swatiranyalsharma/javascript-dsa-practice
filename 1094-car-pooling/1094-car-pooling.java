class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] prefix = new int[1001];
        for(int i=0;i<trips.length;i++){
            int c = trips[i][0];
            int p = trips[i][1];
            int d = trips[i][2];
            prefix[p] = prefix[p] +c;
            prefix[d] = prefix[d] - c;
        }
        for(int i=0; i<prefix.length;i++){
            if(i!=0) prefix[i] = prefix[i-1] + prefix[i];
            if(prefix[i] > capacity) return false;
        }
        return true;
    }
}