public abstract class Personaje implements Combatiente{
    protected String nombre;
    protected int nivel;
    protected int puntosVida;
    protected boolean estaVivo;

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

    public void curar(int cantidad){
        this.puntosVida += cantidad;
    }

    public abstract void atacar();
    public abstract int calcularDanio();

    @Override
    public String toString(){
        return "\nNombre: " + getNombre() + " | Nivel: " + getNivel() + " | Puntos de Vida: " + getPuntosVida() + " | Estado: " + (estaVivo ? "Vivo" : "Muerto");
    }
    public void mostrarEstado(){
        System.out.println(getNombre() + " (Nivel " + getNivel() + ") - " + (estaVivo ? "Vivo" : "Muerto"));
    }
    public void mostrarEstado(boolean detallado){
        if(!detallado){
            mostrarEstado();
            return;
        }
        System.out.println("--Estado de " + getNombre() + "--");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Nivel: " + getNivel());
        System.out.println("Puntos de Vida: " + getPuntosVida());
        System.out.println("Estado: " + (estaVivo ? "Vivo" : "Muerto"));
        System.out.println("Daño potencial de ataque: " + calcularDanio());
    }
    public void mostrarEstado(String prefijo){
        System.out.println(prefijo + " " + getNombre() 
        + " | Nivel: " + getNivel()
        + " | Vida: " + getPuntosVida() 
        + " | " + (estaVivo ? "Vivo" : "Muerto"));
    }
}