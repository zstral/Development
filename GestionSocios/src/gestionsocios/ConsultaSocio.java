package gestionsocios;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class ConsultaSocio {
    public static void consultarSocio(ArrayList<Socio> socios) {
        Scanner reader = new Scanner(System.in);
        
        Socio found = null;
        
        System.out.println("Ingrese el número de socio que desea consultar:");
        int partnerId = reader.nextInt();
        
        for (Socio socio : socios) {
            if (socio.getPartnerId() == partnerId) {
                found = socio;
                break;
            }
        }
        
        if (found != null){
            System.out.println("Datos del Socio:");
            System.out.println("ID: " + found.getPartnerId());
            System.out.println("RUT: " + found.getRut());
            System.out.println("Nombre: " + found.getName());
            System.out.println("Apellido Paterno: " + found.getLastName());
            System.out.println("Apellido Materno: " + found.getsLastName());
            System.out.println("Email: " + found.getEmail());
            System.out.println("Domicilio: " + found.getAddress());
            System.out.println("Región: " + found.getRegion());
            System.out.println("Ciudad: " + found.getCity());
            System.out.println("Comuna: " + found.getCommune());
            System.out.println("Teléfono: " + found.getPhoneNum());
        }
        else {
            System.out.println("Socio no encontrado.");
        }
    }
}
