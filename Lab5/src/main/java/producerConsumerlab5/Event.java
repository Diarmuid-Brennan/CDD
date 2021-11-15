/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producerConsumerlab5;

/**
 *
 * @author Diarmuid Brennan
 * 08/11/2021
 * Event class- event gets created by a producer thread and added to the BufferClass queue
 * event gets consumed by the consumer class and removed from the queue
 */
public class Event {
    int value;
    /**
    * Constructor
    * @param val - takes in an integer to assign to the Event value attribute
    */
    Event(int val) {
        this.value = val;
    }
    
    /**
    * getValue method returns the integer value of the event
    */
    public String getValue(){
        return "This is the num " + value ;
    }
}
