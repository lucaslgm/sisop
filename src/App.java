import Programas.Programas;
import Sistema.Sistema;
import Software.PCB;

import java.util.Scanner;

public class App {
	public static Programas progs;
    public static void main(String args[]) {

        progs = new Programas();
		Sistema s = new Sistema();
		Scanner in = new Scanner(System.in);

		while (true) {
			System.out.println("\nEscolha uma opção:");
			System.out.println("1 - Cria"); //cria um processo na memória. Pede ao GM para alocar frames de memória necessários. cria PCB, seta tabela de páginas do processo no PCB, etc. coloca processo em uma lista de processos (prontos).
			System.out.println("2 - Lista Processos"); //lista todos processos existentes
			System.out.println("3 - Dump"); //lista o conteúdo do PCB e o conteúdo das páginas de memória do processo com id
			System.out.println("4 - Desaloca"); //retira o processo id do sistema
			System.out.println("5 - DumpM"); //lista a memória entre posições início e fim
			System.out.println("6 - Executa"); //executa o processo com id fornecido
			System.out.println("7 - Trace On"); //liga modo de execução em que CPU print cada instrução executada
			System.out.println("8 - Trace Off"); //desliga o modo acima
			System.out.println("9 - Exit"); //sai do sistema
			int aux;

			System.out.print("Digite uma opção: ");
			aux = in.nextInt();

			switch (aux) {
				case 1:
					System.out.println("\nEscolha o programa:");
					System.out.println("1 - Fibonacci");
					System.out.println("2 - FibonacciTRAP");
					System.out.println("3 - Fatorial");
					System.out.println("4 - FatorialTRAP");
					System.out.println("5 - ProgMinimo");
					System.out.println("6 - PB");
					System.out.println("7 - PC");
					System.out.println("9 - Exit");
					System.out.print("Programa: ");
					int aux2;
					aux2 = in.nextInt();

					switch (aux2) {
						case 1:
							System.out.println("Identificador do Processo: " + s.carregaPrograma(progs.fibonacci10));
							break;
						case 2:
							System.out.println("Identificador do Processo: " + s.carregaPrograma(progs.fibonacciTRAP));
							break;
						case 3:
							System.out.println("Identificador do Processo: " + s.carregaPrograma(progs.fatorial));
							break;
						case 4:
							System.out.println("Identificador do Processo: " + s.carregaPrograma(progs.fatorialTRAP));
							break;
						case 5:
							System.out.println("Identificador do Processo: " + s.carregaPrograma(progs.progMinimo));
							break;
						case 6:
							System.out.println("Identificador do Processo: " + s.carregaPrograma(progs.PB));
							break;
						case 7:
							System.out.println("Identificador do Processo: " + s.carregaPrograma(progs.PC));
							break;
						default:
							break;
					}
					break;

				case 2:
					s.listarProcessos();
					break;

				case 3:
					System.out.print("\nProcess ID: ");
					int pid = in.nextInt();
					s.dumpPCB(pid);
					break;

				case 4:
					System.out.print("\nProcess ID: ");
					int pid2 = in.nextInt();
					s.encerraProcessoById(pid2);
					break;

				case 5:
					System.out.print("\nInicio: ");
					int beginning = in.nextInt();
					System.out.print("Fim: ");
					int end = in.nextInt();
					s.dumpMemoria(beginning, end);
					break;

				case 6:
					System.out.print("\nProcess ID: ");
					int pid3 = in.nextInt();
					s.runByProcessId(pid3);
					break;

				case 7:
					s.changeDebug(true);
					System.out.println("Debug On");
					break;

				case 8:
					s.changeDebug(false);
					System.out.println("Debug Off");
					break;

				default:
					System.exit(0);

			}
		}
	}
}
