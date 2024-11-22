/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Usuario;
import ModeloDao.UsuarioDao;
import Vista.Menu;
import Vista.VistaAdministrador;
import Vista.VistaLogin;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author karla
 */
public class ControladorLogin extends MouseAdapter implements ActionListener, MouseListener {

    private VistaLogin vistaLogin;
    private UsuarioDao usuarioDao;

    public ControladorLogin(VistaLogin vistaLogin) {
        this.vistaLogin = vistaLogin;
        this.vistaLogin.setVisible(true);
        this.vistaLogin.setLocationRelativeTo(null);
        this.vistaLogin.setDefaultCloseOperation(vistaLogin.EXIT_ON_CLOSE);
        this.vistaLogin.btnIngresar.addActionListener(this);
        this.vistaLogin.btnSalir.addActionListener(this);
        
        this.usuarioDao= new UsuarioDao();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vistaLogin.btnIngresar) {
            String usuario = this.vistaLogin.txtUsuario1.getText();
            // se obtiene la contrasenia mediante get Pass y luego se pasa a string
            char[] passwordChars = this.vistaLogin.Jpassword.getPassword();
            String contrasenia = new String(passwordChars);
            java.util.Arrays.fill(passwordChars, '\0');
            if(validarCampos(usuario, contrasenia)){
                Usuario user= new Usuario();
               user= this.usuarioDao.validarLogin(usuario, contrasenia);
            if(user!=null){
                DesktopNotify.setDefaultTheme(NotifyTheme.LightBlue);
            DesktopNotify.showDesktopMessage("Login Exitoso", "Empleado :"+user.getEmpleado().getNombre()+" "+user.getEmpleado().getApellido()+" Ingresado al sistema",
                    DesktopNotify.SUCCESS, 5000);
            this.vistaLogin.dispose();
            Iniciar(user);
             
                
            
            
            }else{
                  DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Login Fallido", "Usuario no encontrado en el sistema",
                    DesktopNotify.ERROR, 5000);
            }
            
            }
            this.vistaLogin.txtUsuario1.setText("");
            this.vistaLogin.Jpassword.setText("");
        }
        if (e.getSource() == this.vistaLogin.btnSalir) {
            this.vistaLogin.dispose();
        }
    }

    public boolean validarCampos(String usuario, String contrasenia) {
        // LOS NOMBRE DE USUARIO NO DEBEN DE TENER ESPACIOS
        usuario = usuario.replace(" ", "");
        if (usuario.equals(" ") || usuario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre de usuario está vacio");
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Login", "Nombre de Usuario vacío", DesktopNotify.ERROR, 3000);

            return false;
        }
        // LAS CONTRASEÑIAS NO DEBEN DE TENER ESPACIOS
        contrasenia = contrasenia.replace(" ", "");
        if (contrasenia.equals(" ") || contrasenia.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La contrasenia no debe estar vacia");
            DesktopNotify.setDefaultTheme(NotifyTheme.Red);
            DesktopNotify.showDesktopMessage("Login", "Contraseña vacía", DesktopNotify.ERROR, 3000);
            return false;
        }

        return true;
    }
    
    public void Iniciar(Usuario user){
        
        if(user.getEmpleado().getRol().getRol().equals("Administrador")){
//               VistaAdministrador vistaAdministrador = new VistaAdministrador();
//            ControladorAdministrador controladorAdministrador = new ControladorAdministrador(vistaAdministrador);
//             vistaAdministrador.setVisible(true);

            Menu m = new Menu();
            m.setVisible(true);
             
             
        }
    }
}
