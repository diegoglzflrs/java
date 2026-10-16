public class Arquero extends Personaje{
    private String tipoArco;
    private int numFlechas;
    private int precision;
    public Arquero(String nombre, int nivel, int puntosVida, String tipoArco, int numFlechas, int precision){
        super(nombre, nivel, puntosVida);
        this.tipoArco = tipoArco;
        this.numFlechas = numFlechas;
        this.precision = precision;
    }
    public String getTipoArco(){
        return tipoArco;
    }
    public int getNumFlechas(){
        return numFlechas;
    }
    public int getPrecision(){
        return precision;
    }
    @Override
    public void atacar() throws RpgException{
        if(!getVivo()){
            throw new PersonajeDerrotadoException(getNombre());
        }
        if(numFlechas<=0){
            throw new RecursoInsuficienteException("flechas", numFlechas);
        }
        numFlechas--;
        System.out.println("[" + getNombre() + "] dispara una flecha. " + "Flechas restantes: " + numFlechas);
    }
    @Override
    public void defender(){
        System.out.println(getNombre() + " esquiva el ataque.");
    }
    @Override
    public String toString(){
        return "\n" + super.toString() + " | Tipo de Arco: " + getTipoArco() + " | Número de Flechas: " + getNumFlechas() + " | Precisión: " + getPrecision();
    }
    @Override
    public int calcularDanio(){
        return precision * getNivel();
    }
}