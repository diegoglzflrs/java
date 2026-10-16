public abstract class Bardo extends Personaje implements Sanador{
    String poderCuracion;
    String instrumento;
    int melodiasConocidas;
    int carisma;
    public Bardo(String nombre, int nivel, int puntosVida, String poderCuracion, String instrumento, int melodiasConocidas, int carisma){
        super(nombre, nivel, puntosVida);
        this.poderCuracion = poderCuracion;
        this.instrumento = instrumento;
        this.melodiasConocidas = melodiasConocidas;
        this.carisma = carisma;
    }
    public abstract void atacar();
    public abstract int calcularDanio();
    public abstract void curarAliado(Personaje aliado);
    public abstract int getPoderCuracion();
}
