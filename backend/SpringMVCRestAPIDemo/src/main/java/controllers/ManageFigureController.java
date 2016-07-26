package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import models.Figure;
import services.FigureService;

@RestController
public class ManageFigureController
{
    private FigureService figureService;
    
    @Autowired(required=true)
    @Qualifier(value="figureService")
    public void setFigureService(FigureService fs)
    {
        this.figureService = fs;
    }
    
    @RequestMapping(value = "/figures", method = RequestMethod.GET)
//    @Produces("application/json")
    public List<Figure> listFigure()
    {
        List<Figure> figures = new ArrayList<Figure>();
        Figure f = new Figure(123, "ika", 34);
        figures.add(f);
   //     return this.figureService.listFigure();
        return figures;
    }
//    public String response()
//    {
//        return "dom dom cai dom dom";
//    }
}
