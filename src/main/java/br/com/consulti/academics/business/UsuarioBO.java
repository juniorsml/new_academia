package br.com.consulti.academics.business;

import br.com.consulti.academics.daoImpl.UsuarioDAO;
import br.com.consulti.academics.model.Usuario;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author codigosfontes.com.br
 */
@Stateless
public class UsuarioBO extends GenericBO<Usuario>{

    @Inject
    private UsuarioDAO usuarioDAO;
    
    @Override
    @PostConstruct
    protected void inicializar() {
        this.genericDAO = usuarioDAO;
    }
}