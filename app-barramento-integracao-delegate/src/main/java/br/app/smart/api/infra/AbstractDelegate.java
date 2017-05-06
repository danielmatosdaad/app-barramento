package br.app.smart.api.infra;

import br.app.barramento.integracao.dao.interfaces.IServicoDAO;
import br.app.barramento.integracao.dto.EnvioDTO;
import br.app.barramento.integracao.dto.IService;
import br.app.barramento.integracao.dto.IServiceIntegracao;
import br.app.barramento.integracao.dto.LocalizadorServico;
import br.app.barramento.integracao.dto.Mensagem;
import br.app.barramento.integracao.dto.RespostaDTO;
import br.app.barramento.integracao.dto.TipoAcao;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;

public abstract class AbstractDelegate<S> implements IServiceIntegracao<EnvioDTO, RespostaDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected LocalizadorServico<S> localizarServico;

	public AbstractDelegate() {
	}
	
	public AbstractDelegate(TipoAcao acao) {

		LocalizadorServico<IService> localizaServico = (LocalizadorServico<IService>) getLocalizadorServico();
	}

	public AbstractDelegate(LocalizadorServico<S> localizarServico) {

		this.localizarServico = localizarServico;
	}

	protected LocalizadorServico<S> getLocalizadorServico() {
		return localizarServico;
	}

	public abstract LocalizadorServico<S> getLocalizadorServico(TipoAcao acao);

	public S getServico(TipoAcao acao) {
		return getLocalizadorServico(acao).getServico();
	}

	public S getServico() {
		return getLocalizadorServico().getServico();
	}

	public abstract void executarServico(TipoAcao acao, EnvioDTO envio, RespostaDTO resposta, S servico)
			throws NegocioException, InfraEstruturaException;

	@Override
	public RespostaDTO executar(TipoAcao acao, EnvioDTO envio) throws NegocioException, InfraEstruturaException {
		try {
			if (acao == null || envio == null) {

				throw new InfraEstruturaException("Parametros invalidos", new RuntimeException());
			}

			S servico = getServico(acao);

			RespostaDTO resposta = new RespostaDTO();
			resposta.setMensagem(Mensagem.SEM_RESPOSTA);
			
			if (servico != null && servico instanceof IServicoDAO) {

				executarServicoDAO((IServicoDAO) servico, acao, envio, resposta);
				return resposta;
			}
			executarServico(acao, envio, resposta,servico);

			
			return resposta;

		} catch (Exception e) {
			return criarRespostaErro(e);
		}

	}

	private void executarServicoDAO(IServicoDAO service, TipoAcao acao, EnvioDTO envio, RespostaDTO resposta)
			throws InfraEstruturaException, NegocioException {

		switch (acao) {

		case BUSCAR_POR_ID:
			service.bustarPorID(envio.getRequisicao().getId());
			resposta.setMensagem(Mensagem.SUCESSO);
			break;
		case BUSCAR_POR_INTERVALO:
			service.bustarPorIntervaloID(envio.getRequisicoesNumericas());
			resposta.setMensagem(Mensagem.SUCESSO);
			break;
		case EXCLUIR_POR_ID:
			service.removerPorId(envio.getRequisicao().getId());
			resposta.setMensagem(Mensagem.SUCESSO);
			break;
		case BUSCAR_TODOS:
			resposta.setListaResultado(service.bustarTodos());
			resposta.setMensagem(Mensagem.SUCESSO);
			break;
		case SALVAR:
			resposta.setResultado(service.adiconar(envio.getRequisicao()));
			resposta.setMensagem(Mensagem.SUCESSO);
			break;
		case SALVAR_LISTA:
			resposta.setListaResultado(service.adiconar(envio.getRequisicoes()));
			resposta.setMensagem(Mensagem.SUCESSO);
			break;
		case ATUALIZAR:
			resposta.setResultado(service.alterar(envio.getRequisicao()));
			resposta.setMensagem(Mensagem.SUCESSO);
			break;
		case EXCLUIR:
			service.remover((envio.getRequisicao()));
			resposta.setMensagem(Mensagem.SUCESSO);
			break;
		default:
			break;
		}
	}

	private RespostaDTO criarRespostaErro(Exception erro) {
		RespostaDTO resposta = new RespostaDTO();
		Mensagem mensagem = Mensagem.ERRO;
		mensagem.setErro(erro.getMessage());
		mensagem.setExcecao(erro);
		resposta.setMensagem(mensagem);
		return resposta;
	}
}
