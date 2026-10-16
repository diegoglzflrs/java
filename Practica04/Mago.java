public class Mago extends Personaje{
    private int mana;
    private int nivelMagia;
    public Mago(String nombre, int nivel, int puntosVida, int mana, int nivelMagia){
        super(nombre, nivelMagia, puntosVida);
        this.mana = mana;
        this.nivelMagia = nivelMagia;
    }
    public int getMana(){
        return mana;
    }
    public int getNivelMagia(){
        return nivelMagia;
    }
    @Override
    public void atacar(){
        super.atacar();
        System.out.println(getNombre() + " lanza un hechizo causando " + getMana() + " de daño!");
    }
    @Override
    public void defender(){
        System.out.println(getNombre() + " bloquea con su escudo mágico.");
    }
    @Override
    public String toString(){
        return "\n" + super.toString() + " | Mana: " + getMana() + " | Nivel de Magia: " + getNivelMagia();
    }
}
