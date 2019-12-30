package egitim.uniyaz.dao;

import egitim.uniyaz.domain.Ariza;
import egitim.uniyaz.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ArizaDao {
    public Ariza saveAriza(Ariza ariza) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            session.getTransaction().begin();
            ariza = (Ariza) session.merge(ariza);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ariza;
    }

    public List<Ariza> findAllAriza() {
        List<Ariza> arizaList = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession();) {
            String hql = "Select ariza From Ariza ariza";
            Query query = session.createQuery(hql);
            arizaList = query.list();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return arizaList;
    }


    public List<Ariza> searchAriza(String musteriIsim) {
        List<Ariza> arizaList = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession();) {
            String hql = "Select ariza From Ariza ariza WHERE musteriIsim = :musteriIsim";
            Query query = session.createQuery(hql);
            query.setParameter("musteriIsim", musteriIsim);
            arizaList = query.list();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return arizaList;
    }

}
