package Compendio_Estructuras_Datos.SkipList.src;

public class NodoSkipList<T> {
    NodoSkipList<T> izquierda, derecha, arriba, abajo;
    T elem;

    NodoSkipList(T elemento) {
        izquierda = null;
        derecha = null;
        arriba = null;
        abajo = null;
        elem = elemento;
    }

    public NodoSkipList<T> getIzq() {
        return izquierda;
    }

    public NodoSkipList<T> getDer() {
        return derecha;
    }

    public NodoSkipList<T> getAbajo() {
        return abajo;
    }

    public NodoSkipList<T> getArriba() {
        return arriba;
    }

    public T getElem() {
        return elem;
    }

    public void setIzq(NodoSkipList<T> A) {
        izquierda = A;
    }

    public void setDer(NodoSkipList<T> A) {
        derecha = A;
    }

    public void setArriba(NodoSkipList<T> A) {
        arriba = A;
    }

    public void setAbajo(NodoSkipList<T> A) {
        abajo = A;
    }
}
