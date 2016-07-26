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
     * implement figure service: list all figure object in database
     * 
     * */
    @Transactional
    public List<Figure> listFigure()
    {
        return this.figureDAO.listFigure();
    }

}
