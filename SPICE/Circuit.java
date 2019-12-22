/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SPICE;

import java.util.ArrayList;
import java.util.Iterator;

public class Circuit { 
    private static Circuit instance = null;

    /**
     *
     * @return
     */
    public static Circuit getInstance(){
        if (instance == null){
            instance = new Circuit();
        }
        return instance;
    }
    ArrayList Elements = new ArrayList(); 
    private Circuit(){}
    
    /**
     *
     * @param element
     */
    
    /**Adds the desired element to the array of objects when called **/
    public void add(Object element){ /*Adds element to the circuit */
        Elements.add(element);
    }
    
    /**
     *
     * @return
     */
    
    /**Enables the end command and print-out when called **/
    public String endCircuit(){ /*Returns the terminating message and ends the program */
        String terminate = "All Done"; 
        return terminate;
    }
     
    /**
     *
     * @return
     */
    
    /**Enables the spice command and print-out when called **/
    public String spice(){ /*Calls the toString which fulfills functionality of the spice command */
        String spice = toString();
        return spice;
    }
    
    /**Creates a string of all the elements within the circuit by indexing the Element array and concatenating it to an empty string **/
    @Override
    public String toString(){ /*Indexes the element array and calls the toString of each cell which concatenates to the elements string */
        String elements = "";
        for (Object obj : Elements) {
            elements += obj.toString()+"\n";
        }
        return elements;
    }
}
