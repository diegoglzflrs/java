public class Barco extends Vehiculo{
    private int tonelajeMaximo;
    private int numTripulantes;
    public Barco(String marca, String modelo, int anio, double velocidadMax, int tonelajeMaximo, int numTripulantes){
        super(marca, modelo, anio, velocidadMax);
        this.tonelajeMaximo = tonelajeMaximo;
        this.numTripulantes = numTripulantes;
    }
    public int getTonelajeMaximo(){
        return tonelajeMaximo;
    }
    public int getNumTripulantes(){
        return numTripulantes;
    }
    public void setNumTripulantes(int numTripulantes){
        if(numTripulantes<0)
            System.out.println("ERROR: Número negativo de tripulantes no posible. ");
        else
            this.numTripulantes = numTripulantes;
    }
    @Override
    public String toString(){
        return super.toString() + 
        " | Tonelaje Máximo: " + getTonelajeMaximo() +
        " | Número de Tripulantes: " + getNumTripulantes();
    }
}
