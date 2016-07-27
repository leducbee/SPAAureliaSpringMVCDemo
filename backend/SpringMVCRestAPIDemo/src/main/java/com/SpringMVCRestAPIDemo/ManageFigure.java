package com.SpringMVCRestAPIDemo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import models.Figure;
import models.Figure1;

public class ManageFigure
{
    private static SessionFactory factory;
    
    public static void main(String[] args)
    {
        try
        {
            factory = new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex)
        {
            System.err.println("failed to create sessionFactory object: " + ex);
        }
        
        ManageFigure MF = new ManageFigure();
        
        
        //add imployee
       Integer figureId1 = MF.addFigure("okai", 45);
       MF.getFigureById(28);
//       MF.updateFigure(1, "puj", 200);
       
       MF.listAllFigure();

//test connection         
//        factory = new Configuration().configure().buildSessionFactory();
//        System.out.println("in");
//        Session session = factory.openSession();
//        session.beginTransaction();
//        System.out.println("out");
        
        
    }
    
    
    /*
     * Add new figure
     * @Para: name-string, price-int
     * */
    public Integer addFigure(String name, int price)
    {
        Session session = factory.openSession();
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
     * Update a figure
     * @param: name-string, price-int
     * */
    public void updateFigure(Integer fId, String name, int price)
    {
        Session session = factory.openSession();
        Transaction tx = null;
        
        try
        {
            tx = session.beginTransaction();
            Figure1 figure = session.get(Figure1.class, fId);
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
     * list all figure
     * */
    public void listAllFigure()
    {
        Session session = factory.openSession();
        Transaction tx = null;;
        
        try
        {
            int id = 3;
            tx = session.beginTransaction();
            String hql = "FROM Figure1";
            Query query = session.createQuery(hql);
            List figures = query.list();
            
            for (Iterator iterator = figures.iterator(); iterator.hasNext();)
            {
                Figure1 figure = (Figure1) iterator.next();
                System.out.print("id: " + figure.getId());
                System.out.print("\tname: " + figure.getName());
                System.out.println("\tprice: " + figure.getPrice() + "$");
            }
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
        Session session = factory.openSession();
        Transaction tx = null;
        
        try
        {
            tx = session.beginTransaction();
            Figure1 figure = session.get(Figure1.class, id);
            if (figure != null)
            {
                session.delete(figure);
                tx.commit();
            }
            else
            {
                System.out.println("********************************\n\tid not found\n********************************");
            }
            
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


    public Figure1 getFigureById(Integer id)
    {
        Session session = factory.openSession();
        Transaction tx = null;
        Figure1 figure = new Figure1();
        
        try 
        {
            tx = session.beginTransaction();
            figure = session.load(Figure1.class, id);
           
            if (figure != null)
            {
                System.out.println("got it");
                System.out.print("id: " + figure.getId());
                System.out.print("\tname: " + figure.getName());
                System.out.println("\tprice: " + figure.getPrice() + "$");
            }
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
