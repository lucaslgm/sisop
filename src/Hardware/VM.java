package Hardware;

import Software.InterruptHandling;
import Software.SysCallHandling;

// ------------------------------------ V M  - constituida de CPU e MEMORIA ------------------------------------ //
// ---------------------------------------- atributos e construcao da VM --------------------------------------- //
public class VM {
  public int tamMem;
  public Word[] m;
  public Memory mem;
  public CPU cpu;
  
  // vm deve ser configurada com endereço de tratamento de interrupcoes e de chamadas de sistema
  public VM(InterruptHandling ih, SysCallHandling sysCall){
    // cria memória
    tamMem = 1024;
    mem = new Memory(tamMem);
    m = mem.m;

    // cria cpu
    cpu = new CPU(mem,ih,sysCall, true);  // true liga debug
  }
}