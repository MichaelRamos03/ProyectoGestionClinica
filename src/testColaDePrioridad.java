
import Estructuras.ColaPrioridad;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author karla
 */
public class testColaDePrioridad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
// Una cola con tres niveles de prioridad 0 Alta,1 Media 2,Baja
ColaPrioridad colaPrioridad = new ColaPrioridad(3);

colaPrioridad.offer("Paciente C", 0);
colaPrioridad.offer("Paciente B", 1);
colaPrioridad.offer("Paciente A", 2);
        System.out.println("Pacientes en la cola: "+colaPrioridad.toArray());
        System.out.println("Paciente en la primera posicion"+colaPrioridad.peek());
        System.out.println("Paciente procesado: "+colaPrioridad.poll());
colaPrioridad.prioridad();
    }
    
}
