/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queue.lab4;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Diarmuid Brennan
 * 31/10/2021
 * Leader task class - runs each leader thread
 */
public class LeaderTask implements Runnable{
    
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
    public LeaderTask(String task_1, QueueClass q) {
        name=task_1;
        this.q = q;
    }
    
    /**
     * run method executes queue classes joinLeaderQueue method
    */
    public void run()
    {
       q.joinLeaderQueue(mySem);
    }
}
