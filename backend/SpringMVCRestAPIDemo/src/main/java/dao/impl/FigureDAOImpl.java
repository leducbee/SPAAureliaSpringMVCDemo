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

    
    /*
     * add a figure
     * @param: f-Figure
     * */
    public Integer addFigure(Figure f)
    {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer figureId = null;
        String name = f.getName();
        int price = f.getPrice();
        
        if (name != null && price != 0)
        {
            try
            {
                tx = session.beginTransaction();
                
                Figure figure = new Figure(name, price);
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
        finally
        {
            session.close();
        }
    }
    
    
    /*
     * update a figure with id = json id in request
     * @param: f-Figure
     * */
    public void updateFigure(Figure f)
    {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer figureId = f.getId();
        String name = f.getName();
        int price = f.getPrice();
        
        try
        {
            tx = session.beginTransaction();
            Figure figure = session.get(Figure.class, figureId);
            figure.setName(name);
            figure.setPrice(price);
            tx.commit();
        }
        catch (HibernateException he)
        {
            if (tx != null)
                tx.rollback();
            he.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }


    /*
     * remove a figure with input id
     * */
    public void removeFigure(Integer id)
    {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        
        try
        {
            tx = session.beginTransaction();
            Figure figure = session.get(Figure.class, id);
            session.delete(figure);
            tx.commit();
        }
        catch (HibernateException he)
        {
            if (tx != null)
                tx.rollback();
            he.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }
    
    
    /*
     * get figure by id
     * */
    public Figure getFigureById(Integer id)
    {

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Figure figure = new Figure();
        
        try 
        {
            tx = session.beginTransaction();
            figure = session.get(Figure.class, id);
            tx.commit();
        }
        catch (HibernateException he)
        {
            if (tx != null)
                tx.rollback();
            he.printStackTrace();
        }
        finally
        {
            session.close();
        }
        
        return figure;
    }

}
