import java.util.ArrayList;

public class GestorBatalla {
    private ArrayList<String> historial;
    public GestorBatalla() {
        this.historial = new ArrayList<>();
    }
    public void ejecutarAtaque(Personaje atacante) throws RpgException {
        if (atacante == null || !atacante.getVivo()) {
            System.out.println("ERROR: Personaje inválido o derrotado.");
            return;
        }
        int danio = atacante.calcularDanio();
        atacante.atacar();
        String evento = atacante.getNombre() + 
            " ataca, causando "
            + danio + " puntos de daño.";
        historial.add(evento);
        System.out.println(evento);
    }
    public void ejecutarAtaque(Personaje atacante, Personaje defensor) throws RpgException {
        if (atacante == null || !atacante.getVivo()) {
            System.out.println("ERROR: Personaje inválido o derrotado.");
            return;
        }
        if (defensor == null || !defensor.getVivo()) {
            System.out.println("ERROR: Personaje inválido o derrotado.");
            return;
        }
        int danio = atacante.calcularDanio();
        atacante.atacar();
        defensor.recibirDanio(danio);
        defensor.defender();
        String evento = atacante.getNombre() + " atacó a " + defensor.getNombre()
                + " causando " + danio + " puntos de daño.";
        historial.add(evento);
    }
    public void ejecutarAtaque(Personaje[] equipo) throws RpgException {
        if (equipo == null || equipo.length == 0) {
            System.out.println("ERROR: Equipo vacío o inválido.");
            return;
        }
        System.out.println("El equipo inicia un ataque conjunto!");
        int danioTotal = 0;
        for (Personaje atacante : equipo) {
            if (atacante == null || !atacante.getVivo()) {
                continue;
            }
            int danio = atacante.calcularDanio();
            atacante.atacar();
            danioTotal += danio;
            String evento = atacante.getNombre() + 
                " participa en el ataque de equipo, aporta "
                + danio + " puntos de daño.";
            historial.add(evento);
        }
        String resumen = "Ataque de equipo finalizado. Daño total: " + danioTotal + ".";
        historial.add(resumen);
        System.out.println(resumen);
    }
    public void mostrarHistorial() {
        System.out.println("--HISTORIAL DE LA BATALLA--");
        if (historial.isEmpty()) {
            System.out.println("No hay eventos registrados.");
            return;
        }
        for (int i = 0; i < historial.size(); i++) {
            System.out.println((i + 1) + ". " + historial.get(i));
        }
    }
    public void limpiarHistorial() {
        historial.clear();
        System.out.println("El historial ha sido limpiado.");
    }
}