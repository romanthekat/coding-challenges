package net.romangaranin.leetcode.top.easy;

import java.util.ArrayList;
import java.util.List;

import static dev.romangaranin.leetcode.Helper.test;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * Implement the MinStack class:
 * <p>
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * <p>
 * -2^31 <= val <= 2^31 - 1
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 * At most 3 * 104 calls will be made to push, pop, top, and getMin.
 */
public class MinStackTask {
    public static void main(String[] args) {
        var minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        test(minStack.getMin(), -3);

        minStack.pop();
        test(minStack.top(), 0);
        test(minStack.getMin(), -2);
    }

    static class MinStack {
        private List<Entry> stack;

        public MinStack() {
            stack = new ArrayList<>();
        }

        public void push(int val) {
            var min = stack.isEmpty() ? Integer.MAX_VALUE : getMin();
            if (val < min) {
                min = val;
            }

            stack.add(new Entry(val, min));
        }

        public void pop() {
            stack = stack.subList(0, stack.size() - 1);
        }

        public int top() {
            return getMinEntry().getValue();
        }

        public int getMin() {
            return getMinEntry().getMin();
        }

        private Entry getMinEntry() {
            return stack.get(stack.size() - 1);
        }

        static class Entry {
            private Integer value;
            private Integer min;

            public Entry(Integer value, Integer min) {
                this.value = value;
                this.min = min;
            }

            public Integer getValue() {
                return value;
            }

            public Integer getMin() {
                return min;
            }
        }
    }


}
