/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listaenlazada;

/**
 *
 * @author USUARIO
 */
public class ListaEnlazada {

   public class Nodo{
    Nodo siguiente;
    int libro;
    public Nodo(int libro){
        this.siguiente =null;
       this.libro=libro;
    }
}
    private Nodo cabeza;
    private int tamaño;
    
    public ListaEnlazada(){
        cabeza=null;
        tamaño=0;
    }
    public void insertarprincipio(int libro){
        Nodo nuevo = new Nodo(libro);
        nuevo.siguiente=cabeza;
        cabeza=nuevo;
        tamaño++;
    }
    public void insertarfinal(int libro){
        Nodo nuevo = new Nodo(libro);
        if(cabeza==null){
            cabeza=nuevo;
        }else{
            Nodo puntero =cabeza;
            while(puntero.siguiente!=null){
                puntero=puntero.siguiente;
            }
            puntero.siguiente=nuevo;
        }
        tamaño++;
    }
    public void insertardespues(int n, int libro){
        Nodo nuevo = new Nodo(libro);
        if(cabeza==null){
            cabeza=nuevo;
        }else{
            Nodo puntero =cabeza;
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
    public int obtener(int n){
       if(cabeza==null){
           return 0;
       } else{
           Nodo puntero=cabeza;
           int contador=0;
           while(contador<n &&puntero.siguiente!=null){
              puntero=puntero.siguiente;
              contador++;
           }
           if(contador!=n){
             return 0;
           }else{
               return puntero.libro;
           }
           
        }
    }
    public void mostrarlista(){
        if(cabeza!=null){
            Nodo reco =cabeza;
            System.out.println("elementos de la lista");
            while(reco!=null){
                System.out.println(reco.libro+"");
                reco=reco.siguiente;
            }
            System.out.println();
        }
    }
    public boolean estavacia(){
        if(cabeza==null){
            return true;
        }else{
            return false;
        }
    }
    public int contar(){
       return tamaño; 
    }
    public void eliminarprincipio(){
        if(cabeza!=null){
        Nodo primer= cabeza;
        cabeza=cabeza.siguiente;
        primer.siguiente=null;
        tamaño--;
        }
    }
    public void eliminarultimo(){
        if(cabeza!=null){
            if(cabeza.siguiente==null){
                cabeza=null;
            }else{
            Nodo puntero=cabeza;
            while(puntero.siguiente.siguiente!=null){
                puntero=puntero.siguiente;
            }
            puntero.siguiente=null;
            }
            tamaño--;
        }
    }
    public void eliminar(int n){
        if(cabeza!=null){
            if(n==0){
                Nodo primer= cabeza;
                cabeza=cabeza.siguiente;
                primer.siguiente=null;
                tamaño--;
            }else if (n<tamaño){
                Nodo puntero = cabeza;
                int contador=0;
                while(contador<(n-1)){
                    puntero=puntero.siguiente;
                    contador++;
                }
                Nodo temp =puntero.siguiente;
                puntero.siguiente= temp.siguiente;
                temp.siguiente=null;
                tamaño--;
            }
        }
    }
    public int vaciarlista(){
        if(cabeza!=null){
            int aux=cabeza.libro;
            cabeza=cabeza.siguiente;
            return aux;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        lista.insertarprincipio(5);
        lista.insertarprincipio(6);
        lista.insertarprincipio(3);
        lista.insertarprincipio(7);
        
        lista.insertarfinal(6);
        lista.insertarfinal(12);
        lista.insertarfinal(5);
        
        lista.insertardespues(5,4);
        System.out.println("el tamaño es:"+lista.contar());
        lista.mostrarlista();
        System.out.println(lista.obtener(3));
        
        lista.eliminarprincipio();
        lista.eliminarultimo();
        lista.eliminar(3);
        
        System.out.println("el tamaño es:"+lista.contar());
        lista.mostrarlista();
        while(lista.estavacia()==false){
            System.out.println(lista.vaciarlista());
        }
        System.out.println("la lista esta vacia:"+lista.estavacia());
    }
    
}
