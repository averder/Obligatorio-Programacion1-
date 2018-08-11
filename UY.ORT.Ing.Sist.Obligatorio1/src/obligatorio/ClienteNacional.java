package obligatorio;

public class ClienteNacional extends Cliente {
    //Atributos

    private String direccion;

    //Metodos de acceso y modificacion
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String unaDireccion) {
        direccion = unaDireccion;
    }

    //Constructor sin parametros
    public ClienteNacional() {
        super.setNombre("Sin nombre");
        super.setTelefono(0);
        super.setMail("Sin mail");
        this.setDireccion("Sin direccion");
    }

    //Constructor con parametros
    public ClienteNacional(String unNombre, int unTelefono, String unMail, String unaDireccion) {
        super.setNombre(unNombre);
        super.setTelefono(unTelefono);
        super.setMail(unMail);
        this.setDireccion(unaDireccion);
    }

    @Override
    public String toString() {
        return "Cliente Nacional :" + super.toString()
                + "Dirección: " + this.getDireccion();
    }
}
