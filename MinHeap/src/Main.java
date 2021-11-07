package Compendio_Estructuras_Datos.MinHeap.src;

public class Main {
   public static void main(String[] args) {
    MinHeap<Integer> minHeap = new MinHeap<>();
    minHeap.insert(5);
    minHeap.insert(4);
    minHeap.insert(2);
    minHeap.insert(47);
    minHeap.insert(0);
    
    while(!minHeap.isEmpty())
        System.out.println(minHeap.removeMin());
   }
}
