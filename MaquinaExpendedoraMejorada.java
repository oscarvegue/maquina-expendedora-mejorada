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
    // Numero maximo de billetes que tiene la m?quina
    private int numeroMaximoBilletes;
    // Numero de billetes que quedan para el premio
    private int contadorBilletesPremios;
    // Numero de billetes vendidos
    private int contadorBilletes;
    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, String tipo,int maximoBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        tipoMaquina = tipo;
        numeroMaximoBilletes = maximoBilletes;
        contadorBilletesPremios = 4;
        contadorBilletes = 0;
    }

    /** Crea una maquina expendedora de billetes de tren con el
     *  precio del billete, estacion de origen y de destino.
     */
    public MaquinaExpendedoraMejorada(String tipo,int maximoBilletes) {
        precioBillete = 12;
        estacionOrigen = "Le?n";
        estacionDestino = "Sevilla";
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        tipoMaquina = tipo;
        numeroMaximoBilletes = maximoBilletes;
        contadorBilletesPremios = 4;
        contadorBilletes = 0;
    }
    
    /**
     * Vac?a todo el dinero de la m?quina
     */
    public int getVaciarDineroDeLaMaquina() {
        int conjuntodepositos;
        conjuntodepositos = totalDineroAcumulado + balanceClienteActual;
         if (0 < balanceClienteActual) {
            System.out.println("error operaci?n en curso");
            conjuntodepositos = -1;
        }
        else {
            balanceClienteActual = 0;
            totalDineroAcumulado = 0;
        }
        return conjuntodepositos;
    }
    
    public int getcontadorBilletes(){
        contadorBilletes = 0;
        return contadorBilletes;
    }
    
    /**
     * Devuelve el n?mero de billetes vendidos
     */
    public int getNumeroBilletesVendidos() {
        int numeroBilletesVendidos = totalDineroAcumulado / precioBillete;
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
        int numeroBilletesVendidos = totalDineroAcumulado / precioBillete;
         if (numeroMaximoBilletes > numeroBilletesVendidos) {
             if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            }
        }
        else {
            System.out.println("error no quedan mas billetes");
        }
    }
   
    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta;
        cantidadDeDineroQueFalta = (precioBillete - balanceClienteActual);
        int numeroBilletesVendidos = totalDineroAcumulado / precioBillete;
        
         if (numeroMaximoBilletes > numeroBilletesVendidos) {
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
            // Actualiza los billetes que quedan para el premio
            contadorBilletesPremios = contadorBilletesPremios -1;
            }
            else {
            System.out.println("Necesitas introducir " + cantidadDeDineroQueFalta + " euros mas!");
            }
             if (tipoMaquina == "premio"){
                 if (contadorBilletesPremios == 0){
                    System.out.println("Tienes 3? de descuento en peluquer?as Manolo");
                    contadorBilletesPremios = 4;
                }
            }
            else {
            System.out.println("error no quedan mas billetes");
            }
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

