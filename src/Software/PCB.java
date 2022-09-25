package Software;

import Hardware.Interrupts;

import java.util.ArrayList;

public class PCB {
    public int id;
    public Interrupts interrupt;
    public ArrayList<Integer> allocatedPages;

    // CPU context
    public int pc;
    public ProcessStatus status;
    public int[] reg;

    public PCB(int id, ArrayList<Integer> allocatedPages) {
        this.allocatedPages = allocatedPages;
        this.id = id;
        this.interrupt = Interrupts.noInterrupt;
        this.pc = 0;
        this.status = ProcessStatus.READY;
        this.reg = new int[10];
    }

    //retorna a lista de paginas de um processo
    public ArrayList<Integer> getAllocatedPages() {
        return this.allocatedPages;
    }

    public int getId() {
        return this.id;
    }
}
