class Solution {
    public int smallestNumber(int n, int t) {
        int i=n;
        int iscontinue =1;
        while(iscontinue == 1){
            String[] digits = Integer.toString(i).split("");
            int product = 1;
            for(int j=0;j<digits.length;j++){
                product*=Integer.parseInt(digits[j]);
            }
            if(product % t == 0){
                iscontinue = 0;
                break;
            }
            i++;
        }
        return i;
    }
}