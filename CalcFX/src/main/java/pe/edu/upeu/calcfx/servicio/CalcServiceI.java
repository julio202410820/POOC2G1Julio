package pe.edu.upeu.calcfx.servicio;

import pe.edu.upeu.calcfx.modelo.CalcTO;

import java.util.List;
import java.util.Locale;

public interface CalcServiceI {
    public void guardarResultados(CalcTO to);
    public List<CalcTO> obtenerResultaOper();
    public void actuslizarresultado(CalcTO to, Long index);
    public void eliminarResultado(Long index);


}
