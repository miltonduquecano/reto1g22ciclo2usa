import java.util.Scanner;
/*
* Recomendaciones Generales:
*
*    -> El método run() funcionará como nuestro método principal
*    -> No declarar objetos de tipo Scanner, utilizar el método read() para solicitar datos al usuario.
*    -> Si requiere utilizar varias clases, estas NO deben ser tipo public.
*/
class Reto1{

    /**
    *  Este debe ser el único objeto de tipo Scanner en el código
    */
    private final Scanner scanner = new Scanner(System.in);

    /**
    * Este método es usado para solicitar datos al usuario
    * @return  Lectura de la siguiente linea del teclado
    */
    public String read(){
        return this.scanner.nextLine();
    }
	
	/**
       Valida si la entrada de datos es correcta
       Los valores de masa permitidos están entre 0 y 150
       Los valores de altura permitidos están entre 0.1 y 2.5
       Los valores de edad valores permitidos están entre 0 y 110
       Si alguno de los valores está fuera del rango permitido se debe imprimir un
       mensaje de ERROR
     * @param peso valor para el peso
     * @param altura valor para la altura
     * @param edad valor para la edad
     * @return true si los datos cumple con las validaciones
     *         false en caso contrario
     */
    public static boolean validarDatos(double peso, double altura,int edad){
        //generar condiciones de error
        if (peso < 0 || peso > 150)
            return false;
        else if(altura < 0.1 || altura > 2.5)
            return false;
        else if(edad < 0 || edad > 110)
            return false;
        //o realizar calculos
        else
            return true;
    }
    
    /**
     * Calcula el IMC a partir del peso y la altura
     * @param peso valor para el peso
     * @param altura valor para la altura
     * @return IMC
     */
    public static double calcularImc(double peso,double altura){
        return peso / Math.pow(altura, 2);
    }
    
    /**
     * Calcula el nivel de riesgo
     * @param valorIMC valor del IMC
     * @param edad valor de la edad
     * @return Nivel de riesgo Bajo,Medio,Alto segun condiciones 
     */
    public static String calcularNivelRiesgo(double valorIMC, int edad){
        if (valorIMC < 22 && edad < 45)
            return "Bajo";
        else if (valorIMC >= 22 && edad < 45)
            return "Medio";
        else if (valorIMC < 22 && edad > 45)
            return "Medio";
        else if (valorIMC >= 22 && edad >= 45)
            return "Alto";
        else
            return "";
    }
	
    /**
    * método principal
    */
    public void run(){
	  /*
            Datos de entrada
        */
        String datos[] = read().split(" ");
        
        //convertir de cadena de caracteres a datos primitivos individuales
        double peso = Double.parseDouble(datos[0]);
        double altura = Double.parseDouble(datos[1]);
        int edad = Integer.parseInt(datos[2]);
        double valorIMC;
        String nivelRiesgo="";
        
        
        //validar entrada de datos
        if (validarDatos(peso, altura, edad)==false)
            System.out.println("ERROR");
        //o realizar calculos
        else{
            valorIMC = calcularImc(peso, altura);
            System.out.println(String.format("%.1f", valorIMC) + " " + calcularNivelRiesgo(valorIMC, edad));
        }			
    }
}