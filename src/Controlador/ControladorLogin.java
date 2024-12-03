/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Usuario;
import ModeloDao.UsuarioDao;
import Utilidades.Encriptar;
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
    //private LoginDao LoginDao;
    private UsuarioDao usuarioDao;

    public ControladorLogin(VistaLogin vistaLogin) {
        this.vistaLogin = vistaLogin;
        this.vistaLogin.setVisible(true);
        this.vistaLogin.setLocationRelativeTo(null);
        this.vistaLogin.setDefaultCloseOperation(vistaLogin.EXIT_ON_CLOSE);
        this.vistaLogin.btnIngresar.addActionListener(this);
        this.vistaLogin.btnSalir.addActionListener(this);

        this.usuarioDao = new UsuarioDao();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vistaLogin.btnIngresar) {
            String usuario = this.vistaLogin.txtUsuario1.getText();
            char[] passwordChars = this.vistaLogin.Jpassword.getPassword();
            String contrasenia = new String(passwordChars);
            java.util.Arrays.fill(passwordChars, '\0'); //Limpia

            if (validarCampos(usuario, contrasenia)) {
                Usuario u = new Usuario();
                u.setUsuario(usuario);
               
                Usuario user = this.usuarioDao.obtenerUsuarioPorNombre(u);

                if (user != null) {
                   
                    String hashIngresado = Encriptar.getStringMessageDigest(contrasenia, Encriptar.SHA256);

                   
                    if (hashIngresado.equals(user.getContrasenia())) {
                        
                        DesktopNotify.setDefaultTheme(NotifyTheme.LightBlue);
                        DesktopNotify.showDesktopMessage(
                                "Login Exitoso",
                                "Empleado :" + user.getEmpleado().getNombre() + " " + user.getEmpleado().getApellido() + " ingresado al sistema",
                                DesktopNotify.SUCCESS, 5000
                        );
                        this.vistaLogin.dispose();
                        Iniciar(user);
                    } else {
                      
                        DesktopNotify.setDefaultTheme(NotifyTheme.Red);
                        DesktopNotify.showDesktopMessage(
                                "Login Fallido",
                                "Usuario o contraseña incorrectos",
                                DesktopNotify.ERROR, 5000
                        );
                    }
                } else {
                    // Usuario no encontrado
                    DesktopNotify.setDefaultTheme(NotifyTheme.Red);
                    DesktopNotify.showDesktopMessage(
                            "Login Fallido",
                            "Usuario no encontrado en el sistema",
                            DesktopNotify.ERROR, 5000
                    );
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

    public void Iniciar(Usuario user) {

        // aplicacion de los permisos para la gestion
        if (user.getEmpleado().getRol().getRol().equals("Administrador")) {

           // ACCESO A TODO
            Menu m = new Menu();
            m.setVisible(true);
          // m.Rol.setVisible(false);

        } else if (user.getEmpleado().getRol().getRol().equals("Doctor")) {

             // doctor solo puede ver expediente, receta
            Menu m = new Menu();
            m.setVisible(true);
            m.Rol.setVisible(false);
            m.Usuarios.setVisible(false);
            m.Empleados.setVisible(false);
            m.Especialidad.setVisible(false);
            m.Especialista.setVisible(false);
            m.Recepcion.setVisible(false);
            m.Medicamento.setVisible(false);
            m.Farmacia.setVisible(false);
            
            
        } else if (user.getEmpleado().getRol().getRol().equals("Enfermera")) {
            // enfermera solo puede hacer recepciones
            Menu m = new Menu();
            m.setVisible(true);
            m.Rol.setVisible(false);
            m.Usuarios.setVisible(false);
            m.Empleados.setVisible(false);
            m.Especialidad.setVisible(false);
            m.Especialista.setVisible(false);
            m.Receta.setVisible(false);
            m.Medicamento.setVisible(false);
            m.Farmacia.setVisible(false);
            m.Consultas.setVisible(false);
            
        } else if (user.getEmpleado().getRol().getRol().equals("Farmaceutico")) {
            Menu m = new Menu();
            m.setVisible(true);
            
            m.Rol.setVisible(false);
            m.Usuarios.setVisible(false);
            m.Empleados.setVisible(false);
            m.Especialidad.setVisible(false);
            m.Especialista.setVisible(false);
            m.Receta.setVisible(false);
           m.Recepcion.setVisible(false);
           m.Consultas.setVisible(false);
           m.Expediente.setVisible(false);
        } 

    }
}
