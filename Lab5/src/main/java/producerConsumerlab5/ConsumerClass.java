/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producerConsumerlab5;

import java.util.concurrent.Semaphore;

/**
 *
 * @author liuxvm
 */
public class ConsumerClass implements Runnable {
    /**
    * Every thread is given a name and an IntegerObj value
    * Every thread is given a shared queue class
    */
    private String name;
    private BufferClass b;
    Semaphore mySem = new Semaphore(0);
    /**
    * Constructor
    * @param task_1 - takes in the name of the thread
    * @param q - takes in queue shared by leader and follower class
    */
    public ConsumerClass(String task_1, BufferClass b) {
        name=task_1;
        this.b = b;
    }
    
    /**
     * run method executes queue classes joinFollowerQueue method 
    */
    public void run()
    {
       //q.joinLFollowerQueue(mySem);
        b.consume();
    }
} 