package pe.edu.upeu.calcfx.dao;

import org.springframework.stereotype.Component;
import pe.edu.upeu.calcfx.conexion.ConnDB;
import pe.edu.upeu.calcfx.modelo.CaltTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class calculadoraDao {
    PreparedStatement ps;
    ResultSet rs;
    ConnDB con;
    Connection conn;

    calculadoraDao(){
        con = new ConnDB();     
        conn= con.getConn();
    }

    public List<CaltTO> listar(){
        List<CaltTO> listC= new ArrayList<>();
        try{
            ps=conn.prepareStatement("SELECT * from Calculadora");
            rs=ps.executeQuery();
            while (rs.next()){
                CaltTO caltTO = new CaltTO();
                caltTO.setNum1(rs.getString("num1"));
                caltTO.setNum2(rs.getString("num2"));
                caltTO.setOperador(rs.getString("operador").charAt(0));
                caltTO.setResultado(rs.getString("resultado"));
                listC.add(caltTO);

            }


        }catch (Exception e){
            System.out.println(e.getMessage());

        }
        return null;

    }

    public void insertar(CaltTO caltTO){
        try{
            ps=conn.prepareStatement("INSERT INTO Calculadora(num1, num2, operador, resultado) values('3', '4', '*', '12');");
            ps.setString(1,caltTO.getNum1());
            ps.setString(2,caltTO.getNum2());
            ps.setString(3,String.valueOf(caltTO.getOperador()));
            ps.setString(4,caltTO.getResultado());
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
