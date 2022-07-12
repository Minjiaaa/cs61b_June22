class Solution{
    public int shipWithinDays(int[] weights, int d){
        int max = 0, sum = 0;
        for (int weight : weights){
            max = Math.max(max, w);//求最大值的方法
            sum += w;
        }
        int lo = max, hi = sum;
        while (lo < hi){ //什么时候加等于，什么时候不加等于呢？
            int mid = lo + (hi - lo) / 2;
            if (withInDays(weight, mid, d)){
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
     }       
     public boolean withInDays(int[] weights, int d,int ship){
        int day = d, remain = ship;
        for (int w : weights){
            if (w > ship)
                return false;
            if (remain - w >= 0)
                remain -= w;
            else {
                if (--day == 0)
                    return false;
                remain = ship - w;
            }
        }
        return true;
     }
 }
       
            
