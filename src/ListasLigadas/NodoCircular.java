package ListasLigadas;

public class NodoCircular {

    String nombre;
    int edad;
    NodoCircular ligaSig;
    NodoCircular ligaAnt;

    public NodoCircular () {
        nombre = null;
        edad = 0;
        ligaSig = null;
        ligaAnt = null; 
    }

    public NodoCircular(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        ligaSig = null;
        ligaAnt = null;
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

    public NodoCircular getLigaSig() {
        return ligaSig;
    }

    public void setLigaSig(NodoCircular liga) {
        this.ligaSig = liga;
    }

    public NodoCircular getLigaAnt() {
        return ligaAnt;
    }

    public void setLigaAnt(NodoCircular liga) {
        this.ligaAnt = liga;
    }
}
