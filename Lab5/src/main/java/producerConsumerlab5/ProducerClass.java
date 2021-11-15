/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producerConsumerlab5;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Diarmuid Brennan
 * 08/11/2021
 * ProducerClass class - runs each producer thread 
 */
public class ProducerClass implements Runnable {

    private String name;
    private BufferClass b;
    static Semaphore mutex = new Semaphore(1);
    static int num = 0 ;
    private Event event ;
    
    /**
    * Constructor
    * @param task_1 - takes in the name of the thread
    * @param b - takes in buffer shared by producer and consumer threads
    */
    public ProducerClass(String task_1, BufferClass b) {
        name=task_1;
        this.b = b;
        
    }
    
     /**
     * run method increments the value of each event and executes buffer classes add method 
     * mutex lock allows only one event to be carried at a time and to add to the buffer
    */
    public void run()
    {
        try
        {
            mutex.acquire();
            num++;
            event = new Event(num) ;
            b.addEvent(event);
            mutex.release();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }

    }
}
