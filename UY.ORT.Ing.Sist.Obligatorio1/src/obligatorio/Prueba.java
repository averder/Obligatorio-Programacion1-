package obligatorio;

import java.util.*;

public class Prueba {

    public static void main(String[] args) {
        System.out.println("*****Bienvenido*****");
        Sistema sistema = new Sistema();
        int opcionMenu = 0;
        String menu = "\nIngresar valor de la opción deseada: "
                + "\n 1-Registo de Oferta:"
                + "\n 2-Consulta de Ofertas:"
                + "\n 3-Registro de Cliente Nacional o Extranjero:"
                + "\n 4-Registro de Interés:"
                + "\n 5-Cierre de oferta:"
                + "\n 6-Consulta de ofertas:"
                + "\n 7-Consulta de tipo:"
                + "\n 8-Reiniciar numerador de ofertas:"
                + "\n 9-Salir del programa:";
        opcionMenu = (pedirNumero(menu, 1, 9));
        while (opcionMenu != 9) {
            switch (opcionMenu) {
                case (1):
                    //Registro de Oferta
                    sistema.agregarOferta(registrarOferta(sistema));
                    opcionMenu = pedirNumero(menu, 1, 9);
                    break;
                case (2):
                    //Consulta de ofertas
                    consultaDeOferta(sistema.getListaOferta());
                    opcionMenu = pedirNumero(menu, 1, 9);
                    break;
                case (3):
                    //Registro de Cliente Nacional o Cliente Extranjero
                    int opcion = pedirNumero("Desea registrar un cliente\n1- Nacional\n2- Extranjero\n", 1, 2);
                    switch (opcion) {
                        case 1:
                            sistema.agregarCliente(registrarClienteNacional());
                            break;
                        case 2:
                            sistema.agregarCliente(registrarClienteExtranjero());
                            break;
                    }
                    opcionMenu = pedirNumero(menu, 1, 9);
                    break;
                case (4):
                    //Registro de interes
                    registroDeInteres(sistema);
                    opcionMenu = pedirNumero(menu, 1, 9);
                    break;
                case (5):
                    //Cierre de ofertas
                    cierreDeOferta(sistema);
                    opcionMenu = pedirNumero(menu, 1, 9);
                    break;
                case (6):
                    //Consulta de oferta (por tipo)
                    consultaDeTipoOfertas(sistema.getListaOferta());
                    opcionMenu = pedirNumero(menu, 1, 9);
                    break;
                case (7):
                    //Consulta de tipo
                    consutaDeTipo(sistema.getListaOferta());
                    opcionMenu = pedirNumero(menu, 1, 9);
                    break;
                case (8):
                    //Reiniciar numerador de ofertas
                    numeradorDeOfertas(sistema);
                    opcionMenu = pedirNumero(menu, 1, 9);
                    break;
                case (9):
                    //Fin del programa
                    break;
            }
        }
    }

    public static String pedirTexto(String mensaje) {
        Scanner in = new Scanner(System.in);
        String texto = "";
        System.out.print(mensaje);
        texto = in.nextLine();
        while (texto.trim().equals("")) {
            System.out.print("Ingresar un texto sin espacios vacíos: ");
            texto = in.nextLine();
        }
        return texto;
    }

    public static int pedirNumero(String mensaje, int rIni, int rFin) {
        int retorno = -1;
        boolean correcto = false;
        Scanner in = new Scanner(System.in);
        System.out.println(mensaje);
        //Si el caracter es numerico
        while (!correcto) {
            try {
                retorno = in.nextInt();
                //Verificacion del rango
                while (((retorno < rIni) || (retorno > rFin))) {
                    //Se imprime el error deseado
                    System.out.println("Ingresar un valor entre " + rIni + " y " + rFin + "\n" + mensaje);
                    retorno = in.nextInt();
                }
                correcto = true;
            } //Si no se ingresa un caracter numerico
            catch (Exception e) {
                System.out.println("ERROR: Debe ingresar un valor numérico.");
                in.nextLine();
            }
        }
        return retorno;
    }

