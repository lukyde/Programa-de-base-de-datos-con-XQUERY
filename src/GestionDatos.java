import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.basex.core.*;
import org.basex.core.cmd.*;

public class GestionDatos {

    //privates Context contexto;
    private static String direccion = "AD52425/taller.xml";
 

    public void creacionFiecheros() {

        try {
            FileReader taller = new FileReader(this.direccion);
            BufferedReader br = new BufferedReader(taller);

            //   FileWriter fichero = new FileWriter(ficheroReparaciones);
            //   BufferedWriter writer = new BufferedWriter(fichero);
            String linea;
            StringBuilder todoElfichero = new StringBuilder();
            String[] archivos = null;
            int contador = 0;
            while ((linea = br.readLine()) != null) {
                contador++;
                if (contador > 3) {
                    todoElfichero.append(linea).append("\n");
                }

            }
            contador = 0;
            linea = todoElfichero.toString();
            archivos = linea.split("</vehiculos>");
            if (archivos.length > 0) {
                String codigoPrimero = archivos[0];
                String[] vehiculos = codigoPrimero.split("</vehiculos>");

                for (int i = 0; i < vehiculos.length; i++) {
                    String vehiculo = vehiculos[i];
                    String[] vehiculoSeparados = vehiculo.split("</vehiculo>");
                    for (int j = 0; j < vehiculoSeparados.length; j++) {

                        if (vehiculoSeparados[j].trim().isEmpty()) {

                        } else {
                            //Véhiculos
                            contador++;
                            String ficheroVehiculo = "AD52425/vehiculos" + contador + ".xml";
                            StringBuilder vehiculosEscribir = new StringBuilder();
                            vehiculosEscribir.append(vehiculoSeparados[j]);
                            vehiculosEscribir.append("</vehiculo>");

                            String ficheroMarca = "AD52425/marca" + contador + ".xml";
                            String marcaString = vehiculosEscribir.toString();
                            String[] marcasSeparadas = marcaString.split("<marca>");

                            if (marcasSeparadas.length > 1) {

                                String fragmentoMarca = marcasSeparadas[1];
                                String[] partesMarca = fragmentoMarca.split("</marca>");
                                String marcaSinEtiqueta = partesMarca[0];
                                String marca = marcaSinEtiqueta.trim();

                                StringBuilder marcaEscribir = new StringBuilder();
                                marcaEscribir.append("<marca>").append(marca).append("</marca>");

                                try (FileWriter fichero = new FileWriter(ficheroMarca);
                                        BufferedWriter writer = new BufferedWriter(fichero)) {
                                    writer.write(marcaEscribir.toString());
                                } catch (IOException e) {
                                    System.err.println("Error al escribir el archivo de la marca: " + e.getMessage());
                                }

                            }

                            try {
                                FileWriter fichero = new FileWriter(ficheroVehiculo);
                                BufferedWriter writer = new BufferedWriter(fichero);
                                writer.write(vehiculosEscribir.toString());
                                writer.close();

                            } catch (IOException e) {
                                System.err.println("Error al escribir el archivo: " + e.getMessage());
                            }

                        }

                    }

                }

                codigoPrimero = archivos[1];
                String[] reparaciones = codigoPrimero.split("</reparaciones>");
                contador = 0;
                for (int i = 0; i < reparaciones.length; i++) {
                    String reparacion = reparaciones[i];
                    String[] reparacionSeparados = reparacion.split("</entrada>");
                    for (int j = 0; j < reparacionSeparados.length; j++) {
                        String elemento = reparacionSeparados[j].trim();
                        if (elemento.contains("</taller>") || elemento.isEmpty()) {

                        } else {
                            contador++;
                            String ficheroReparaciones = "AD52425/reparacion" + contador + ".xml";
                            StringBuilder reparacionEscribir = new StringBuilder();
                            reparacionEscribir.append(elemento);
                            reparacionEscribir.append("</entrada>");
                            try {
                                FileWriter fichero = new FileWriter(ficheroReparaciones);
                                BufferedWriter writer = new BufferedWriter(fichero);
                                writer.write(reparacionEscribir.toString());
                                writer.close();

                            } catch (IOException e) {
                                System.err.println("Error al escribir el archivo: " + e.getMessage());
                            }
                        }

                    }

                }

            }

            br.close();
            
              
            System.out.println("Se ha guardado el archivo de reparaciones.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    

}
