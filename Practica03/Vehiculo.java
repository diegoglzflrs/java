public class Vehiculo{
    private String marca;
    private String modelo;
    private int anio;
    protected double velocidadMax;
    public Vehiculo(String marca, String modelo, int anio, double velocidadMax){
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.velocidadMax = velocidadMax;
    }
    public String getMarca(){
        return marca;
    }
    public String getModelo(){
        return modelo;
    }
    public int getAnio(){
        return anio;
    }
    public void setAnio(int anio){
        if(anio>=1885 && anio<=2100)
            this.anio = anio;
        else
            System.out.println("ERROR: Año no válido.");
    }
    public double getVelocidadMax(){
        return velocidadMax;
    }
    public void setVelocidadMax(double velocidadMax){
        if(velocidadMax<0)
            System.out.println("ERROR: Vehiculo en reposo o velocidad fuera de rango.");
        else
            this.velocidadMax = velocidadMax;
    }
    public void describir(){
        System.out.println("Este vehiculo es de la marca " + getMarca() + 
        ", del modelo " + getModelo() +
        ", fabricado en el año " + getAnio() +
        ", y tiene velocidad máxima de " + getVelocidadMax() + 
        " km/h.");
    }
    @Override
    public String toString(){
        return "\nMarca: " + getMarca() + 
        " | Modelo: " + getModelo() + 
        " | Año: " + getAnio() +
        " | Velocidad Máxima: " + getVelocidadMax();
    }
}