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
import br.app.barramento.integracao.dto.RespostaDTO;
import br.app.barramento.integracao.dto.TipoAcao;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.catalago.api.RespositorioDelegate;
import br.app.corporativo.integracao.api.IntegracaoDelegate;
import br.app.repositorio.servico.integracao.IRepositorio;
import br.app.repositorio.servico.integracao.IServicoRepositorio;
import br.app.servico.infra.apl.api.AplicativoDelegate;
import br.app.servico.infra.integracao.dto.AplicativoDTO;

@Stateless
@Remote(value = IConexaoRemote.class)
@Local(value = IConexaoLocal.class)
public class SessaoConexaoAplicativoImp implements IConexaoRemote, IConexaoLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ISessao sessao;

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

		AplicativoDTO aplicativoDTO = AplicativoDelegate.getInstancia()
				.validaAplicativo(sessaoEnvio.getNomeIdentificadorAutenticacao(), sessaoEnvio.getSenha());

		IServicoRepositorio servicoRepositorio = RespositorioDelegate.getIntancia().getServico();
		IRepositorio repositorioServico = servicoRepositorio.getRespositorio();
		this.sessao = new SessaoAplicativoDTO(repositorioServico, sessaoEnvio, aplicativoDTO, Long.valueOf(100000));
		return this.sessao;
	}

	@Override
	public void fecharConexao(SessaoEnvioDTO sessaoEnvio) throws NegocioException, InfraEstruturaException {
		if (sessaoEnvio == null) {
			throw new NegocioException("informacoes invalida", new RuntimeException());
		}

	}

	@Override
	public RespostaDTO executar(TipoAcao acao, EnvioDTO envio) throws NegocioException, InfraEstruturaException {

		return IntegracaoDelegate.getInstancia().executar(acao, envio);
	}

}
