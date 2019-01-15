package ifpr.singleton;

public class Main {

	public static void main(String[] args) 
	{
		// Obtendo uma referência para o singleton
		
		Singleton is1 = Singleton.getIndiceSingleton();
		
		// Mostrando o valor default do flag na criação do objeto
		
		System.out.println("Valor do flagProcessamentoOn para ref 1>> " + is1.getFlagProcessamentoOn());
		
		is1.setFlagProcessamentoOn(8);
		
		System.out.println("Valor do flagProcessamentoOn para ref 1 apos alteracao do flag>> " + is1.getFlagProcessamentoOn());
		
		// Obtendo outra referência para o singleton
		
		Singleton is2 = Singleton.getIndiceSingleton();
		
		is2.setFlagProcessamentoOn(56);
		
		System.out.println("Valor do flagProcessamentoOn para ref 2 >> " + is2.getFlagProcessamentoOn());
		
		is1 = Singleton.getIndiceSingleton();
		
		System.out.println("Valor do flagProcessamentoOn para ref 1 apos alteracao do flag>> " + is1.getFlagProcessamentoOn());
	}
}
