/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queue.lab4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Diarmuid Brennan
 * 31/10/2021
 * Fifo class - creates a queue of semaphores 
 */
public class FifoQueue {
    Queue<Semaphore> q = new LinkedList<>();
    static Semaphore mutex = new Semaphore(1);//semaphoer is set to released
    
    public FifoQueue()
    {
        
    }
    
    public void addToQueue(Semaphore sem)
    {
        try
        {
            mutex.acquire();
            q.add(sem);
            mutex.release();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        
    }
    
    public void releaseFromQueue()
    {
        try
        {
            mutex.acquire();
            Semaphore s = q.remove();
            mutex.release();
            s.release();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        
    }
}
