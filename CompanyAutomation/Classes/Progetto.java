package Search_Development;
import java.util.concurrent.atomic.AtomicInteger;

public class Progetto 
{
	private static final AtomicInteger count = new AtomicInteger(3000);
	private int dep_no, project_duration, project_cost;
	private int project_id;
 	private String project_name;
	
	public int getDep_no() {
		return dep_no;
	}
	public void setDep_no(int dep_no) {
		this.dep_no = dep_no;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id() {
		this.project_id = count.incrementAndGet();
	}
	public int getProject_duration() {
		return project_duration;
	}
	public void setProject_duration(int project_duration) {
		this.project_duration = project_duration;
	}
	public int getProject_cost() {
		return project_cost;
	}
	public void setProject_cost(int project_cost) {
		this.project_cost = project_cost;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	
	
	
	
}
