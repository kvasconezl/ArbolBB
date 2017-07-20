/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.main;

import espol.edu.ec.TDAs.ArbolBB;

/**
 *
 * @author kvasconezl
 */
public class Main {
    public static void main(String[] args) {
        ArbolBB<Integer> abb = new ArbolBB<>((Integer n1, Integer n2) -> n1 - n2);
        ArbolBB<Integer> abb2 = new ArbolBB<>((Integer n1, Integer n2) -> n1 - n2);
        
        abb.add(55); abb2.add(55);
        abb.add(35); abb2.add(35);
        abb.add(75); abb2.add(75);
        abb.add(70); abb2.add(70);
        abb.add(41); abb2.add(41);
        abb.add(4);  abb2.add(4);
        abb.add(85); abb2.add(85);
        abb.add(80); abb2.add(80);
        abb.add(1);  abb2.add(1);
        abb.add(14); abb2.add(14);
        abb.add(90); abb2.add(90);
        abb.add(49); abb2.add(49);
        abb.add(40); abb2.add(40);
        abb.add(60); abb2.add(60);
        abb.add(72); abb2.add(72);
        
        System.out.println("Imprimiendo árbol1 en enOrden:");
        abb.enOrden();
        System.out.println("\nImprimiendo árbol1 en posOrden:");
        abb.posOrden();
        System.out.println("\nImprimiendo árbol1 en preOrden:");
        abb.preOrden();
        
        System.out.println("\nImprimiendo árbol2 en enOrden:");
        abb2.enOrden();
        System.out.println("\nImprimiendo árbol2 en posOrden:");
        abb2.posOrden();
        System.out.println("\nImprimiendo árbol2 en preOrden:");
        abb2.preOrden();
        
        System.out.print("\nEs el árbol1 igual al árbol2 --> ");
        String iguales = (abb.equals(abb2)) ? "Sí" : "No";
        System.out.println(iguales);
        
        System.out.print("\nValor mínimo del árbol1 --> ");
        System.out.println(abb.min());
        
        System.out.print("\nValor máximo del árbol1 --> ");
        System.out.println(abb.max());
        
        System.out.print("\nVerificando si árbol1 está lleno --> ");
        String lleno = (abb.isFull()) ? "Está lleno" : "No está lleno";
        System.out.println(lleno + "\n");
        
        System.out.print("Verificandi si árbol1 contiene al 60 --> ");
        String contiene1 = (abb.contains(60)) ? "Contiene" : "No contiene";
        System.out.println(contiene1 + "\n");
        
        System.out.print("Verificando si árbol1 contiene al 100 --> ");
        String contiene2 = (abb.contains(100)) ? "Contiene" : "No contiene";
        System.out.println(contiene2 + "\n");
        
        System.out.println("Removiendo el 40...");
        abb.remove(40);
        String contiene3 = (abb.contains(40)) ? "Contiene" : "No contiene";
        System.out.println("Verificando si el árbol1 contiene al 40 luego del remove ---> " + contiene3 + "\n");
        
        
        System.out.print("Verificando si árbol1 está lleno --> ");
        lleno = (abb.isFull()) ? "Está lleno" : "No está lleno";
        System.out.println(lleno + "\n");
        
        
        System.out.print("\n\n\nEs el árbol1 igual al árbol2 --> ");
        iguales = (abb.equals(abb2)) ? "Sí" : "No";
        System.out.println(iguales + "\n");
        
    }
}
