package semafaro;

public class ThreadSemafaro implements Runnable{

    private CorSemafaro cor;
    private boolean parar;
    private boolean corMudou;

    public ThreadSemafaro() {
        this.cor = CorSemafaro.VERDE;
        new Thread(this).start();
        this.parar = false;
        this.corMudou = false;
    }

    @Override
    public void run() {

        while(!parar) {
            try {
                System.out.println("***" + this.getCor() + "***");
                System.out.println("Esperando " + Double.parseDouble(String.valueOf(this.getCor().getTempoEspera()/1000)) + " segundos\n");
                Thread.sleep((long) this.cor.getTempoEspera());
                this.mudarCor();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private synchronized void mudarCor() {
        switch(this.cor) {
            case VERMELHO:
                this.cor = CorSemafaro.VERDE;
                break;
            case AMARELO:
                this.cor = CorSemafaro.VERMELHO;
                break;
            case VERDE:
                this.cor = CorSemafaro.AMARELO;
                break;
            default:
                break;
        }
        this.corMudou = true;
        this.notify();
    }

    public synchronized void esperaCorMudar() {
        while(!this.corMudou) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.corMudou = false;
    }

    public synchronized void desligarSemafaro() {
        this.parar = true;
    }

    public CorSemafaro getCor() {
        return cor;
    }
}