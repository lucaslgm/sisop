package Software;

import Hardware.Memory;
import Hardware.Word;

import java.util.LinkedList;
import java.util.Queue;

public class GerenciaProcesso {
    public GerenciaMemoriaPF gerenciaMemoriaPF;
    public Queue<PCB> listaPCBs;
    public int processId = 0;

    public GerenciaProcesso(Memory memory) {
        this.gerenciaMemoriaPF = new GerenciaMemoriaPF(memory);
        this.listaPCBs = new LinkedList<>();
    }

    public PCB create(Word[] p) {
        PCB processControlBlock;
        int newPartition = gerenciaMemoriaPF.aloca(p);
        if (newPartition < 0) return null;
        processControlBlock = new PCB(processId, newPartition, (newPartition*gerenciaMemoriaPF.partitionSize));
        ++processId;
        listaPCBs.add(processControlBlock);
        return processControlBlock;
    }

    public void finish(PCB processo) {
        System.out.println("Processo encerrado: " + processo.id);
        gerenciaMemoriaPF.desaloca(processo.id);
        listaPCBs.remove(processo);
    }

    public PCB getProcessByID(int id) {
        for (PCB pcb : listaPCBs){
            if (pcb.getId() == id){
                return pcb;
            }
        }
        return null;
    }

    public void listAllProcesses(){
        System.out.println("Processos: ");
        for(PCB pcb : listaPCBs){
            System.out.println(pcb.toString());
        }
    }

    public int getMemoryPartitionFromProcess(int pid){
        for (PCB pcb : listaPCBs){
            if (pcb.id == pid) return pcb.getParticaoAlocada();
        }
        return -1;
    }
}
