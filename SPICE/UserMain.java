/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SPICE;
import java.util.Scanner;


/**Takes user input from the keyboard **/
public class UserMain {
    
    /**
     *
     * @param args
     */
    public static void main(String[] args){
        Circuit circuit = Circuit.getInstance(); /*Required for program to work */
        
        Scanner userIn = new Scanner(System.in);
        boolean cont = true;
        
        System.out.println("This program builds circuits by adding resistor and voltage source elements. For example, to add a resistor element with 5.2 Ohms of resistance, between nodes 2 and 3, the user would input:\nr 2 3 5.2\nThe same formatting is valid for a voltage source.\n");
        System.out.println("Please describe the desired element below, or type 'spice' to see all elements within the circuit, or 'end' to terminate the program.");
        
        String element;
        int node1;
        int node2;
        double value;
        Node Node1 = new Node();
        Node Node2 = new Node();
        
        String input = "";
        input = userIn.nextLine();
       
        while (cont){
            if (input.startsWith("r") || input.startsWith("R")){
                String dataIn[] = input.split(" ");
                element = dataIn[0];
                node1 = Integer.parseInt(dataIn[1]);
                node2 = Integer.parseInt(dataIn[2]);
                value = Double.parseDouble(dataIn[3]);

                Node1.nID = node1;
                Node2.nID = node2;
                    
                Resistor resistor = new Resistor(value, Node1, Node2);
                circuit.add(resistor);
            }
            else if (input.startsWith("v") || input.startsWith("V")){
                String dataIn[] = input.split(" ");
                element = dataIn[0];
                node1 = Integer.parseInt(dataIn[1]);
                node2 = Integer.parseInt(dataIn[2]);
                value = Double.parseDouble(dataIn[3]);

                Node1.nID = node1;
                Node2.nID = node2;
                    
                Voltage voltage = new Voltage(value, Node1, Node2);
                circuit.add(voltage); 
            }
            else if (input.equalsIgnoreCase("spice")){
                System.out.println(circuit.spice());
            }
            else if (input.equalsIgnoreCase("end")){
                System.out.println(circuit.endCircuit());
                cont = false;
                break;
            }
            else {
                System.out.println("Invaild input");
            }
            input = userIn.nextLine();
        }
    }
}        