package banco.ui;

import java.util.List;

import banco.dao.Livro;
import banco.dao.Autor;
import banco.modelo.Livro;
import banco.modelo.Autor;

public class InterfaceContaTexto extends InterfaceModeloTexto {

	private Autor dao;
	private Livro clienteDao;
	
	public InterfaceContaTexto() {
		super();
		dao = new Autor();
		clienteDao = new Livro();
	}
	
	@Override
	public void adicionar() {
		System.out.println("Adicionar conta");
		System.out.println();
		
		Autor novaConta = obtemDadosConta(null);	
		dao.insert(novaConta);
	}

	private Autor obtemDadosConta(Autor conta) {
		System.out.print("Insira o número da conta: ");
		int numero = entrada.nextInt();
		
		System.out.print("Insira o número da agência: ");
		int agencia = entrada.nextInt();
		
		System.out.print("Insira o saldo: ");
		double saldo = entrada.nextDouble();
		
		System.out.print("Insira o ID do cliente: ");
		int idCliente = entrada.nextInt();
		
		Livro cliente = clienteDao.getByKey(idCliente);
		
		return new Autor(0, agencia, numero, cliente, saldo);
	}

	@Override
	public void listarTodos() {
		List<Autor> contas = dao.getAll();
		
		System.out.println("Lista de contas");
		System.out.println();
		
		System.out.println("id\tAgência\tNúmero\tSaldo\tID do Cliente\tNome do Cliente");
		
		for (Autor conta : contas) {
			imprimeItem(conta);
		}
	}

	@Override
	public void editar() {
		listarTodos();
		
		System.out.println("Editar conta");
		System.out.println();
		
		System.out.print("Entre o id da conta: ");
		int id = entrada.nextInt();
		entrada.nextLine();
		
		Autor contaAModificar = dao.getByKey(id);
		
		Autor novaConta = obtemDadosConta(contaAModificar);
		
		novaConta.setId(id);
		
		dao.update(novaConta);
	}

	@Override
	public void excluir() {
		listarTodos();
		
		System.out.println("Excluir conta");
		System.out.println();
		
		System.out.print("Entre o id da conta: ");
		int id = entrada.nextInt();
		entrada.nextLine();
		
		dao.delete(id);
	}

}
