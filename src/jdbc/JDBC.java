
package jdbc;

import jdbc.servicio.UsuarioService;


public class JDBC {


    public static void main(String[] args) {
        UsuarioService usuarioService = new UsuarioService();
        
        try {
            usuarioService.crearUsuario("180","Avelino","avel@gmail.com",28);
            usuarioService.mostrarTodos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
