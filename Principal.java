import java.util.Scanner;

/**
 * @autor: Diego Oswaldo Flores Rivas
 * @version: 14/08/2023D
 * 
 * La siguiente clase es la responsable de mostrar todos los datos al usuario de manera ordenada e intuitiva
 * Tambien se encarga de la ejecucion del programa.
 */
public class Principal {
    public static void main(String[] args) { //En este metodo se encuentra el menu para que el usuario pueda interactuar con el programa
        Scanner sc = new Scanner(System.in);
        Comprar miCompra = null;
        boolean isBuying = true;
        while(isBuying){
            System.out.println("\nTHE ERAS TOUR\n");
            System.out.println("1. Crear un nuevo comprador");
            System.out.println("2. Nueva solicitud de compra");
            System.out.println("3. Consultar disponibilidad");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte de caja");
            System.out.println("6. Salir");
            System.out.print("Selecciona la opcion que desees: ");
            String opcion = sc.nextLine();
            switch(opcion){
                case "1": //Si selecciona agregar nuevo comprador
                    System.out.println("\nNUEVO COMPRADOR\n");
                    System.out.print("Ingresa tu nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingresa tu email: ");
                    String email = sc.nextLine();
                    System.out.print("Ingresa la cantidad de boletos que desees comprar: ");
                    int cantBoletos = Integer.parseInt(sc.nextLine());
                    System.out.print("Ingresa tu presupuesto para la compra: ");
                    double presupuesto = Double.parseDouble(sc.nextLine());
                    if(miCompra==null){
                        miCompra = new Comprar(nombre, email, cantBoletos, presupuesto);
                    }else{
                        miCompra.getComprador().setNombre(nombre);
                        miCompra.getComprador().setEmail(email);
                        miCompra.getComprador().setCantBoletos(cantBoletos);
                        miCompra.getComprador().setPresupuesto(presupuesto);
                    }
                    break;
                case "2": //Si selecciona comprar
                    if(miCompra!=null){
                        System.out.println("\nVERIFICANDO COMPRA\n");
                        miCompra.compra();
                    }else{
                        System.out.println("Aun no has creado un nuevo comprador");
                    }
                    break;
                case "3": //Si selecciona ver disponibilidad
                    if(miCompra!=null){
                        System.out.println("\nDISPONIBILIDAD DE LOCALIDADES\n");
                        miCompra.disponibilidadTotal();
                    }else{
                       System.out.println("Aun no has creado un nuevo comprador"); 
                    }
                    break;
                case "4": //Si selecciona ver disponibilidad individual
                    if(miCompra!=null){
                        System.out.println("\nDISPONIBILIDAD INDIVIDUAL\n");
                        System.out.println("Localidad 1");
                        System.out.println("Localidad 5");
                        System.out.println("Localidad 10");
                        System.out.print("Escribe unicamente el numero de la localidad que deseas ver: ");
                        String localidad = sc.nextLine();
                        switch(localidad){
                            case "1":
                                System.out.println("Los boletos disponibles son: "+miCompra.getLocalidad1().getBoletosDisponibles());
                                break;
                            case "5":
                                System.out.println("Los boletos disponibles son: "+miCompra.getLocalidad2().getBoletosDisponibles());
                                break;
                            case "10":
                                System.out.println("Los boletos disponibles son: "+miCompra.getLocalidad3().getBoletosDisponibles());
                                break;
                        }
                    }else{
                       System.out.println("Aun no has creado un nuevo comprador"); 
                    }
                    break;
                case "5": //Si selecciona ver reporte de ventas
                    if(miCompra!=null){
                        System.out.println("\nREPORTE DE CAJA\n");
                        System.out.println("El total recolectado es: "+miCompra.reporteCaja());
                    }else{
                        System.out.println("Aun no has creado un nuevo comprador");
                    }
                    break;
                case "6": //Si selecciona salir
                    isBuying = false;
                    break;
            }
        }
        sc.close();
    }
}