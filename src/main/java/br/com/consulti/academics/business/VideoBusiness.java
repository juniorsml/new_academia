/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consulti.academics.business;

import br.com.consulti.academics.daoImpl.VideoHibernateDAOImpl;
import br.com.consulti.academics.model.Video;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Valter
 */
public class VideoBusiness implements Serializable {

    VideoHibernateDAOImpl dao = new VideoHibernateDAOImpl();

    public List<Video> getAll() {
        return dao.getAll();
    }

    public Video obterPorID(Long id) {
        return dao.get(id);

    }
}
