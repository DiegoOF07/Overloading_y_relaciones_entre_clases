/**
 * 
 * @autor: Diego Oswaldo Flores Rivas
 * @version: 13/08/2023B
 * 
 * La siguiente clase tiene como objetivo modelar los ticket, siendo capaz de generarlos y a su vez de validarlos
 * El valor de los atributos no puede ser alterado de alguna forma a menos que se genere otro ticket
 */

public class Ticket {
    private int ticket;
    private int verificadorA;
    private int verificadorB;

    /*Constructor */
    public Ticket() {
        this.ticket = 0;
        this.verificadorA = 0;
        this.verificadorB = 0;
    }

    /*Este metodo se encarga de generar los numeros aleatorios correspondientes al ticket */
    public void generarTicket(){ //Cambio en el nombre y retorno del metodo, cambiar analisis y diseño
        this.ticket = (int)(Math.random()*15000);
        this.verificadorA = (int)(Math.random()*15000);
        this.verificadorB = (int)(Math.random()*15000);
    }

    /*Este metodo se encarga de validar si el ticket generado es valido o no para proceder con la compra de alguna entrada */
    public boolean validarTicket(){
        if(Math.abs(verificadorA-verificadorB)>=ticket){
            return true;
        }else{
            return false;
        }
    }

    /*Getters de los atributos */
    public int getTicket() {
        return ticket;
    }

    public int getVerificadorA() {
        return verificadorA;
    }

    public int getVerificadorB() {
        return verificadorB;
    }

    
}
