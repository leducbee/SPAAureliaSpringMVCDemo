package dao;

import java.util.List;

import models.Figure;

public interface FigureDAO
{
    public Integer addFigure(Figure f);
    public void updateFigure(Figure f);
    public List<Figure> listFigure();
    public Figure getFigureById(Integer id);
    public void removeFigure(Integer id);
}
