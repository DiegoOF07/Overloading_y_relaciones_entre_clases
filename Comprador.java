/**
 * 
 * @author: Diego Oswaldo Flores Rivas
 * @version: 13/08/2023B
 * 
 * Esta clase se encarga de modelar un comprador con la informacion necesaria para efectuar una compra
 * Posee un ticket que determinara si el comprador puede comprar boletos o no.
 */

public class Comprador {
    private String nombre;
    private String email;
    private int cantBoletos;
    private double presupuesto;
    private Ticket ticket;

    /*El constructor solicitara los parametros para inicializar los atributos, a excepcion del ticket
     *El ticket simplemente se inicializara como un objeto de la clase Ticket
     */
    public Comprador(String nombre, String email, int cantBoletos, double presupuesto) {
        this.nombre = nombre;
        this.email = email;
        this.cantBoletos = cantBoletos;
        this.presupuesto = presupuesto;
        this.ticket = new Ticket();
    }

    /*Getters de los atributos del comprador */

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public int getCantBoletos() {
        return cantBoletos;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public Ticket getTicket() {
        return ticket;
    }

    /*Setters de los atributos del comprador */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCantBoletos(int cantBoletos) {
        this.cantBoletos = cantBoletos;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    

}
