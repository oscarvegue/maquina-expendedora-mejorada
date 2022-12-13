public class MaquinaExpendedoraMejorada {

    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // Tipo de la maquina
    private String tipoMaquina;
    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, String tipo) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        tipoMaquina = tipo;
    }

    /** Crea una maquina expendedora de billetes de tren con el
     *  precio del billete, estacion de origen y de destino.
     */
    public MaquinaExpendedoraMejorada(String tipo) {
        precioBillete = 12;
        estacionOrigen = "Le�n";
        estacionDestino = "Sevilla";
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        tipoMaquina = tipo;
    }
    
    /**
     * Vac�a todo el dinero de la m�quina
     */
    public int getVaciarDineroDeLaMaquina() {
        int conjuntodepositos;
        conjuntodepositos = totalDineroAcumulado + balanceClienteActual;
         if (0 < balanceClienteActual) {
            System.out.println("error operaci�n en curso");
            conjuntodepositos = -1;
        }
        else {
            balanceClienteActual = 0;
            totalDineroAcumulado = 0;
        }
        return conjuntodepositos;
    }
    
    /**
     * Devuelve el n�mero de billetes vendidos
     */
    public int getNumeroBilletesVendidos() {
        int numeroBilletesVendidos = totalDineroAcumulado / precioBillete;
        if (tipoMaquina == "premio"){
            System.out.println("tienes 3� de descuento en peluqueria Manolo");
        }
        else if (tipoMaquina == "normal"){
            
        }
        else {
            System.out.println("error tipo de maquina no v�lido");
            numeroBilletesVendidos = 0;
        }
        return numeroBilletesVendidos;
    }
    
    /**
     * Imprimir los billete vendidos
     */
    public void imprimirNumeroBilletesVendidos() {
        int numeroBilletesVendidos = totalDineroAcumulado / precioBillete;
        System.out.println(numeroBilletesVendidos);
    }
    
    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (cantidadIntroducida > 0) {
            balanceClienteActual = balanceClienteActual + cantidadIntroducida;
        }
        else {
            System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
        }        
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta;
        cantidadDeDineroQueFalta = (precioBillete - balanceClienteActual);
        if (cantidadDeDineroQueFalta <= 0) {        
            // Simula la impresion de un billete
            System.out.println("##################");
            System.out.println("# Billete de tren:");
            System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
            System.out.println("# " + precioBillete + " euros.");
            System.out.println("##################");
            System.out.println();         

            // Actualiza el total de dinero acumulado en la maquina
            totalDineroAcumulado = totalDineroAcumulado + precioBillete;
            // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
            balanceClienteActual = balanceClienteActual - precioBillete;
        }
        else {
            System.out.println("Necesitas introducir " + cantidadDeDineroQueFalta + " euros mas!");

        }     
        
        if (tipoMaquina == "premio"){
            System.out.println("tienes 3� de descuento en peluqueria Manolo");
        }
        else {
        }
    }
    
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    }
}

