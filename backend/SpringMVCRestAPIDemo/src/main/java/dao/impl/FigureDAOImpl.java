package dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import dao.FigureDAO;
import models.Figure;
import models.Figure1;

@Repository
public class FigureDAOImpl implements FigureDAO
{
    private static SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf)
    {
        this.sessionFactory = sf;
    }

    
    
    public Integer addFigure(String name, int price)
    {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer figureId = null;
        
        try
        {
            tx = session.beginTransaction();
            Figure1 figure = new Figure1(name, price);
            figureId = (Integer) session.save(figure);
            tx.commit();
        }
        catch (HibernateException he)
        {
            if (tx != null) tx.rollback();
            he.printStackTrace();
        }
        finally
        {
            session.close();
        }
        
        return figureId;
    }
    
    
    
    /*
     * List all figure object in database table
     * 
     * */
    public List<Figure> listFigure()
    {
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        
        try
        {
            tr = session.beginTransaction();
            String hql = "FROM Figure";
            Query query = session.createQuery(hql);
            List figures = query.list();
            
            return figures;
        }
        catch (HibernateException he)
        {
            if (tr != null)
                tr.rollback();
            he.printStackTrace();
            return null;
        }
    }
}
