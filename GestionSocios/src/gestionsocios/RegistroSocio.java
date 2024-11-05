package gestionsocios;
import java.util.Scanner;
/**
 *
 * @author Rafael
 */
public class RegistroSocio {
    public static Socio RegistrarSocio() {
        
        Scanner reader = new Scanner(System.in);
        
        System.out.print("Ingrese número de Socio: ");
        int partnerId = reader.nextInt();
        reader.nextLine();
        
        String rut;
        do {
            System.out.print("Ingrese RUT: ");
            rut = reader.nextLine();

            if (!validateRut(rut)) {
                System.out.println("RUT Invalido, ingrese nuevamente");
            }
        } while (!validateRut(rut));
        
        
        System.out.print("Ingrese Nombre: ");
        String name = reader.nextLine();
        
        System.out.print("Ingrese Apellido Paterno: ");
        String lastName = reader.nextLine();
        
        System.out.print("Ingrese Apellido Materno: ");
        String sLastName = reader.nextLine();
        
        System.out.print("Ingrese Email: ");
        String email = reader.nextLine();
        
        System.out.print("Ingrese Domicilio: ");
        String address = reader.nextLine();
        
        System.out.print("Ingrese Región: ");
        String region = reader.nextLine();
        
        System.out.print("Ingrese Ciudad: ");
        String city = reader.nextLine();
        
        System.out.print("Ingrese Comuna: ");
        String commune = reader.nextLine();

        boolean telefonoValido = false;
        int phoneNum = 0;
        
        while (!telefonoValido) {
            try {
                System.out.print("Ingrese Teléfono: ");
                phoneNum = reader.nextInt();
                reader.nextLine();
                telefonoValido = true;
            } catch (Exception e) {
                System.out.println("Ingrese un telefono valido");
                reader.nextLine();
            }
        }   
        
        return new Socio(partnerId, rut, name, lastName, sLastName, email, address, region, city, commune, phoneNum);
    }

    public static boolean validateRut(String rut) {

        String regex = "^[0-9]{1,2}\\.[0-9]{3}\\.[0-9]{3}-[0-9kK]$";
        return rut.matches(regex) && (rut.length() >= 11 && rut.length() <= 12);

    }
}
