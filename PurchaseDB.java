
package business;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author acmor
 */
public class PurchaseDB {
    public static List<Purchase> getPurchases(String memid) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qS = "SELECT p FROM Purchase p " +
                " WHERE p.memid = :memid " +
                "ORDER BY p.purchdt ";
        
        TypedQuery<Purchase> q = em.createQuery(qS, Purchase.class);
        q.setParameter("memid", memid);
        List<Purchase> p = null;
        try {
            p = q.getResultList();
            if (p==null || p.isEmpty()) {
            p = null;
        }
        } catch (NoResultException e) {
            p = null;
        } finally {
            em.close();
        }
        return p;
    }
     public static List<Purchase> getPurchases(String memid, Date pd) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qS = "SELECT p FROM Purchase p " +
                " WHERE p.memid = :memid " +
                " AND p.purchdt >= :pd " +
                "ORDER BY p.purchdt ";
        
        TypedQuery<Purchase> q = em.createQuery(qS, Purchase.class);
        q.setParameter("memid", memid);
        q.setParameter("pd", pd);
        List<Purchase> p = null;
        try {
            p = q.getResultList();
            if (p==null || p.isEmpty()) {
            p = null;
        }
        } catch (NoResultException e) {
            p = null;
        } finally {
            em.close();
        }
        return p;
    }
}
