public class Personaje implements Combatiente{
    private String nombre;
    private int nivel;
    private int puntosVida;
    private boolean estaVivo;

    public Personaje(String nombre, int nivel, int puntosVida){
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
        this.estaVivo = true;
    }
    public String getNombre(){
        return nombre;
    }
    public int getNivel(){
        return nivel;
    }
    public int getPuntosVida(){
        return puntosVida;
    }
    public boolean getVivo(){
        return estaVivo;
    }
    public void recibirDanio(int danio){
        this.puntosVida -= danio;
        if(this.puntosVida <= 0){
            this.puntosVida = 0;
            this.estaVivo = false;
        }
        System.out.println(nombre + " recibe " + danio + " puntos de daño.\nVida restante: " + puntosVida);
        if(!estaVivo){
            System.out.println(nombre + " ha sido derrotado.");
        }
    }
	@Override
	public void atacar() {
        System.out.println(nombre + " ataca con un golpe básico.");
    }
    @Override
	public void defender(){
        System.out.println(nombre + " se pone en guardia.");
    }
    @Override
    public String toString(){
        return "\nNombre: " + getNombre() + " | Nivel: " + getNivel() + " | Puntos de Vida: " + puntosVida + " | Estado: " + (estaVivo ? "Vivo" : "Muerto");
    }
}
