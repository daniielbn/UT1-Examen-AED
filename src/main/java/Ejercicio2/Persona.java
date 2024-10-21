/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;


/**
 *
 * @author 
 */
public class Persona {
    private static int Max;
    private int Id;
    private String Nombre;
    private String Apellido1;
    private String Apellido2;
    private int Edad;
    private String Sexo;
    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }
    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Apellido1
     */
    public String getApellido1() {
        return Apellido1;
    }

    /**
     * @param Apellido1 the Apellido1 to set
     */
    public void setApellido1(String Apellido1) {
        this.Apellido1 = Apellido1;
    }

    /**
     * @return the Apellido2
     */
    public String getApellido2() {
        return Apellido2;
    }

    /**
     * @param Apellido2 the Apellido2 to set
     */
    public void setApellido2(String Apellido2) {
        this.Apellido2 = Apellido2;
    }

    /**
     * @return the Edad
     */
    public int getEdad() {
        return Edad;
    }

    /**
     * @param Edad the Edad to set
     */
    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    /**
     * @return the Sexo
     */
    public String getSexo() {
        return Sexo;
    }

    /**
     * @param Sexo the Sexo to set
     */
    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }
    public Persona(){
        this.Nombre= "";
        this.Apellido1= "";
        this.Apellido2= "";
        this.Edad= 0;
        this.Sexo= "";
    }
    
    public Persona(int Id, String Nombre, String Apellido1, String Apellido2, int Edad, String Sexo){
        this.Id = Id;
        this.Nombre= Nombre;
        this.Apellido1= Apellido1;
        this.Apellido2= Apellido2;
        this.Edad= Edad;
        this.Sexo= Sexo;
    }

    @Override
    public String toString() {
        return "Persona{" + "Id=" + Id + ", Nombre=" + Nombre + ", Apellido1=" + Apellido1 + ", Apellido2=" + Apellido2 + ", Edad=" + Edad + ", Sexo=" + Sexo + '}';
    }
}
