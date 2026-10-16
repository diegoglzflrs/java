package Practica02;
public class Perro extends Animal{
    String raza;
    boolean estaVacunado;
    public Perro(String nombre, int edad, double peso, String raza, boolean estaVacunado){
        super();
        setNombre(nombre);
        setEdad(edad);
        setPeso(peso);
        this.raza = raza;
        this.estaVacunado = estaVacunado;
    }
    void ladrar(){
        System.out.println(getNombre() + " dice ¡Guau guau!");
    }
    void buscarPelota(){
        System.out.println(getNombre() + " está buscando la pelota.");
    }
    @Override
    public String toString(){
        return "\nNombre: " + getNombre()
                + " | Edad: " + getEdad()
                + " | Peso: " + getPeso()
                + " | Raza: " + raza
                + " | Está Vacunado: " + estaVacunado;
    }
}