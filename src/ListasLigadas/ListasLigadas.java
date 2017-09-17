package ListasLigadas;

import javax.swing.JOptionPane;

public class ListasLigadas {

    public static void main(String[] args) {
        String encabezado = "************MENU************\n";
        String menu = "1. Listas Simplemente Ligadas\n2. Listas Simplemente Ligadas Circulares\n3. Lista Doblemente Ligada Circular\n4. Salir";
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(encabezado + menu));
            switch(op){
                case 1:
                    ListaSimple ls = new ListaSimple();
                    ls.menu();
                    break;
                case 2:
                    ListaSimpleCircular lsc = new ListaSimpleCircular();
                    lsc.menu();
                    break;
                case 3:
                    ListaDobleCircular ldc = new ListaDobleCircular();
                    ldc.menu();
                case 4:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"La opción no es válida");
                    break;
            }
        } while (op != 4);
    }
}
