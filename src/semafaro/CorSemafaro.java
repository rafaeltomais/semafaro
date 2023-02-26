package semafaro;

public enum CorSemafaro {

    VERDE(1500), AMARELO(800), VERMELHO(2000);

    private double tempoEspera;

    CorSemafaro(int tempoEspera){
        this.tempoEspera = tempoEspera;
    }

    public double getTempoEspera() {
        return tempoEspera;
    }
}
