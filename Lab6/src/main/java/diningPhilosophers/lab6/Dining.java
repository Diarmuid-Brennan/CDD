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
 * Dining class - contains methods for acquiring forks
 */
public class Dining implements Runnable{
    
    private String name;
    static Semaphore mutex = new Semaphore(1);
    static int num = 0 ;
    static Semaphore[] resources  = new Semaphore[5];
    private int philosopherNumber;
    
    public Dining(String task_1) {
        name=task_1;       
        philosopherNumber = num;
        num++;
        setSemaphoreArray();
    }
    
    public void setSemaphoreArray(){
        for(int i =0; i < 5; ){
            resources[i] = new Semaphore(1);
        }
    }
    
     public void run()
    {
        try
        {
            mutex.acquire();
            getLeftFork(philosopherNumber);
            mutex.release();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
     
    public int getLeftFork(int num){
        return num;
    }
    
    public int getRightFork(int num){
        return (num +1) % 5;
    }
    
    public void getForks(int num){
        try
        {
            resources[getLeftFork(num)].acquire();
            resources[getRightFork(num)].acquire();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        
    }
    
    public void returnForks(int num){
        resources[getLeftFork(num)].release();
        resources[getRightFork(num)].release();
    }
}
