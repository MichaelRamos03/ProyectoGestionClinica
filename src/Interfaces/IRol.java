/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Estructuras.Cola;
import Modelo.Rol;

/**
 *
 * @author PC
 */
public interface IRol {
    public Cola<Rol> selectAll();
    public boolean insert(Rol r);
    public boolean update(Rol r);
    public boolean delete(Rol r);
}
