package Practica02;
public class Main{
    public static void main(String[] args) {
        Perro miPerro = new Perro("Sparky", 5, 22, "Cocker Spaniel", true);
        System.out.println(miPerro.toString());
        miPerro.ladrar();
        miPerro.comer();
        miPerro.dormir();

        Gato miGato = new Gato("Ludwig", 4, 3.5, "Negro", false);
        System.out.println(miGato.toString());
        miGato.maullar();
        miGato.ronronear();
        miGato.dormir();

        Canario miCanario = new Canario("Falco", 3, 6, "Verde", true);
        System.out.println(miCanario.toString());
        miCanario.comer();
        miCanario.cantar();
        miCanario.volar();
    }
}