package br.com.consulti.academics.dao;

import java.sql.Connection;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

public interface DAO<T> {

    public Class<T> getPersistentClass();

    public void excluir(T entity);

    public T buscarPorId(int id);

    /**
     * Recupera o objeto dando join em todos os relacionamentos
     * @param campo
     * @param valor
     * @return 
     */
    public T buscarUmPorCampoCompleto(String campo, Object valor);

    public List<T> buscarTodos();

    public T salvar(T entity);

    public List<T> buscarListaPorCriterio(Criterion... criterion);

    public List<T> buscarListaPorCriterio(Order order, Criterion... criterion);

    public T buscarUmPorCriterio(Criterion... criterion);

    /**
     * Retorna uma Session do hibernate retirada do EntityManager do JPA
     *
     * @return
     */
    public Session getSession();

    /**
     * Retorna a conexao JDBC com o Postgres
     *
     * @return
     */
    public Connection getConnection();
}
