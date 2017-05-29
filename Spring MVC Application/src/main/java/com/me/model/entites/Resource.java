package com.me.model.entites;

import java.math.BigDecimal;
import java.util.Arrays;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="file")
public class Resource
{
	private Long resourceId;
	private String name;
	private String type;
	private BigDecimal cost;
	private String unitOfMesure;
	private String[] indicators;
	private String notes;
	
	
	public Resource() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Resource(Long resourceId, String name, String type, BigDecimal cost, String unitOfMesure) {
		super();
		this.resourceId = resourceId;
		this.name = name;
		this.type = type;
		this.cost = cost;
		this.unitOfMesure = unitOfMesure;
	}





	public String[] getIndicators() {
		return indicators;
	}
	public void setIndicators(String[] indicators) {
		this.indicators = indicators;
	}
	public Long getResourceId() {
		return resourceId;
	}
	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public String getUnitOfMesure() {
		return unitOfMesure;
	}
	public void setUnitOfMesure(String unitOfMesure) {
		this.unitOfMesure = unitOfMesure;
	}
	
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public String toString() {
		return "Resource [resourceId=" + resourceId + ", name=" + name + ", type=" + type + ", cost=" + cost
				+ ", unitOfMesure=" + unitOfMesure + ", indicators=" + Arrays.toString(indicators) + ", notes=" + notes
				+ "]";
	}
	
}
