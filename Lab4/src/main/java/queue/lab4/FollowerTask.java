/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queue.lab4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Diarmuid Brennan
 * 31/10/2021
 * Follower Task class - runs each follower thread 
 */
public class FollowerTask implements Runnable {
    /**
    * Every thread is given a name and an IntegerObj value
    * Every thread is given a shared queue class
    */
    private String name;
    private QueueClass q;
    Semaphore mySem = new Semaphore(0);
    /**
    * Constructor
    * @param task_1 - takes in the name of the thread
    * @param q - takes in queue shared by leader and follower class
    */
    public FollowerTask(String task_1, QueueClass q) {
        name=task_1;
        this.q = q;
    }
    
    /**
     * run method executes queue classes joinFollowerQueue method 
    */
    public void run()
    {
       q.joinLFollowerQueue(mySem);
    }
    
}