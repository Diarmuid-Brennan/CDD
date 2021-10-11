/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Synchronized;

/**
 *
 * @author Diarmuid Brennan
 * 11/10/2021
 */
public class IntegerObj {
    int value;
    /**
    * Constructor
    * @param val - takes in an integer to assign to the Integer Object
    */
    IntegerObj(int val) {
        this.value = val;
    }
    /**
    * method that increases the IntegerQbj value by one when called
    * method is synchronized to allow only one thread call it at a time
    * @return returns the incremented value
    */
    synchronized int inc(){
        this.value++;
        return this.value;
    }
}