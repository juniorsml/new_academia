package br.com.codigosfontes.testenetbeans4.bo;

import br.com.codigosfontes.testenetbeans4.dao.UsuarioDAO;
import br.com.codigosfontes.testenetbeans4.domain.Usuario;
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