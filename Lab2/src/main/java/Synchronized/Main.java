/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Synchronized;

package com.itc.mutexexample;
import java.text.SimpleDateFormat; 
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Diarmuid Brennan
 * 11/10/2021
 * Main class
 * Create multiple threads using runnable, assigning an initial integer value of 0.
 * Assign treads to a thread pool
 * Output total value 
 */

public class Main {
     // Maximum number of threads in thread pool
    /**
    * Initialize the max number of threads that can be created
    */
    static final int MAX_T = 4;             
  
    public static void main(String[] args)
    {
        /**
        * Create an integer object, passing a value of 0 to it
        */
        IntegerObj total= new IntegerObj(0);
        // creates four tasks
        /**
        * Create four threads
        */
        Runnable r1 = new Task("task 1",total);
        Runnable r2 = new Task("task 2",total);
        Runnable r3 = new Task("task 3",total);
        Runnable r4 = new Task("task 4",total);    
          
        // creates a thread pool with MAX_T no. of 
        // threads as the fixed pool size(Step 2)
        /**
        * Create a thread pool that can contain the max number of threads
        */
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);  
         
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
        /**
        * Output the total value after each thread has completed
        */
        System.out.println("total is: "+total.value);
    }
}