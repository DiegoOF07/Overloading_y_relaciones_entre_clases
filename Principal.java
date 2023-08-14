/**
 * @autor: Diego Oswaldo Flores Rivas
 * @version: 13/08/2023C
 * 
 * La siguiente clase es la responsable de mostrar todos los datos al usuario de manera ordenada e intuitiva
 * Tambien se encarga de la ejecucion del programa.
 */
public class Principal {

    public static void main(String[] args) {
        /*Datos de prueba */
        Comprar com = new Comprar("Pedro", "pedro@gmail.com", 2, 5000);
        com.compra();
    }
}