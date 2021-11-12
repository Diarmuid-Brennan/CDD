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
 * 08/11/2021
 * BufferClass class - contains methods for adding and removing events from the buffer
 * Buffer can only be accessed by one thread at a time
 * Producers must wait if buffer is full and Consumers must wait if buffer is empty 
 */
public class BufferClass {

    private int empty = 0;
    private int full = 4 ;
    /**
    * Create 3 static semaphores, one set to released, one set to acquired and one set the the size of the buffer
    * one will act as a mutex lock managing access to the buffer
    * the other 2 synchronize the producer and consumer threads so that they can only add/remove from the buffer when allowed
    */
    static Semaphore mutex = new Semaphore(1);//semaphoer is set to released
    static Semaphore producerCount = new Semaphore(0);
    static Semaphore consumerCount = new Semaphore(4);
    /**
    * Data structure to store the events
    */
    Queue<Event> q = new LinkedList<>();
    
    /**
    *  @param event - event to be added to the buffer
    * addEvent synchronises producer input to the buffer
    * implements mutex when adding to the buffer
    */
    public void addEvent(Event event)
    {
        try
        {
            consumerCount.acquire();
            mutex.acquire();
            q.add(event);
            mutex.release();
            producerCount.release();
            
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    
    /**
    * consume synchronises consumer removing data from the buffer
    * implements mutex when removing from the buffer
    */
    public void consume()
    {
        try
        {
            producerCount.acquire();
            mutex.acquire();
            Event e = q.remove();
                      
            mutex.release();
            consumerCount.release();
            System.out.println(e.getValue()); 
            
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
