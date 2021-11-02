/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barrier.lab3;

package com.itc.mutexexample;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Diarmuid Brennan
 * 20/10/2021
 * Task class - runs each thread 
 */
public class Task implements Runnable {
    /**
    * Every thread is given a name and an IntegerObj value
    */
    private String name;
    /**
    * Create a static variable to hold the total number of threads, global to each thread
    * Create a static variable to hold the current count of threads, global to each thread
    */
    static int totalThreads = 4;
    static int count = 0;
    /**
    * Create three static semaphores, two set to released and one set to acquired
    * one will act as a mutex lock to the count variable
    * the other 2 will act as turnstile to prevent threads processing til a given number of threads have reached
    */
    static Semaphore mutex = new Semaphore(1);//semaphoer is set to released
    static Semaphore turnstile = new Semaphore(0);//semaphoer is set to acquired
    static Semaphore turnstile2 = new Semaphore(1);//semaphoer is set to released
    /**
    * Constructor
    * @param task_1 - takes in the name of the thread
    */
    public Task(String task_1) {
        name=task_1;
    }
    
    /**
     * method demonstrating a barrier in action using only semaphores
    * each thread can acquire a lock and increment the global count by 1
    * Each thread will then be blocked until the count hits 4, using a semaphore 
    * At this point each thread is released using a turnstile
    * each thread then acquires a lock and decrements the global count by 1
    * A second turnstile is implemented when the count reaches 0 each thread is released
    * This is so that the barrier is reusable
    */
    public void run()
    {
        try
        {
            //NON-REUSABLE
//            mutex.acquire();
//            count++;
//            System.out.println(name + " arrived. Count = " + count );
//            mutex.release();
//            
//            if(count == totalThreads) semaphore1.release();
//
//            turnstile.acquire();
//            System.out.println(name + " released. Count = " + count );
//            count--;
//            turnstile.release();
            //after final thread is released the turnstile is not reset to acquired again and cannot be reused
            
            //REUSABLE
            mutex.acquire();
            count++;
            System.out.println(name + " arrived. Count = " + count );
            if(count == totalThreads)
            {
                turnstile2.acquire();//lock the second turnstile first
                turnstile.release();//then release the firsst turnstile
            }
            mutex.release();
            
            turnstile.acquire();
            turnstile.release();
            
            mutex.acquire();
            System.out.println(name + " released. Count = " + count );
            count--;
            if(count == 0)
            {
                turnstile.acquire();//lock the first turnstile first
                turnstile2.release();//then release the firsst turnstile
            }
            mutex.release();
            
            turnstile2.acquire();
            turnstile2.release();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    
}