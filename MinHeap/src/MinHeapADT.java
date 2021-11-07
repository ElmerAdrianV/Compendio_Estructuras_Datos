package Compendio_Estructuras_Datos.MinHeap.src;
public interface MinHeapADT<T> {
    public T getMin();
    public T removeMin();
    public void insert(T elem);
}
