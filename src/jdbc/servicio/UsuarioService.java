package jdbc.servicio;

import java.util.List;
import jdbc.persistencia.UsuarioDAO;
import jdbc.entidades.Usuario;

public class UsuarioService {

    private UsuarioDAO dao;

    public UsuarioService() {
        this.dao = new UsuarioDAO();
    }

    public List<Usuario> listarTodos() throws Exception {
        List<Usuario> usuarios = dao.listarTodos();
        return usuarios;
    }

    public void mostrarTodos() throws Exception {
        List<Usuario> usuarios = listarTodos();
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    public void crearUsuario(String clave, String nombre, String correoElectronico, int edad) throws Exception {

    }
    
    public Usuario buscarPorCorreoElectronico(String correo) throws Exception{
        Usuario usuario = dao.buscarPorCorreoElectronico(correo);
        return usuario;
    }
    
    public void modificarUsuario(String correo, String nombre) throws Exception{
        Usuario u = new Usuario();
        u.setCorreoElectronico(correo);
        u.setNombre(nombre);
        
        dao.modificarUsuario(u);
    }
    
    public void eliminarUsuario(String correo) throws Exception{
        dao.eliminarUsuario(correo);
    }

    public void Validar(String clave, String nombre, String correoElectronico, int edad) throws Exception {
        if(clave == null || clave.isEmpty()){
            throw new Exception("Debe indicar la clave");
        }
        if(nombre == null || nombre.isEmpty()){
            throw new Exception("Debe indicar el nombre");
        }if(edad <= 0 || edad >= 120){
            throw new Exception("Edad incorrecta");
        }
        Usuario u = buscarPorCorreoElectronico(correoElectronico);
        if(u != null){
            throw new Exception("Correo repetido");
        }
    }
}
