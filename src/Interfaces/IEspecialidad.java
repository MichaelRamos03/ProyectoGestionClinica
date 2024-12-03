/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Estructuras.ABinarioBusqueda;
import Estructuras.ListaDoble;
import Modelo.Especialidad;
import Modelo.Expediente;

/**
 *
 * @author Gaby Laínez
 */
public interface IEspecialidad {
    public ListaDoble<Especialidad> selectAll();
    public boolean insert(Especialidad obj);
    public boolean update(Especialidad obj);
    public boolean delete(Especialidad obj);
    public ABinarioBusqueda<Especialidad> buscar();
    
}
