package com.hbc.myQueue;

import com.hbc.myQueue.impl.ArrayLoopQueue;
import com.hbc.myQueue.impl.ArrayQueue;
import com.hbc.myQueue.impl.LinkedQueue;

/**
 * @Author: Beer
 * @Date: 2019/5/26 18:19
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayLoopQueue<>(5);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.deQueue();
        queue.enQueue(6);
        System.out.println(queue.peek());//2
        System.out.println(queue.deQueue());//2
        System.out.println(queue.deQueue());//3
        System.out.println(queue.getSize());//3
        System.out.println(queue.peek());//4
    }
}
