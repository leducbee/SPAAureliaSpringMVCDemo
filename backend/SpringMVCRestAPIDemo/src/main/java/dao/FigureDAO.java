package dao;

import java.util.List;

import models.Figure;

public interface FigureDAO
{
    public void addFigure(Figure f);
//    public void updateFigure(Figure f);
    public List<Figure> listFigure();
//    public Figure getFigureById(int id);
//    public void removeFigure(int id);
}
