package semafaro;

public class Teste {

    public static void main(String[] args) {

        ThreadSemafaro semafaro = new ThreadSemafaro();

        for(int i = 0; i<9; i++) {
            semafaro.esperaCorMudar();
        }
        semafaro.desligarSemafaro();
    }
}