/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

/**
 *
 * @author ASUS_FLR
 */
public class FileExtensionesClass {
    private String extension;
    private int cuenta;
    /***
     * constrcutor 
     * @param extension 
     */
    FileExtensionesClass(String extension){
        this.extension =  extension;
        this.cuenta = 1;
    }
    /**
     * @return the extension
     */
    public String getExtension() {
        return extension;
    }

    /**
     * @param extension the extension to set
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * @return the cuenta
     */
    public int getCuenta() {
        return cuenta;
    }

    /**
     * @param cuenta the cuenta to set
     */
    public void incrementaCuenta() {
        this.cuenta++;
    }
    
    
}
