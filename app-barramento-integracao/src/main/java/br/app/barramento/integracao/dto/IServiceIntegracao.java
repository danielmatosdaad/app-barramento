package br.app.barramento.integracao.dto;

import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;

public interface IServiceIntegracao<E extends EnvioDTO, R extends RespostaDTO> extends IService {

	public R executar(TipoAcao acao, E envio) throws NegocioException, InfraEstruturaException;
}
