package Ejercicio3;

import java.io.RandomAccessFile;

public class Ejercicio3 {
    private long tamanioRegistros() {
        int id = Integer.BYTES;
        int apellido = 10 * 2; // 2 bytes por character
        int departamento = Integer.BYTES;
        int salario = Double.BYTES;

        return id + apellido + departamento + salario;
    }

    private String formatearString(RandomAccessFile raf) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.setLength(10);
            for (int i = 0; i < 10; i++) {
                sb.append(raf.readChar());
            }
            return sb.toString();
        } catch (Exception e) {
            System.out.println("Error al formatear el string: " + e.getMessage());
            return null;
        }
    }

    public Empleado devuelveEmpleado(int posicion) {
        try (RandomAccessFile raf = new RandomAccessFile("Ficheros\\AleatorioEmpleUno.dat", "r")) {
            long numeroRegistros = raf.length() / tamanioRegistros();
            long inicio = 0;
            long fin = numeroRegistros - 1;

            while (inicio <= fin) {
                long mitad = (inicio + fin) / 2;
                raf.seek(mitad * tamanioRegistros());
                int id = raf.readInt();
                String apellido = formatearString(raf);
                if (apellido != null) {
                    apellido = apellido.trim();
                }
                int departamento = raf.readInt();
                double salario = raf.readDouble();

                if (id == posicion) {
                    return new Empleado(id, apellido, departamento, salario);
                } else if (id < posicion) {
                    inicio = mitad + 1;
                } else {
                    fin = mitad - 1;
                }
            }
            return null;
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
    }

    public boolean grabarEmpleado(Empleado emple, int posicion) {
        try (RandomAccessFile raf = new RandomAccessFile("Ficheros\\AleatorioEmpleUno.dat", "rw")) {
            long pos = (posicion - 1) * tamanioRegistros();
            raf.seek(pos);
            long tamanioRegistro = tamanioRegistros();
            raf.writeInt(emple.getId());

            StringBuilder sb = new StringBuilder(emple.getApellido());

            sb.setLength(10);
            raf.writeChars(sb.toString());
            raf.writeInt(emple.getDepartamento());
            raf.writeDouble(emple.getSalario());
            // Escribir los datos del empleado
            raf.writeInt(emple.getId());
            return true;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder(emple.getApellido());
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
            return false;
        }
    }
}
