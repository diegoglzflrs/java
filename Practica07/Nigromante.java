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
    public void atacar() throws RpgException{
        if(!getVivo())
            throw new PersonajeDerrotadoException(this.nombre);
        if(mana<15)
            throw new RecursoInsuficienteException("mana", mana);
        this.mana -= 15;
        int danio = calcularDanio();
    }
    public abstract int calcularDanio();
    public abstract void lanzarHechizo();
    public int getMana(){
        return mana;
    }
}