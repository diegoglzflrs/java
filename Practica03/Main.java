public class Main {
    public static void main(String[] args) {
        Automovil miAuto = new Automovil("Toyota", "Corolla", 2022, 180, 4, false);
        Avion miAvion = new Avion("Boeing", "737", 2019, 850, "United", 12500, 230);
        Barco miBarco = new Barco("Ferretti", "550", 2020, 45, 30, 1);
        miAuto.describir();
        miAuto.setAnio(1800);        // debe mostrar mensaje de error
        miAuto.setNumPuertas(10);    // debe mostrar mensaje de error
        miAvion.describir();
        miBarco.describir();
        System.out.println(miAuto.toString());
        System.out.println(miAvion.toString());
        System.out.println(miBarco.toString());
    }
}
