package banco.modelo;


public class Livro extends Livro implements Imprimivel {
	private double rendaMensal;

	public Livro() { super(); }
	
	public Livro(integer id, String titulo, integer anoPublicacao, String editora, String autor) {
		super(id, titulo, anoPublicacao, editora, autor);

		this.rendaMensal = rendaMensal;
	}

	public double getRendaMensal() {
		return rendaMensal;
	}

	public void setRendaMensal(double rendaMensal) {
		this.rendaMensal = rendaMensal;
	}

	@Override
	public String toString() {
		return super.toString()
				+ String.format("\nRenda mensal: R$ %.2f", 
						getRendaMensal());
	}

	@Override
	public String imprimeEmLista() {
		return String.format("%d\t%s\t%s\t%d\t%d\t%d%.2f", getId(), getTitulo(), getAnoPublicacao(), getEditora(), 
				getAutor());
	}

	@Override
	public String[] getColunas() {
		String[] colunas = {"id", "Titulo", "AnoPublicacao", "Editora", "Autor"};
		return colunas;
	}
	
	
	
}
