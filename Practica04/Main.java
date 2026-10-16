public class Main {
    public static void main(String[] args) {
        Guerrero Hercules = new Guerrero("Hercules", 25, 100, 150, "Hierro");
        Mago Lordberg = new Mago("Lordberg", 15, 42, 79, 32);
        Arquero Deatheyes = new Arquero("Deatheyes", 80, 214, "Ballesta", 67, 95);
        Hercules.atacar();
        Hercules.defender();
        Hercules.recibirDanio(17);
        Lordberg.atacar();
        Lordberg.defender();
        Lordberg.recibirDanio(50);
        Deatheyes.atacar();
        Deatheyes.defender();
        System.out.println("Victoria!\n");
        System.out.println(Hercules.toString());
        System.out.println(Lordberg.toString());
        System.out.println(Deatheyes.toString());
    }
}
