package services;

import java.util.List;

import models.Figure;

public interface FigureService
{
    public Integer addFigure(String name, int price);
    public List<Figure> listFigure();
}
