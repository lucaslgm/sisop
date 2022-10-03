package Software;

import Hardware.Interrupts;

import java.util.ArrayList;

public class PCB {
    public int id;
    public Interrupts interrupt;
    public int particaoAlocada;

    // CPU context
    public int pc;
    public ProcessStatus status;
    public int[] reg;

    public PCB(int id, int particaoAlocada, int pc) {
        this.particaoAlocada = particaoAlocada;
        this.id = id;
        this.interrupt = Interrupts.noInterrupt;
        this.pc = pc;
        this.status = ProcessStatus.READY;
        this.reg = new int[10];
    }

    public int getParticaoAlocada(){
        return particaoAlocada;
    }

    public int getId() {
        return this.id;
    }

    public String toString(){
        return "ID: " + id +
                "\tPartição: " + particaoAlocada +
                "\tProgram Counter: " + pc +
                "\tStatus: " + status +
                "\tInterrupts: " + interrupt;
    }

    public void setStatus(ProcessStatus status){
        this.status = status;
    }
}
