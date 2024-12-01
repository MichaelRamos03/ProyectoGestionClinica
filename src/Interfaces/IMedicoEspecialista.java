/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Estructuras.ListaDoble;
import Modelo.MedicoEspecialista;

/**
 *
 * @author MINEDUCYT
 */
public interface IMedicoEspecialista {
    public ListaDoble<MedicoEspecialista> selectAll();
}
