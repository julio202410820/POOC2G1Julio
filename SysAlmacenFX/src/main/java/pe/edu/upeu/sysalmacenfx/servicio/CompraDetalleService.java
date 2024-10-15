package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.modelo.CompraDetalle;
import pe.edu.upeu.sysalmacenfx.repositorio.CompraDetalleRepository;

import java.util.List;

@Service
public class CompraDetalleService {
    @Autowired
    CompraDetalleRepository repo;

    public CompraDetalle save(CompraDetalle to){
        return repo.save(to);
    }

    public List<CompraDetalle> list(){
        return repo.findAll();
    }

    public CompraDetalle update(CompraDetalle to, Long idCompraDetalle){
        try {
            CompraDetalle existingCompraDetalle = repo.findById(idCompraDetalle).orElse(null);
            if (existingCompraDetalle != null) {
                existingCompraDetalle.setPu(to.getPu());
                existingCompraDetalle.setCantidad(to.getCantidad());
                existingCompraDetalle.setSubtotal(to.getSubtotal());
                existingCompraDetalle.setCompra(to.getCompra());
                existingCompraDetalle.setProducto(to.getProducto());
            }
            return repo.save(existingCompraDetalle);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public void delete(Long idCompraDetalle){
        repo.deleteById(idCompraDetalle);
    }

    public CompraDetalle buscarId(Long idCompraDetalle){
        return repo.findById(idCompraDetalle).orElse(null);
    }
}
