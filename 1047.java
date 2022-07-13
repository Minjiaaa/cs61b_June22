class Solution{
  public String removeDuplicates(String S){
    
    Stack<Character> stack = new Stack(); //create stack
    
    for (char c: S.toCharArray()){ //iterate through string
      if (！stack.isEmpty() && stack.peek() == c) { //check if top of stack is equal to this character
          stack.pop(); //remove
      } else {
          stack.push(c); // add to stack
      }
    }
    String Builder res = new StringBuilder(); // string builder for result
    
    while(!stack.isEmpty()){
      res.append(stack.pop()); // empty stack out everything left is not an adjacent duplicate
      return res.reverse().toString(); //result
    }
 }

 这个方法复杂度比较低
 class Solution{
    public String removeDuplicates(String S){
        char[] c = S.toCharArray();
        int n = c.length, top = -1; //top表示栈顶索引
        for (int i = 0; i < n; i++){ //将新字符串存储在c的前段
            if (top == -1 ||c[top] != c[i])//栈为空或者栈顶与当前元素不同
                c[++top] = c[i];
            else
                top--;
        }
        return String.valueOf(c, 0, ++top);
    }
}
 
    
    
            
        
      
