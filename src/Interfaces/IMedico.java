/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Estructuras.ListaDoble;
import Modelo.MedicoEspecialista;

/**
 *
 * @author equipo
 */
public interface IMedico {
     public boolean insert(MedicoEspecialista obj1);
    public boolean update(MedicoEspecialista obj2);
    public ListaDoble<MedicoEspecialista> mostrar();
    public boolean delete(MedicoEspecialista obj3);
}
