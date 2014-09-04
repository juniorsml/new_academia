package br.com.consulti.academics.daoImpl;

import br.com.consulti.academics.dao.DAO;
import br.com.consulti.academics.util.HibernateUtil;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.inject.Inject;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StaleObjectStateException;
import org.hibernate.context.internal.ManagedSessionContext;
import org.hibernate.proxy.HibernateProxy;

public class HibernateDaoImpl<T> implements DAO<T> {

    private Class<T> type;
    private SessionFactory sf = HibernateUtil.getSessionFactory();
    private Session currentSession;

    public HibernateDaoImpl() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void start() {
        currentSession = sf.openSession();
        currentSession.setFlushMode(FlushMode.MANUAL);
        ManagedSessionContext.bind(currentSession);
        currentSession.beginTransaction();

    }

    @Override
    public void finish() {
        ManagedSessionContext.unbind(sf);
        currentSession.flush();
        currentSession.getTransaction().commit();
        currentSession.close();
    }

    @Override
    public Session getSession() {
        
        return sf.openSession();
    }

    @Override
    public void save(T persistentObject) {
        try {
            start();
            currentSession.save(persistentObject);
        } catch (StaleObjectStateException epse) {
            Logger.getLogger("erro").error(HibernateDaoImpl.class + " : " + epse);
        } catch (Throwable ex) {
            // fazer rollback
            Logger.getLogger("erro").error(HibernateDaoImpl.class + " : " + ex);
            ex.printStackTrace();
            try {
                if (sf.getCurrentSession().getTransaction().isActive()) {
                    sf.getCurrentSession().getTransaction().rollback();
                }
            } catch (Throwable rbEx) {
                Logger.getLogger("erro").error(HibernateDaoImpl.class + " : " + rbEx);
            }
        } finally {
            finish();
        }
    }

    @SuppressWarnings("unchecked")
    public T get(Long id) {
        T value = (T) getSession().get(type, id);
        if (value == null) {
            return null;
        }

        if (value instanceof HibernateProxy) {
            Hibernate.initialize(value);
            value = (T) ((HibernateProxy) value).getHibernateLazyInitializer().getImplementation();
        }
        return value;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAll() {
        Criteria crit = getSession().createCriteria(type);
        return crit.list();
    }

    @Override
    public void createOrUpdate(T o) {
        try {
            start();
            currentSession.saveOrUpdate(o);
        } catch (StaleObjectStateException epse) {
            Logger.getLogger("erro").error(HibernateDaoImpl.class + " : " + epse);
        } catch (Throwable ex) {
            // fazer rollback
            Logger.getLogger("erro").error(HibernateDaoImpl.class + " : " + ex);
            ex.printStackTrace();
            try {
                if (sf.getCurrentSession().getTransaction().isActive()) {
                    sf.getCurrentSession().getTransaction().rollback();
                }
            } catch (Throwable rbEx) {
                Logger.getLogger("erro").error(HibernateDaoImpl.class + " : " + rbEx);
            }

        } finally {
            finish();
        }
    }

    @Override
    public void update(T o) {
        try {
            start();
            currentSession.update(o);
        } catch (StaleObjectStateException epse) {
            Logger.getLogger("erro").error(HibernateDaoImpl.class + " : " + epse);
        } catch (Throwable ex) {
            // fazer rollback
            Logger.getLogger("erro").error(HibernateDaoImpl.class + " : " + ex);
            ex.printStackTrace();
            try {
                if (sf.getCurrentSession().getTransaction().isActive()) {
                    sf.getCurrentSession().getTransaction().rollback();
                }
            } catch (Throwable rbEx) {
                Logger.getLogger("erro").error(HibernateDaoImpl.class + " : " + rbEx);
            }
        } finally {
            finish();
        }
    }

    @Override
    public void delete(T o) {
        try {
            start();
            currentSession.delete(o);
        } catch (StaleObjectStateException epse) {
            Logger.getLogger("erro").error(HibernateDaoImpl.class + " : " + epse);
        } catch (Throwable ex) {
            // fazer rollback
            Logger.getLogger("erro").error(HibernateDaoImpl.class + " : " + ex);
            ex.printStackTrace();
            try {
                if (sf.getCurrentSession().getTransaction().isActive()) {
                    sf.getCurrentSession().getTransaction().rollback();
                }
            } catch (Throwable rbEx) {
                Logger.getLogger("erro").error(HibernateDaoImpl.class + " : " + rbEx);
            }
        } finally {
            finish();
        }
    }
}