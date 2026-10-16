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
    public void atacar() throws RpgException{
        if(!getVivo())
                throw new PersonajeDerrotadoException(this.nombre);
        if(mana < 10)
            throw new RecursoInsuficienteException("mana", mana);
        this.mana -= 10;
        int danio = calcularDanio();
    }
    public abstract int calcularDanio();
    public abstract void lanzarHechizo();
    public int getMana(){
        return mana;
    }
    public void curarAliado(Personaje aliado) throws RpgException{
        if(aliado == null)
            throw new PersonajeNuloException("curarAliado");
        if(!aliado.getVivo())
                throw new AccionInvalidaException("curarAliado", "No se puede curar a un personaje derrotado");
        aliado.curar(poderCuracion);
    }
    public int getPoderCuracion(){
        return poderCuracion;
    }
}