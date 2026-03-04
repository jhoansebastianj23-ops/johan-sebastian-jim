package clases;

import java.util.HashMap;
import entidades.Estudiante;

public class ModeloDatos {

    private HashMap<String, Estudiante> estudiantesMap;

    public ModeloDatos(){
        estudiantesMap = new HashMap<>();
    }

    public String registrarEstudiante(Estudiante est){

        if(!estudiantesMap.containsKey(est.getDocumento())){
            estudiantesMap.put(est.getDocumento(), est);
            return "Registrado correctamente";
        }

        return "Estudiante ya existe";
    }

    public Estudiante consultarEstudiante(String documento){
        return estudiantesMap.get(documento);
    }

    public String eliminarEstudiante(String documento){

        if(estudiantesMap.containsKey(documento)){
            estudiantesMap.remove(documento);
            return "Eliminado correctamente";
        }

        return "No existe el estudiante";
    }

    public String actualizarEstudiante(Estudiante est){

        if(estudiantesMap.containsKey(est.getDocumento())){
            estudiantesMap.put(est.getDocumento(), est);
            return "Actualizado correctamente";
        }

        return "No existe el estudiante";
    }

    public String imprimirListaEstudiantes(){

        String msj = "LISTA DE ESTUDIANTES\n\n";

        for(Estudiante e : estudiantesMap.values()){

            msj += "Documento: " + e.getDocumento() + "\n";
            msj += "Nombre: " + e.getNombre() + "\n";
            msj += "Materia: " + e.getMateria() + "\n";
            msj += "Promedio: " + e.getPromedio() + "\n";
            msj += "--------------------------\n";
        }

        return msj;
    }
}
