/**
 * 
 * @author: Diego Oswaldo Flores Rivas
 * @version: 13/08/2023C
 * 
 * La siguiente clase es la encargada de efectuar las compras
 * Tambien hara las respectivas verificaciones para determinar si los boletos pueden ser comprados o no
 */

public class Comprar {
    private double totalVentas;
    private Comprador comprador;
    private Localidad localidad1; //Cambio en la cantidad de atributos, cambiar analisis y diseño
    private Localidad localidad2;
    private Localidad localidad3;
    
    /*En el constructor se solicitan los atributos del comprador y se inicializan los atributos */
    public Comprar(String nombre, String email, int cantBoletos, double presupuesto){
        this.totalVentas = 0;
        this.localidad1 = new Localidad(20, 100.00, "1", 0);
        this.localidad2 = new Localidad(20, 500.00, "5", 0);
        this.localidad3 = new Localidad(20, 1000.00, "10", 0);
        this.comprador = new Comprador(nombre, email, cantBoletos, presupuesto);
    }

    /*En el siguiente metodo se efectua toda la logica necesaria para efectuar una compra */
    public void compra(){
        Localidad localidadSeleccionada = null;
        Localidad localidales[]={localidad1,localidad2, localidad3};
        comprador.getTicket().generarTicket();
        if(comprador.getTicket().validarTicket()){
            localidadSeleccionada = localidales[(int)(Math.random()*localidales.length)];
            if(localidadSeleccionada.getBoletosVendidos()<20){
                if(comprador.getCantBoletos()>localidadSeleccionada.getBoletosDisponibles()){
                    System.out.println("Solamente hay "+localidadSeleccionada.getBoletosDisponibles()+" boletos disponibles");
                    if(comprador.getPresupuesto()>=(localidadSeleccionada.getPrecio()*localidadSeleccionada.getBoletosDisponibles())){
                        System.out.println("Tu compra se ha efectuado con exito");
                        localidadSeleccionada.setBoletosVendidos(localidadSeleccionada.getBoletosVendidos()+localidadSeleccionada.getBoletosDisponibles());
                        localidadSeleccionada.setBoletosDisponibles(0);
                    }else{
                        System.out.println("Tu presupuesto no es suficiente para comprar el/los boletos");
                    }
                }else{
                    if(comprador.getPresupuesto()>=(localidadSeleccionada.getPrecio()*comprador.getCantBoletos())){
                        System.out.println("Tu compra se ha efectuado con exito");
                        localidadSeleccionada.setBoletosVendidos(localidadSeleccionada.getBoletosVendidos()+comprador.getCantBoletos());
                        localidadSeleccionada.setBoletosDisponibles(localidadSeleccionada.getBoletosDisponibles()-comprador.getCantBoletos());
                    }else{
                        System.out.println("Tu presupuesto no es suficiente para comprar el/los boletos");
                    }
                }
            }else{
                System.out.println("Los boletos para la localidad "+localidadSeleccionada.getNombre()+" estan agotados");
            }
        }else{
            System.out.println("Lo sentimos, su ticket no es valido para proceder con la compra");
            System.out.println("Ticket obtenido: "+comprador.getTicket().getTicket());
        }
    }

}
