package pt.ipp.estg.projeto_kidszone.Model;

import android.content.Context;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import projeto_kidszone.database_library.Database.MyDbHelper;
import projeto_kidszone.database_library.Model.Dicas;

/**
 * Created by margarida on 31/12/2017.
 */

public class Dicas_Jogo {
    private Context context;
    private ArrayList<Dicas> dicasJogo;
    private LinkedList<Integer> dicasMostradas;
    private MyDbHelper dbHelper;
    private int posicaoUltimaDica;

    public Dicas_Jogo(Context context, int opcao) {
        this.context = context;
        dbHelper = new MyDbHelper(context);
        dicasJogo = new ArrayList<>();
        dicasMostradas = new LinkedList<>();

        /*Vai buscar as perguntas a serem mostradas*/
        Dicas.getDicas(dbHelper.getReadableDatabase(), dicasJogo);

        dicasMostradas = new LinkedList<>();

        this.posicaoUltimaDica = -1;
    }

    /*Método que calcula qual a próxima pergunta a ser mostrada ao utilizador
    * A pergunta é gerada conforme a sua posição na lista ligada(LinkedList) onde
    * estão as perguntas todas (perguntasJogadas).
    * Para encontrar a próxima pergunta a sua posição não pode estar na lista ligada
    * porque esta contem as posições que já sairam*/


    public Dicas getNextDica() {
        if (dicasJogo.size() == dicasMostradas.size()) {
            return null;
        }

        int randomNum = positionDica(dicasJogo.size());
        dicasMostradas.add(randomNum);
        posicaoUltimaDica = randomNum;

        return dicasJogo.get(randomNum);
    }

    /*Este método vai gerar a posição da pergunta, vai gerar um número random, de 0(inclusive)
    * até ao número recebido - tamMaximo - (exclusive) e vai retornar esse número gerado*/
    public int positionDica(int tamMaximo) {
        Random random = new Random();
        int randomNum=-1;

        do {
            /*randomNum vai ficar com um pseudorandom, ou seja, um valor entre 0 e o tamMax
           um valor interno distribuído uniformemente entre 0 (inclusive) extraído da sequência deste
           gerador de números aleatórios.*/
            randomNum = random.nextInt(tamMaximo);
        } while (dicasMostradas.contains(randomNum));

        return randomNum;
    }
}
