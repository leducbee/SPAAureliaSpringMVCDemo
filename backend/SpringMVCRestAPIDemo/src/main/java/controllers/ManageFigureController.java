package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    
    @RequestMapping(value="/figure/add/{name}/{price}", method=RequestMethod.POST)
    public String addFigure(@PathVariable("name") String name, @PathVariable("price") int price)
    {
        Integer figureNewID = figureService.addFigure(name, price);
        return "redirect:/figures";
    }
    
    
    
    @RequestMapping(value = "/figures", method = RequestMethod.GET)
//    @Produces("application/json")
    public List<Figure> listFigure()
    {
//        List<Figure> figures = new ArrayList<Figure>();
//        Figure f = new Figure(123, "ika", 34);
//        figures.add(f);
        List<Figure> figureList = this.figureService.listFigure();
        System.out.println(figureList);
        return figureList;
   //     return figures;
    }
//    public String response()
//    {
//        return "dom dom cai dom dom";
//    }
}
