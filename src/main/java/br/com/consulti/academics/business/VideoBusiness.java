/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consulti.academics.business;

import br.com.consulti.academics.dao.VideoHibernateDAO;
import br.com.consulti.academics.model.Video;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Valter
 */
@Stateless
public class VideoBusiness extends GenericBO<Video> implements Serializable  {

   @Inject
    VideoHibernateDAO  dao ;

    

    public List<Video> getAll() {
        return dao.buscarTodos();
    }

    public Video obterPorID(Long id) {
        return dao.buscarPorId(id.intValue());
    }

    @PostConstruct
    @Override
    protected void inicializar() {
        this.genericDAO = dao;
    }

    

    

  
}
