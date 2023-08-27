package Ex2_3;

import java.util.Stack;

public class Queue2Stacks {
    Stack<Integer> stack1,stack2;
    int size;

    public Queue2Stacks(){
        /*stack1 = new Stack<>();
        stack2 = new Stack<>();
        Queue<Integer> q = null;
        for(int i =0; i<stack1.size()&&i<stack2.size();i++){
            q.add(stack1.remove(i));
            q.add(stack2.remove(i));
        }*/
        this.size=0;
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enQueue(int x){
        while (!stack1.isEmpty())
        {
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while (!stack2.isEmpty())
        {
            stack1.push(stack2.pop());
        }
    }

    public int deQueue(){
        if (stack1.isEmpty())
        {
            return -1;
        }
        int x = stack1.peek();
        stack1.pop();
        return x;
    }

    public boolean isEmpty(){
        if(stack1.isEmpty()&&stack2.isEmpty()){
            return true;
        }
        return false;
    }

    public int size(){
        return stack1.size()+stack2.size();
    }

}
