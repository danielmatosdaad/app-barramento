package br.app.barramento.servico.imp;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.app.barramento.controlesessao.dto.SessaoAplicativoDTO;
import br.app.barramento.controlesessao.dto.SessaoEnvioDTO;
import br.app.barramento.controlesessao.interfaces.IConexaoLocal;
import br.app.barramento.controlesessao.interfaces.IConexaoRemote;
import br.app.barramento.controlesessao.interfaces.ISessao;
import br.app.barramento.integracao.dto.EnvioDTO;
import br.app.barramento.integracao.dto.IServiceIntegracao;
import br.app.barramento.integracao.dto.LocalizadorServico;
import br.app.barramento.integracao.dto.RespostaDTO;
import br.app.barramento.integracao.dto.TipoAcao;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.corporativo.integracao.api.IntegracaoDelegate;
import br.app.repositorio.api.RespositorioDelegate;
import br.app.repositorio.servico.integracao.CatalogoServico;
import br.app.repositorio.servico.integracao.IRepositorio;
import br.app.repositorio.servico.integracao.IServicoRepositorio;
import br.app.repositorio.servico.integracao.InformacaoServico;
import br.app.repositorio.servico.integracao.RepositorioServico;

@Stateless
@Remote(value = IConexaoRemote.class)
@Local(value = IConexaoLocal.class)
public class SessaoConexaoAplicativoImp implements IConexaoRemote, IConexaoLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void init() {
		try {
			Date dataHoraRequisicao = new Date();
			System.out.println(SessaoConexaoAplicativoImp.class + " : " + dataHoraRequisicao.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public ISessao abrirConexao(SessaoEnvioDTO sessaoEnvio) throws NegocioException, InfraEstruturaException {

		if (sessaoEnvio == null) {
			throw new NegocioException("informacoes invalida", new RuntimeException());
		}

		IServicoRepositorio servicoRepositorio = RespositorioDelegate.getIntancia().getServico();
		IRepositorio repositorioServico = servicoRepositorio.getRespositorio();
		return new SessaoAplicativoDTO(repositorioServico, sessaoEnvio, Long.valueOf(100000));
	}

	@Override
	public void fecharConexao(SessaoEnvioDTO sessaoEnvio) throws NegocioException, InfraEstruturaException {
		if (sessaoEnvio == null) {
			throw new NegocioException("informacoes invalida", new RuntimeException());
		}

	}

	@Override
	public RespostaDTO executar(TipoAcao acao, EnvioDTO envio, String nomeRepositorioArtefatoId,
			String nomeCatalogoArtefatoId, String ip, String porta, String login, String senha)
			throws NegocioException, InfraEstruturaException {
		IServiceIntegracao servico = IntegracaoDelegate
				.getInstancia(nomeRepositorioArtefatoId, nomeCatalogoArtefatoId, ip, porta, login, senha).getServico();
		if (servico == null) {
			throw new NegocioException("nao foi possivel localizar o servico", new RuntimeException());
		}
		return servico.executar(acao, envio);
	}

}
