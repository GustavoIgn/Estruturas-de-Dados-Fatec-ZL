package model;

public class ListaSet<T> {

    No<T> primeiro;

    public ListaSet() {
        primeiro = null;
    }

    public boolean isEmpty() {
        if (primeiro == null) {
            return true;
        }
        return false;
    }

    public int size() {
        int cont = 0;
        if (!isEmpty()) {
            No<T> auxiliar = primeiro;
            while (auxiliar != null) {
                cont++;
                auxiliar = auxiliar.proximo;
            }
        }
        return cont;
    }

    private No<T> getNo(int posicao) throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        int tamanho = size();
        if (posicao < 0 || posicao > tamanho - 1) {
            throw new Exception("Posição Inválida");
        }
        No<T> auxiliar = primeiro;
        int cont = 0;
        while (cont < posicao) {
            auxiliar = auxiliar.proximo;
            cont++;
        }
        return auxiliar;
    }

    public void addFirst(T t) {
        if (!contains(t)) {
            No<T> elemento = new No<>();
            elemento.dado = t;
            elemento.proximo = primeiro;
            primeiro = elemento;
        }
    }

    public void addLast(T t) throws Exception {
        if (!contains(t)) {
            if (isEmpty()) {
                throw new Exception("Lista Vazia");
            }
        }
        No<T> elemento = new No<>();
        elemento.dado = t;
        elemento.proximo = null;
        int tamanho = size();
        No<T> ultimo = getNo(tamanho - 1);
        ultimo.proximo = elemento;
    }

    public void add(T t, int posicao) throws Exception {
        if (!contains(t)) {
            if (isEmpty()) {
                throw new Exception("Lista Vazia");
            }
            int tamanho = size();
            if (posicao < 0 || posicao > tamanho) {
                throw new Exception("Posição inválida");
            }
            if (posicao == 0) {
                addFirst(t);
            } else if (posicao == tamanho) {
                addLast(t);
            } else {
                No<T> elemento = new No<>();
                elemento.dado = t;
                No<T> anterior = getNo(posicao - 1);
                elemento.proximo = anterior.proximo;
                anterior.proximo = elemento;
            }
        }
    }

    public void removeFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        primeiro = primeiro.proximo;
    }

    public void removeLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        int tamanho = size();
        if (tamanho == 1) {
            removeFirst();
        } else {
            No<T> penultimo = getNo(tamanho - 2);
            penultimo.proximo = null;
        }
    }

    public void remove(int posicao) throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        int tamanho = size();
        if (posicao < 0 || posicao > tamanho - 1) {
            throw new Exception("Posição Inválida");
        }
        if (posicao == 0) {
            removeFirst();
        } else if (posicao == tamanho - 1) {
            removeLast();
        } else {
            No<T> atual = getNo(posicao);
            No<T> anterior = getNo(posicao - 1);
            anterior.proximo = atual.proximo;
        }
    }

    public T get(int posicao) throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista vazia");
        }
        int tamanho = size();
        if (posicao < 0 || posicao > tamanho - 1) {
            throw new Exception("Posição inválida");
        }
        int count = 0;
        No<T> aux = primeiro;
        while (count < posicao) {
            aux = aux.proximo;
            count++;
        }
        return aux.dado;
    }

    private boolean contains(T t) {
        No<T> aux = primeiro;
        while (aux != null) {
            if (aux.dado.equals(t)) {
                return true;
            }
            aux = aux.proximo;
        }
        return false;
    }
}
