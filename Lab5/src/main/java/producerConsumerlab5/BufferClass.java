/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producerConsumerlab5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Diarmuid Brennan
 * 11/08/2021
 * BufferClass class - contains methods for adding follower and leader threads to queue
 * Allows only one leader and one follower to execute at a time before allowing the next threads through
 */
public class BufferClass {
    /**
    * Create a int variable to keep track of current number of leader threads
    * Create a int variable to keep track of current number of follower threads
    */
    private int empty = 0;
    private int full = 5 ;
    /**
    * Create four static semaphores, three set to released and one set to acquired
    * one will act as a mutex lock to the count variables
    * the other 3 will act to ensure only one leader and one follower can execute at any one time
    */
    static Semaphore mutex = new Semaphore(1);//semaphoer is set to released
    static Semaphore producerCount = new Semaphore(0);
    static Semaphore consumerCount = new Semaphore(0);
    
    Queue<Event> q = new LinkedList<>();
    
    public void addEvent(Event event)
    {
        try
        {
            producerCount.acquire();
            mutex.acquire();
            q.add(event);
            mutex.release();
            consumerCount.release();
            
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    
    public void consume()
    {
        try
        {
            consumerCount.acquire();
            mutex.acquire();
            Event e = q.remove();
            System.out.println(e.getValue());           
            mutex.release();
            consumerCount.release();
            
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
