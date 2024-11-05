package gestionsocios;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Rafael
 */
public class Socio {
    int partnerId;
    String rut;
    String name;
    String lastName;
    String sLastName;
    String email;
    String address;
    String region;
    String city;
    String commune;
    int phoneNum;
    int totAmount;
    List<Cuota> quotas;

    public Socio(int partnerId, String rut, String name, String lastName, String sLastName, String email, String address, String region, String city, String commune, int phoneNum) {
        this.partnerId = partnerId;
        this.rut = rut;
        this.name = name;
        this.lastName = lastName;
        this.sLastName = sLastName;
        this.email = email;
        this.address = address;
        this.region = region;
        this.city = city;
        this.commune = commune;
        this.phoneNum = phoneNum;
        this.totAmount = 0;
        this.quotas = new ArrayList<>();
    }

    public void addQuota(int amount) {
        if (amount <= 0) {
            System.out.println("Error: la cuota debe ser mayor a cero.");
            return;
            }
        Cuota quota = new Cuota(amount);
        this.quotas.add(quota);
        this.totAmount += amount;
        System.out.println("Cuota de $" + amount + " registrada con éxito.");
    }

    public ArrayList<String> getQuotas() {    
        ArrayList<String> cuotas = new ArrayList<>();
        for (Cuota cuota : quotas) {
            cuotas.add(cuota.toString());
        }
        return cuotas;
    }

    public int gettotAmount() {
        return this.totAmount;
    }

    public int getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getsLastName() {
        return sLastName;
    }

    public void setsLastName(String sLastName) {
        this.sLastName = sLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }
}
