/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SPICE;

/**Contains contact points of elements used within the circuit as a superclass to be more efficient. Element is an abstract superclass so it cannot be instanciated **/
public abstract class Element { 
    
    /* Node/location formatting */
    Node contact1;
    Node contact2;
    Node location[] = new Node[2];
    
    double value; /*Holds value of either the resistance or the voltage source */
    
    
}
