/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listasdoblementeenlazadasporteclado;

import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class ListaDoblementeEnlazadaPorTeclado {
    public class NodoDoble{
        NodoDoble siguiente;
        NodoDoble anterior;
        int dato;
        //cosntructor para cuando no hay nodos
        public NodoDoble(int d){
            this.siguiente=null;
            this.anterior=null;
            this.dato=d;
        }
        //constructor para cuando hay nodos
        public NodoDoble(int d,NodoDoble s,NodoDoble a){
            dato=d;
            siguiente=s;
            anterior=a;
        }
    }
    private NodoDoble inicio;
    private NodoDoble fin;
    private int tamaño;
    public ListaDoblementeEnlazadaPorTeclado(){
        inicio=null;
        fin=null;
        tamaño=0;
    }
    public boolean estaVacia(){
        if(inicio==null){
            return true;
        }else{
            return false;
        }
    }
   
    public void AgregarAlInicio(int d){
        if(!estaVacia()){
            inicio= new NodoDoble(d, inicio, null);
            inicio.siguiente.anterior=inicio;
        }else{
            fin=inicio=new NodoDoble(d);
        }
        tamaño++;
    }
     public void AgregarAlFinal(int d){
        if(!estaVacia()){
            fin=new NodoDoble(d, null, fin);
            fin.anterior.siguiente=fin;
         }else{
            inicio=fin=new NodoDoble(d);
        }
        tamaño++;
    }
     public void AgregarDespues(int n, int dato){
         NodoDoble nuevo = new NodoDoble(dato);
        if(inicio==null){
            inicio=nuevo;
        }else{
            NodoDoble puntero =inicio;
            int contador=0;
            while(contador<n && puntero.siguiente!=null){
                puntero=puntero.siguiente;
                contador++;
            }
            nuevo.siguiente=puntero.siguiente;
            puntero.siguiente=nuevo;
        }
        tamaño++;
     }
    public void MostrarInicioFin(){
        if(!estaVacia()){
            NodoDoble reco=inicio;
            System.out.println("mostrar de inicio a fin");
            while(reco!=null){
                System.out.println(reco.dato+"");
                reco=reco.siguiente;
            }
            System.out.println();
        }
    }
   
    public void MostrarFinInicio(){
        if(!estaVacia()){
            NodoDoble reco=fin;
            System.out.println("mostrar de fin a inicio");
            while(reco!=null){
                System.out.println(reco.dato+"");
                reco=reco.anterior;
            }
            System.out.println();
        }
    }
     public int mostrarunelemento(int n){
        if(inicio==null){
           return 0;
       } else{
            NodoDoble puntero=inicio;
            int contador=0;
            while(contador<n&&puntero.siguiente!=null){
                puntero=puntero.siguiente;
                contador++;
           }
           if(contador!=n){
              return 0;
           }else{
               return puntero.dato;
                }
           }
    }
     public void eliminarinicio(){
        if(inicio!=null){
        NodoDoble primer= inicio;
        inicio=inicio.siguiente;
        primer.siguiente=null;
        tamaño--;
        }
    }
    public void eliminarfin(){
        if(fin!=null){
        NodoDoble ultimo= fin;
        fin=fin.anterior;
        ultimo.anterior=null;
        tamaño--; 
        }
    }
    public void eliminarelemento(int n){
         if(inicio!=null){
            if(n==0){
                NodoDoble primer= inicio;
                inicio=inicio.siguiente;
                primer.siguiente=null;
                tamaño--;
            }else if (n<tamaño){
                NodoDoble puntero = inicio;
                int contador=0;
                while(contador<(n-1)){
                    puntero=puntero.siguiente;
                    contador++;
                }
                NodoDoble temp =puntero.siguiente;
                puntero.siguiente= temp.siguiente;
                temp.siguiente=null;
                tamaño--;
            }
        }
    }
   
    public int tamaño(){
        return tamaño;
    }
    public int vaciarLista(){
        if(inicio!=null){
            int aux=inicio.dato;
            inicio=inicio.siguiente;
            return aux;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner obtener = new Scanner(System.in);
        ListaDoblementeEnlazadaPorTeclado lista = new ListaDoblementeEnlazadaPorTeclado();
        System.out.println("Ingrese el tamaño de la lista");
        int Lista = obtener.nextInt();
        int arreglo[] = new int[Lista];
        
        int elemento = 0;

        String eliminar, ingresar = null;
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("#####################################################");
            System.out.println("Escribir (si) si deesea ingresar por inicio");
            ingresar = obtener.next().intern();
            if (ingresar == "si") {
                System.out.println("Ingrese numero por el inicio de la lista");
                elemento = obtener.nextInt();
                lista.AgregarAlInicio(elemento);
            }
            System.out.println("#####################################################");
            System.out.println("Ecribir (si) si desea ingresar por final");
            ingresar = obtener.next().intern();
            if (ingresar == "si") {

                System.out.println("Ingrese numeros al final de la lista");
                elemento = obtener.nextInt();
                lista.AgregarAlFinal(elemento);
            }
            System.out.println("#####################################################");
            System.out.println("Escribir (si) si desea ingresar despues un elemento a la lista");
            ingresar = obtener.next().intern();
            if (ingresar == "si") {
                System.out.println("Ingresar un elemento despues a la lista");
                elemento = obtener.nextInt();
                lista.AgregarDespues(elemento, elemento);
            }
            System.out.println("#####################################################");
            System.out.println("La lista esta vacia:"+lista.estaVacia());
            System.out.println("#####################################################");
            lista.MostrarInicioFin();
            System.out.println("#####################################################");
            lista.MostrarFinInicio();
            System.out.println("#####################################################");
            lista.mostrarunelemento(elemento);
            System.out.println("#####################################################");
            System.out.println("El tamaño de la lista  es:" + lista.tamaño());
            System.out.println("#####################################################");
            System.out.println("Escibir (si) si desea eliminar por el inicio elementos de la lista");
            eliminar = obtener.next().intern();
            if (eliminar == "si") {
                lista.eliminarinicio();
            }
            System.out.println("#####################################################");
            System.out.println("Escribir (si) si desea eliminar por final elementos de la lista");
            eliminar = obtener.next().intern();
            if (eliminar == "si") {
                lista.eliminarfin();
            }
            System.out.println("#####################################################");
            System.out.println("Ecribir (si) si desea eliminar un elemento de la lista");
            eliminar = obtener.next().intern();
            if (eliminar == "si") {
                lista.eliminarelemento(elemento);
            }
            System.out.println("#####################################################");
            lista.MostrarInicioFin();
            System.out.println("#####################################################");
            lista.MostrarFinInicio();
            System.out.println("#####################################################");
            System.out.println("El tamaño de la lista  es :" + lista.tamaño());
            System.out.println("#####################################################");
            System.out.println("La lista esta vacia:"+lista.estaVacia());
            System.out.println("#####################################################");
            System.out.println("Escribir (si) si desea vaciar todos los elementos de la lista");
            eliminar=obtener.next().intern();
            if(eliminar=="si"){
                while(lista.estaVacia()==false){
                    System.out.println(lista.vaciarLista());
                }
            }
            System.out.println("#####################################################");
            System.out.println("La lista esta vacia:"+lista.estaVacia());
        }
    }
}
