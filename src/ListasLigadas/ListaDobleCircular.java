package ListasLigadas;

import javax.swing.JOptionPane;

public class ListaDobleCircular {

    NodoCircular cab, ult;

    public ListaDobleCircular() {
        this.cab = null;
        this.ult = null;
    }

    public void menu() {
        String encabezado = "************MENU************\n";
        String menu = "1. Mostrar\n2. Insertar al Final\n3. Eliminar Dato\n4. Buscar Dato\n5. Ordenar Por Edad\n6. Salir\nSeleccione la opción";
        int edad, op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(encabezado + menu));

            switch (op) {
                case 1:
                    mostrar();
                    break;
                case 2:
                    String nom = JOptionPane.showInputDialog(null, "Ingrese el nombre");
                    edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad"));
                    insertarFinal(nom, edad);
                    break;
                case 3:
                    eliminarDato();
                    break;
                case 4:
                    String nom2 = JOptionPane.showInputDialog(null, "Ingrese el nombre a eliminar");
                    buscarDato(nom2);
                    break;
                case 5:
                    ordenarEdad();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "La opción seleccionada no es admitida");
                    break;
            }
        } while (op != 6);
    }

    public void mostrar() {
        String texto = "";
        NodoCircular q = cab;
        if (cab == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacía");
        } else {
            if (cab.getLigaSig() == null) {
                texto += q.getNombre() + "      " + q.getEdad() + "\n";
            } else {
                do {
                    texto += q.getNombre() + "      " + q.getEdad() + "\n";
                    q = q.getLigaSig();
                } while ((q != cab));
            }
            JOptionPane.showMessageDialog(null, "Nombre   Edad\n" + texto);
        }
    }

    public void insertarFinal(String nom, int edad) {
        NodoCircular x = new NodoCircular(nom, edad);
        if (cab == null) {
            cab = x;
            ult = x;
            x.setLigaSig(x);
            x.setLigaAnt(x);
        } /*else if (ult == cab) {
            cab.setLigaSig(x);
            x.setLigaAnt(cab);
            ult = x;
            ult.setLigaSig(cab);
            cab.setLigaAnt(ult);*/ else {
            x.setLigaAnt(ult);
            x.setLigaSig(cab);
            ult.setLigaSig(x);
            ult = x;
        }
        JOptionPane.showMessageDialog(null, "Nodo insertado al final de la lista");
        System.out.println(cab.getNombre() + " nombre en CAB");
        System.out.println(ult.getNombre() + " nombre en ULT");
    }

    public void eliminarDato() {
        NodoCircular q = cab, del, auxS, auxA;
        boolean sw = false;
        if (cab == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacía");
        } else {
            String nom = JOptionPane.showInputDialog(null, "Ingrese el nombre a eliminar");
            do {
                if (q.getNombre().equals(nom)) {
                    sw = true;
                } else {
                    q = q.getLigaSig();
                }
            } while ((q != cab) && (sw == false));
            if (sw == false) {
                JOptionPane.showMessageDialog(null, "El nombre " + nom + " no está en la lista");
            } else if (cab == ult) {
                //Si es solo uno
                del = q;
                cab = null;
                ult = null;
                //delete(del);
            } else if (cab.getLigaSig() == ult) {
                //Se valida si son 2 datos
                ult = cab;
                cab.setLigaSig(cab);
                cab.setLigaAnt(cab);
                del = q;
                //delete(del);
            } else if (q == cab) {
                //valida si el dato a eliminar es el primero
                del = cab;
                cab = cab.getLigaSig();
                del.setLigaAnt(null);
                del.setLigaSig(null);
                if (ult.getLigaSig() == del) {
                    ult.setLigaSig(cab);
                }
                //delete(del);
            } else if (q == ult) {
                //valida si el dato a eliminar es el último.
                del = ult;
                ult = ult.getLigaAnt();
                ult.setLigaSig(cab);
                cab.setLigaAnt(ult);
                //delete(del);
            } else {
                //Si el nodo queda entre otros
                auxS = q.getLigaSig();
                auxA = q.getLigaAnt();
                del = q;
                del.setLigaAnt(null);
                del.setLigaSig(null);
                auxA.setLigaSig(auxS);
                auxS.setLigaAnt(auxA);
                //delete(del);
            }
            JOptionPane.showMessageDialog(null, "El nombre " + nom + " ha sido eliminado en su primera aparición");
        }
    }

    public void buscarDato(String nom) {
        NodoCircular q = cab;
        boolean sw = false;
        if (cab == null) {
            JOptionPane.showMessageDialog(null, "La lista se encuentra vacía");
        } else {
            do {
                if (q.getNombre().equals(nom)) {
                    // No entiendo esta línea que hace
                    sw = true;
                    JOptionPane.showMessageDialog(null, "El nombre " + nom + " SI se encuentra en la lista");
                } else {
                    q = q.getLigaSig();
                }
            } while ((q != cab) && (sw == false) && (q != null));
            if (sw == false) {
                JOptionPane.showMessageDialog(null, "El nombre " + nom + " NO se encuentra en la lista");
            }
        }
    }

    public void ordenarEdad() {
        NodoCircular q = cab, auxS, auxA, auxC, aux;
        boolean cambia = false;
        if (q == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacía");
        } else if (q.getLigaSig() == cab) {
            JOptionPane.showMessageDialog(null, "La lista solo tiene un nodo, no se puede ordenar");
        } else {
            while(q.getLigaSig() != cab){
               auxA = q.getLigaSig();
               cambia = false;
               while(auxA != cab){
                   if (q.getEdad() > auxA.getEdad()){
                       cambia = true;
                       if (auxA.getLigaSig().getLigaSig() == cab){
                           auxA.getLigaSig().setLigaSig(auxA);
                       }
                       if (auxA.getLigaAnt().getLigaAnt() == cab){
                        auxA.getLigaAnt().setLigaAnt(auxA);
                       }
                       
                       auxS =  new NodoCircular(auxA.getNombre(), auxA.getEdad());
                       auxS.setLigaAnt(auxA.getLigaAnt());
                       auxS.setLigaSig(auxA.getLigaSig());
                       
                       if (q == auxA.getLigaAnt()){
                           q.getLigaAnt().setLigaSig(auxA);
                           auxA.setLigaSig(q);
                           auxA.setLigaAnt(q.getLigaAnt());
                           q.setLigaAnt(auxS);
                           q.setLigaSig(auxS.getLigaSig());
                       }
                       else{
                            auxA.getLigaAnt().setLigaSig(q);
                            auxA.getLigaSig().setLigaAnt(q);
                            auxA.setLigaSig(q.getLigaSig());
                            auxA.setLigaAnt(q.getLigaAnt());

                            q.setLigaSig(auxS.getLigaSig());
                            q.setLigaAnt(auxS.getLigaAnt());
                       }
                       
                       if (q == cab){
                           cab = auxA;
                       }
                       auxA = q.getLigaSig();
                   }
                   else{
                        auxA = auxA.getLigaSig();
                   }
               }
               if (cambia){
                   q = cab;
               }
               else{
                    q = q.getLigaSig();
               }
            }
        }
        JOptionPane.showMessageDialog(null, "Lista ordenada correctamente");
    }
}
