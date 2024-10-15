package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upeu.sysalmacenfx.dto.ComboBoxOption;
import pe.edu.upeu.sysalmacenfx.modelo.Categoria;

import pe.edu.upeu.sysalmacenfx.repositorio.CategoriaRepository;


import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    @Autowired
    CategoriaRepository repo;
    //    CategoriaRepository repo=new  CategoriaRepository()
//C
    public Categoria save(Categoria to){
        return repo.save(to);
    }
    public List <Categoria> list(){
        return repo.findAll();
    }
    public Categoria update(Categoria to, Long id){
        try{
            Categoria toe=repo.findById(id).get();
            if(toe!=null){
                toe.setNombre(to.getNombre());
            }
            return repo.save(toe);

        }catch (Exception e){
            System.out.println("error:"+e.getMessage());
        }
        return null;
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
    public Categoria buscarId(Long id){
        return repo.findById(id).get();
    }
    public List<ComboBoxOption> listarCombobox(){
        List<ComboBoxOption> listar =new ArrayList<>();
        for (Categoria cate : repo.findAll()) {
            listar.add(new ComboBoxOption(String
                    .valueOf(cate.getIdCategoria()),
                    cate.getNombre()));

        }
        return listar;
    }
}