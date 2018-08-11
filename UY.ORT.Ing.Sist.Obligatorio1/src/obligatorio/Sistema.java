package obligatorio;

import java.util.*;

public class Sistema {
    //Atributos
    private ArrayList <Oferta> listaOferta ;
    private ArrayList <Cliente> listaCliente;
    private ArrayList <Interes> listaInteres ;
    private int numeroMinOferta;
   
    //Metodos de acceso y modificacion
    public ArrayList<Oferta> getListaOferta(){
        return listaOferta;
    }
    public ArrayList<Cliente> getListaCliente(){
        return listaCliente;
    }
    public ArrayList<Interes> getListaInteres(){
        return listaInteres;
    }
    public void agregarOferta(Oferta unaOferta){
        listaOferta.add(unaOferta);
    }
    public void agregarCliente(Cliente unCliente){
        listaCliente.add(unCliente);
    }
    public void agregarInteres(Interes unInteres){
        listaInteres.add(unInteres);
    }
    public int getNumeroMinOferta(){
        return this.numeroMinOferta;
    }
    public void setNumeroMinOferta(int unNumeroMinDeOfertas){
        numeroMinOferta = unNumeroMinDeOfertas;
    }
    
    //Contructor sin parametros
    public Sistema(){
        listaOferta = new ArrayList<Oferta>();
        listaCliente = new ArrayList<Cliente>();
        listaInteres = new ArrayList<Interes>();
        this.setNumeroMinOferta(0);
    }
}
