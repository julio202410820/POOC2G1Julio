package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.modelo.Perfil;
import pe.edu.upeu.sysalmacenfx.repositorio.PerfilRepository;

import java.util.List;

@Service
public class PerfilSevice {
    @Autowired
    PerfilRepository repo;

    public Perfil save(Perfil to){
        return repo.save(to);
    }

    public List<Perfil> list(){
        return repo.findAll();
    }

    public Perfil update(Perfil to, Long idPerfil){
        try {
            Perfil existingPerfil = repo.findById(idPerfil).orElse(null);
            if (existingPerfil != null) {
                existingPerfil.setNombre(to.getNombre());
                existingPerfil.setCodigo(to.getCodigo());
            }
            return repo.save(existingPerfil);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public void delete(Long idPerfil){
        repo.deleteById(idPerfil);
    }

    public Perfil buscarId(Long idPerfil){
        return repo.findById(idPerfil).orElse(null);
    }
}
