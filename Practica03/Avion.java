public class Avion extends Vehiculo{
    private String aerolinea;
    private double altitudMaxima;
    private int numPasajeros;
    public Avion(String marca, String modelo, int anio, double velocidadMax, String aerolinea, double altitudMaxima, int numPasajeros){
        super(marca, modelo, anio, velocidadMax);
        this.aerolinea = aerolinea;
        this.altitudMaxima = altitudMaxima;
        this.numPasajeros = numPasajeros;
    }
    public String getAerolinea(){
        return aerolinea;
    }
    public double getAltitudMaxima(){
        return altitudMaxima;
    }
    public int getNumPasajeros(){
        return numPasajeros;
    }
    public void setNumPasajeros(int numPasajeros){
        if(numPasajeros<0)
            System.out.println("ERROR: Número negativo de pasajeros no posible.");
        else
            this.numPasajeros = numPasajeros;
    }
    @Override
    public String toString(){
        return super.toString() + 
        " | Aerolinea: " + getAerolinea() +
        " | Altitud Máxima: " + getAltitudMaxima() + 
        " | Número de Pasajeros: " + getNumPasajeros();
    }
}
