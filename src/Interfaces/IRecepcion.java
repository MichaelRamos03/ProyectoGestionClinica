/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Estructuras.ColaPrioridad;
import Modelo.Recepcion;

/**
 *
 * @author karla
 */
public interface IRecepcion {
    
    //// Una cola con tres niveles de prioridad 0 Alta,1 Media 2,Baja

    public boolean insert(Recepcion obj);
    public boolean update(Recepcion obj);
    public ColaPrioridad<Recepcion> mostrar();
    public boolean delete(Recepcion obj);
}