    public static Oferta registrarOferta(Sistema sistema) {
        System.out.println("Registrar oferta:");
        int tipo = pedirNumero("Ingresar tipo de oferta: \n1-turismo \n2-servicio \n3-comida \n4-entretenimiento \n5-belleza \n6-educación \n7-otros", 1, 7);
        String unaDescripcion = pedirTexto("Ingresar una descripción:\n");
        int costo = pedirNumero("Ingresar un costo entre 100 y 5000:", 100, 5000);
        int cantMin = pedirNumero("Ingresar cantidad mínima necesaria de interesados para su concreción número entre 1 y 100 :", 1, 100);
        int numeroDeOferta = sistema.getNumeroMinOferta() + 1;
        sistema.setNumeroMinOferta(numeroDeOferta);
        Oferta oferta = new Oferta(tipo, unaDescripcion, costo, cantMin, true, numeroDeOferta, false);
        return oferta;
    }

    public static int pedirNumeroUno(String mensaje) {
        return pedirNumero(mensaje, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static String validacionMail(String usuario) {
        boolean ok = false;
        int contadorArroba = 0;
        int contadorEspacio = 0;

        while (!ok) {
            for (int i = 0; i < usuario.length(); i++) {
                char aux = usuario.charAt(i);
                if (aux == '@') {
                    contadorArroba++;
                }
                if (aux == ' ') {
                    contadorEspacio++;
                }
            }
            boolean arrobaYEspacioBien = (contadorArroba == 1 && contadorEspacio == 0);
            boolean contieneDominio = ((usuario.contains("@gmail.com")) || (usuario.contains("@yahoo.com")));
            boolean terminaEnPuntoCom = (((usuario.substring(usuario.indexOf("@")))).length()) <= 10;
            if (arrobaYEspacioBien && contieneDominio && terminaEnPuntoCom) {
                ok = true;
            } else {
                usuario = pedirTexto("Ingresar un usuario ,  formato aceptado son : usuario@gmail.com o usuario@yahoo.com la palabra usuario no debe contener @ ni espacios \n");
                contadorArroba = 0;
                contadorEspacio = 0;
            }
        }
        return usuario;
    }

    public static int tresDigitos() {
        boolean ok = false;
        int numero = pedirNumeroUno("Ingresar código de prefijo de país (3 dígitos)");
        while (!ok) {
            int numeroUno = numero / 100;
            if (numeroUno >= 1 && numeroUno <= 9) {
                ok = true;
                numero = numeroUno;
            } else {
                numero = pedirNumeroUno("Ingresar código de prefijo de país (3 dígitos)");
            }
        }
        return numero;
    }

    public static ClienteNacional registrarClienteNacional() {
        //se incializa como cliente nacional para tener la variable incializada luego se sobrescribira segun el switch
        ClienteNacional cliente = new ClienteNacional();

        String nombreUno = pedirTexto("Ingresar un nombre:\n");
        int telefonoUno = pedirNumeroUno("Ingresar un teléfono:");
        String mailUno = validacionMail(pedirTexto("Ingresar un usuario,formato aceptado son : usuario@gmail.com o usuario@yahoo.com la palabra usuario no debe contener @ ni espacios:\n"));
        String direccion = pedirTexto("Ingresar una dirección:");
        cliente = new ClienteNacional(nombreUno, telefonoUno, mailUno, direccion);

        return cliente;
    }

    public static ClienteExtranjero registrarClienteExtranjero() {
        //se incializa como cliente nacional para tener la variable incializada luego se sobrescribira segun el switch
        ClienteExtranjero cliente = new ClienteExtranjero();
        String nombre = pedirTexto("Ingresar un nombre:\n");
        int telefono = pedirNumeroUno("Ingresar un teléfono:");
        String mail = validacionMail(pedirTexto("Ingresar un usuario,formato aceptado son : usuario@gmail.com o usuario@yahoo.com la palabra usuario no debe contener @ ni espacios:\n"));
        int codigo = tresDigitos();
        cliente = new ClienteExtranjero(nombre, telefono, mail, codigo);
        return cliente;
    }

    public static void registroDeInteres(Sistema sist) {
        boolean teniaInteres = false;
        Interes interes = new Interes();
        ArrayList<Oferta> ofertasAbiertas = new ArrayList<Oferta>();
        for (int i = 0; i < sist.getListaCliente().size(); i++) {
            System.out.println("Los clientes son:\n" + (i + 1) + "--" + sist.getListaCliente().get(i));
        }
        int indiceCliente = pedirNumero("Elija un cliente:\n", 1, sist.getListaCliente().size());
        indiceCliente--;
        Cliente unCliente = sist.getListaCliente().get(indiceCliente);
        for (int i = 0; i < sist.getListaOferta().size(); i++) {
            if (sist.getListaOferta().get(i).getEstado()) {
                ofertasAbiertas.add(sist.getListaOferta().get(i));
            }
        }
        for (int i = 0; i < ofertasAbiertas.size(); i++) {
            System.out.println("Las ofertas abiertas son:\n" + (i + 1) + "--" + ofertasAbiertas.get(i));
        }
        int indiceOferta = pedirNumero("Elegir una oferta por su número", 1, ofertasAbiertas.size());
        // le resto uno para que corresponda al indice del arraylist
        indiceOferta--;
        Oferta unaOferta = sist.getListaOferta().get(indiceOferta);
        for (int i = 0; i < sist.getListaInteres().size(); i++) {
            if (sist.getListaInteres().get(i).getCliente().equals(unCliente) && sist.getListaInteres().get(i).getOferta().equals(unaOferta)) {
                teniaInteres = true;
            }
        }
        if (!teniaInteres) {
            Calendar c = Calendar.getInstance();
            int tipoDePago = pedirNumero("Ingresar tipo de pago: \n1-Abitab \n2-Redpagos \n3-Débito \n4-No definida", 1, 4);
            System.out.println("Se ha ingresado fecha y hora automaticamente ");
            String fechaYHora = c.getTime().toString();
            interes = new Interes(unaOferta, unCliente, tipoDePago, fechaYHora);
            sist.getListaInteres().add(interes);
        } else {
            System.out.println("El usuario ya tuvo interes en esta oferta ");
        }
    }

    public static void cierreDeOferta(Sistema sist) {
        Oferta of = new Oferta();
        int cantInteresados = 0;
        int numero = 0;
        for (int i = 0; i < sist.getListaOferta().size(); i++) {
            if (sist.getListaOferta().get(i).getEstado()) {
                System.out.println("Las ofertas abiertas son:" + (i + 1) + "---" + sist.getListaOferta().get(i));
            }
        }
        numero = pedirNumero("Ingrese el número de la oferta que desea cerrar", 1, sist.getListaOferta().size());
        numero--;
        sist.getListaOferta().get(numero).setEstado(false);
        System.out.println("La oferta ha sido cerrada satisfactoriamente");
        of = sist.getListaOferta().get(numero);
        for (int i = 0; i < sist.getListaInteres().size(); i++) {
            if (sist.getListaInteres().get(i).getOferta().equals(of)) {
                cantInteresados++;
            }
        }
        for (int i = 0; i < sist.getListaInteres().size(); i++) {
            if (cantInteresados >= of.getCantMin()) {
                of.setConcretada(true);
                if (sist.getListaInteres().get(i).getOferta().equals(of)) {
                    System.out.println("Los clientes interesados son :" + (i + 1)
                            + "---" + sist.getListaInteres().get(i).getCliente());
                }
            } else {
                of.setEstado(false);
                for (int j = 0; j < sist.getListaInteres().size(); j++) {
                    if (sist.getListaInteres().get(i).getOferta().equals(of)) {
                        sist.getListaInteres().remove(sist.getListaInteres().get(i));
                    }
                }
                sist.getListaOferta().remove(of);
            }
        }
    }

    public static void consultaDeOferta(ArrayList<Oferta> of) {
        ArrayList<Oferta> ofertaOrdenada = new ArrayList<Oferta>();
        if (of.isEmpty()) {
            System.out.println("No hay ofertas registradas");
        } else {
            int numero = pedirNumero("Ingresar un tipo de oferta \n1-Turismo \n2-Servicio \n3-Comida \n4-Entretenimiento "
                    + "\n5-Belleza  \n6-Educacion  \n7-Otros", 1, 7);
            for (int i = 0; i < of.size(); i++) {
                if (of.get(i).getEstado() && of.get(i).getTipo() == numero) {
                    ofertaOrdenada.add(of.get(i));
                }
            }
            Collections.sort(ofertaOrdenada);
            for (int i = 0; i < ofertaOrdenada.size(); i++) {
                System.out.println(ofertaOrdenada.get(i));
            }
            if (ofertaOrdenada.isEmpty()) {
                System.out.println("No hay ofertas de ese tipo o las ofertas de ese tipo estaban cerradas");
            }
        }
    }

    public static void consultaDeTipoOfertas(ArrayList<Oferta> listaOferta) {
        int[] tipoOfDinero = new int[8];
        int[] totalOfCerrada = new int[8];
        for (int i = 0; i < listaOferta.size(); i++) {
            if (!listaOferta.get(i).getEstado() && listaOferta.get(i).getConcretada()) {
                totalOfCerrada[listaOferta.get(i).getTipo()]++;
                tipoOfDinero[listaOferta.get(i).getTipo()] += listaOferta.get(i).getCosto();
            }
        }
        for (int i = 1; i < 8; i++) {
            System.out.println(" Tipo de oferta " + i + " su total de oferta cerrada que fueron concretadas es: "
                    + totalOfCerrada[i]);
        }
        for (int i = 1; i < 8; i++) {
            System.out.println(" Tipo de oferta " + i + " genero $ " + tipoOfDinero[i]);
        }
    }

    //parte del menu 8
    public static void consutaDeTipo(ArrayList<Oferta> listaOferta) {
        boolean[] tipos = new boolean[7];
        String[] tiposOferta = {"1-Turismo","2-Servicio","3-Comida","4-Entretenimiento","5-Belleza","6-Educación","7-Otros"};
        int numero = 0;
        boolean ok = false;
        int max = Integer.MIN_VALUE;
        int[] totalOfPorTipo = new int[7];
        for (int i = 0; i < listaOferta.size(); i++) {
            int numTipo = listaOferta.get(i).getTipo();
            totalOfPorTipo[numTipo - 1]++;
            System.out.println(totalOfPorTipo[numTipo - 1]);
        }
        //Busqueda del maximo
        for (int i = 0; i < totalOfPorTipo.length; i++) {
            if (totalOfPorTipo[i] > max) {
                max = totalOfPorTipo[i];
            }
        }
        //Si encuentra que una tiene el maximo lo coloca en numero y le suma 1
        for (int i = 0; i < totalOfPorTipo.length; i++) {
            if (totalOfPorTipo[i] == max) {
                numero = i + 1;
            }
            //Si la oferta tiene el tipo, pone true en el array de boolean
            for (int j = 0; j < listaOferta.size(); j++) {
                if (listaOferta.get(j).getTipo() == numero) {
                    tipos[listaOferta.get(j).getTipo()-1] = true;
                }
            }
        }
        System.out.println("Los tipos mas frecuentes son:");
        for (int i = 0; i < tipos.length; i++) {
            if (tipos[i]) {
                System.out.println(tiposOferta[i]);
            }
        }
    }

    public static void numeradorDeOfertas(Sistema sist) {
        boolean ok = false;
        int numero = pedirNumeroUno("Ingresar numero mayor a " + (sist.getNumeroMinOferta()));
        while (!ok) {
            if (numero > sist.getNumeroMinOferta()) {
                ok = true;
            } else {
                numero = pedirNumeroUno("Ingresar numero mayor a " + (sist.getNumeroMinOferta()));
            }
        }
        sist.setNumeroMinOferta(numero);
    }

}
