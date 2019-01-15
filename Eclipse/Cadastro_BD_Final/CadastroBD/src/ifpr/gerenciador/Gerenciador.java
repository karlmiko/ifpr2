package ifpr.gerenciador;

import java.util.List;

public interface Gerenciador<Objeto> {
	
	public void inserir(Objeto objeto);
	
	public List<Objeto> listar();
	
	public void atualizar(int ID, Objeto objeto);
	
	public void remover(int ID);
	
	public Objeto pesquisaID(int ID) throws Exception;
	
}
