/**
 * @autor: Diego Oswaldo Flores Rivas
 * @version: 13/08/2023B
 * 
 * La siguiente clase es la responsable de mostrar todos los datos al usuario de manera ordenada e intuitiva
 * Tambien se encarga de la ejecucion del programa.
 */
public class Principal {

    public static void main(String[] args) {
        Comprador persona = new Comprador("Pedro", "pedro@gmail.com", 2, 500.50);
        persona.getTicket().generarTicket();
        System.out.println(persona.getTicket().validarTicket());
        System.out.println(persona.getTicket().getTicket());
    }
}