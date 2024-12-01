
package Modelo;

import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Michael Ramos;
**/
public class Conexion {
    
     Connection cn;

    public Conexion() {
        
    }
    
    public Connection getConexion(){
        String user ="postgres";
        String clave = "root";
        String url = "jdbc:postgresql://localhost:5433/proyectofinal_clinica";
        
        try{
            this.cn = DriverManager.getConnection(url, user, clave);
            DesktopNotify.setDefaultTheme(NotifyTheme.Green);
            DesktopNotify.showDesktopMessage("Exito", "la conexion tubo exito",
            DesktopNotify.SUCCESS, 2000);
            
        }catch(Exception ex){
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Error en la conexion a la base",
            DesktopNotify.ERROR, 2000);
        }
        return cn;
    }
    
    public void closeConexion(Connection conn){
        try{
            if (conn != null) {
                conn.close();
            }
        }catch(Exception sql){
            sql.printStackTrace();
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Error", "Error al cerrar la conexion a la base",
            DesktopNotify.ERROR, 3000);   
        }
    }
}
