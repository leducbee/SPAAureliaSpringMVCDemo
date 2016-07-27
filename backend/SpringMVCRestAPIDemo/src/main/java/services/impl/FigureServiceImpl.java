package services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.FigureDAO;
import models.Figure;
import services.FigureService;

public class FigureServiceImpl implements FigureService
{
    private FigureDAO figureDAO;
    
    public void setFigureDAO(FigureDAO figureDAO)
    {
        this.figureDAO = figureDAO;
    }
    
    /*
     * service add figure: implement service interface - add service
     * */
    @Transactional
    public Integer addFigure(Figure f)
    {
        return this.figureDAO.addFigure(f);
    }
    
    
    /*
     * implement figure service: list all figure object in database
     * implement service interface - listFigure
     * 
     * */
    @Transactional
    public List<Figure> listFigure()
    {
        return this.figureDAO.listFigure();
    }

    
    /*
     * service update figure
     * implement service interface - updateFigure
     * */
    @Transactional
    public void updateFigure(Figure f)
    {
        this.figureDAO.updateFigure(f);
    }
    
    
    /*
     *service remove a figure with id
     *implement service interface - removeFigure 
     * */
    @Transactional
    public void removeFigure(Integer id)
    {
        this.figureDAO.removeFigure(id);
    }


    /*
     * service get figure by id
     * implement service interface - getFigureById
     * */
    @Transactional
    public Figure getFigureById(Integer id)
    {
        return this.figureDAO.getFigureById(id);
    }
}
