package clases;

import entidades.Estudiante;

public class Procesos {

    public double calcularPromedio(Estudiante est) {

        double n1 = est.getNota1();
        double n2 = est.getNota2();
        double n3 = est.getNota3();

        if(validar(n1,n2,n3)){
            return (n1+n2+n3)/3;
        }

        return -1;
    }

    private boolean validar(double n1,double n2,double n3){
        return (n1>=0 && n1<=5 &&
                n2>=0 && n2<=5 &&
                n3>=0 && n3<=5);
    }
}
