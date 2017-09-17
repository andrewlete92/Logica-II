package ListasLigadas;

public class Nodo {
    String nombre;
    int edad;
    Nodo liga;

    public Nodo(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        liga=null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Nodo getLiga() {
        return liga;
    }

    public void setLiga(Nodo liga) {
        this.liga = liga;
    }

}
