/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SPICE;

/**Voltage is an extension of the Element superclass and cannot take null input values. If a negative value of voltage is inputted, the nodes are switched.  **/
public class Voltage extends Element { 
    int vID;
    int n1;
    int n2;
    static int next = 1;
    
    /**
     *
     * @param value
     * @param node1
     * @param node2
     */
    public Voltage (double value, Node node1, Node node2){ /*Creates a voltage source with a value, connected between 2 nodes */
        
        if (node1 == null || node2 == null){
        throw new IllegalArgumentException("Node values cannot be null");
        }
        
        if (node1.nID == node2.nID){
        throw new IllegalArgumentException("Node values cannot be the same");
        }
        
        if (node1.nID < 0){
        throw new IllegalArgumentException("Node values cannot be negative");
        }
        
        if (node2.nID < 0){
        throw new IllegalArgumentException("Node values cannot be negative");
        }

        if (value < 0){ /*Checking to see if the voltage is negative */
            this.value = Math.abs(value); /*If negative, take the absolute value and switch the node inputs */
            this.contact1 = node2;
            this.contact2 = node1;
            this.n1 = node2.nID;
            this.n2 = node1.nID;
        }
        
        else{
            this.value = value;
            this.contact1 = node1;
            this.contact2 = node2;
            this.n1 = node1.nID;
            this.n2 = node2.nID;
        }
        this.vID = next;
        next++;
    }
    
    /**
     *
     * @return
     */
    
    /**Returns the node values of the element
     * @return  **/
    public Node[] getNodes(){ 
        this.location[0] = this.contact1;
        this.location[1] = this.contact2;
        return this.location;
    }
    
    /**Prints element information 
     * @return  **/
    @Override
    public String toString(){ /*Prints element information*/
      String components = ("V"+this.vID+" "+this.n1+" "+"DC" +" "+this.n2+ " "+this.value);
       return components;
    } 
}