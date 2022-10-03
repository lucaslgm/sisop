package Software;

import Hardware.Memory;
import Hardware.Opcode;
import Hardware.Word;

import java.util.ArrayList;

public class GerenciaMemoriaPF {
    public Memory memory;
    public int memorySize;
    public int partitionSize;
    public int nmrParticao;

    public boolean[] freePartition;

    public GerenciaMemoriaPF(Memory _memory) {
        memory = _memory;
        memorySize = memory.tamMem;
        partitionSize = 64;
        nmrParticao = memorySize / partitionSize;

        this.freePartition = new boolean[nmrParticao];
        for(int i = 0; i < nmrParticao; i++){
            freePartition[i] = true;
        }
    }

    public int aloca(Word[] program){
        int tamanhoAlocar = program.length;

        for(Word w : program){
            if (w.opc.equals(Opcode.LDD) || w.opc.equals(Opcode.STD))
                if (w.p > tamanhoAlocar)
                    tamanhoAlocar = w.p;
        }

        if(tamanhoAlocar > partitionSize){
            System.out.println("Programa maior que a partição (" + partitionSize + ")");
            return -1;
        } else if(tamanhoAlocar < partitionSize){

            int posicao = 0;
            for(int i = 0; i < nmrParticao; i++){
                if(freePartition[i]){
                    freePartition[i] = false;
                    //System.out.println("Alocado na partição:" + i);
                    int inicioParticao = i*partitionSize;
                    for(int j=inicioParticao; j<(i+1)*partitionSize; j++){
                        if (posicao < program.length){
                            memory.m[j].opc = program[posicao].opc;
                            memory.m[j].r1 = program[posicao].r1;
                            memory.m[j].r2 = program[posicao].r2;
                            memory.m[j].p = program[posicao].p;
                            posicao++;
                        }
                    }
                    return i;
                }
            }
        }
        return -1;
    }

    public void desaloca(int particao) {
        freePartition[particao] = true;
        int inicioParticao = particao*partitionSize;
        for(int i=inicioParticao; i<(particao+1)*partitionSize; i++){
            memory.m[i] = new Word(Opcode.___, -1,-1,-1); //Esvazia memoria
        }
    }

}