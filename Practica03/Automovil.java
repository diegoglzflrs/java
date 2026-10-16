public class Automovil extends Vehiculo{
    private int numPuertas;
    private boolean esElectrico;
    public Automovil (String marca, String modelo, int anio, double velocidadMax, int numPuertas, boolean esElectrico){
        super(marca, modelo, anio, velocidadMax);
        this.numPuertas = numPuertas;
        this.esElectrico = esElectrico;
    }
    public int getNumPuertas(){
        return numPuertas;
    }
    public boolean getEsElectrico(){
        return esElectrico;
    }
    public void setNumPuertas(int numPuertas){
        if(numPuertas>6 || numPuertas<2)
            System.out.println("ERROR: Número de puertas no posible.");
        else
            this.numPuertas = numPuertas;
    }
    @Override
    public String toString(){
        return super.toString() + 
        " | Número de Puertas: " + getNumPuertas() + 
        " | Es Eléctrico: " + (getEsElectrico() ? "Si" : "No");
    }
}
