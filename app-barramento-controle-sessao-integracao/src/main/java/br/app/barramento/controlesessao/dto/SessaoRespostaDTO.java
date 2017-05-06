package br.app.barramento.controlesessao.dto;

import java.io.Serializable;

import br.app.barramento.controlesessao.interfaces.IConexao;
import br.app.barramento.controlesessao.interfaces.ISessao;

public class SessaoRespostaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IConexao conexao;
	private ISessao sessao;

	public void setSessaoConexao(IConexao sessaoConexao) {

		this.conexao = sessaoConexao;
	}

	public IConexao getConexao() {
		return conexao;
	}

	public ISessao getSessao() {
		return sessao;
	}

	public void setSessao(ISessao sesso) {
		this.sessao = sesso;
	}

}
