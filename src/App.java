import Programas.Programas;
import Sistema.Sistema;

public class App {
	public static Programas progs;
    public static void main(String args[]) {

        progs = new Programas();
		Sistema s = new Sistema();			
		//s.loadAndExec(progs.fibonacci10);
		//s.loadAndExec(progs.progMinimo);
		//s.loadAndExec(progs.fatorial);
		s.loadAndExec(progs.fatorialTRAP); // saida
		//s.loadAndExec(progs.fibonacciTRAP); // entrada
		//s.loadAndExec(progs.PC); // bubble sort
			
	}
}
