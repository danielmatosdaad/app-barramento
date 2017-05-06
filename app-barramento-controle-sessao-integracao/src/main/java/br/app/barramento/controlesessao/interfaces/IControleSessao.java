package br.app.barramento.controlesessao.interfaces;


import br.app.barramento.controlesessao.dto.SessaoEnvioDTO;
import br.app.barramento.controlesessao.dto.SessaoRespostaDTO;
import br.app.barramento.integracao.dto.IService;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;

public interface IControleSessao extends IService {

	public SessaoRespostaDTO abrir(SessaoEnvioDTO sessaoEnvio) throws NegocioException, InfraEstruturaException;

	public void fechar(ISessaoUsuario sessaoEnvio);

}
