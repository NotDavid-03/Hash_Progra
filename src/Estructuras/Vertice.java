package estructuras;

public class Vertice {
    public String tipo;       // "CLIENTE", "FACTURA", "PRODUCTO"
    public String id;         // El ID de la base de datos (convertido a String)
    public String nombre;     // Nombre del cliente, número de factura o nombre de producto
    public Arista adyacentes; // Cabeza de la lista de aristas que salen de este vértice
    public Vertice siguiente; // Para mantener una lista global de todos los vértices del grafo

    public Vertice(String tipo, String id, String nombre) {
        this.tipo = tipo;
        this.id = id;
        this.nombre = nombre;
        this.adyacentes = null;
        this.siguiente = null;
    }

    // Método para conectar este vértice con otro (crear arista dirigida)
    public void agregarArista(Vertice destino) {
        Arista nuevaArista = new Arista(destino);
        if (adyacentes == null) {
            adyacentes = nuevaArista;
        } else {
            Arista actual = adyacentes;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevaArista;
        }
    }
}
