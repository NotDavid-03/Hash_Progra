package estructuras;

public class Grafo {
    private Vertice cabeza; // Inicio de la lista global de vértices

    public Grafo() {
        this.cabeza = null;
    }

    // Insertar un vértice si no existe previamente
    public Vertice agregarVertice(String tipo, String id, String nombre) {
        Vertice encontrado = buscarVertice(tipo, id);
        if (encontrado != null) {
            return encontrado; // Si ya existe, devolvemos el existente
        }

        Vertice nuevo = new Vertice(tipo, id, nombre);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Vertice actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        return nuevo;
    }

    // Buscar un vértice específico en la lista global por su Tipo e ID
    public Vertice buscarVertice(String tipo, String id) {
        Vertice actual = cabeza;
        while (actual != null) {
            if (actual.tipo.equals(tipo) && actual.id.equals(id)) {
                return actual;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    // Conectar dos entidades mediante una arista dirigida (Origen -> Destino)
    public void conectar(String tipoOrig, String idOrig, String tipoDest, String idDest) {
        Vertice origen = buscarVertice(tipoOrig, idOrig);
        Vertice destino = buscarVertice(tipoDest, idDest);

        if (origen != null && destino != null) {
            origen.agregarArista(destino);
        }
    }
}