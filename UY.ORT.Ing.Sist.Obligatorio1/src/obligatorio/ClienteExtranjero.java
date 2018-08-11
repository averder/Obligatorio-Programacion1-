package obligatorio;

public class ClienteExtranjero extends Cliente {

    //Atributos
    private int codigoDePrefijo;

    //Metodos de acceso y modificacion
    public int getCodigoDePrefijo() {
        return codigoDePrefijo;
    }

    public void setCodigoDePrefijo(int unCodigoDePrefijo) {
        codigoDePrefijo = unCodigoDePrefijo;
    }

    //Constructor sin parametros
    public ClienteExtranjero() {
        super.setNombre("Sin nombre");
        super.setTelefono(0);
        super.setMail("Sin mail");
        setCodigoDePrefijo(0);
    }

    //Constructor con parametros
    public ClienteExtranjero(String unNombre, int unTelefono, String unMail, int unCodigoDePrefijo) {
        super.setNombre(unNombre);
        super.setTelefono(unTelefono);
        super.setMail(unMail);
        setCodigoDePrefijo(unCodigoDePrefijo);
    }

    @Override
    public String toString() {
        return "Cliente Extranjero: " + super.toString()
                + "Código de prefijo de país: " + this.getCodigoDePrefijo();
    }
}
