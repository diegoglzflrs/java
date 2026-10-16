public abstract class Druida extends Personaje implements Hechicero, Sanador{
    int mana;
    int poderCuracion;
    String vinculoAnimal;
    public Druida(String nombre, int nivel, int puntosVida, int mana, int poderCuracion, String vinculoAnimal){
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.poderCuracion = poderCuracion;
        this.vinculoAnimal = vinculoAnimal;
    }
    public abstract void atacar();
    public abstract int calcularDanio();
    public abstract void lanzarHechizo();
    public abstract int getMana();
    public abstract void curarAliado(Personaje aliado);
    public abstract int getPoderCuracion();
}