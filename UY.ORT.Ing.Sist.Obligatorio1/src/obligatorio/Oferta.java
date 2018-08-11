package obligatorio;

public class Oferta implements Comparable {
    //Atributos

    private int tipo;
    private String descripcion;
    private int costo;
    private int cantMin;
    private boolean estado;
    private int numeroDeOferta;
    private boolean concretada;

    //Metodos de acceso y modificacion
    public int getTipo() {
        return this.tipo;
    }

    public void setTipo(int unTipo) {
        tipo = unTipo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String unaDescripcion) {
        descripcion = unaDescripcion;
    }

    public int getCosto() {
        return this.costo;
    }

    public void setCosto(int unCosto) {
        costo = unCosto;
    }

    public int getCantMin() {
        return this.cantMin;
    }

    public void setCantMin(int unaCantMin) {
        cantMin = unaCantMin;
    }

    public boolean getEstado() {
        return this.estado;
    }

    public void setEstado(boolean unEstado) {
        estado = unEstado;
    }
    
    public int getNumeroDeOferta(){
        return this.numeroDeOferta;
    }
    
    public void setNumeroDeOferta(int unNumeroDeOferta){
        numeroDeOferta = unNumeroDeOferta;
    }
    
    public boolean getConcretada(){
        return this.concretada;
    }
    
    public void setConcretada(boolean unConcretada){
       this.concretada = unConcretada;
    }

    //Constructor sin parámetros
    public Oferta() {
        setTipo(0);
        setDescripcion("Sin descripción");
        setCosto(0);
        setCantMin(0);
        setEstado(false);
        setNumeroDeOferta(1);
        setConcretada(false);    
    }

    //Contructor con parámetros
    public Oferta(int unTipo, String unaDescripcion, int unCosto, int unaCantMin,
            boolean unEstado , int unNumeroDeOferta , boolean unConcretada) {
        setTipo(unTipo);
        setDescripcion(unaDescripcion);
        setCosto(unCosto);
        setCantMin(unaCantMin);
        setEstado(unEstado);
        setNumeroDeOferta(unNumeroDeOferta);
        setConcretada(unConcretada);
    }

    public String tipoOferta() {

        String retorno = "Ningun tipo corresponde";

        switch (this.tipo) {
            case 1: {
                retorno = "1-Turismo";
                break;
            }
            case 2: {
                retorno = "2-Servicio";
                break;
            }
            case 3: {
                retorno = "3-Comida";
                break;
            }
            case 4: {
                retorno = "4-Entretenimiento";
                break;
            }
            case 5: {
                retorno = "5-Belleza";
                break;
            }
            case 6: {
                retorno = "6-Educación";
                break;
            }
            case 7: {
                retorno = "7-Otros";
                break;
            }
        }
        return retorno;
    }

    public String estado() {
        String estado = "";
        if (this.getEstado()) {
            estado = "Abierto";
        } else {
            estado = "Cerrado";
        }
        return estado;
    }
    
     public String concretada() {
        String concretada = "";
        if (this.getConcretada()) {
            concretada = "La oferta ha sido concretada";
        } else {
            concretada = "La oferta no ha sido concretada";
        }
        return concretada;
    }

    @Override
    public int compareTo(Object o) {
        return this.getCosto() - ((Oferta) o).getCosto();
    }

    @Override
    public String toString() {

        return "-----------------------------------------------------------------------\n"
                + "\nTipo de Oferta:" + this.tipoOferta() + "\nDescripción:"
                + this.getDescripcion() + "\nCosto:" + this.getCosto()
                + "\nCantidad mínima de interesados para su concreción:"
                + this.getCantMin() + "\nEstado:" + this.estado() + "\nNúmero de Oferta:"
                + this.getNumeroDeOferta() + "\n" +this.concretada()
                + "\n***********************************************************************";
    }
}
