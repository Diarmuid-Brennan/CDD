/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AtomicInteger;

package com.itc.mutexexample;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Diarmuid Brennan
 * 11/10/2021
 * Task class - runs each thread 
 */
public class Task implements Runnable {
    /**
    * Every thread is given a name and an AtomicInteger value
    */
    private String name;
    private AtomicInteger total;
    

    /**
    * Constructor
    * @param task_1 - takes in the name of the thread
    * @param total - takes in an AtomicInteger to assign to the thread
    */
    public Task(String task_1, AtomicInteger total) {
        name=task_1;
        this.total = total;
    }
    
    /**
    * method to run a thread through a loop incrementing the AtomicInteger each time
    * Outputs thread has completed to the screen when the loop finishes
    */
    public void run()
    {
        try
        {
            for (int i = 0; i<500; i++)
            {
                total.getAndIncrement();
                if (i%100==0){
                   Thread.sleep(100); 
                }
            }
            System.out.println(name+" complete");
        }

        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}