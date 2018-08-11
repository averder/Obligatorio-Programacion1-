package obligatorio;

public class Interes {
    //Atributos

    private Oferta oferta;
    private Cliente cliente;
    private int tipoPago;
    private String fechaYHora;

    //metodos de acceso y modificacion
    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta unaOferta) {
        oferta = unaOferta;
    }

    public Cliente getCliente(){
        return cliente;
    }
    
    public void setCliente(Cliente unCliente){
        cliente = unCliente;
    }

    public int getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(int unTipoPago) {
        tipoPago = unTipoPago;
    }

    public String getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(String unaFechaYHora) {
        fechaYHora = unaFechaYHora;
    }

    public Interes() {
        setOferta(new Oferta());
        setCliente(new ClienteNacional());
        setTipoPago(0);
        setFechaYHora("sin fecha");
    }

    public Interes(Oferta unaOferta,Cliente unCliente, int unTipoDePago, String unaFechaYHora) {

        setOferta(unaOferta);
        setCliente(unCliente);
        setTipoPago(unTipoDePago);
        setFechaYHora(unaFechaYHora);
    }

    public String tipoDePago(int unTipoPago) {
        String[] tipoDePago = {" ", "1-Abitab", "2-Redpagos", "3-Debito bancario", "4-No definida"};
        String retorno = tipoDePago[unTipoPago];
        return retorno;
    }

    @Override
    public String toString() {
        return "El cliente \n:" + this.getCliente() + "\nTiene interes en la oferta \n:" + oferta.toString()
                + "\nEl cliente pagara por: " + tipoDePago(this.getTipoPago()) + "\nFecha y Hora del sistema:\n" + this.getFechaYHora();



    }
}
