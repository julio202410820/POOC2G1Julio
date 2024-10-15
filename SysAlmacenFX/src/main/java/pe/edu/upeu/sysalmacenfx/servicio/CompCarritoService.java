package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.dto.ComboBoxOption;

import pe.edu.upeu.sysalmacenfx.modelo.CompCarrito;

import pe.edu.upeu.sysalmacenfx.repositorio.CompraCarritoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompCarritoService {
    @Autowired
    CompraCarritoRepository repo;

    public CompCarrito save(CompCarrito to){
        return repo.save(to);
    }

    public List<CompCarrito> list(){
        return repo.findAll();
    }

    public CompCarrito update(CompCarrito to, Long idCompCarrito){
        try {
            CompCarrito existingCompCarrito = repo.findById(idCompCarrito).orElse(null);
            if (existingCompCarrito != null) {
                existingCompCarrito.setProveedor(to.getProveedor());
                existingCompCarrito.setProducto(to.getProducto());
                existingCompCarrito.setNombreProducto(to.getNombreProducto());
                existingCompCarrito.setCantidad(to.getCantidad());
                existingCompCarrito.setPunitario(to.getPunitario());
                existingCompCarrito.setPtotal(to.getPtotal());
                existingCompCarrito.setEstado(to.getEstado());
                existingCompCarrito.setUsuario(to.getUsuario());
            }
            return repo.save(existingCompCarrito);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public void delete(Long idCompCarrito){
        repo.deleteById(idCompCarrito);
    }

    public CompCarrito buscarId(Long idCompCarrito){
        return repo.findById(idCompCarrito).orElse(null);
    }
}
