public class Druida extends Personaje implements Hechicero, Sanador{
    int mana;
    int poderCuracion;
    String vinculoAnimal;
    public Druida(String nombre, int nivel, int puntosVida, int mana, int poderCuracion, String vinculoAnimal){
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.poderCuracion = poderCuracion;
        this.vinculoAnimal = vinculoAnimal;
    }
    @Override
    public void atacar() throws RpgException{
        if (!getVivo())
            throw new PersonajeDerrotadoException(this.nombre);
        if (mana < 10)
            throw new RecursoInsuficienteException("mana", mana);
        this.mana -= 10;
        System.out.println(nombre + " ataca con la fuerza de la naturaleza.");
    }
    @Override
    public void defender(){
        System.out.println(nombre + " se protege con una barrera de raíces.");
    }
    @Override
    public int calcularDanio(){return nivel * 8;}
    @Override
    public void lanzarHechizo(){
        System.out.println(nombre + " lanza un hechizo natural! (Maná: " + mana + ")");
    }
    @Override
    public int getMana() { return mana; }
    @Override
    public void curarAliado(Personaje aliado) throws RpgException{
        if (aliado == null)
            throw new PersonajeNuloException("curarAliado");
        if (!aliado.getVivo())
            throw new AccionInvalidaException("curarAliado", "No se puede curar a un personaje derrotado");
        aliado.curar(poderCuracion);
    }
    @Override
    public int getPoderCuracion(){return poderCuracion;}
}