package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.modelo.Venta;
import pe.edu.upeu.sysalmacenfx.repositorio.VentaRepository;

import java.util.List;

@Service
public class VentaDetalleService {
    @Autowired
    VentaRepository repo;

    public Venta save(Venta to){
        return repo.save(to);
    }

    public List<Venta> list(){
        return repo.findAll();
    }

    public Venta update(Venta to, Long idVenta){
        try {
            Venta existingVenta = repo.findById(idVenta).orElse(null);
            if (existingVenta != null) {
                existingVenta.setPrecioBase(to.getPrecioBase());
                existingVenta.setIgv(to.getIgv());
                existingVenta.setPrecioTotal(to.getPrecioTotal());
                existingVenta.setCliente(to.getCliente());
                existingVenta.setUsuario(to.getUsuario());
                existingVenta.setNumDoc(to.getNumDoc());
                existingVenta.setFechaGener(to.getFechaGener());
                existingVenta.setSerie(to.getSerie());
                existingVenta.setTipoDoc(to.getTipoDoc());
                existingVenta.setVentaDetalles(to.getVentaDetalles());
            }
            return repo.save(existingVenta);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public void delete(Long idVenta){
        repo.deleteById(idVenta);
    }

    public Venta buscarId(Long idVenta){
        return repo.findById(idVenta).orElse(null);
    }
}
