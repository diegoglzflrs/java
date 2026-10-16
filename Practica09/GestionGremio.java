import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class GestionGremio {

    private ArrayList<Personaje> roster;
    private java.util.LinkedList<String> colaTurnos;
    private java.util.HashMap<String, Integer> inventario;
    private java.util.HashSet<String> habilidades;

    public GestionGremio() {
        roster      = new ArrayList<>();
        colaTurnos  = new java.util.LinkedList<>();
        inventario  = new java.util.HashMap<>();
        habilidades = new java.util.HashSet<>();
    }

    // ──────────────────────────────────────────
    // SECCIÓN 1 — ArrayList: roster de personajes
    // ──────────────────────────────────────────

    public void agregarMiembro(Personaje p) {
        roster.add(p);
        System.out.println("[Gremio] " + p.getNombre() + " se unió al gremio.");
    }

    public void eliminarMiembro(String nombre) {
        Iterator<Personaje> it = roster.iterator();
        while (it.hasNext()) {
            Personaje p = it.next();
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                it.remove();   // forma segura de eliminar durante iteración
                System.out.println("[Gremio] " + nombre + " abandonó el gremio.");
                return;
            }
        }
        System.out.println("[Gremio] No se encontró: " + nombre);
    }

    public Personaje buscarPorNombre(String nombre) {
        for (Personaje p : roster) {       // for-each
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public void mostrarRoster() {
        System.out.println("\n=== Roster del Gremio (" + roster.size() + " miembros) ===");
        for (int i = 0; i < roster.size(); i++) {
            Personaje p = roster.get(i);
            System.out.println((i + 1) + ". " + p.getNombre() +
                               " | Nivel: " + p.getNivel() +
                               " | Vida: " + p.getPuntosVida());
        }
    }

    // ──────────────────────────────────────────
    // SECCIÓN 2 — LinkedList: cola de turnos
    // ──────────────────────────────────────────

    public void encolarSolicitante(String nombre) {
        colaTurnos.addLast(nombre);    // agrega al final
        System.out.println("[Cola] " + nombre +
                        " en posición " + colaTurnos.size());
    }

    public String atenderSiguiente() {
        if (colaTurnos.isEmpty()) {
            System.out.println("[Cola] No hay solicitantes en espera.");
            return null;
        }
        String atendido = colaTurnos.removeFirst();   // saca del frente
        System.out.println("[Cola] Atendiendo a: " + atendido);
        return atendido;
    }

    public void mostrarCola() {
        System.out.println("\n=== Cola de Espera (" + colaTurnos.size() + ") ===");
        int pos = 1;
        for (String nombre : colaTurnos) {   
            System.out.println(pos++ + ". " + nombre);
        }
    }

    public void agregarItem(String item, int cantidad){
        if(inventario.containsKey(item))
            inventario.put(item, inventario.getOrDefault(item, 0) + cantidad);
        else
            inventario.put(item, cantidad);
        System.out.println("[Inventario] " + item + ": " + inventario.get(item));
    }

    public void usarItem(String item){
        if(inventario.containsKey(item) && inventario.get(item) > 0){
            int restante = inventario.get(item) - 1;
            inventario.put(item, restante);
            if(restante == 0){
                inventario.remove(item);
                System.out.println("[Inventario] Usaste el último " + item +
                                   ". Se eliminó del inventario.");
            }else{
                System.out.println("[Inventario] Usaste " + item +
                                   ". Quedan: " + restante);
            }
        }else
            System.out.println("[Inventario] Error: no tienes '" + item + "'.");
    }

    public void mostrarInventario(){
        System.out.println("\n=== Inventario (" + inventario.size() + " tipos de objeto) ===");
        for (Map.Entry<String, Integer> entry : inventario.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void registrarHabilidad(String habilidad){
        if (habilidades.add(habilidad))
            System.out.println("[Habilidades] Nueva habilidad registrada: " + habilidad);
        else
            System.out.println("[Habilidades] '" + habilidad + "' ya estaba registrada.");
    }

    public boolean tieneHabilidad(String habilidad){
        return habilidades.contains(habilidad);
    }

    public void mostrarHabilidades(){
        System.out.println("\n=== Habilidades del Gremio (" + habilidades.size() + ") ===");
        for (String habilidad : habilidades){
            System.out.println("- " + habilidad);
        }
    }
}