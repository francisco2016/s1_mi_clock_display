
/**
 * Write a description of class ClockDisplay here.
 *
 */
public class ClockDisplay
{
    // instance variables - replace the example below with your own
    private NumberDisplay2 horas;
    private NumberDisplay2 minutos;
    private String horaActual;

    /**
     * Constructor sin parámetros, que fija la hora a "00:00" 
     */
    public ClockDisplay(){
        horas = new  NumberDisplay2(24);
        horas.setValue(0);
        minutos = new  NumberDisplay2(60);
        minutos.setValue(0);
        horaActual = horas.getDisplayValue()+ " : " +minutos.getDisplayValue();
    }

    /**
     * Constructor con 2 parámetros de tipo int, que representan las horas y los minutos a los que fijar la hora actual. 
     */
    public ClockDisplay(int h, int m)
    {
        horas = new  NumberDisplay2(h);
        minutos = new  NumberDisplay2(m);
        horaActual = horas.getDisplayValue()+ " : " +minutos.getDisplayValue();
    }

    /**
     * acepta dos parámetros de tipo int, que representan horas y minutos, y que fije dichos valores
     * como el tiempo actual del reloj
     */
    public void setTime(int h, int m){
        horas.setValue(h);
        minutos.setValue(m);
    }

    //     /**
    //      * método  que devuelva la hora como String de 5 caracteres.
    //      */
    //     public String getTime(){
    //         return  horas.getDisplayValue()+ " : " +minutos.getDisplayValue();
    //     }
    
    /**
     * método  que devuelva la hora como String de 5 caracteres.
     */
    public String getTime(){
        
        if(horas.getValue() > 12){
            horaActual = (horas.getValue()-12)+ " : " +minutos.getDisplayValue()+ " p.m.";
        }
        if(horas.getValue() < 12){
            horaActual =  horas.getValue() + " : " +minutos.getDisplayValue()+ " a.m.";
        }
          if(horas.getValue() == 12){
            horaActual = (horas.getValue())+ " : " +minutos.getDisplayValue()+ " p.m.";
        }
          if(horas.getValue() == 0){
            horaActual = (horas.getValue() )+ " : " +minutos.getDisplayValue()+ " a.m.";
        }
        return  horaActual;
    }

    /**
     * método timeTick que haga avanzar un minuto la hora actual 
     */
    public void timeTick(){
        minutos.increment();
        if(minutos.getValue() == 0){
            horas.increment();
        }
        getTime();
    }
}
























