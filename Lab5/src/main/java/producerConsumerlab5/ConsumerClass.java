/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producerConsumerlab5;

import java.util.concurrent.Semaphore;
import static producerConsumerlab5.BufferClass.consumerCount;
import static producerConsumerlab5.BufferClass.mutex;
import static producerConsumerlab5.BufferClass.producerCount;

/**
 *
 * @author liuxvm
 */
public class ConsumerClass implements Runnable {

    private String name;
    private BufferClass b;
    Semaphore mutex = new Semaphore(1);
    /**
    * Constructor
    * @param task_1 - takes in the name of the thread
    * @param b - takes in buffer shared by producer and consumer threads
    */
    public ConsumerClass(String task_1, BufferClass b) {
        name=task_1;
        this.b = b;
    }
    
    /**
     * run method executes buffer classes consume method 
    */
    public void run()
    {
       for(int i = 0; i < 10; i++)
        {
            try
            {
                mutex.acquire();
                b.consume();
                mutex.release();
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
              
        }
    }
} 