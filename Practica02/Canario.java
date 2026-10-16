package Practica02;
public class Canario extends Animal{
    String colorPlumaje;
    boolean cantaEnJaula;
    public Canario(String nombre, int edad, double peso, String colorPlumaje, boolean cantaEnJaula){
        super();
        setNombre(nombre);
        setEdad(edad);
        setPeso(peso);
        this.colorPlumaje = colorPlumaje;
        this.cantaEnJaula = cantaEnJaula;
    }
    public void cantar(){
        System.out.println(getNombre() + " dice ¡Pio, pio, pio!");
    }

    public void volar(){
        System.out.println(getNombre() + " está volando.");
    }
    @Override
    public String toString() {
        return "\nNombre: " + getNombre()
            + " | Edad: " + getEdad()
            + " | Peso: " + getPeso()
            + " | Color del Plumaje: " + colorPlumaje
            + " | Canta en su Jaula: " + cantaEnJaula;
    }
}
