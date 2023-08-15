/**
 * 
 * @author: Diego Oswaldo Flores Rivas
 * @version: 14/08/2023D
 * 
 * La siguiente clase es la encargada de efectuar las compras
 * Tambien hara las respectivas verificaciones para determinar si los boletos pueden ser comprados o no
 */

public class Comprar {
    private double totalVentas;
    private Comprador comprador;
    private Localidad localidad1; 
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
        Localidad localidadSeleccionada = null; //Aqui se guarda la localidad aleatoria
        Localidad localidales[]={localidad1,localidad2, localidad3}; //A traves de un array, se puede elegir aleatoriamente a las localidades
        comprador.getTicket().generarTicket(); //El ticket del comprador es generado
        if(comprador.getTicket().validarTicket()){ //Si el ticket es valido, procede con las validaciones, si no, no
            System.out.println("Tu ticket es valido para la compra");

            localidadSeleccionada = localidales[(int)(Math.random()*localidales.length)]; //Se selecciona la localidad aleatoriamente
            if(localidadSeleccionada.getBoletosVendidos()<20){ //Si hay 20 boletos vendidos o mas indica que ya no hay boletos disponibles
                System.out.println("Estas comprando boletos para la localidad "+localidadSeleccionada.getNombre());

                if(comprador.getCantBoletos()>localidadSeleccionada.getBoletosDisponibles()){ // Si los boletos que desea comprar exceden los disponibles se venden los disponibles
                    System.out.println("Solamente hay "+localidadSeleccionada.getBoletosDisponibles()+" boletos disponibles");
                    if(comprador.getPresupuesto()>=(localidadSeleccionada.getPrecio()*localidadSeleccionada.getBoletosDisponibles())){ //Si el presupuesto alcanza para comprar los boletos
                        System.out.println("Tu compra se ha efectuado con exito");
                        localidadSeleccionada.setBoletosVendidos(localidadSeleccionada.getBoletosVendidos()+localidadSeleccionada.getBoletosDisponibles()); //Se suman los boletos vendidos
                        localidadSeleccionada.setBoletosDisponibles(0); //Se ponen como 0 los disponibles
                    }else{
                        System.out.println("Tu presupuesto no es suficiente para comprar el/los boletos");
                    }
                }else{
                    if(comprador.getPresupuesto()>=(localidadSeleccionada.getPrecio()*comprador.getCantBoletos())){
                        System.out.println("Tu compra se ha efectuado con exito");
                        localidadSeleccionada.setBoletosVendidos(localidadSeleccionada.getBoletosVendidos()+comprador.getCantBoletos()); //Se suman los boletos vendidos
                        localidadSeleccionada.setBoletosDisponibles(localidadSeleccionada.getBoletosDisponibles()-comprador.getCantBoletos());//Se restan los disponibles
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
    //Este metodo recopila todos los datos de las tres localidades
    public void disponibilidadTotal(){
        System.out.println("\nLocalidad "+localidad1.getNombre()+": \n");
        System.out.println("Boletos disponibles: "+localidad1.getBoletosDisponibles());
        System.out.println("Boletos vendidos: "+localidad1.getBoletosVendidos());
        System.out.println("\nLocalidad "+localidad2.getNombre()+": \n");
        System.out.println("Boletos disponibles: "+localidad2.getBoletosDisponibles());
        System.out.println("Boletos vendidos: "+localidad2.getBoletosVendidos());
        System.out.println("\nLocalidad "+localidad3.getNombre()+": \n");
        System.out.println("Boletos disponibles: "+localidad3.getBoletosDisponibles());
        System.out.println("Boletos vendidos: "+localidad3.getBoletosVendidos());
    }
    //Este metodo se encarga de asignar el total de ventas
    public double reporteCaja(){
        this.totalVentas = (localidad1.getBoletosVendidos()*localidad1.getPrecio())+(localidad2.getBoletosVendidos()*localidad2.getPrecio())+(localidad3.getBoletosVendidos()*localidad3.getPrecio());
        return totalVentas;
    }

    // getters de los objetos
    public Comprador getComprador() {
        return comprador;
    }

    public Localidad getLocalidad1() {
        return localidad1;
    }

    public Localidad getLocalidad2() {
        return localidad2;
    }

    public Localidad getLocalidad3() {
        return localidad3;
    }

}
