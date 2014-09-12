/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consulti.academics.daoImpl;
import br.com.consulti.academics.dao.VideoHibernateDAO;
import br.com.consulti.academics.model.Video;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author Valter
 * @param <T>
 */
@Stateless
public class VideoHibernateDAOImpl <T> extends GenericDAO<Video> implements  VideoHibernateDAO , Serializable{
    
    
    
    
}
