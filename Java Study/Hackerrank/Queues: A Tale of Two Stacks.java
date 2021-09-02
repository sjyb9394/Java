import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
    
    static class MyQueue<T>{
        private Stack<T> stack;
        private Stack<T> stack2;
        
        public MyQueue(){
            stack = new Stack<>();
            stack2 = new Stack<>();
        }
        
        public void enqueue(T x){
            stack.push(x);
        }
        
        public T dequeue(){
            if(stack2.isEmpty()){
                while(!stack.isEmpty()){
                    stack2.push(stack.pop());
                }
            }
            return stack2.pop();
        }
        
        public T peek(){
            if(stack2.isEmpty()){
                while(!stack.isEmpty()){
                    stack2.push(stack.pop());
                }
            }
            return stack2.peek();
        }
    }
}
