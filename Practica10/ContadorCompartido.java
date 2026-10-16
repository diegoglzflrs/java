public class ContadorCompartido {

    private int contador = 0;

    public void incrementar() {
        contador++;
    }

    public synchronized void incrementarSeguro() {
        contador++;
    }

    public int getContador() {
        return contador;
    }

    public void resetear() {
        contador = 0;
    }
}