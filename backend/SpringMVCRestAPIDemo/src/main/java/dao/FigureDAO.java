package dao;

import java.util.List;

import models.Figure;

public interface FigureDAO
{
    public Integer addFigure(String name, int price);
//    public void updateFigure(Figure f);
    public List<Figure> listFigure();
//    public Figure getFigureById(int id);
//    public void removeFigure(int id);
}
