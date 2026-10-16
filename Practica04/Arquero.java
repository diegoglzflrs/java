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
    public void atacar(){
        super.atacar();
        System.out.println(getNombre() + " dispara flechas a distancia con precision de " + precision + "%.");
    }
    @Override
    public void defender(){
        System.out.println(getNombre() + " esquiva el ataque.");
    }
    @Override
    public String toString(){
        return "\n" + super.toString() + " | Tipo de Arco: " + getTipoArco() + " | Número de Flechas: " + getNumFlechas() + " | Precisión: " + getPrecision();
    }
}
