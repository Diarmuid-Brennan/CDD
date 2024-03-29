/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Synchronized;

package com.itc.mutexexample;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    
    /**
    * Constructor
    * @param task_1 - takes in the name of the thread
    * @param total - takes in an integer to assign to the thread
    */
    public Task(String task_1, IntegerObj total) {
        name=task_1;
        this.total = total;
    }
    
    /**
    * method that runs a thread through a loop incrementing the IntegerObj each time 
    * Outputs to the screen when the loop finishes
    */
    public void run()
    {
        try
        {
            for (int i = 0; i<500; i++)
            {
                total.inc();
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