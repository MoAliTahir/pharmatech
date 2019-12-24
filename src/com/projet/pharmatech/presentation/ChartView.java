package com.projet.pharmatech.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.BubbleChartModel;
import org.primefaces.model.chart.BubbleChartSeries;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.DonutChartModel;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.LinearAxis;
import org.primefaces.model.chart.MeterGaugeChartModel;
import org.primefaces.model.chart.OhlcChartModel;
import org.primefaces.model.chart.OhlcChartSeries;
import org.primefaces.model.chart.PieChartModel;

import com.projet.pharmatech.entities.Medicament;
import com.projet.pharmatech.entities.User;
import com.projet.pharmatech.services.MedicamentService;
import com.projet.pharmatech.services.UserService;

@ManagedBean(name = "chartView")
@RequestScoped
public class ChartView implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private PieChartModel pieModel1;
    private PieChartModel pieModel2;
    private List<User> users;
    private List<Medicament> medicaments;
    private UserService userService;
    private MedicamentService medService;
 
    @PostConstruct
    public void init() {
    	userService = new UserService();
    	medService = new MedicamentService();
    	users = userService.findAll();
    	medicaments = medService.findAll();
        createPieModels();
    }
 
    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());
 
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 

 
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
 
    public PieChartModel getPieModel2() {
        return pieModel2;
    }
 
   
 
 
    private void createPieModels() {
        createPieModel1();
        createPieModel2();
    }
 
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
 
        Iterator<User> i = users.iterator();
        int admins = 0, pharmaciens = 0;
        while (i.hasNext()) {
			User u = (User) i.next();
			if(u.getRole().equals("admin"))
				admins++;
			else
				pharmaciens++;
		}
       
        pieModel1.set("Pharmacien", pharmaciens);
        pieModel1.set("Administrateur", admins);
 
        pieModel1.setTitle("Nombre des utilisateurs ("+users.size()+")");
        pieModel1.setLegendPosition("sw");
        pieModel1.setShowDataLabels(true);
        pieModel1.setDiameter(150);
        pieModel1.setShadow(false);
    }
 
    private void createPieModel2() {
        pieModel2 = new PieChartModel();
        int total = 0;
        Iterator<Medicament> i = medicaments.iterator();
        while (i.hasNext()) {
			Medicament med = (Medicament) i.next();
			total += med.getQuantiteStock();
			pieModel2.set(med.getLibelle(), med.getQuantiteStock());
		}
       
 
        pieModel2.setTitle("Nombre des medicaments en stock ("+total+")");
        pieModel2.setLegendPosition("e");
        pieModel2.setFill(false);
        pieModel2.setShowDataLabels(true);
        pieModel2.setShadow(false);
    }

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Medicament> getMedicaments() {
		return medicaments;
	}

	public void setMedicaments(List<Medicament> medicaments) {
		this.medicaments = medicaments;
	}
 

}
