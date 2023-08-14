/**
 * 
 * @author: Diego Oswaldo Flores Rivas
 * @version: 13/08/2023B
 *
 * Esta clase modela una localidad, con la cantidad de boletos disponibles y vendidos 
 * asi como el precio de cada boleto
 */

public class Localidad {
    private int boletosDisponibles;
    private double precio;
    private String nombre;
    private int boletosVendidos;
    
    /*En el constructor se solicitan los valores necesarios para inicializar los atributos de la clase */
    public Localidad(int boletosDisponibles, double precio, String nombre, int boletosVendidos) {
        this.boletosDisponibles = boletosDisponibles;
        this.precio = precio;
        this.nombre = nombre;
        this.boletosVendidos = boletosVendidos;
    }

    /*Se presentan los getter y setter de cada atributo */

    public int getBoletosDisponibles() {
        return boletosDisponibles;
    }

    public void setBoletosDisponibles(int boletosDisponibles) {
        this.boletosDisponibles = boletosDisponibles;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getBoletosVendidos() {
        return boletosVendidos;
    }

    public void setBoletosVendidos(int boletosVendidos) {
        this.boletosVendidos = boletosVendidos;
    }
}
