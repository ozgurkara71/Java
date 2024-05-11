package Search_Development;
import java.util.concurrent.atomic.AtomicInteger;

public class Personel 
{
	private static final AtomicInteger count = new AtomicInteger(2000);
	private int dep_no, per_age;
	private int per_id;
	private String per_name, per_surname;
	
	public int getDep_no() {
		return dep_no;
	}
	public void setDep_no(int dep_no) {
		this.dep_no = dep_no;
	}
	public int getPer_id() {
		return per_id;
	}
	public void setPer_id() {
		this.per_id = count.incrementAndGet();
	}
	public int getPer_age() {
		return per_age;
	}
	public void setPer_age(int per_age) {
		this.per_age = per_age;
	}
	public String getPer_name() {
		return per_name;
	}
	public void setPer_name(String per_name) {
		this.per_name = per_name;
	}
	public String getPer_surname() {
		return per_surname;
	}
	public void setPer_surname(String per_surname) {
		this.per_surname = per_surname;
	}
	
	
	
	
}
