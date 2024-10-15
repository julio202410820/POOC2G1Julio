package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.modelo.Usuario;
import pe.edu.upeu.sysalmacenfx.repositorio.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioSevice {
    @Autowired
    UsuarioRepository repo;

    public Usuario save(Usuario to){
        return repo.save(to);
    }

    public List<Usuario> list(){
        return repo.findAll();
    }

    public Usuario update(Usuario to, Long idUsuario){
        try {
            Usuario existingUsuario = repo.findById(idUsuario).orElse(null);
            if (existingUsuario != null) {
                existingUsuario.setUser(to.getUser());
                existingUsuario.setClave(to.getClave());
                existingUsuario.setEstado(to.getEstado());
                existingUsuario.setIdPerfil(to.getIdPerfil());
            }
            return repo.save(existingUsuario);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public void delete(Long idUsuario){
        repo.deleteById(idUsuario);
    }

    public Usuario buscarId(Long idUsuario){
        return repo.findById(idUsuario).orElse(null);
    }
}
