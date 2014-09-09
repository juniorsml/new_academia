package br.com.consulti.academics.teste;

import br.com.consulti.academics.daoImpl.VideoHibernateDAOImpl;
import br.com.consulti.academics.model.Video;
import org.hibernate.StaleObjectStateException;

public class TestClientAdd {

    /**
     * @param args
     */
    public static void main(String[] args) {

//        SessionFactory sf = HibernateUtil.getSessionFactory();
//        Session currentSession;
        VideoHibernateDAOImpl dao = new VideoHibernateDAOImpl();

        try {
//            currentSession = sf.openSession();
//            currentSession.setFlushMode(FlushMode.MANUAL);
//
//            ManagedSessionContext.bind(currentSession);
//            currentSession.beginTransaction();

            Video v = new Video();
            // v.setId(new Long(17));
            v.setNomeVideo("Teste 3 de Nome");
            v.setCuidadosExercicio("teste13");
            // dao.delete(v);

//            for(int i = 0; i < 10; i++) {
//                dao.save(v);
//            }

            // v = dao.get(new Long(13));
            //  dao.createOrUpdate(v);

            for (Video vi : dao.buscarTodos()) {
                System.out.println(vi.getId());
            }

            System.out.println(v.getId());

//            ManagedSessionContext.unbind(sf);

//            currentSession.flush();
//            currentSession.getTransaction().commit();
//            currentSession.close();
        } catch (StaleObjectStateException epse) {
            throw epse;
        } catch (Throwable ex) {
// fazer rollback
            ex.printStackTrace();
//            try {
//                if (sf.getCurrentSession().getTransaction().isActive()) {
//                    sf.getCurrentSession().getTransaction().rollback();
//                }
//            } catch (Throwable rbEx) {
//                rbEx.printStackTrace();
//            } finally {
////                currentSession = ManagedSessionContext.unbind(sf);
////                currentSession.close();
        }
        //      }

        System.out.println("Finalizado!");
    }
}