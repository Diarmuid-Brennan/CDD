/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producerConsumerlab5;

/**
 *
 * @author liuxvm
 */
public class Event {
    int value;
    /**
    * Constructor
    * @param val - takes in an integer to assign to the IntegerObj value attribute
    */
    Event(int val) {
        this.value = val;
    }
    
    public String getValue(){
        return "This is the num " + value ;
    }
}
