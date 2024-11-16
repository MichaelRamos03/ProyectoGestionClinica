/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Estructuras.ListaCircular;
import Modelo.Medicamento;

/**
 *
 * @author karla
 */
public interface IMedicamento {
    public boolean insert(Medicamento obj);
    public boolean update(Medicamento obj);
    public ListaCircular<Medicamento> mostrar();
    public boolean delete(Medicamento obj);
    
}
