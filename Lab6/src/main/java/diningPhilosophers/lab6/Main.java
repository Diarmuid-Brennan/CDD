/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diningPhilosophers.lab6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diarmuid Brennan
 * 21/11/2021
 * Project demonstrates the Dining Philosophers problem using semaphores
 * Each thread requires access to shared resources
 * Threads must be synchronized when accessing the resources
 * if a resource is already taken the other threads must wait and try again later
 */
public class Main {
    /**
    * Initialize max number of threads
    */
    static final int MAX_T = 4;
    
  
    public static void main(String[] args)
    {

        /**
        * Create tasks
        */
        Runnable r1 = new Dining("diner", 0);
        Runnable r2 = new Dining("diner", 1);
        Runnable r3 = new Dining("diner", 2);
        Runnable r4 = new Dining("diner", 3);
        Runnable r5 = new Dining("diner", 4);


          
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
        pool.execute(r3);
        pool.execute(r4);
        pool.execute(r5);

          
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