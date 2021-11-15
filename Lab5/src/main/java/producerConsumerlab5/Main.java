/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package producerConsumerlab5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diarmuid Brennan
 * 08/11/2021
 * Project demonstrates the Producer/Consumer event using semaphores
 * Producer thread creates an event and adds it to the buffer
 * Consumer thread consumes event from the buffer
 * Threads must be synchronized when accessing the buffer
 * Producer can only produce when there is room in the queue
 * Consumer can only consume when the buffer is not empty
 */
public class Main {
    /**
    * Initialize max number of threads
    */
    static final int MAX_T = 4;
    
  
    public static void main(String[] args)
    {
        /**
        * Create Buffer Class object
        */
        final BufferClass b = new BufferClass();
        /**
        * Create tasks
        */
        Runnable r1 = new ProducerClass("Producer", b);
        Runnable r2 = new ProducerClass("Producer", b);
        Runnable r3 = new ProducerClass("Producer", b);
        Runnable r4 = new ProducerClass("Producer", b);
        Runnable r5 = new ProducerClass("Producer", b);
       
        Runnable r11 = new ConsumerClass("Consumer", b);
        Runnable r12 = new ConsumerClass("Consumer", b);
        Runnable r13 = new ConsumerClass("Consumer", b);
        Runnable r14 = new ConsumerClass("Consumer", b);
        Runnable r15 = new ConsumerClass("Consumer", b);
          
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
       
        

        pool.execute(r11);
        pool.execute(r12);
        
        pool.execute(r3);
        pool.execute(r4);
        pool.execute(r5);
        pool.execute(r13);
        pool.execute(r14);
        pool.execute(r15);
          
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
