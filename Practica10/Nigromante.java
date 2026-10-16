public class Nigromante extends Personaje implements Hechicero{
    int mana;
    int almasAbsorbidas;
    int nivelOscuridad;
    String maldicion;

    public Nigromante(String nombre, int nivel, int puntosVida, int mana,
                      int almasAbsorbidas, int nivelOscuridad, String maldicion){
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.almasAbsorbidas = almasAbsorbidas;
        this.nivelOscuridad = nivelOscuridad;
        this.maldicion = maldicion;
    }

    @Override
    public void atacar() throws RpgException{
        if (!getVivo())
            throw new PersonajeDerrotadoException(this.nombre);
        if (mana < 15)
            throw new RecursoInsuficienteException("mana", mana);
        this.mana -= 15;
        System.out.println(nombre + " drena la esencia vital causando " + calcularDanio() + " de daño!");
    }

    @Override
    public void defender(){
        System.out.println(nombre + " se envuelve en un manto de sombras.");
    }

    @Override
    public int calcularDanio(){
        return nivel * nivelOscuridad;
    }

    @Override
    public void lanzarHechizo(){
        System.out.println(nombre + " lanza la maldición '" + maldicion + "'! (Maná: " + mana + ")");
    }

    @Override
    public int getMana(){
        return mana;
    }
}