package pe.edu.upeu.calcfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.calcfx.dao.calculadoraDao;
import pe.edu.upeu.calcfx.modelo.CaltTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalcServiceImp implements CalcServiceI {

    @Autowired
    calculadoraDao dbOper;

    //List <CaltTO> dbOper= new ArrayList<>();

    @Override
    public void guardarResultados(CaltTO to) {dbOper.insertar(to);}

    @Override
    public List<CaltTO> obtenerResultaOper() {
        return null;
    }

    @Override
    public void actuslizarresultado(CaltTO to, int index) {
        //dbOper.set(index,to);

    }

    @Override
    public void eliminarResultado(int index) {
        //dbOper.remove(index);

    }
}
