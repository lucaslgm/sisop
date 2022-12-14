package Software;

import Hardware.CPU;
import Hardware.Opcode;
import Hardware.VM;

import java.util.ArrayList;
import java.util.Scanner;

// ------------------- C H A M A D A S  D E  S I S T E M A  - rotinas de tratamento ---------------------- //

public class SysCallHandling {
    private VM vm;
    
    public void setVM(VM _vm){
        vm = _vm;
    }

    public void handle() {
        System.out.println("                                               Chamada de Sistema com op  /  par:  "+ vm.cpu.reg[8] + " / " + vm.cpu.reg[9]);
    }

    public void trapHandling (int reg9convertido){
        Scanner io = new Scanner(System.in);

        System.out.println("reg[8] = " + vm.cpu.reg[8]);
        System.out.println("reg[9] = " + vm.cpu.reg[9]);

        switch (vm.cpu.reg[8]) {
            case 1:
                System.out.println("ENTRADA");
                System.out.println("Digite um valor inteiro: ");

                Integer input = io.nextInt();

                vm.cpu.mem.m[vm.cpu.reg[9]].opc = Opcode.DATA;
                vm.cpu.mem.m[vm.cpu.reg[9]].p = input;

                System.out.println("Valor armazenado " + vm.cpu.mem.m[vm.cpu.reg[9]].p);
                System.out.println("Posição  " + vm.cpu.reg[9]);
                break;

            case 2:
                System.out.println("SAÍDA");
                System.out.println("Valor: " + vm.cpu.mem.m[reg9convertido].p);
                break;
        }
    }

}