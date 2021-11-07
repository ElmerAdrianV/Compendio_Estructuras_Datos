package Compendio_Estructuras_Datos.SkipList.src;

public class SkipList<T extends Comparable<T>> {
    NodoSkipList<T> cabeza, cola;
    int cont, numNiveles;

    public SkipList(){
        cabeza = new NodoSkipList<T>(null);
        cola = new NodoSkipList<T>(null);
        ligaID(cabeza, cola);
        cont = 0;
        numNiveles = 1;
    }

    // asignar derecha e izquierda
    public void ligaID(NodoSkipList<T> izquierdo, NodoSkipList<T> derecha) {
        izquierdo.setDer(derecha);
        derecha.setIzq(izquierdo);
    }

    // arriba getAbajo
    public void ligaArAb(NodoSkipList<T> arriba, NodoSkipList<T> abajo) {
        arriba.setAbajo(abajo);
        abajo.setArriba(arriba);
    }

    public String toString() {
        NodoSkipList<T> actual = cabeza;
        String s = "";
        while (actual.getAbajo() != null)
            actual = actual.getAbajo();
        actual = actual.getDer();
        while (actual.getElem() != null) {
            s += actual.getElem() + " ";
            actual = actual.getDer();
        }
        return s;
    }

    private NodoSkipList<T> busca(T elem) {
        NodoSkipList<T> actual = cabeza;
        boolean termine = false;
        while (!termine) {
            // te sigues moviendo a la --> hasta que el nodo en el que estás sea menor al
            // que estás buscando
            // Cuando encuentras uno mayor que el elemento se busca bajar
            while (actual.derecha.elem != null && elem.compareTo(actual.derecha.elem) >= 0) {
                actual = actual.derecha;
            }
            // bajas
            if (actual.abajo != null) {
                actual = actual.abajo;
            } else {
                termine = true;
            }
        }
        return actual;
    }

    // Método por Gius y David
    public NodoSkipList<T> inserta(T elem) {
        int i = 1;
        double volado;
        NodoSkipList<T> aux = busca(elem);

        NodoSkipList<T> nuevo = new NodoSkipList<T>(elem);
        nuevo.setIzq(aux);
        nuevo.setDer(aux.getDer());
        aux.getDer().setIzq(nuevo);
        aux.setDer(nuevo);
        // ligaID(nuevo,aux.derecha);
        // ligaID(aux,nuevo);
        cont++;
        volado = Math.random();
        while (volado > .5 && (double) i < 1.0 + Math.log(cont) / Math.log(2)) {
            if (i >= numNiveles)
                expandeListas();

            while (aux.getArriba() == null && aux.getIzq() != null)
                aux = aux.getIzq();

            aux = aux.getArriba();
            NodoSkipList<T> nuevo2 = new NodoSkipList<T>(elem);
            ligaID(nuevo2, aux.derecha);
            ligaID(aux, nuevo2);
            ligaArAb(nuevo2, nuevo);
            nuevo = nuevo2;
            volado = Math.random();
            i++;
        }

        return aux;
    }

    private void expandeListas() {
        NodoSkipList<T> cabezaN = new NodoSkipList<T>(null);
        NodoSkipList<T> colaN = new NodoSkipList<T>(null);

        ligaID(cabezaN, colaN);
        ligaArAb(cabezaN, cabeza);
        ligaArAb(colaN, cola);
        this.cabeza = cabezaN;
        this.cola = colaN;
        numNiveles++;
    }
}
