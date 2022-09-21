package Sistema;

import Hardware.VM;
import Hardware.Word;
import Programas.Programas;
import Software.InterruptHandling;
import Software.SysCallHandling;

// -------------------  S I S T E M A -------------------------------------------------------------------- //

public class Sistema{   // a VM com tratamento de interrupções
    public VM vm;
    public InterruptHandling ih;
    public SysCallHandling sysCall;
    public static Programas progs;

    public Sistema() { // a VM com tratamento de interrupções
        ih = new InterruptHandling();
        sysCall = new SysCallHandling();
        vm = new VM(ih, sysCall);

        sysCall.setVM(vm);
    }
// -------------------  S I S T E M A - FIM---------------------------------------------------------------- //

// ------------------ U T I L I T A R I O S   D O   S I S T E M A ----------------------------------------- //
// ------------------ load é invocado a partir de requisição do usuário ----------------------------------- //

    public void loadProgram(Word[] p, Word[] m) {
		for (int i = 0; i < p.length; i++) {
			m[i].opc = p[i].opc;     m[i].r1 = p[i].r1;     m[i].r2 = p[i].r2;     m[i].p = p[i].p;
		}
	}

	public void loadProgram(Word[] p) {
		loadProgram(p, vm.m);
	}

	public void loadAndExec(Word[] p){
		loadProgram(p);    // carga do programa na memoria
				System.out.println("---------------------------------- programa carregado na memoria");
				vm.mem.dump(0, p.length);            // dump da memoria nestas posicoes				
		vm.cpu.setContext(0, vm.tamMem - 1, 0);      // seta estado da cpu ]
				System.out.println("---------------------------------- inicia execucao ");
		vm.cpu.run();                                // cpu roda programa ate parar	
				System.out.println("---------------------------------- memoria após execucao ");
				vm.mem.dump(0, p.length);            // dump da memoria com resultado
	}
}
