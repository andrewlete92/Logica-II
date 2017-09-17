package ListasLigadas;

import javax.swing.JOptionPane;

public class ListaSimple {

    Nodo cab;

    public ListaSimple() {
        this.cab = null;
    }

    public void menu() {
        String encabezado = "************MENU************\n";
        String menu = "1. Mostrar\n2. Insertar al inicio\n3. Eliminar el primero\n4. Quiz\n5. Salir\n Seleccione la opción";
        int edad, op;
        ListaSimple ls = new ListaSimple();
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(encabezado + menu));

            switch (op) {
                case 1:
                    ls.mostrar();
                    break;
                case 2:
                    String nom = JOptionPane.showInputDialog(null, "Ingrese el nombre");
                    edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad"));
                    ls.insertarInicio(nom, edad);
                    break;
                case 3:
                    ls.eliminarPrimerNodo();
                    break;
                case 4:
                    ls.Quiz();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "La opción seleccionada no es admitida");
                    break;
            }
        } while (op != 5);
    }

    public void mostrar() {
        String texto = "";
        Nodo q = cab;
        if (cab == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacía");
            //System.out.println("La lista está vacía");
        } else {
            while (q != null) {
                texto += q.getNombre() + "          " + q.getEdad() + "\n";
                q = q.getLiga();
            }
            JOptionPane.showMessageDialog(null, "Nombre         Edad\n" + texto);
        }
    }

    public void insertarInicio(String nombre, int edad) {
        Nodo x = new Nodo(nombre, edad);
        x.setLiga(cab);
        cab = x;
    }

    public void eliminarPrimerNodo() {
        Nodo x;
        if (cab == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacía");
        } else {
            x = cab;
            cab = cab.getLiga();
            //delete(x); // El garbashcolector de java se encarga de borrarlo, no hay una instrucción para esto.
        }
        JOptionPane.showMessageDialog(null, "Nodo eliminado con exito");
    }

    public void Quiz() {
        Nodo ant = cab, pen = cab, Q = cab, x, P, ult = cab, aux;
        if (cab == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacía");
        } else {
            while (Q != null) {
                pen = ult;
                ult = Q;
                Q = Q.getLiga();
            }
            if (pen == cab) {
                JOptionPane.showMessageDialog(null, "La lista solo tiene 2 nodos, mínimo se necesitan 3");
            } else {
                P = cab;
                while (P != pen) {
                    ant = P;
                    P = P.getLiga();
                }
                if ((cab.getEdad() % 2 == 0) && ult.getEdad() % 2 == 0) {
                    //Elimina el penúltimo
                    x = pen;
                    ant.setLiga(pen.getLiga());
                    //delete(x); //Trabaja el Garbash
                    JOptionPane.showMessageDialog(null, "Se eliminó el penúlimo nodo de la lista");
                } else {
                    //Inserta después del primero
                    String nom = JOptionPane.showInputDialog(null, "Ingrese el nombre");
                    int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad"));
                    Nodo n = new Nodo(nom, edad);
                    aux = cab;
                    n.setLiga(aux.getLiga());
                    cab.setLiga(n);
                    JOptionPane.showMessageDialog(null, "Se insertó un nodo después del primero");
                }
            }
        }
    }
}
