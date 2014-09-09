/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consulti.academics.business;

import br.com.consulti.academics.daoImpl.VideoHibernateDAOImpl;
import br.com.consulti.academics.model.Video;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author Valter
 */
public class VideoBusiness extends GenericBO<Video> implements Serializable  {

    @Inject
    VideoHibernateDAOImpl dao ;

    public List<Video> getAll() {
        return dao.buscarTodos();
    }

    public Video obterPorID(Long id) {
        return dao.buscarPorId(id.intValue());
    }

    @Override
    @PostConstruct
    protected void inicializar() {
        this.genericDAO = dao;
    }
}
