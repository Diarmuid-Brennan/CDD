/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mutex;

package com.itc.mutexexample;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Diarmuid Brennan
 * 11/10/2021
 * Task class - runs each thread 
 */
public class Task implements Runnable {
    /**
    * Every thread is given a name and an IntegerObj value
    */
    private String name;
    private IntegerObj total;
    
    static Semaphore semaphore = new Semaphore(1);
    /**
    * Constructor
    * @param task_1 - takes in the name of the thread
    * @param total - takes in an integer to assign to the IntegerObj value
    */
    public Task(String task_1, IntegerObj total) {
        name=task_1;
        this.total = total;

    }
    
    /**
    * method that runs a thread through a loop incrementing the IntegerObj each time
    * thread must acquire a semaphore lock before entering the for loop and release it once completed executing in the loop
    * Outputs thread has completed to the screen when the loop finishes
    */
    public void run()
    {
        try
        {
            for (int i = 0; i<500; i++)
            {
                semaphore.acquire();
                total.inc();
                semaphore.release();
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