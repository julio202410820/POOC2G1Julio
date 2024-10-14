package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upeu.sysalmacenfx.modelo.Producto;
import pe.edu.upeu.sysalmacenfx.repositorio.ProductoRepository;

import java.util.List;

public class ProductoService {
    @Autowired
    ProductoRepository repo;

    // Save a new Categoria
    public Producto save(Producto to) {
        return repo.save(to);
    }

    // List all Categorias
    public List<Producto> list() {return repo.findAll();}

    // Update an existing Categoria
    public Producto update(Producto to, Long id) {
        try {
            Producto existingCategoria = repo.findById(id).orElse(null);
            if (existingCategoria != null) {
                existingCategoria.setNombre(to.getNombre());
                return repo.save(existingCategoria);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    // Delete a Categoria by ID
    public void delete(Long id) {
        repo.deleteById(id);
    }

    // Find a Categoria by ID
    public Producto buscarId(Long id) {
        return repo.findById(id).orElse(null);
    }

}
