/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.app.barramento.integracao.servico.imp;

import java.io.Serializable;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.app.barramento.integracao.dto.EnvioDTO;
import br.app.barramento.integracao.dto.IService;
import br.app.barramento.integracao.dto.IServiceIntegracaoLocal;
import br.app.barramento.integracao.dto.IServiceIntegracaoRemote;
import br.app.barramento.integracao.dto.Mensagem;
import br.app.barramento.integracao.dto.RespostaDTO;
import br.app.barramento.integracao.dto.TipoAcao;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.smart.api.infra.AbstractDelegate;

/**
 *
 * @author daniel.matos
 */
@Stateless
@Remote(value = { IServiceIntegracaoRemote.class })
@Local(value = { IServiceIntegracaoLocal.class })
public class IntegracaoServicoImp implements IServiceIntegracaoRemote<EnvioDTO, RespostaDTO>,
		IServiceIntegracaoLocal<EnvioDTO, RespostaDTO>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public RespostaDTO executar(TipoAcao acao, EnvioDTO envio) throws NegocioException, InfraEstruturaException {

		try {

			Class classDelegate = getClassDelegate(envio.getDelegate());

			AbstractDelegate delegate = (AbstractDelegate) classDelegate.newInstance();

			return delegate.executar(acao, envio);

		} catch (ClassNotFoundException e) {
			throw new InfraEstruturaException("Nao foi possivel executar o servico, de forma integrada.");
		} catch (Exception e) {

			return criarRespostaErro(e);
		}
	}

	public <I extends IService, D extends AbstractDelegate<I>> Class<D> getClassDelegate(String delegate)
			throws ClassNotFoundException {
		return (Class<D>) Class.forName(delegate);
	}

	private RespostaDTO criarRespostaErro(Exception e) {
		RespostaDTO resposta = new RespostaDTO();
		Mensagem mensagem = Mensagem.ERRO;
		mensagem.setErro(e.getMessage());
		mensagem.setExcecao(e);
		resposta.setMensagem(mensagem);
		return resposta;
	}

	public <I extends IService> Class<I> getClassIntefaces(String nomeService) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return (Class<I>) Class.forName(nomeService);
	}
}
