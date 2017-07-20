/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.TDAs;

import java.util.Comparator;

/**
 *
 * @author kvasconezl
 * @param <E>
 */
public class ArbolBB<E> {
    private Node<E> root;
    private Comparator<E> f;
    
    public ArbolBB(Comparator<E> f) {
        this.root = null;
        this.f = f;
    }
    
    public void add(E data) {
        this.root = add(data, this.root);
    }
    
    private Node<E> add(E data, Node<E> nodo) {
        if (nodo == null) {
            nodo = new Node<>(data);
        } else if (f.compare(data, nodo.getData()) > 0) {
           nodo.setDerecho(add(data, nodo.getDerecho()));
        } else if (f.compare(data, nodo.getData()) < 0) {
            nodo.setIzquierdo(add(data, nodo.getIzquierdo()));
        }
        return nodo;
    }
    
    public boolean contains(E data) {
        return contains(data, this.root);
    }
    
    private boolean contains(E data, Node<E> nodo) {
        if (nodo != null) {
            if (data == nodo.getData()) {
                return true;
            } else if (f.compare(data, nodo.getData()) > 0) {
                return contains(data, nodo.getDerecho());
            } else if (f.compare(data, nodo.getData()) < 0) {
                return contains(data, nodo.getIzquierdo());
            } 
        }
        return false;
    }
    
    public int contarHojas() {
        return contarHojas(this.root);
    }
    
    private int contarHojas(Node<E> nodo) {
        if (nodo == null) {
            return 0;
        } else if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
            return 1;
        } else {
            return contarHojas(nodo.getDerecho()) + contarHojas(nodo.getIzquierdo());
        }
    }
    
    public int contarNodos() {
        return contarNodos(this.root);
    }
    
    private int contarNodos(Node<E> nodo) {
        if (nodo == null) {
            return 0;
        } else {
            return 1 + contarNodos(nodo.getDerecho()) + contarNodos(nodo.getIzquierdo());
        }
    }
    
    public int height() {
        return ArbolBB.this.height(this.root);
    }
    
    private int height(Node <E> nodo) {
        if (nodo == null) {
            return 0;
        } else if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
            return 1;
        } else {
            return 1 + Math.max(ArbolBB.this.height(nodo.getIzquierdo()), ArbolBB.this.height(nodo.getDerecho()));
        }
    }
    
    public E getRoot() {
        return this.root.getData();
    }
    
    public boolean isFull() {
        return isFull(this.root);
    }
    
    private boolean isFull(Node<E> nodo) {
        if (nodo == null) {
            return true;
        } else if ((nodo.getIzquierdo() != null && nodo.getDerecho() == null) || (nodo.getIzquierdo() == null && nodo.getDerecho() != null)) {
            return false;
        }
        return (isFull(nodo.getIzquierdo()) && isFull(nodo.getDerecho()) && ArbolBB.this.height(nodo.getIzquierdo()) == ArbolBB.this.height(nodo.getDerecho()));
    }
    
    public E min() {
        return min(this.root);
    }
    
    private E min(Node<E> nodo) {
        if(nodo == null) {
            return null;
        } else if (nodo.getIzquierdo() == null) {
            return nodo.getData();
        } else {
            return min(nodo.getIzquierdo());
        }
    }
    
    public E max(){
        return max(this.root);
    }    
    
    private E max(Node<E> nodo) {
        if (nodo == null) {
            return null;
        } else if (nodo.getDerecho() == null) {
            return nodo.getData();
        } else {
            return max(nodo.getDerecho());
        }
    }
    
    public void remove(E data) {
        this.root = remove(data, this.root);
    }
    
    private Node<E> remove(E data, Node<E> nodo) {
        if (nodo == null) {
            return null;
        } else if (f.compare(data, nodo.getData()) > 0) {
            nodo.setDerecho(remove(data, nodo.getDerecho()));
        } else if (f.compare(data, nodo.getData()) < 0) {
            nodo.setIzquierdo(remove(data, nodo.getIzquierdo()));
        } else if (nodo.getDerecho() != null) {
            nodo.setData(min(nodo.getDerecho()));
            nodo.setDerecho(remove(nodo.getData(), nodo.getDerecho()));
        } else if (nodo.getIzquierdo() != null) {
            nodo.setData(max(nodo.getIzquierdo()));
            nodo.setIzquierdo(remove(nodo.getData(), nodo.getIzquierdo()));
        } else {
            nodo = null;
        }
        return nodo;
    }
    
    public void posOrden() {
        posOrden(this.root);
        System.out.print("\n");
    }
    
    private void posOrden(Node<E> nodo) {
        if (nodo != null) {
            posOrden(nodo.getIzquierdo());
            posOrden(nodo.getDerecho());
            System.out.print(nodo.getData());
            System.out.print(" ");
        }
    }
    
    public void preOrden() {
        preOrden(this.root);
        System.out.print("\n");
    }
    
    private void preOrden(Node<E> nodo) {
        if(nodo != null) {
            System.out.print(nodo.getData());
            System.out.print(" ");
            preOrden(nodo.getIzquierdo());
            preOrden(nodo.getDerecho());
        }
    } 
    
    public void enOrden() {
        enOrden(this.root);
        System.out.print("\n");
    }
    
    private void enOrden(Node<E> nodo) {
        if(nodo != null) {
            enOrden(nodo.getIzquierdo());
            System.out.print(nodo.getData());
            System.out.print(" ");
            enOrden(nodo.getDerecho());
        }
    }
    
    @Override
    public boolean equals(Object o) {
        ArbolBB<E> arbol = (ArbolBB<E>) o;
        return equals(this.root, arbol.root);
    }
    
    private boolean equals(Node<E> n1, Node<E> n2) {
        if (n1 == null && n2 == null) {
            return true;
        } else if ((n1 == null & n2 != null) || (n1 != null && n2 == null)) {
            return false;
        } else if (f.compare(n1.getData(), n2.getData()) == 0) {
            return equals(n1.getDerecho(), n2.getDerecho()) && equals(n1.getIzquierdo(), n2.getIzquierdo());
        } else {
            return false;
        }
    }
    
    @Override
    public String toString() {
        return "{\n" + toString(this.root) + "}";
    }
    
    private String toString(Node<E> nodo) {
        String s = "";
        if (nodo != null) {
            if (nodo == this.root) {
                s += "Raíz: " + nodo.getData() + " -> ";
            } else {
                s += "Padre: " + nodo.getData() + " -> ";
            }
            if (nodo.getIzquierdo() == null) {
                s+= "NULL";
            } else {
                s += nodo.getIzquierdo().getData();
            }
            s += " | ";
            if (nodo.getDerecho() == null) {
                s += "NULL";
            } else {
                s += nodo.getDerecho().getData();
            }
            s += "\n";
        } 
        if (nodo.getIzquierdo() != null) {
            s += toString(nodo.getIzquierdo());
        } 
        if (nodo.getDerecho() != null) {
            s += toString(nodo.getDerecho());
        }
        return s;
    }
}
