package br.com.codigosfontes.testenetbeans4.bo;


import br.com.codigosfontes.testenetbeans4.dao.GenericDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

/**
 * @author codigosfontes.com.br
 * BO genérico com as operações básicas
 */
public abstract class GenericBO<E> implements Serializable {
    
    protected GenericDAO<E> genericDAO;  

    @PostConstruct    
    protected abstract void inicializar();
    
    public E salvar(E entidade) {
        return genericDAO.salvar(entidade);            
    }
    
    public void excluir(E entidade) {
        genericDAO.excluir(entidade);
    }
    
    public List<E> buscarTodos(String ordenarPor) {
        return genericDAO.buscarListaPorCriterio(Order.asc(ordenarPor));
    }
    
    public List<E> buscarTodos() {
        return genericDAO.buscarTodos();
    }
    
    public E buscarPorId(int id) {
        return (E)genericDAO.buscarPorId(id);
    }
    
    public E buscarUmPorCampoCompleto(String campo, Object valor) {
        return (E)genericDAO.buscarUmPorCampoCompleto(campo, valor);
    }
    
    public List<E> buscarListaPorCriterio(Criterion... criterion) {
        return genericDAO.buscarListaPorCriterio(criterion);
    }

    public List<E> buscarListaPorCriterio(Order order, Criterion... criterion) {
        return genericDAO.buscarListaPorCriterio(order, criterion);
    }

    public E buscarUmPorCriterio(Criterion... criterion) {
        return genericDAO.buscarUmPorCriterio(criterion);
    }    
}