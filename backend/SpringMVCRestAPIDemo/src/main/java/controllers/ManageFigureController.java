package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import models.Figure;
import services.FigureService;

@Controller
public class ManageFigureController
{
    private FigureService figureService;
    
    @Autowired(required=true)
    @Qualifier(value="figureService")
    public void setFigureService(FigureService fs)
    {
        this.figureService = fs;
    }
    
    /*
     * call addFigure
     * URL   : localhost:8080/SpringMVCRestAPIDemo/figure/add/
     * Method: POST
     * */
    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(value="/figure/add/", method=RequestMethod.POST, headers="Accept=application/json")
    public String addFigure(@RequestBody Figure f)
    {
        Integer figureNewID = figureService.addFigure(f);
        return "redirect:/figures";
    }
    
    
    /*
     * call listFigure
     * URL   : localhost:8080/SpringMVCRestAPIDemo/figures
     * Method: GET
     * */
    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(value = "/figures", method = RequestMethod.GET)
    public @ResponseBody List<Figure> listFigure()
    {
        List<Figure> figureList = this.figureService.listFigure();
        System.out.println(figureList);
        return figureList;
    }
    
    
    /*
     * call updateFigure
     * URL   : localhost:8080/SpringMVCRestAPIDemo/figure/update
     * METHOD: PUT
     * */
    @RequestMapping(value="/figure/update", method=RequestMethod.PUT, consumes="application/json")
    public String updateFigure(@RequestBody Figure f)
    {
        figureService.updateFigure(f);
        return "redirect:/figures";
    }


    /*
     * call removeFigure
     * URL   : locahost:8080/SpringMVCRestAPIDemo/figure/remove/{id}
     * @param: id- Integer
     * */
    @RequestMapping(value="/figure/remove/{id}", method=RequestMethod.GET)
    public String removeFigure(@PathVariable Integer id)
    {
        figureService.removeFigure(id);
        return "redirect:/figures";
    }


    /*
     * call getFigureById
     * URL   : localhost:8080/SpringMVCRestAPIDemo/figure/
     * */
    @RequestMapping(value="figure/{id}", method=RequestMethod.GET)
    public @ResponseBody Figure getFigureById(@PathVariable Integer id)
    {
        return figureService.getFigureById(id);
    }


}
