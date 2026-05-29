package src.estructuras;

public class Arista {
    public Vertice destino;
    public Arista siguiente; // Para manejar la lista enlazada de conexiones de un vértice

    public Arista(Vertice destino) {
        this.destino = destino;
        this.siguiente = null;
    }
}