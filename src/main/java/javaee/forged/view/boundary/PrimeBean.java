package javaee.forged.view.boundary;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class PrimeBean implements Serializable {

	private static final long serialVersionUID = -2403138950814741653L;
	private String name;

	public PrimeBean() {
		name = "John";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
