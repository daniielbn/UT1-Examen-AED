package Main;

import Ejercicio1.Ejercicio1;
import Ejercicio3.Empleado;
import Ejercicio3.Ejercicio3;
import Ejercicio2.Ejercicio2;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Ejercicio1 ejercicio1 = new Ejercicio1();
        //ejercicio1.iniciar("Ficheros\\MiDir");

        Ejercicio2 ejercicio2 = new Ejercicio2();
        //ejercicio2.generarXML();

        Ejercicio3 ejercicio3 = new Ejercicio3();
        //Empleado empleado = ejercicio3.devuelveEmpleado(22);
        //System.out.println(empleado.toString());
        //if (ejercicio3.grabarEmpleado(new Empleado(22, "Brito", 3, 1500), 22)) {
        //    System.out.println("Empleado grabado correctamente");
        //}
    }
}
