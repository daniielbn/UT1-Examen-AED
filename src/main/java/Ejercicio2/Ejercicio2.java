package Ejercicio2;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Ejercicio2 {
    private ArrayList<Persona> listaPersonas;
    private String cabecera;

    public Ejercicio2(){
        listaPersonas = new ArrayList<>();
        cabecera = "";
    }

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public String getCabecera() {
        return cabecera;
    }

    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public void setCabecera(String cabecera) {
        this.cabecera = cabecera;
    }

    public ArrayList<Persona> recuperarPersonas(String fichero) {
        ArrayList<Persona> personas = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fichero));
            String linea;
            int contador = 0;
            while ((linea = br.readLine()) != null) {
                if (contador == 0) {
                    cabecera = linea;
                    contador++;
                } else {
                    String[] partesProvisional = linea.split("\\|");
                    ArrayList<String> partes = new ArrayList<>();
                    for (int i = 0; i < partesProvisional.length; i++) {
                        if (!partesProvisional[i].isEmpty()) {
                            partes.add(partesProvisional[i]);
                        }
                    }
                    String[] partesFinal = partes.toArray(new String[5]);


                    personas.add(new Persona(contador, partesFinal[0], partesFinal[1], partesFinal[2], Integer.parseInt(partesFinal[3]), partesFinal[4]));
                    contador++;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return personas;
    }

    private void crearElemento(String datoPersona, String valor, Element raiz, Document document) {
        Element elem = document.createElement(datoPersona);
        elem.appendChild(document.createTextNode(valor));
        raiz.appendChild(elem);
    }

    public void generarXML() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Personas", null);

            ArrayList<Persona> personas = recuperarPersonas("Ficheros\\ejecicio2.txt");


            for (Persona persona : personas) {
                Element raiz = document.createElement("Persona");
                document.getDocumentElement().appendChild(raiz);
                crearElemento("Id", String.valueOf(persona.getId()), raiz, document);
                crearElemento("Nombre", persona.getNombre(), raiz, document);
                crearElemento("Apellido1", persona.getApellido1(), raiz, document);
                crearElemento("Apellido2", persona.getApellido2(), raiz, document);
                crearElemento("Edad", String.valueOf(persona.getEdad()), raiz, document);
                crearElemento("Sexo", persona.getSexo(), raiz, document);
            }

            Source source = new DOMSource(document);
            Result result = new StreamResult(new File("Ficheros\\ejercicio2.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
            transformer.transform(source, result);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
