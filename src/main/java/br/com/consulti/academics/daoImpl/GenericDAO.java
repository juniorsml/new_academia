package br.com.consulti.academics.daoImpl;

import br.com.consulti.academics.dao.DAO;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

/**
 * Classe DAO generica para acesso aos dados.
 * @author codigosfontes.com.br
 * @param <T>
 */
public abstract class GenericDAO<T> implements Serializable , DAO<T>{

    @PersistenceContext(unitName = "AcademicsPU")
    private EntityManager entityManager;
    
    @Resource(mappedName="jdbc/academics")
    DataSource dataSource;   
    

    public GenericDAO() {
        this.persistentClass = (Class<T>) ((ParameterizedType) 
                getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
     
    
    private Class<T> persistentClass;

    public Class<T> getPersistentClass() {
        return this.persistentClass;
    }


    public void excluir(T entity) {
        entity = entityManager.merge(entity);
        entityManager.remove(entity);
    }

    public T buscarPorId(int id) {
        try {
            return (T) entityManager.find(getPersistentClass(), id);
        } catch (NoResultException noResultException) {
            return null;
        }        
    }
    
    /**
     * Recupera o objeto dando join em todos os relacionamentos
     */    
    public T buscarUmPorCampoCompleto(String campo, Object valor) {
        try {
            return (T) entityManager.createQuery("SELECT obj FROM " + persistentClass.getName() + " obj "
                                               + "FETCH ALL PROPERTIES "
                                               + "WHERE " + campo + " = :_valor ")
                                                .setParameter("_valor", valor)
                                               .setMaxResults(1)
                                               .getSingleResult();
        } catch (NoResultException noResultException) {
            return null;
        }        
    }

    @Override
    public List<T> buscarTodos() {
        return getSession().createCriteria(persistentClass)
                           .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    public T salvar(T entity) {
        entity = entityManager.merge(entity);
        return entity;
    }

    @Override
    public List<T> buscarListaPorCriterio(Criterion... criterion) {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        for (Criterion c : criterion) {
            crit.add(c);
        }
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return crit.list();
    }

    public List<T> buscarListaPorCriterio(Order order, Criterion... criterion) {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        for (Criterion c : criterion) {
            crit.add(c);
        }

        crit.addOrder(order);
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

        return crit.list();
    }

    public T buscarUmPorCriterio(Criterion... criterion) {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        for (Criterion c : criterion) {
            crit.add(c);
        }
        return (T) crit.uniqueResult();
    }
    
    /**
     * Retorna uma Session do hibernate retirada do EntityManager do JPA
     * @return 
     */
    @Override
    public Session getSession() {
        System.out.println("entityManager " + entityManager);
       return (Session) entityManager.unwrap(Session.class);
    }
    
    /**
     * Retorna a conexao JDBC com o Postgres
     */
    @Override
    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException ex) {
            return null;
        }
    }    
}