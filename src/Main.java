import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Persona> personas = new ArrayList<>();
    private static List<Perro> perrosDisponibles = new ArrayList<>();
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
       int opc;

       do{
           mostrarMenu();
           opc= teclado.nextInt();

           switch(opc){
               case 1-> registrarPersona();
               case 2-> registrarPerro();
               case 3-> verPersonas();
               case 4-> verPerrosDisponibles();
               case 5-> adoptarPerros();
               case 6-> consultarPerroMasViejo();
               case 7-> System.out.println("Saliendo del programa....");
               default -> System.out.println("Opcion invalida. ");

           }
       }while (opc != 7);
    }
    public static void mostrarMenu (){
        System.out.println("\n-----MENU DEL SISTEMA DE ADOPCION----");
        System.out.println("1-Registrar persona");
        System.out.println("2-Registrar perro");
        System.out.println("3-Ver personas registradas");
        System.out.println("4-Ver perros disponibles");
        System.out.println("5-Adoptar perro");
        System.out.println("6-Consultar perro mas viejo");
        System.out.println("7-Salir del programa. ");
        System.out.println("Seleccione una opcion. ");
    }
    public static void registrarPersona (){
        System.out.println("Nombre: ");
        String nombre = teclado.next();
        System.out.println("Apellido: ");
        String apellido = teclado.next();
        System.out.println("Edad: ");
        int edad = teclado.nextInt();
        System.out.println("Documento: ");
        String documento = teclado.next();

        personas.add(new Persona(nombre,apellido,edad,documento));
        System.out.println("Persona registrada con exito.....");

    }
    public static void registrarPerro(){
        System.out.println("Placa: ");
        String placa = teclado.next();
        System.out.println("Nombre: ");
        String nombre = teclado.next();
        System.out.println("Raza: ");
        String raza = teclado.next();
        System.out.println("Edad: ");
        int edad = teclado.nextInt();
        System.out.println("Tamaño: ");
        String tamaño = teclado.next();

        perrosDisponibles.add(new Perro(placa,nombre,raza,edad,tamaño));
        System.out.println("Perro registrado con exito......");
    }
   }
    private static void verPersonas(){
        if (personas.isEmpty()){
            System.out.println("No hay personas registradas...");
            return;
        }
        for(Persona p : personas){
            System.out.println(p);
        }
    }
    private static void verPerrosDisponibles(){
        if(perrosDisponibles.isEmpty()){
            System.out.println("No hay perros disponibles.....");
            return;
        }
        for(Perro p : perrosDisponibles){
            System.out.println(p);
        }
    }
    private static void adoptarPerros(){
        System.out.println("Documento de la persona: ");
        String documento = teclado.next();
        Persona persona = buscarPersona(documento);
        if (persona == null){
            System.out.println("Persona no encontrada.... ");
            return;
        }
        System.out.println("Placa del perro a adoptar: ");
        String placa = teclado.next();
        Perro perro = buscarPerro(placa);
        if(perro == null){
            System.out.println("Perro no disponible....");
            return;
        }
        if(persona.adoptarPerro(perro)){
            perrosDisponibles.remove(perro);
            System.out.println("Perro adoptado con exito....");
        }else{
            System.out.println("Esta persona ya ha adoptado el maximo de 3 perros.....");
        }
    }
    private static void consultarPerroMasViejo(){
        System.out.println("Documento de la persona: ");
        String documento = teclado.next();
        Persona persona = buscarPersona(documento);
        if(persona == null){
            System.out.println("Persona no encontrada.....");
            return;
        }
        Perro masViejo = persona.perroMasGrande();
        if(masViejo!=null){
            System.out.println("El perros mas viejo adoptado es:  \n"+masViejo);
        }else{
            System.out.println("Esta persona no ha adoptado perros aun.....");
        }

    }
    private static Persona buscarPersona(String documento) {
        for(Persona p: personas ){
            if(p.getDocumento().equalsIgnoreCase(documento)){
                return p;
            }
        }
        return null;
    }
    private static Perro buscarPerro(String placa) {
        for(Perro p : perrosDisponibles){
            if(p.getPlaca().equalsIgnoreCase(placa)){
                return p;
            }
        }
        return null;
    }
}
