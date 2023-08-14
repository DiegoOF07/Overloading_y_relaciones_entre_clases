/**
 * @autor: Diego Oswaldo Flores Rivas
 * @version: 1.0
 * 
 * La siguiente clase es la responsable de mostrar todos los datos al usuario de manera ordenada e intuitiva
 * Tambien se encarga de la ejecucion del programa.
 */
public class Principal {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        ticket.generarTicket();
        System.out.println(ticket.getTicket());
        System.out.println(ticket.validarTicket());
    }
}