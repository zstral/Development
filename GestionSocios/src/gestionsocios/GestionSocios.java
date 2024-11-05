package gestionsocios;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author Rafael
 */
public class GestionSocios {
    
    private static ArrayList<Socio> socios = new ArrayList<>();
    
    public static void main(String[] args) {
        
        Scanner reader = new Scanner(System.in);
        
        while (true) {
            System.out.println("Menú");
            System.out.println("1 - Registrar Socio");
            System.out.println("2 - Consultar datos del Socio");
            System.out.println("3 - Cancelar cuota");
            System.out.println("4 - Consultar cuota cancelada");
            System.out.println("5 - Consultar total de cuotas pagadas");
            System.out.println("0 - Salir");
            
            System.out.print("Ingrese una opción: ");
            byte option = reader.nextByte();
            
            switch (option) {
                case 1:
                    Socio socio = RegistroSocio.RegistrarSocio();
                    socios.add(socio);
                    System.out.println("Socio registrado con éxito: " + socio.name + " " + socio.lastName);
                    break;
                case 2:
                    ConsultaSocio.consultarSocio(socios);
                    break;
                case 3:
                    System.out.println("Ingrese ID del socio: ");
                    int idQuota = reader.nextInt();
                    reader.nextLine();

                    System.out.println("Ingrese monto de la cuota: ");
                    System.out.println("(El monto de la cuota no puede ser menor o igual a 0$");
                    int amount = reader.nextInt();
                    reader.nextLine();

                    for (Socio s : socios) {
                        if (s.getPartnerId() == idQuota) {
                            s.addQuota(amount);
                            System.out.println("Cuota cancelada con éxito para el socio con ID: " + idQuota);
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Ingrese ID del socio: ");
                    int idQuery = reader.nextInt();

                    for (Socio s : socios) {
                        if (s.getPartnerId() == idQuery) {
                            System.out.println("===================================");
                            for (int i = 0; i < s.getQuotas().size(); i++) {                                
                                System.out.println(i + 1 + ") " + s.getQuotas().get(i));                                
                            }
                            System.out.println("===================================");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Ingrese ID socio: ");
                    int idAmount = reader.nextInt();

                    for (Socio s : socios) {
                        if (s.getPartnerId() == idAmount) {
                            System.out.println("El monto total de cuotas pagas es: $" + s.gettotAmount());
                            break;
                        }
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del sistema... Hasta pronto!");
                    reader.close();
                    System.exit(0);
            }
            
        }
     
    }
    
}
