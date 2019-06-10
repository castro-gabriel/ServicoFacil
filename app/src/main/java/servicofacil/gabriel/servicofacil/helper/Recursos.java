package servicofacil.gabriel.servicofacil.helper;

import servicofacil.gabriel.servicofacil.model.Prestador;
import servicofacil.gabriel.servicofacil.model.Solicitante;

public class Recursos {

    // atributos
    private static Recursos singleton = null;
    private Prestador prestadorAtivo = null;
    private Solicitante solicitanteAtivo = null;

    // construtor
    private Recursos(){

    }

    // metodos
    public static Recursos getInstance(){
        if(singleton == null)
            singleton = new Recursos();
        return singleton;
    }

    public void setPrestadorAtivo(Prestador p){
        this.prestadorAtivo = p;
    }

    public Prestador getPrestadorAtivo(){
        return this.prestadorAtivo;
    }

    public void setSolicitanteAtivo(Solicitante s){
        this.solicitanteAtivo = s;
    }

    public Solicitante getSolicitanteAtivo(){
        return this.solicitanteAtivo;
    }
}
