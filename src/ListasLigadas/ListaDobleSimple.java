package ListasLigadas;

import javax.swing.JOptionPane;

public class ListaDobleSimple {
    NodoCircular cab, ult;

    public ListaDobleSimple() {
        this.cab = null;
        this.ult = null;
    }
    
    public void insertarInicio(String nombre, int edad){
        NodoCircular x = new NodoCircular(nombre,edad);
        if(cab==null){
            cab=x;
            ult=x;
        } else{
            x.setLigaSig(cab);
            cab.setLigaAnt(x);
            cab = x;
        }
    }
    
    public void insertarFinal(String nom, int edad){
        NodoCircular x = new NodoCircular(nom, edad);
        if(ult==null){
            cab=x;
            ult = x;
        } else {
            ult.setLigaSig(x);
            x.setLigaAnt(ult);
            ult = x;
        }
    }
    
    public void eliminarDato(int dato){
        NodoCircular q = cab, aux;
        boolean sw = false;
        if(cab==null){
            JOptionPane.showMessageDialog(null, "La lista está vacía");
        } else {
            while(q!=null && sw ==false){
                if(q.edad == dato){
                    sw = true;
                } else {
                    q = q.getLigaSig();
                }
            }
            if(q==cab){
                if(q.getLigaSig()==null){
                    cab=null;
                    ult = null;
                    //delete(x);
                } else {
                    cab = q.getLigaSig();
                    cab.setLigaAnt(null);
                    //delete(x);
                }
            }
        }
    }
}
