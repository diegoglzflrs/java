public abstract class Nigromante extends Personaje implements Hechicero{
    int mana;
    int almasAbsorbidas;
    int nivelOscuridad;
    String maldicion;
    public Nigromante(String nombre, int nivel, int puntosVida, int mana, int almasAbsorbidas, int nivelOscuridad, String maldicion) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.almasAbsorbidas = almasAbsorbidas;
        this.nivelOscuridad = nivelOscuridad;
        this.maldicion = maldicion;
    }
    public abstract void atacar();
    public abstract int calcularDanio();
    public abstract void lanzarHechizo();
    public abstract int getMana();
}