/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.TDAs;

/**
 *
 * @author kvasconezl
 * @param <E>
 */
public class Node<E> {
    private E data;
    private Node<E> izquierdo;
    private Node<E> derecho;
    
    public Node(E data) {
        this.data = data;
        this.izquierdo = this.derecho = null;
    }
    
    public Node() {
        this.data = null;
        this.izquierdo = this.derecho = null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Node<E> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Node<E> getDerecho() {
        return derecho;
    }

    public void setDerecho(Node<E> derecho) {
        this.derecho = derecho;
    }
}
