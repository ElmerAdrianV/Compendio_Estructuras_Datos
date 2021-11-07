package Compendio_Estructuras_Datos.MinHeap.src;
public class MinHeap<T extends Comparable<T>> implements MinHeapADT<T> {
    private T[] datos;
    private int cont;
    
    public MinHeap(){
        datos = (T[]) new Comparable[20];
        cont = 0; 
    }

    public MinHeap(int size) {
        datos = (T[]) new Comparable[size];
        cont = 0;
    
    }
    @Override
    public T getMin() {
        return datos[1];
    }
    @Override
    public void insert(T elem) {
        int posNuevo=++cont;
        expande();
        datos[posNuevo]=elem;
        int papa=posNuevo>>1;
        while(posNuevo > 1 && datos[posNuevo].compareTo(datos[papa])<0){
            this.swap(papa, posNuevo);
            posNuevo=papa;
            papa=posNuevo>>1;
        }
    }

    @Override
    public T removeMin() {
        T min = datos[1];
        boolean termine = false;
        datos[1]=datos[cont--];
        int papaI=1, hijoIzq, hijoDer, hijoMin;
        while(!termine){
            hijoIzq=papaI<<1;
            hijoDer= (papaI<<1)+1;
            
            if(hijoDer<=cont){
                if( datos[hijoIzq].compareTo(datos[hijoDer])<=0)
                    hijoMin=hijoIzq;
                else
                    hijoMin=hijoDer;
                if( datos[hijoMin].compareTo(datos[papaI])<=0){
                    this.swap(papaI, hijoMin);
                    papaI=hijoMin;
                }
                else
                    termine=true;
            }
            else{
                if(hijoIzq<=cont){
                    if( datos[hijoIzq].compareTo(datos[papaI])<0){
                        this.swap(papaI, hijoIzq);
                        papaI=hijoIzq;
                    }
                }
                termine=true;
            }   
        }
        return min;
    }
    
    //Métodos auxiliares
    public boolean isEmpty(){
        return cont == 0;
    }
    public void swap(int papa, int hijo) {
        T aux = datos[papa];
        datos[papa] = datos[hijo];
        datos[hijo] = aux;
    }
    private void expande() {
        T[] temp;
        if (cont < datos.length)
          return;
        temp = (T[]) new Comparable[datos.length * 2];
        for (int i = 1; i < datos.length; i++)
          temp[i] = datos[i];
        this.datos = temp;
    }
}
