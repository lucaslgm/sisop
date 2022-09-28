package Software;

import Hardware.Memory;
import Hardware.Opcode;
import Hardware.Word;

import java.util.ArrayList;

public class GerenciaMemoriaPF {
    
    public int memorySize;
    public int partitionSize;
    public int nmrParticao;

    public boolean[] freePartition;

    public GerenciaMemoriaPF(int memorySize, int partitionSize) {
        this.memorySize = memorySize;
        this.partitionSize = partitionSize;
        nmrParticao = memorySize/partitionSize;

        this.freePartition = new boolean[nmrParticao];
        for(int i = 0; i < nmrParticao; i++){
            freePartition[i] = true;
        }
    }

    private int aloca(Word[] program){
        if(program.length > partitionSize){
            System.out.println("Programa maior que a partição");
            return -1;
        }else{
            for(int i = 0; i < nmrParticao; i++){
                if(freePartition[i]){
                    freePartition[i] = false;
                    System.out.println("Alocado na partição:" + i);
                }
            }
        }
    }

}


    // // Inicializa o array de frames com valor TRUE
    // private boolean[] initFrames(int tamMem, int pageSize) {
    //     availableFrames = new boolean[(tamMem / pageSize)];

    //     for (int i = 0; i < availableFrames.length; i++)
    //         availableFrames[i] = true;
    //     return availableFrames;
    // }

    // public boolean temEspacoParaAlocar(int numeroPalavras) {
    //     int quantidadeDeFramesQueVaiOcupar = 0;

    //     // Se for exatamente o tamanho da pagina, se não usa um a mais
    //     if (numeroPalavras % frameSize == 0)
    //         quantidadeDeFramesQueVaiOcupar = ((numeroPalavras / frameSize));
    //     else quantidadeDeFramesQueVaiOcupar = ((numeroPalavras / frameSize) + 1);

    //     int quantidadeDeFramesDisponiveis = 0;
    //     for (int i = 0; i < availableFrames.length; i++) {
    //         if (availableFrames[i]) quantidadeDeFramesDisponiveis++;
    //     }

    //     return (quantidadeDeFramesQueVaiOcupar <= quantidadeDeFramesDisponiveis);
    // }

    // // Retornar o conjunto de frames alocados
    // public ArrayList<Integer> aloca(Word[] p) {
    //     int quantidadeDeFramesQueVaiOcupar = 0;

    //     // Se for exatamente o tamanho da Pagina, se nao usa um a mais
    //     if (p.length % frameSize == 0)
    //         quantidadeDeFramesQueVaiOcupar = ((p.length / frameSize));
    //     else quantidadeDeFramesQueVaiOcupar = ((p.length / frameSize) + 1);

    //     int quantidadeNovosFramesOcupados = 0;
    //     int posicao = 0;

    //     ArrayList<Integer> paginas = new ArrayList<>();

    //     for (int f = 0; f < availableFrames.length; f++) {
    //         if (availableFrames[f] == true) {
    //             availableFrames[f] = false;
    //             quantidadeNovosFramesOcupados++;
    //             paginas.add(f);
    //         }

    //         for (int j = (f * frameSize); j < (f + 1) * frameSize; j++) {
    //             if (posicao < p.length) {
    //                 memory.m[j].opc = p[posicao].opc;
    //                 memory.m[j].r1 = p[posicao].r1;
    //                 memory.m[j].r2 = p[posicao].r2;
    //                 memory.m[j].p = p[posicao].p;
    //                 posicao++;
    //             } else {
    //                 break;
    //             }
    //         }
    //         if (quantidadeNovosFramesOcupados == quantidadeDeFramesQueVaiOcupar)
    //             return paginas; //Retorna um array de inteiros com os índices dos frames.
    //     }
    //     return null;
    // }

    // // Dado um array de inteiros com as páginas de um processo, o gerente desloca as páginas.
    // public void desaloca(ArrayList<Integer> paginasAlocadas) {
    //     for (Integer pagina : paginasAlocadas) {
    //         for (int i = 0; i < availableFrames.length; i++) {
    //             if (pagina == i) {
    //                 availableFrames[i] = true; // Libera o frame
    //                 for (int position = (i * frameSize); position < (i + 1) * frameSize; position++) {
    //                     memory.m[position] = new Word(Opcode.___, -1,-1,-1); //Esvazia memoria
    //                 }
    //             }
    //         }
    //     }
    // }