package estructuras;

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