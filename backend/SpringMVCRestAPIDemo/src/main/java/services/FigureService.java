package services;

import java.util.List;

import models.Figure;

public interface FigureService
{
    public Integer addFigure(Figure f);
    public List<Figure> listFigure();
    public void updateFigure(Figure f);
    public Figure getFigureById(Integer id);
    public void removeFigure(Integer id);
}
