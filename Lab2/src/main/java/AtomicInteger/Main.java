/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AtomicInteger;

package com.itc.mutexexample;
import java.text.SimpleDateFormat; 
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Diarmuid Brennan
 * 11/10/2021
 * Main class
 * Create multiple threads using runnable, assigning an initial AtomicInteger value of 0.
 * Assign threads to a thread pool
 * Output total value of AtomicInteger once threads have completed their tasks and pool has shutdown
 */

public class Main {
     // Maximum number of threads in thread pool
    /**
    * Initialize the max number of threads to be created
    */
    static final int MAX_T = 4;             
  
    public static void main(String[] args)
    {
        /**
        * Create an AtomicInteger object, passing a value of 0 to it
        */
        AtomicInteger atomicInteger = new AtomicInteger();
        // creates four tasks
        /**
        * Create four threads, passing the atomicInteger value to each
        */
        Runnable r1 = new Task("task 1", atomicInteger);
        Runnable r2 = new Task("task 2", atomicInteger);
        Runnable r3 = new Task("task 3", atomicInteger);
        Runnable r4 = new Task("task 4", atomicInteger); 
          
        // creates a thread pool with MAX_T no. of 
        // threads as the fixed pool size(Step 2)
        /**
        * Create a thread pool setting the pool size of the max number of threads to be created
        */
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);  
         
        
        long startTime = System.currentTimeMillis();
        // passes the Task objects to the pool to execute (Step 3)
        /**
        * Run each thread in the thread pool
        */
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);
          
        // pool shutdown ( Step 4)
        /**
        * Shutdown the thread pool
        */
        pool.shutdown(); 
        
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                            
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);
        /**
        * Output the total atomic Integer once each thread has completed
        */
        System.out.println("total is: "+ atomicInteger.get());
    }
}