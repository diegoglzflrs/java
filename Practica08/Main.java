public class Main {
    public static void main(String[] args) throws RpgException{
        Guerrero Hercules = new Guerrero("Hercules", 25, 100, 150, "Hierro");
        Mago Lordberg = new Mago("Lordberg", 15, 42, 79, 32);
        Arquero Deatheyes = new Arquero("Deatheyes", 80, 214, "Ballesta", 67, 95);
        Druida Ermac = new Druida("Ermac", 9, 200, 220, 50, "Perro"){
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
        MotorCombate motor = new MotorCombate();
        motor.ejecutarTurno(Ermac, Darko);
        Ermac.recibirDanio(9999);
        motor.ejecutarTurno(Ermac, Darko);
        Arquero sinFlechas = new Arquero("Legolas", 6, 150, "Arco Largo", 0, 95);
        Druida druida2 = new Druida("Medic", 12, 180, 200, 70, "Lobo"){
            @Override public void defender() { }
            @Override public int calcularDanio() {return nivel * 11;}
            @Override public void lanzarHechizo(){
                System.out.println(nombre + " lanza: Hielo subzero!");
            }
        };
        motor.ejecutarTurno(sinFlechas, Darko);
        try{
            druida2.curarAliado(Ermac);
        }catch(RpgException e){
            System.out.println("No se pudo curar: " + e.getMessage());
        }

        try{
            Darko.recibirDanio(-50);
        }catch(AccionInvalidaException e){
            System.out.println("Capturado: " + e.getMessage());
        }finally{
            System.out.println("El bloque finally siempre se ejecuta.");
        }

        motor.mostrarBitacora();

        GestionGremio gremio = new GestionGremio();
        gremio.agregarMiembro(new Druida("Sylva", 10, 300, 100, 50, "Búho"));
        gremio.agregarMiembro(new Nigromante("Malachar", 8, 250, 120, 15, 40, "Calavera"));
        gremio.agregarMiembro(new Arquero("Legolas", 6, 150, "Arco", 20, 95));
        gremio.agregarMiembro(new Guerrero("Thorin", 9, 400, 80, "Hacha"));
        gremio.mostrarRoster();
        gremio.eliminarMiembro("Malachar");
        gremio.mostrarRoster();
        Personaje encontrado = gremio.buscarPorNombre("Legolas");
        if (encontrado != null)
            System.out.println("Encontrado: " + encontrado.getNombre());

        gremio.encolarSolicitante("Gandalf");
        gremio.encolarSolicitante("Aragorn");
        gremio.encolarSolicitante("Gimli");
        gremio.mostrarCola();
        gremio.atenderSiguiente();
        gremio.mostrarCola();

        gremio.agregarItem("Poción de vida", 5);
        gremio.agregarItem("Flecha élfica", 30);
        gremio.agregarItem("Poción de vida", 3);
        gremio.mostrarInventario();
        gremio.usarItem("Poción de vida");
        gremio.usarItem("Pergamino de fuego");
        gremio.mostrarInventario();

        gremio.registrarHabilidad("Curación");
        gremio.registrarHabilidad("Magia oscura");
        gremio.registrarHabilidad("Curación");
        gremio.mostrarHabilidades();
        System.out.println("¿Tiene flecha? " + gremio.tieneHabilidad("Tiro con arco"));
        System.out.println("¿Tiene curación? " + gremio.tieneHabilidad("Curación"));

        gremio.mostrarRoster();
        gremio.mostrarCola();
        gremio.mostrarInventario();
        gremio.mostrarHabilidades();
    }
}
