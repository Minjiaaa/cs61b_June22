class Solution{
    public int shipWithinDays(int[] weights, int d){ //从数组的最大元素开始遍历判断值i是否满足verification
        // 二分查找 r =数组的总和， l=数组的最大值
        int r = Arrays.stream(weights).sum();
        int l = Arrays.stream(weights).max().getAsInt();
        // l < r
        while(l < r) {
            int mid = (l+r)/2; //取中间值
            if(verification(weights, d, mid)){ //包括mid
                r = mid; //
            } else {
                l = mid + 1；//逼近左指针
            }
        }
        return l; //返回当前l就是最小的满足条件的值，即最低运载能力
    }
    //判断最低运载能力为H的时候能否在d天内送达
     public boolean verification(int[] weights, int d,int H){
        int count = 1; //天数计数，天数初始化为1
        int singleWeight = 0； //每天的包裹总量
        for (int i = 0; i < weights.length; ++i){
            singleWeights += weights[i];//累计包裹总量
            if (singleWeights > H) { //如果累计包裹总量singleWeight>H，天数+1
                ++count;
                singleWeight = weights[i]； 
            }
            //如果当前累计的天数count>d, 说明当前H不满足条件，返回false
            if (count > d){
                return false;
            }
        }
        return true; //说明当前H满足条件，返回true
     }
 }

class Solution{
    public int shipWithinDays(int[] weights, int d){
        int lo = 0, hi = 0;
        for (int weight : weights){
            hi += weight;
        }
        while (hi-lo > 1){
            int mid = (hi + lo) / 2;
            if (withInDays(weights, d, mid) == false){
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return hi;
    }
    
    public boolean withInDays(int[] weights, int d, int ship){
        int day = d, remain = ship;// 剩余天数,承载量
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
       
            
