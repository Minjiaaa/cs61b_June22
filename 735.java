//模拟+栈
// 由于碰撞抵消总是从相邻行星之间发生，我们可以使用「栈」来模拟该过程。
// 从前往后处理所有的 ats[i]，使用栈存储当前未被抵消的行星.
// 当栈顶元素方向往右，当前 ats[i]方向往左时，会发生抵消操作，抵消过程根据规则进行即可。
// https://leetcode.cn/problems/asteroid-collision/solution/by-ac_oier-p4qh/

class Solution{
  public int[] asteroidCollusion(int[] ats){
      Deque<Integer> d = new ArrayDeque<>();
      for (int t: ats) {
        boolean ok = true;
        while (ok && !d.isEmpty() && d.peekLast() >0 && t < 0 {
            int a = d.peekLast(), b = -t;
            if (a <= b) d.pollLast();
            if (a >= b) ok = false; //为什么要把ok设成boolean？--取相反数
        }
         if (ok) d.addLast(t); 
      }
      int sz = d.size();
      int[] ans = new int[sz];
      while (!d.isEmpty()) ans[--sz] = d.pollLast(); // 这边栈的设置还不是很懂
      return ans;
  }
}
