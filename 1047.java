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

    
    
            
        
      
