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
        
        System.out.println(Hercules.calcularDanio());
        System.out.println(Lordberg.calcularDanio());
        System.out.println(Deatheyes.calcularDanio());
        Personaje[] equipo = {Hercules, Lordberg, Deatheyes};
        for (Personaje p : equipo)
            System.out.println(p.getNombre() + " daño: " + p.calcularDanio());

        GestorBatalla gestor = new GestorBatalla();
        gestor.ejecutarAtaque(Hercules);
        gestor.ejecutarAtaque(Lordberg, Hercules);
        gestor.ejecutarAtaque(equipo);
        gestor.mostrarHistorial();
        for (Personaje p : equipo){
            if (p instanceof Guerrero)
                System.out.println(p.getNombre() + " es un Guerrero.");
            else if (p instanceof Mago)
                System.out.println(p.getNombre() + " es un Mago.");
            else if (p instanceof Arquero)
                System.out.println(p.getNombre() + " es un Arquero.");
        }

        Hercules.mostrarEstado();
        Lordberg.mostrarEstado();
        Deatheyes.mostrarEstado();
        System.out.println("--DETALLADO--");
        Hercules.mostrarEstado(true);
        System.out.println("--NO DETALLADO--");
        Hercules.mostrarEstado(false);

        Hercules.mostrarEstado("[Equipo A]");
        Lordberg.mostrarEstado("[Equipo A]");
        Deatheyes.mostrarEstado("[Equipo A]");
    }
}
