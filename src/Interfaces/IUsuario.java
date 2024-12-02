/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Estructuras.ABinarioBusqueda;
import Estructuras.Cola;
import Modelo.Usuario;

/**
 *
 * @author Gaby Laínez
 */
public interface IUsuario {
    
    public Cola<Usuario> selectAll();
    public boolean insert(Usuario obj);
    public boolean update(Usuario obj);
    public boolean delete(Usuario obj);
    public ABinarioBusqueda<Usuario>buscar();
    
}
