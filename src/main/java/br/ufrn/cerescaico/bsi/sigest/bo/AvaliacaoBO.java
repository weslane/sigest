package br.ufrn.cerescaico.bsi.sigest.bo;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.ufrn.cerescaico.bsi.sigest.dao.AvaliacaoJpaController;
import br.ufrn.cerescaico.bsi.sigest.dao.exceptions.PreexistingEntityException;
import br.ufrn.cerescaico.bsi.sigest.dao.util.JPAUtil;
import br.ufrn.cerescaico.bsi.sigest.model.Avaliacao;
import br.ufrn.cerescaico.bsi.sigest.model.Curso;

public class AvaliacaoBO {
private static final Logger logger = Logger.getLogger(CursoBO.class.getName());
    
    private AvaliacaoJpaController daoAvaliacao;

    public AvaliacaoBO() {
        this.daoAvaliacao = new AvaliacaoJpaController(JPAUtil.EMF);
    }
    
    public Avaliacao inserir(Avaliacao avaliacao) throws NegocioException {
        try {
            return daoAvaliacao.create(avaliacao);
        }
        catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
            throw new NegocioException("erro.avaliacao.bo.inserir.exception",ex);
        }
    }
    
    public List<Avaliacao> listar() throws NegocioException {
    	try {
            return daoAvaliacao.findAvaliacaoEntities();
        }
        catch (Exception ex) {
        	logger.log(Level.SEVERE, ex.getMessage(), ex);
            throw new NegocioException("erro.avaliacao.bo.listar", ex);
        }
    }
    
    public Avaliacao buscarAvaliacao (Integer id) throws NegocioException{
    	try {
            return daoAvaliacao.findAvaliacao(id);
        }
        catch (Exception ex) {
        	logger.log(Level.SEVERE, ex.getMessage(), ex);
            throw new NegocioException("erro.avaliacao.bo.buscarAvaliacao", ex);
        }
    }
    
    public List<Avaliacao> buscarAvaliacaoPorProf(int codProf) throws NegocioException{
    	try{
    		return daoAvaliacao.buscarPorProf(codProf);
    	}catch (Exception ex){
    		logger.log(Level.SEVERE, ex.getMessage(), ex);
            throw new NegocioException("erro.avaliacao.bo.buscarAvaliacaoPorProf", ex);
    	}
    }

}
