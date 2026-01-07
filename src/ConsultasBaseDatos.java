import java.io.BufferedReader;
import java.io.FileReader;
import org.basex.core.*;
import org.basex.core.cmd.*;
import org.basex.query.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author raull
 */
public class ConsultasBaseDatos {

    //privates Context contexto;
    private static String direccion = "./AD52425/taller.xml";
    private static Context contexto;

    public String AbrirBaseDatos(String consultaArchivo) {
        String resultado = null;

        if (contexto == null) {

            contexto = new Context();
        }
        try {
            CreateDB bd = new CreateDB("Taller", direccion);
            bd.execute(contexto);

            System.out.println("Base datos abierta");
            String consulta = consultaArchivo;

            XQuery query = new XQuery(consulta);
            resultado = query.execute(contexto);

            System.out.println(resultado);

            contexto.close();
        } catch (BaseXException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
            e.printStackTrace();
        }

        return resultado;
    }

    public String Actualizar(String consultaArchivo,String consultaQuery) {
        String resultadoActualizacion = null;
        String resultado = null;

        if (contexto == null) {

            contexto = new Context();
        }
        try {
            CreateDB bd = new CreateDB("Taller", direccion);
            bd.execute(contexto);

            System.out.println("Base datos abierta");
            String consulta = consultaArchivo;

            XQuery queryConsulta = new XQuery(consulta);
            resultadoActualizacion = queryConsulta.execute(contexto);

            XQuery query = new XQuery(consultaQuery);
            resultado = query.execute(contexto);

              System.out.println("Resultado de selección: " + resultado);

            contexto.close();
        } catch (BaseXException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
            e.printStackTrace();
        }

        return resultado;
    }

    public String leerArchivo(String ruta) {
        StringBuilder contenido = new StringBuilder();
        try {
            FileReader fichero = new FileReader(ruta);
            BufferedReader buffer = new BufferedReader(fichero);
            String linea;
            while ((linea = buffer.readLine()) != null) {
                contenido.append(linea);
                contenido.append(" ");
            }
            System.out.println(contenido.toString());

        } catch (Exception e) {
        }
        return contenido.toString();
    }

}
