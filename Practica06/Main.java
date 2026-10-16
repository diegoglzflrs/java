public class Main {
    public static void main(String[] args) {
        /*Guerrero Hercules = new Guerrero("Hercules", 25, 100, 150, "Hierro");
        Mago Lordberg = new Mago("Lordberg", 15, 42, 79, 32);
        Arquero Deatheyes = new Arquero("Deatheyes", 80, 214, "Ballesta", 67, 95);*/
        //Hechicero Ermac = new Hechicero(); (ERROR: Cannot instantiate the type Hechicero)
        Druida Ermac = new Druida("Ermac", 9, 200, 220, 50, "Perro") {
            @Override
            public void defender(){}
            @Override
            public void atacar(){
                System.out.println(nombre + " invoca raíces del bosque.");
            }
            @Override
            public int calcularDanio(){return nivel*10;}
            @Override
            public void lanzarHechizo(){
                System.out.println(nombre + " lanza: Tormenta de espinas! (Maná: " + mana +")");
            }
            @Override
            public int getMana(){return mana;}
            @Override
            public void curarAliado(Personaje aliado){
                int cantidad = 120;
                aliado.curar(cantidad);
                System.out.println(nombre + " toca la tierra y cura a " 
                    + aliado.getNombre() + " +" 
                    + cantidad + ". Vida: " 
                    + aliado.getPuntosVida());
            }
            @Override
            public int getPoderCuracion(){return puntosVida*10;}
            
        };
        Nigromante Darko = new Nigromante("Darko", 10, 230, 300, 17, 45, "El Diablo") {
            @Override
            public void defender(){}
            @Override
            public void atacar(){
                System.out.println(nombre + " drena la esencia vital.");
            }
            @Override
            public int calcularDanio(){return nivel*15;}
            @Override
            public void lanzarHechizo(){
                System.out.println(nombre + " lanza maldición de decadencia! (Maná: " + mana +")");
            }
            @Override
            public int getMana() {return mana;}
        };
        Bardo Prince = new Bardo("Prince", 8, 150, "Cielo", "Guitarra", 5, 19){
            @Override
            public void defender(){}
            @Override
            public void atacar(){
                System.out.println(nombre + " ataca con su guitarra.");
            }
            @Override
            public int calcularDanio(){return nivel*17;}
            @Override
            public void curarAliado(Personaje aliado){
                int cantidad = 60;
                aliado.curar(cantidad);
                System.out.println(nombre + " entona una melodía y cura a " + aliado.getNombre() + " +" + cantidad + 
                    ". Vida: " + aliado.getPuntosVida());
            }
            @Override
            public int getPoderCuracion(){return 60;}
        };
        System.out.println("-- Ataques y daño --");
        Personaje[] equipo = {Ermac, Darko, Prince};
        for (Personaje p : equipo) {
            p.atacar();
            System.out.println(" Daño: " + p.calcularDanio());
        }

        System.out.println("\n-- Solo los Hechiceros lanzan hechizos --");
        for (Personaje p : equipo) {
            if (p instanceof Hechicero h) {
                h.lanzarHechizo();
            }
        }

        System.out.println("\n-- Solo los Sanadores curan --");
        Darko.recibirDanio(300);
        for (Personaje p : equipo) {
            if (p instanceof Sanador s) {
                s.curarAliado(Darko);
            }
        }

        System.out.println("\n-- Estado final --");
        int maxLen = 0;
        for (Personaje p : equipo) maxLen = Math.max(maxLen, p.getNombre().length());
        for (Personaje p : equipo) {
            System.out.printf("Nombre: %-" + maxLen + "s | Nivel: %d | Vida: %d | Vivo: %s%n", 
                p.getNombre(), p.getNivel(), p.getPuntosVida(), p.getVivo() ? "Sí" : "No");
        }
    }
}
