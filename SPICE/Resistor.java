/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SPICE;


/**Resistor is an extension of the Element superclass and cannot take negative or null input values  **/
public class Resistor extends Element { /*Resistor is an extension of the Element superclass */
    int rID;
    int n1;
    int n2;
    static int next = 1;
    
    /**
     *
     * @param value
     * @param node1
     * @param node2
     */
    public Resistor (double value, Node node1, Node node2){ /*Creates a voltage source with a value, connected between 2 nodes */
      
        if (value <= 0.0){
            throw new IllegalArgumentException("Resistance can't be negative or 0");
        }
        
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
        
        
        this.value = value;
        this.rID = next;
        next++;
        this.contact1 = node1;
        this.contact2 = node2;
        this.n1 = node1.nID;
        this.n2 = node2.nID;
        
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
        String components = ("R"+this.rID+" "+this.n1+" "+this.n2+ " "+this.value);
        return components;
    }
}