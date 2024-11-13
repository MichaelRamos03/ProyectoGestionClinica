/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Modelo.Usuario;

/**
 *
 * @author karla
 */
public interface ILogin {
    public Usuario validarLogin(String usuario,String contrasenia);
}
