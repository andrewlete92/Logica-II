package ListasLigadas;

import javax.swing.JOptionPane;

public class ListaSimpleCircular {

    Nodo cab;

    public ListaSimpleCircular() {
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
        } else {
            do {
                texto += q.getNombre() + "          " + q.getEdad() + "\n";
                q = q.getLiga();
            } while (q != cab);
            JOptionPane.showMessageDialog(null, texto);
        }
    }

    public void insertarInicio(String nombre, int edad) {
        String nom = JOptionPane.showInputDialog(null, "Ingrese el nombre");
        int ed = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad"));
        Nodo q = cab;
        if (cab == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacía");
        } else {
            if (cab.getLiga() == null) {
                 
            } else {
                do {

                } while (q != cab);
            }
        }
        Nodo x = new Nodo(nombre, ed);
        x.setLiga(cab);
        cab = x;
    }
}
