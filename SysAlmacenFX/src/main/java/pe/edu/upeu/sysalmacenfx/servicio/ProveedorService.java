package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.modelo.Proveedor;
import pe.edu.upeu.sysalmacenfx.repositorio.ProveedorRepository;

import java.util.List;

@Service
public class ProveedorService {
    @Autowired
    ProveedorRepository repo;

    public Proveedor save(Proveedor to){
        return repo.save(to);
    }

    public List<Proveedor> list(){
        return repo.findAll();
    }

    public Proveedor update(Proveedor to, Long idProveedor){
        try {
            Proveedor existingProveedor = repo.findById(idProveedor).orElse(null);
            if (existingProveedor != null) {
                existingProveedor.setDniRuc(to.getDniRuc());
                existingProveedor.setNombresRaso(to.getNombresRaso());
                existingProveedor.setTipoDoc(to.getTipoDoc());
                existingProveedor.setCelular(to.getCelular());
                existingProveedor.setEmail(to.getEmail());
                existingProveedor.setDireccion(to.getDireccion());
            }
            return repo.save(existingProveedor);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public void delete(Long idProveedor){
        repo.deleteById(idProveedor);
    }

    public Proveedor buscarId(Long idProveedor){
        return repo.findById(idProveedor).orElse(null);
    }
}
