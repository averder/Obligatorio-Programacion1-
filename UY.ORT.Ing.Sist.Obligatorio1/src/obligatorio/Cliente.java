package obligatorio;

public abstract class  Cliente {
    
    //Atributos
    private String nombre;
    private int telefono;
    private String mail;
    

    //Metodos de acceso y modificacion
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String unNombre) {
        nombre = unNombre;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public void setTelefono(int unTelefono) {
        telefono = unTelefono;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String unMail) {
        mail = unMail;
    }
    
    //Constructor sin parametros
    public Cliente(){
        setNombre("Sin nombre");
        setTelefono(0);
        setMail("Sin mail");
    }
    
    //Constructor con parametros
    public Cliente(String unNombre, int unTelefono,String unMail){
        setNombre(unNombre);
        setTelefono(unTelefono);
        setMail(unMail);
    }

    @Override
    public String toString(){
        return  "-----------------------------------------------------------------------\n" +
                "\nNombre cliente:" + this.getNombre() + "\nTeléfono:" + this.getTelefono() +
                "\nMail:" + this.getMail()
                ;
    }
}
