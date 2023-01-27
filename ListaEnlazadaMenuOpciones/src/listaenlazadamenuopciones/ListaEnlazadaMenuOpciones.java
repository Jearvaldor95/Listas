// Lista enlazada por medio de un menú de opciones

package listaenlazadamenuopciones;

import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class ListaEnlazadaMenuOpciones {

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
    
    public ListaEnlazadaMenuOpciones(){
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
       
        Scanner leer = new Scanner(System.in);
         
        ListaEnlazadaMenuOpciones lista = new ListaEnlazadaMenuOpciones();
        int bandera=0;
        int seleccion=0;
        int elemento=0;
        do{
            do{
            System.out.println("Por fabor seleccione una opcion:");
            System.out.println("------------------------------------------------");
            System.out.println("    1.Insertar al principio de la lista.");
            System.out.println("------------------------------------------------");
            System.out.println("    2.Insertar al final de la lista.");
            System.out.println("------------------------------------------------");
            System.out.println("    3.Insertar despues a la lista.");
            System.out.println("------------------------------------------------");
            System.out.println("    4.Obtener un elemento cualquiera.");
            System.out.println("------------------------------------------------");
            System.out.println("    5.Mostrar los elemetos de la lista.");
            System.out.println("------------------------------------------------");
            System.out.println("    6.Lista esta vacia.");
            System.out.println("------------------------------------------------");
            System.out.println("    7.Contar los elementos de la lista.");
            System.out.println("------------------------------------------------");
            System.out.println("    8.Eliminar por el principio de la lista.");
            System.out.println("------------------------------------------------");
            System.out.println("    9.Eliminar ultimo elemento de la lista.");
            System.out.println("------------------------------------------------");
            System.out.println("    10.Eliminar cualquier elemento de la lista.");
            System.out.println("------------------------------------------------");
            System.out.println("    11.Vaciar la lista.");
            System.out.println("------------------------------------------------");
            System.out.println("    12.Salir.");
            seleccion=leer.nextInt();
            if(seleccion>=1 && seleccion<=12){
                bandera=1;
            }else{
                System.out.println("------------------------------------------------");
                System.out.println("opcion incorrecta, vuelva a intentarlo por favor");
                System.out.println("------------------------------------------------");
            }
            }while(bandera==0);
            if(seleccion==1){
                System.out.println("inserte un elemento al principio");
                elemento=leer.nextInt();
                
               lista.insertarprincipio(elemento);
            }else if(seleccion==2){
                
                System.out.println("inserte un elemento al final");
                elemento=leer.nextInt();
               lista.insertarfinal(elemento);
            }else if(seleccion==3){
                System.out.println("inserte un elemento despues ");
                elemento=leer.nextInt();
                lista.insertardespues(elemento, elemento);
            }else if(seleccion==4){
                System.out.println("el elemento que esta en la posicion:"+lista.obtener(elemento));
            }else if(seleccion==5){
                if(!lista.estavacia()){
                  lista.mostrarlista();
                }else{
                    System.out.println("la lista esta vacia");
                }
            }else if(seleccion==6){
                System.out.println("la lista esta vacia:"+lista.estavacia());
            }else if(seleccion==7){
                System.out.println("el tamaño de la lista es :"+lista.contar());
            }else if(seleccion==8){
                lista.eliminarprincipio();
            }else if(seleccion==9){
                lista.eliminarultimo();
            }else if(seleccion==10){
                lista.eliminar(elemento);
            }else if(seleccion==11){
                while(lista.estavacia()==false){
                    System.out.println(lista.vaciarlista());
                }
                
            }else if(seleccion==12){
                System.out.println("------------------------------------------------");
                System.out.println("Gracias hasta pronto.");
                System.out.println("------------------------------------------------");
                bandera=2;
            }
        }while(bandera!=2);
        
    }
    
}
