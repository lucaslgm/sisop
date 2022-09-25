package Software;

import Hardware.Memory;
import Hardware.Word;

import java.util.LinkedList;
import java.util.Queue;

public class GerenciaProcesso {
    public GerenciaMemoria gerenciaMemoria;
    public Queue<PCB> listaPCBs;
    public int processId = 0;

    public GerenciaProcesso(Memory memory) {
        this.gerenciaMemoria = new GerenciaMemoria(memory);
        this.listaPCBs = new LinkedList<>();
    }

    public PCB create(Word[] p) {
        System.out.println("Gerente Processo criado");
        PCB processControlBlock;

        if (gerenciaMemoria.temEspacoParaAlocar(p.length)) {
            processControlBlock = new PCB(processId, gerenciaMemoria.aloca(p));
            ++processId;

            listaPCBs.add(processControlBlock);
        } else {
            System.out.println("Sem espaço na memória para criar o processo de ID: " + processId);
            processControlBlock = null;
        }

        return processControlBlock;
    }

    public void finish(PCB processo) {
        System.out.println("Gerente Processo encerrado.");
        gerenciaMemoria.desaloca(processo.getAllocatedPages());
        listaPCBs.remove(processo);
    }

    public PCB getProcess(int id) {
        if (listaPCBs.peek().getId() == id) {
            return listaPCBs.peek();
        } else {
            System.out.println("Não foi possível encontrar o processo de ID: " + processId);
            return null;
        }
    }
}
