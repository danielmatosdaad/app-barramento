package br.app.barramento.controlesessao.dto;

import java.io.Serializable;

import br.app.barramento.controlesessao.interfaces.ISessaoUsuario;
import br.app.repositorio.servico.integracao.IRepositorio;

public class SessaoUsuarioDTO extends SessaoDTO implements ISessaoUsuario, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public SessaoUsuarioDTO(IRepositorio repositorio, SessaoEnvioDTO requisicaoOriginal,
			Long tempoMaximoSessaoMilSegundos) {
		super(repositorio, requisicaoOriginal, tempoMaximoSessaoMilSegundos);

	}

	public SessaoUsuarioDTO() {

	}


}
