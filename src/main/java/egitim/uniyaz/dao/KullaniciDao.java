package egitim.uniyaz.dao;

import egitim.uniyaz.domain.Kullanici;
import egitim.uniyaz.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;



public class KullaniciDao {

    public Kullanici findKullanici(Kullanici giriskullanici) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        String isim = giriskullanici.getIsim();
        String sifre = giriskullanici.getSifre();

        try (Session session = sessionFactory.openSession();) {
            String hql = "Select kullanici from Kullanici kullanici where isim = :isim and sifre = :sifre";
            Query query = session.createQuery(hql);
            query.setParameter("isim", isim);
            query.setParameter("sifre",sifre);
            Kullanici kullanici = (Kullanici)query.uniqueResult();
            return kullanici;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
