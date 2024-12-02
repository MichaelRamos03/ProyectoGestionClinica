/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Estructuras.Lista;
import Modelo.Consulta;

/**
 *
 * @author MINEDUCYT
 */
public interface IConsulta {
    //010011001001100

    public Lista<Consulta> selectAll();
    public Lista<Consulta> selectAllTo(String atributo, String condicion);

    public boolean insert(Consulta obj);

    public boolean update(Consulta obj);

    public boolean delete(Consulta obj);

    public Lista<Consulta> buscar(String dato);

}
