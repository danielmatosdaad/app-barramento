package br.app.barramento.controlesessao.dto;

import java.io.Serializable;

import br.app.barramento.controlesessao.interfaces.ISessaoUsuario;
import br.app.corporativo.integracao.dto.UsuarioDTO;
import br.app.repositorio.servico.integracao.IRepositorio;

public class SessaoUsuarioDTO extends SessaoDTO implements ISessaoUsuario, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UsuarioDTO usuarioDTO;

	public SessaoUsuarioDTO(IRepositorio repositorio, SessaoEnvioDTO requisicaoOriginal, UsuarioDTO usuarioDTO,
			Long tempoMaximoSessaoMilSegundos) {
		super(repositorio, requisicaoOriginal, tempoMaximoSessaoMilSegundos);
		try {

			this.usuarioDTO = usuarioDTO;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public SessaoUsuarioDTO() {

	}

	@Override
	public UsuarioDTO getUsuarioDTO() {
		return this.usuarioDTO;
	}

}
