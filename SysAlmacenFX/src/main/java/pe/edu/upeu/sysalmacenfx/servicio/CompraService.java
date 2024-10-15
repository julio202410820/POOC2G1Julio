package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.dto.ComboBoxOption;
import pe.edu.upeu.sysalmacenfx.modelo.Compra;
import pe.edu.upeu.sysalmacenfx.repositorio.CompraRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompraService {
    @Autowired
    CompraRepository repo;

    public Compra save(Compra to){
        return repo.save(to);
    }

    public List<Compra> list(){
        return repo.findAll();
    }

    public Compra update(Compra to, Long idCompra){
        try {
            Compra existingCompra = repo.findById(idCompra).orElse(null);
            if (existingCompra != null) {
                existingCompra.setPrecioBase(to.getPrecioBase());
                existingCompra.setIgv(to.getIgv());
                existingCompra.setPrecioTotal(to.getPrecioTotal());
                existingCompra.setProveedor(to.getProveedor());
                existingCompra.setUsuario(to.getUsuario());
                existingCompra.setSerie(to.getSerie());
                existingCompra.setNumDoc(to.getNumDoc());
                existingCompra.setFechaComp(to.getFechaComp());
                existingCompra.setTipoDoc(to.getTipoDoc());
                existingCompra.setFechaReg(to.getFechaReg());
                existingCompra.setCompraDetalles(to.getCompraDetalles());
            }
            return repo.save(existingCompra);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public void delete(Long idCompra){
        repo.deleteById(idCompra);
    }

    public Compra buscarId(Long idCompra){
        return repo.findById(idCompra).orElse(null);
    }
}
