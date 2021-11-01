/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queue.lab4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diarmuid Brennan
 * 31/10/2021
 * Creating threads and implement a Queue using semaphores
 */
public class Main {
    
    static final int MAX_T = 4;
    
  
    public static void main(String[] args)
    {
        final QueueClass q = new QueueClass();
        // creates four tasks
        /**
        * Create four tasks
        */
        Runnable r1 = new FollowerTask("Follower task 1", q);
        Runnable r2 = new FollowerTask("Follower task 2", q);
        
        
        Runnable r5 = new LeaderTask("Leader task 1", q);
        Runnable r6 = new LeaderTask("Leader task 2", q);
        
        Runnable r3 = new FollowerTask("Follower task 3", q);
        Runnable r4 = new FollowerTask("Follower task 4", q); 
        Runnable r7 = new LeaderTask("Leader task 3", q);
        Runnable r8 = new LeaderTask("Leader task 4", q); 
          
        // creates a thread pool with MAX_T no. of 
        // threads as the fixed pool size
        /**
        * Create a thread pool setting the pool size of the max number of threads to be created
        */
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);  
         
        // passes the Task objects to the pool to execute
        /**
        * Run each thread in the thread pool
        */
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r5);
        pool.execute(r6);
        
        pool.execute(r3);
        pool.execute(r4);
        pool.execute(r7);
        pool.execute(r8);
          
        // pool shutdown
        /**
        * Shutdown the thread pool
        */
        pool.shutdown(); 
        
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
