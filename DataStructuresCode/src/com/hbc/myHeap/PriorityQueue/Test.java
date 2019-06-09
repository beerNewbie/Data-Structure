package com.hbc.myHeap.PriorityQueue;

/**
 * @Author: Beer
 * @Date: 2019/6/9 20:51
 * @Description: 优先级队列
 */
public class Test {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.enQueue(5);
        priorityQueue.enQueue(8);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(7);
        priorityQueue.enQueue(6);
        System.out.println(priorityQueue.peek());//8
        System.out.println(priorityQueue.deQueue());//8
        System.out.println(priorityQueue.peek());//7
        System.out.println(priorityQueue.isEmpty());//false
    }
}
