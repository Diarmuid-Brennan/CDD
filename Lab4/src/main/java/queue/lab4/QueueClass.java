/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queue.lab4;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Diarmuid Brennan
 * 31/10/2021
 * QueueClass class - contains methods for adding follower and leader threads to queue
 * Allows only one leader and one follower to execute at a time before allowing the next threads through
 */
public class QueueClass {
    /**
    * Create a int variable to keep track of current number of leader threads
    * Create a int variable to keep track of current number of follower threads
    */
    private int leaders = 0;
    private int followers = 0 ;
    /**
    * Create four static semaphores, three set to released and one set to acquired
    * one will act as a mutex lock to the count variables
    * the other 3 will act to ensure only one leader and one follower can execute at any one time
    */
    static Semaphore mutex = new Semaphore(1);//semaphoer is set to released
    static Semaphore leaderQ = new Semaphore(0);
    static Semaphore followerQ = new Semaphore(0);
    static Semaphore rendevous = new Semaphore(0);
    
     /**
    * Create tow fifo queues
    * one for leader tasks and one for follower tasks
    */
    FifoQueue leaderFifo = new FifoQueue();
    FifoQueue followerFifo = new FifoQueue();
    
    /**
    * joinLeaderQueue method
    * if there is awaiting follower, it decrements the followers and release the follower semaphore
    * if there is no awaiting followers, it increases the number of awaiting leaders and acquires the leader semaphore
    * if follower awaiting or a leader is released output its data and acquire the rendevouz semaphore
    */
    public void joinLeaderQueue(Semaphore mySem)
    {
        try
        {
            mutex.acquire();
            if(followers > 0)
            {
                followers--;
                
                followerQ.release();
                followerFifo.releaseFromQueue();
                
            }
            else
            {
                leaders++;
                mutex.release();
                
                leaderFifo.addToQueue(mySem);
                leaderQ.acquire();
                
                
            }
            System.out.print('A');
            rendevous.acquire();
            mutex.release();

        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    
    /**
    * joinFollowerQueue method
    * if there is awaiting leader, it decrements the leaders and release the leader semaphore
    * if there is no awaiting leaders, it increases the number of awaiting followers and acquires the follower semaphore
    * if a leader is awaiting or a follower is released output its data and release the rendevouz semaphore
    */
    public void joinLFollowerQueue(Semaphore mySem)
    {
        try
        {
            mutex.acquire();
            if(leaders > 0)
            {
                leaders--;
                
                leaderQ.release();
                leaderFifo.releaseFromQueue();
                
            }
            else
            {
                followers++;
                mutex.release();
                
                followerFifo.addToQueue(mySem);
                followerQ.acquire();
                
                
            }
            System.out.print('1');
            rendevous.release();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
