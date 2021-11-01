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
 * Follower Task class - runs each thread 
 */
public class FollowerTask implements Runnable {
    /**
    * Every thread is given a name and an IntegerObj value
    */
    private String name;

    private QueueClass q;
    /**
    * Constructor
    * @param task_1 - takes in the name of the thread
    */
    public FollowerTask(String task_1, QueueClass q) {
        name=task_1;
        this.q = q;
    }
    
    /**
     * method demonstrating a barrier 
    */
    public void run()
    {
       q.joinLFoolwerQueue();
    }
    
}