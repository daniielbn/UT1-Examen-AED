package Ejercicio1;

import java.io.File;
import java.util.ArrayList;

public class Ejercicio1 {
    private ArrayList<FileExtensionesClass> listaExtensiones;
    private int numeroDirectorios;
    private int numeroFicheros;

    public Ejercicio1(){
        listaExtensiones = new ArrayList<>();
        numeroDirectorios = 0;
        numeroFicheros = 0;
    }

    public ArrayList<FileExtensionesClass> getListaExtensiones() {
        return listaExtensiones;
    }

    public int getNumeroDirectorios() {
        return numeroDirectorios;
    }

    public int getNumeroFicheros() {
        return numeroFicheros;
    }

    public void setListaExtensiones(ArrayList<FileExtensionesClass> listaExtensiones) {
        this.listaExtensiones = listaExtensiones;
    }

    public void setNumeroDirectorios(int numeroDirectorios) {
        this.numeroDirectorios = numeroDirectorios;
    }

    public void setNumeroFicheros(int numeroFicheros) {
        this.numeroFicheros = numeroFicheros;
    }

    public void accederDirectorio(String nombreDirectorio) {
        // Acceder al directorio
        File directorioPadre = new File(nombreDirectorio);
        // Obtener los archivos del directorio
        File[] archivos = directorioPadre.listFiles();
        for (File archivo : archivos) {
            if (archivo.isDirectory()) {
                numeroDirectorios++;
                accederDirectorio(archivo.getPath());
            } else {
                numeroFicheros++;
                comprobarExtension(archivo);
            }
        }
    }

    public void comprobarExtension(File fichero) {
        String[] partes = fichero.getName().split("\\.");
        if (listaExtensiones.size() == 0) {
            listaExtensiones.add(new FileExtensionesClass(partes[1]));
            return;
        }
        for (FileExtensionesClass extension : listaExtensiones) {
            if (extension.getExtension().equals(partes[1])) {
                extension.incrementaCuenta();
                return;
            }
        }
        listaExtensiones.add(new FileExtensionesClass(partes[1]));
    }

    public void mostrarResultados(String directorioRaiz) {
        System.out.println("Directorio raíz: " + directorioRaiz);
        System.out.println("Número de directorios: " + numeroDirectorios);
        for (FileExtensionesClass extension : listaExtensiones) {
            System.out.println("Fichero con extensión: ." + extension.getExtension() + ": " + extension.getCuenta());
        }
        System.out.println("Número de ficheros: " + numeroFicheros);
    }

    public void iniciar(String directorioRaiz) {
        accederDirectorio(directorioRaiz);
        mostrarResultados(directorioRaiz);
    }
}
