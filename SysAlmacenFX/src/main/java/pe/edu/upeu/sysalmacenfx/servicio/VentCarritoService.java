package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.modelo.VentCarrito;
import pe.edu.upeu.sysalmacenfx.repositorio.VentCarritoRepository;

import java.util.List;

@Service
public class VentCarritoService {
    @Autowired
    VentCarritoRepository repo;

    public VentCarrito save(VentCarrito to){
        return repo.save(to);
    }

    public List<VentCarrito> list(){
        return repo.findAll();
    }

    public VentCarrito update(VentCarrito to, Long idCarrito){
        try {
            VentCarrito existingVentCarrito = repo.findById(idCarrito).orElse(null);
            if (existingVentCarrito != null) {
                existingVentCarrito.setDniruc(to.getDniruc());
                existingVentCarrito.setProducto(to.getProducto());
                existingVentCarrito.setNombreProducto(to.getNombreProducto());
                existingVentCarrito.setCantidad(to.getCantidad());
                existingVentCarrito.setPunitario(to.getPunitario());
                existingVentCarrito.setPtotal(to.getPtotal());
                existingVentCarrito.setEstado(to.getEstado());
                existingVentCarrito.setUsuario(to.getUsuario());
            }
            return repo.save(existingVentCarrito);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public void delete(Long idCarrito){
        repo.deleteById(idCarrito);
    }

    public VentCarrito buscarId(Long idCarrito){
        return repo.findById(idCarrito).orElse(null);
    }
}
