package Practica02;
public class Gato extends Animal {
    String color;
    boolean tienePelajeLargo;
    public Gato(String nombre, int edad, double peso, String color, boolean tienePelajeLargo) {
        super();
        setNombre(nombre);
        setEdad(edad);
        setPeso(peso);
        this.color = color;
        this.tienePelajeLargo = tienePelajeLargo;
    }
    public void maullar() {
        System.out.println(getNombre() + " dice ¡Miau!");
    }

    public void ronronear() {
        System.out.println(getNombre() + " está ronroneando");
    }
    @Override
    public String toString() {
        return "\nNombre: " + getNombre()
            + " | Edad: " + getEdad()
            + " | Peso: " + getPeso()
            + " | Color: " + color
            + " | Tiene Pelaje Largo: " + tienePelajeLargo;
    }
}