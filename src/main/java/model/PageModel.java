package model;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;

public abstract class PageModel {

	@Override
	public String toString()
	{
		return name.getValue();
	}
	private StringProperty name;
	private StringProperty id;
	public StringProperty  description;
	public ObservableList<String> external_links; 
	public HashMap<String, ObservableList<String>> page_links;
	Page p;
	

	public PageModel(Page p)
	{
		
		this.p = p;
		name = new SimpleStringProperty();
		id = new SimpleStringProperty();
		description= new SimpleStringProperty();
		external_links = FXCollections.observableArrayList();
		page_links =  new HashMap<String, ObservableList<String>>();
		this.name.setValue(p.getName());
		this.id.setValue(p.getId());
		this.description.setValue(p.getDescription());
		
		for(int i = 0; i < p.getExternalLinks().size();i++)
		{
			external_links.add(p.getExternalLinks().get(i));
		}
		
		
		for(int i = 0; i < p.getRolesHas().length; i++)
		{
			ObservableList<String> currArrayList = FXCollections.observableArrayList();
			String currName = p.getRolesHas()[i];
			//currArrayList.addAll(p.getPage_links().get(currName));
			page_links.put(currName, currArrayList);
			
		}
		
	}
	public Page getPage()
	{
		return p;
	}
	public StringProperty getName() {
		return name;
	}
	public void setName(StringProperty name) {
		this.name = name;
	}
	public StringProperty getId() {
		return id;
	}
	public void setId(StringProperty id) {
		this.id = id;
	}
	public StringProperty getDescription() {
		return description;
	}
	public void setDescription(StringProperty description) {
		this.description = description;
	}
	public ObservableList<String> getExternal_links() {
		return external_links;
	}
	public void setExternal_links(ObservableList<String> external_links) {
		this.external_links = external_links;
	}
	public HashMap<String, ObservableList<String>> getPage_links() {
		return page_links;
	}
	public void setPage_links(HashMap<String, ObservableList<String>> page_links) {
		this.page_links = page_links;
	}
	public abstract PageTransitionModel create_transition(BorderPane view);
	
	
}
