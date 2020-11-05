/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallercolasimpresion;

import java.util.LinkedList;
import java.util.List;

/*
 * EJEMPLO DE COLAS IMPLEMENTADAS CON LINKEDLIST
 */

/**
 *
 * @author Practica
 */
public class Cola {

    /**
     * @param args the command line arguments
     */
    private final LinkedList<Trabajo> list;
	
	// Queue constructor
	public Cola()
	{
            // Create a new LinkedList.
            list = new LinkedList();
	}

	public boolean estaVacia()
	// Post: Returns true if the queue is empty. Otherwise, false.
	{
            return list.isEmpty();
	}

        
        public int obtenerTamanio()
	// Post: Returns the size.
	{
            return list.size();
	}
        
	public void encolar(Trabajo item)
	// Post: An item is added to the back of the queue.
	{
            // Append the item to the end of our linked list.
            list.add(item);
	}

	public Trabajo desencolar()
	{
            Trabajo item = list.get(0);
            list.remove(0);
		
            // Return the item
            return item;
	}

	public Trabajo obtener()
	// Pre: this.isEmpty() == false
	// Post: The item at the front of the queue is returned and 
	//         deleted from the queue. Returns null if precondition
	//         not met.
	{
            // This method is very similar to dequeue().
            // See Queue.dequeue() for comments.
            return estaVacia() ? null : list.get(0);
	}
        
        public List<Trabajo> lista() {
            return list;
        }
    
}
