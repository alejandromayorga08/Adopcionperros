import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private String documento;
    private List<Perro> perrosAdoptados;

    public Persona(String nombre, String apellido, int edad, String documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
    }

    public String getDocumento() {
        return documento;
    }

    public boolean adoptarPerro(Perro perro){
        if(perrosAdoptados.size() <3){
            perrosAdoptados.add(perro);
            return true;
        }
        return false;
    }

    public Perro perroMasGrande(){
        if(perrosAdoptados.isEmpty()) return null;
        Perro mayor = perrosAdoptados.get(0);
        for(Perro p : perrosAdoptados){
            if (p.getEdad()> mayor.getEdad()){
                mayor= p;
            }
        }
        return mayor;
    }

    @Override
    public String toString() {
    StringBuilder info = new StringBuilder("Nombre: "+nombre+"Apellido: "+apellido+"Edad: "+edad+"Doc: "+documento+"\n Perros adoptados: \n"+perrosAdoptados);
    if(perrosAdoptados.isEmpty()){
        info.append("Ninguno\n");
    }else{
        for(Perro p : perrosAdoptados){
            info.append(" ").append(p).append("\n");
        }
    }
    return info.toString();
    }
}
