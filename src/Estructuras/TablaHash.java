package estructuras;

public class TablaHash<K, V> {
    private HashNode<K, V>[] tabla;
    private int capacidad;
    private int totalColisiones;

    @SuppressWarnings("unchecked")
    public TablaHash(int capacidad) {
        this.capacidad = capacidad;
        this.tabla = new HashNode[capacidad];
        this.totalColisiones = 0;
    }

    // 3.2. Función de Hashing para indexar de manera uniforme
    private int calcularHash(K clave) {
        // Usamos el hashCode nativo del objeto y aseguramos que sea positivo
        int hash = clave.hashCode();
        return Math.abs(hash) % capacidad;
    }

    // 3.1. Proceso de inserción registrando colisiones
    public void insertar(K clave, V valor) {
        int indice = calcularHash(clave);
        HashNode<K, V> nuevoNodo = new HashNode<>(clave, valor);

        // Si la casilla está vacía, se inserta directamente
        if (tabla[indice] == null) {
            tabla[indice] = nuevoNodo;
        } else {
            // ¡Hay una colisión! Recorremos la lista enlazada
            totalColisiones++;
            HashNode<K, V> actual = tabla[indice];
            while (actual.siguiente != null) {
                // Si la clave ya existe, actualizamos el valor y salimos
                if (actual.clave.equals(clave)) {
                    actual.valor = valor;
                    return;
                }
                actual = actual.siguiente;
            }
            // Validar el último nodo de la lista
            if (actual.clave.equals(clave)) {
                actual.valor = valor;
            } else {
                actual.siguiente = nuevoNodo; // Insertar al final de la lista
            }
        }
    }

    // 3.2. Búsqueda en tiempo promedio O(1)
    public V buscar(K clave) {
        int indice = calcularHash(clave);package estructuras;

public class HashNode<K, V> {
    K clave;
    V valor;
    HashNode<K, V> siguiente;

    public HashNode(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
        this.siguiente = null;
    }
}
        HashNode<K, V> actual = tabla[indice];

        while (actual != null) {
            if (actual.clave.equals(clave)) {
                return actual.valor;
            }
            actual = actual.siguiente;
        }
        return null; // No se encontró
    }

    // Métodos auxiliares para los reportes requeridos
    public int getIndice(K clave) {
        return calcularHash(clave);
    }

    public int getTotalColisiones() {
        return totalColisiones;
    }
}
