package Software;

import Hardware.VM;

// ------------------- C H A M A D A S  D E  S I S T E M A  - rotinas de tratamento ---------------------- //

public class SysCallHandling {
    private VM vm;
    
    public void setVM(VM _vm){
        vm = _vm;
    }
    public void handle() {   // apenas avisa - todas interrupcoes neste momento finalizam o programa
        System.out.println("                                               Chamada de Sistema com op  /  par:  "+ vm.cpu.reg[8] + " / " + vm.cpu.reg[9]);
    }
}