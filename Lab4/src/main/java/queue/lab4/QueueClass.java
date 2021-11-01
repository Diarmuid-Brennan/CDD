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
 * Fifo class - creates a queue of semaphores 
 */
public class QueueClass {
    private int leaders = 0;
    private int followers = 0 ;
    
    static Semaphore mutex = new Semaphore(1);//semaphoer is set to released
    static Semaphore leaderQ = new Semaphore(0);
    static Semaphore followerQ = new Semaphore(0);
    static Semaphore rendevous = new Semaphore(0);
    
    public void joinLeaderQueue()
    {
        try
        {
            mutex.acquire();
            if(followers > 0)
            {
                followers--;
                followerQ.release();
            }
            else
            {
                leaders++;
                mutex.release();
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
    
    public void joinLFoolwerQueue()
    {
        try
        {
            mutex.acquire();
            if(leaders > 0)
            {
                leaders--;
                leaderQ.release();
            }
            else
            {
                followers++;
                mutex.release();
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
