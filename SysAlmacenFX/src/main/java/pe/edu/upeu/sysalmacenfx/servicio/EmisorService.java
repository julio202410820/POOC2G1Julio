package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.modelo.Emisor;
import pe.edu.upeu.sysalmacenfx.repositorio.EmisorRepository;

import java.util.List;

@Service
public class EmisorService {
    @Autowired
    EmisorRepository repo;

    public Emisor save(Emisor to){
        return repo.save(to);
    }

    public List<Emisor> list(){
        return repo.findAll();
    }

    public Emisor update(Emisor to, Long idEmisor){
        try {
            Emisor existingEmisor = repo.findById(idEmisor).orElse(null);
            if (existingEmisor != null) {
                existingEmisor.setRuc(to.getRuc());
                existingEmisor.setNombreComercial(to.getNombreComercial());
                existingEmisor.setUbigeo(to.getUbigeo());
                existingEmisor.setDomicilioFiscal(to.getDomicilioFiscal());
                existingEmisor.setUrbanizacion(to.getUrbanizacion());
                existingEmisor.setDepartamento(to.getDepartamento());
                existingEmisor.setProvincia(to.getProvincia());
                existingEmisor.setDistrito(to.getDistrito());
            }
            return repo.save(existingEmisor);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public void delete(Long idEmisor){
        repo.deleteById(idEmisor);
    }

    public Emisor buscarId(Long idEmisor){
        return repo.findById(idEmisor).orElse(null);
    }
}
