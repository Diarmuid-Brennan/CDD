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
//    private boolean locked = true;
//    private boolean released = true;
    /**
    * Create a static variable to hold the total number of threads, global to each thread
    * Create a static variable to hold the current count of threads, global to each thread
    */
    static int totalThreads = 4;
    static int count = 0;
    /**
    * Create two static semaphore, one set to released and one set to acquired
    */
    static Semaphore semaphore = new Semaphore(1);//semaphoer is set to released
    static Semaphore semaphore1 = new Semaphore(0);//semaphoer is set to acquired
    /**
    * Constructor
    * @param task_1 - takes in the name of the thread
    */
    public Task(String task_1) {
        name=task_1;
    }
    
    /**
    * method that each thread can acquire a lock and increment the global count by 1
    * Each thread will then be blocked until the count hits 4, using a semaphore 
    * At this point each thread is released
    */
    public void run()
    {
        try
        {
            semaphore.acquire();
            count++;
            System.out.println(name + " arrived. Count = " + count );
            semaphore.release();
            
            if(count == totalThreads) semaphore1.release();

            semaphore1.acquire();
            System.out.println(name + " released. Count = " + count );
            count--;
            semaphore1.release();
            
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    
}