package br.com.javaweb.service;

import java.util.ArrayList;
import java.util.List;

import br.com.javaweb.model.Cliente;

public class ClienteService {
	static private List<Cliente> lista = new ArrayList<>();
	
	public void cadastrar(Cliente cliente){
		lista.add(cliente);
	}
	public List<Cliente> getTodosClientes(){
		return lista;
	}
	public void excluir(int idice){
		lista.remove(idice);
	}
	
}
