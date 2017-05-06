package br.app.barramento.controlesessao.dto;

import java.io.Serializable;

import br.app.barramento.controlesessao.interfaces.ISessaoAplicativo;
import br.app.repositorio.servico.integracao.IRepositorio;
import br.app.servico.infra.integracao.dto.AplicativoDTO;

public class SessaoAplicativoDTO extends SessaoDTO implements ISessaoAplicativo, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AplicativoDTO aplicativoDTO;

	public SessaoAplicativoDTO(IRepositorio repositorio, SessaoEnvioDTO requisicaoOriginal, AplicativoDTO aplicativoDTO,
			Long tempoMaximoSessaoMilSegundos) {
		super(repositorio, requisicaoOriginal, tempoMaximoSessaoMilSegundos);
		try {
			this.aplicativoDTO = aplicativoDTO;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public SessaoAplicativoDTO() {

	}

	public AplicativoDTO getAplicativoDTO() {
		return aplicativoDTO;
	}

	@Override
	public boolean isSessaoValida() {
		return true;
	}

}
