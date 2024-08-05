package stack_and_queue;


import java.util.Stack;

public class ImplementQueueUsingStack_232 {

    // 多态性测试
//    @Test
//    public void test() {
//        Person p = new Student();
//        p.show();
//        //p.study()
//
//    }

    public static void main(String[] args) {

    }

    static class MyQueue {

        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            if(stack1.empty()) return -1;

            while(!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            int x = stack2.pop();

            while(!stack2.empty()) {
                stack1.push(stack2.pop());
            }
            return x;
        }

        public int peek() {
            if(stack1.empty()) return -1;

            while(!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            int x = stack2.peek();

            while(!stack2.empty()) {
                stack1.push(stack2.pop());
            }
            return x;
        }

        public boolean empty() {
            return stack1.empty();
        }
    }
}

//class Person {
//    public void show() {
//        System.out.println("Person");
//    }
//}
//
//class Student extends Person {
//    @Override
//    public void show() {
//        System.out.println("Student");
//    }
//
//    public void study() {
//        System.out.println("Study");
//    }
//}
