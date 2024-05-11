package Search_Development;

public class DEpartment 
{
	private int dep_no;
	private String dep_name;
	public Personel[] personels;
	public Progetto[] projects;
	
	public int getDep_no() {
		return dep_no;
	}
	public void setDep_no(int dep_no) {
		this.dep_no = dep_no;
	}
	public String getDep_name() {
		return dep_name;
	}
	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}
	
	/*
	pubblic DEpartment(int dep_no, int dep_name, Personel[] personels, Progetto[] projects) {
		this.dep_no = dep_no;
		this.dep_name = dep_name;
		this.personels = personels;
		this.projects = projects;
	}
	*/
	
}
