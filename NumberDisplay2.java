
/**
 * Write a description of class NumberDisplay here.
 * 
 */
public class NumberDisplay2
{
    // instance variables - replace the example below with your own
    private int limite; 
    private int valorActual;

    /**
     * Constructor for objects of class NumberDisplay
     */
    public NumberDisplay2(int limite)
    {
        this.limite = limite;
        valorActual = 0;
    }
    
    /**
     * mt para fijar el valorActual
     */
    public void setValue(int valor){
        if(valor <= 0 || valor >= limite){
            valorActual = 12;
        }
        else{
            valorActual = valor;
        }
    }
    
    /**
     * método que devuelve el valor actual del display en forma de cadena de 2 caracteres (nombre del método: )
     */
    public String getDisplayValue(){
        String cadena = "";
        if(valorActual < 10){
            cadena = "0" +valorActual;
        }
        else{
            cadena = valorActual+ "";
        }
        return cadena;
    }
    
    /**
     * método que devuelve el valor actual del display como entero (),
     */
    public int getValue(){
        return valorActual;
    }
    
    /**
     * método que incrementa en 1 al display y lo hace volver al principio si alcanza el límite.
     */
    public void increment(){
        valorActual = (valorActual + 1) % limite;
    }
    
}



















