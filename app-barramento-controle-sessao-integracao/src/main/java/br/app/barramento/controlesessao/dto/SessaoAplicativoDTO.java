package br.app.barramento.controlesessao.dto;

import java.io.Serializable;

import br.app.barramento.controlesessao.interfaces.ISessaoAplicativo;
import br.app.repositorio.servico.integracao.IRepositorio;

public class SessaoAplicativoDTO extends SessaoDTO implements ISessaoAplicativo, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SessaoAplicativoDTO(IRepositorio repositorio, SessaoEnvioDTO requisicaoOriginal,
			Long tempoMaximoSessaoMilSegundos) {
		super(repositorio, requisicaoOriginal, tempoMaximoSessaoMilSegundos);

	}

	public SessaoAplicativoDTO() {

	}

	@Override
	public boolean isSessaoValida() {
		return true;
	}

}
