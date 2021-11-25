/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diningPhilosophers.lab6;

import java.util.concurrent.Semaphore;


/**
 *
 * @author Diarmuid Brennan
 * 21/11/2021
 * Dining class - contains methods for acquiring resources shared between threads
 * each thread can only access the resources to its left and right
 * when a resource is acquired the thread must wait
 */
public class Dining implements Runnable{
    
    
    private String name;
    private int philosopherNumber;
    /**
    * Create a static array of semaphores, to be shared by each thread
    * use a counting semaphore to ensure a max of four threads can attempt to get a fork at ant time, prevents deadlock
    */
    static Semaphore[] resources  = new Semaphore[5];
    static Semaphore count = new Semaphore(4);
    
    /**
    * Constructor
    * @param task_1 - sets name of thread
    * @param num - sets an integer value to each thread
    */
    public Dining(String task_1, int num) {
        name=task_1;       
        philosopherNumber = num;
        setSem();
    }
    
    /**
    * initialises the array of semaphores
    */
    public void setSem(){
        for (int i =0; i < 5; i++)
        {
            resources[i] = new Semaphore(1);
        }
    }
    
    /**
    * run method acquires the resources for each thread
    */
     public void run()
    {       
        System.out.println(philosopherNumber);
        getForks(philosopherNumber);
        returnForks(philosopherNumber);
    }
     
     /**
      * @param num - sets the position of the resource
    * returns the index position of a threads left resource
    */
     public int getLeftFork(int num){
        return num;
    }
    
     /**
      * @param num - sets the position of the resource
    * returns the index position of a threads right resource
    */
    public int getRightFork(int num){
        return (num +1) % 5;
    }
    
    /**
      * @param num -  the number of the thread
    * acquires a resource and prevents other threads from acquiring at the same time
    * if a resource is in use the thread must wait till it is released
    */
    public void getForks(int num){
        try
        {
            count.acquire();
            System.out.println(num);
            resources[getRightFork(num)].acquire();
            resources[getLeftFork(num)].acquire();
            
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        
    }
    
    /**
      * @param num -  the number of the thread
    * releases resource once thread has completed their task
    */
    public void returnForks(int num){
        
        resources[getLeftFork(num)].release();
        resources[getRightFork(num)].release();
        count.release();
    }
    
}
