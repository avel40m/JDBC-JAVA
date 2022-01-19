package jdbc.persistencia;

import java.util.ArrayList;
import java.util.List;
import jdbc.entidades.Usuario;

public class UsuarioDAO extends DAO {

    public List<Usuario> listarTodos() throws Exception {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            consultarBase("SELECT * FROM usuario");
            System.out.println(resultado.toString());

            while (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.setClave(resultado.getString("clave"));
                usuario.setNombre(resultado.getString(2));
                usuario.setCorreoElectronico(resultado.getString(3));
                usuario.setEdad(resultado.getInt("edad"));

                usuarios.add(usuario);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
        return usuarios;
    }

    public void crearUsuario(Usuario usuario) throws Exception {
        try {
            String sql = "INSERT INTO usuario (clave,nombre,correoElectronico,edad) VALUES ('" + usuario.getClave() + "','"
                    + usuario.getNombre() + "','" + usuario.getCorreoElectronico() + "','" + usuario.getEdad() + ")";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public Usuario buscarPorCorreoElectronico(String correo) throws Exception {
        Usuario usuario = null;
        try {
            String sql = "SELECT * FROM usuario WHERE LIKE '%" + correo + "%'";
            consultarBase(sql);
            while (resultado.next()) {
                usuario = new Usuario();
                usuario.setClave(resultado.getString(1));
                usuario.setNombre(resultado.getString(2));
                usuario.setCorreoElectronico(resultado.getString(3));
                usuario.setEdad(resultado.getShort(4));
            }
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarBase();
        }
        return usuario;
    }
    
    public void modificarUsuario(Usuario usuario) throws Exception{
        try {
            String sql = "UPDATE usuario SET nombre = '" + usuario.getNombre() + "' WHERE correoElectronico LIKE '"
                    + usuario.getCorreoElectronico() + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminarUsuario(String correo) throws Exception{
        try {
            String sql = "DELETE FROM usuario WHERE correoElectronico LIKE '" + correo + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
    
}
