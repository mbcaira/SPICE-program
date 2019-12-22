/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SPICE;

/**Keeps track of nodes within the circuit **/
public class Node {
    int nID;
    static int next = 0;
    
    /**
     *
     */
    /**Iterates the node ID as more nodes are created **/
    public Node(){
        nID = next; 
        this.next = next+1;
    }
    
    /**Returns the node ID as a string **/
    @Override
    public String toString(){
        String node = Integer.toString(nID);
        return node;
    }
}
