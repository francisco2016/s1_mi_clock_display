import java.util.Calendar;
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
    private boolean r24horas;
    private NumberDisplay2 dia;
    private NumberDisplay2 mes;
    private NumberDisplay2 ano;

    /**
     * Constructor sin parámetros, que fija la hora a "00:00" 
     * Si r24horas = false muestra el reloj en formato am/pm, si r24horas = true, lo muestra en formato 24 horas.
     */
    public ClockDisplay(boolean r24horas){
        horas = new  NumberDisplay2(24);
        minutos = new  NumberDisplay2(60);
        horaActual = horas.getDisplayValue()+ " : " +minutos.getDisplayValue();
        this.r24horas = r24horas;
        dia = new  NumberDisplay2(30);
        mes = new  NumberDisplay2(12);
        ano = new  NumberDisplay2(100);
        
        //permite poner el reloj a la fecha actual.
        Calendar fecha = Calendar.getInstance();
        setTime(0, 0, fecha.get(Calendar.DAY_OF_MONTH),
            fecha.get(Calendar.MONTH) + 1, 
            fecha.get(Calendar.YEAR) % 100);

    }

    /**
     * Constructor con 2 parámetros de tipo int, que representan las horas y los minutos a los que fijar la hora actual. 
     * Si r24horas = false muestra el reloj en formato am/pm, si = true, lo muestra en formato 24 horas.
     */
    public ClockDisplay(int h, int m, int d, int m2, int a, boolean r24horas)
    {
        horas = new  NumberDisplay2(24);
        minutos = new  NumberDisplay2(60);
        dia = new  NumberDisplay2(30);
        mes = new  NumberDisplay2(12);
        ano = new  NumberDisplay2(100);
        
        this.r24horas = r24horas; 
        setTime(h, m, d,  m2, a );
    }

    /**
     * acepta dos parámetros de tipo int, que representan horas y minutos, y que fije dichos valores
     * como el tiempo actual del reloj
     */
    public void setTime(int h, int m, int d , int m1, int a ){
        horas.setValue(h);
        minutos.setValue(m);
        dia.setValue(d);
        mes.setValue(m1);
        ano.setValue(a);
        
        getTime();
    }

    /**
     * método  que devuelva la hora como String de 5 caracteres.
     */
    public String getTime(){
        if(r24horas == false){
            if(horas.getValue() > 12){
                horaActual = (horas.getValue()-12)+ " : " + minutos.getDisplayValue() + " p.m. "  + dia.getDisplayValue()
                + " / " +mes.getDisplayValue()+ " / " + ano.getDisplayValue() ;
            }
            if(horas.getValue() < 12){
                horaActual =  horas.getValue() + " : " + minutos.getDisplayValue() + " a.m. "  + dia.getDisplayValue()
                + " / " + mes.getDisplayValue() + " / " + ano.getDisplayValue() ;
            }
            if(horas.getValue() == 12){
                horaActual = (horas.getValue()) + " : " +minutos.getDisplayValue()+ " p.m."   +dia.getDisplayValue()
                + " / " + mes.getDisplayValue() + "/ " + ano.getDisplayValue() ;
            }
            if(horas.getValue() == 0){
                horaActual = (horas.getValue() )+ " : " +minutos.getDisplayValue()+ " a.m. "  +dia.getDisplayValue()
                + " / " +mes.getDisplayValue()+ " / " +ano.getDisplayValue() ;
            }
        }
        else{
            horaActual = horas.getDisplayValue()+ " : " +minutos.getDisplayValue()+ "  "  +dia.getDisplayValue()
            + " / " +mes.getDisplayValue()+ " / " +ano.getDisplayValue() ;
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
            if(horas.getValue() == 0){
                dia.increment();
                if(dia.getValue() == 0){
                    dia.increment();
                    mes.increment();
                    if(mes.getValue() == 0){
                        mes.increment();
                        ano.increment();
                    }
                }
            }
        }
        getTime();
    }
    /**
     * mt para cambiar de formato automáticamente.
     */
    public void changeFormat(){
     r24horas = !r24horas;
     getTime();
    }
}



