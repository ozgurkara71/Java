package Search_Development;
import java.util.Scanner;
/*equals() -> girilen stringi digeriyle karsilastirir
  
 */
public class Main_Page 
{
	static Scanner kb = new Scanner(System.in);
	public static void main(String[] args) 
	{
		int choosen, dep_count, sequencer;
		DEpartment departments[];
		
		
		System.out.println("How many departments you will enter: ");
		departments = new DEpartment[kb.nextInt()];
		for(int i = 0; i < departments.length; i++)
		{
			sequencer = i + 1;
			departments[i] = new DEpartment();			
			System.out.println("Enter " + (sequencer) + ". department name: ");
			departments[i].setDep_name(kb.next());
			System.out.println("Enter department no: ");
			departments[i].setDep_no(kb.nextInt());
			System.out.println("Enter how many personel in that department: ");
			departments[i].personels = new Personel[kb.nextInt()];
			for(int j = 0; j < departments[i].personels.length; j++)
			{
				sequencer = j + 1;
				departments[i].personels[j] = new Personel();
				departments[i].personels[j].setPer_id();
				departments[i].personels[j].setDep_no(departments[i].getDep_no());
				System.out.println("Enter age of " + (sequencer) + ". personel: ");
				departments[i].personels[j].setPer_age(kb.nextInt());
				System.out.println("Enter name of " + (sequencer) + ". personel: ");
				departments[i].personels[j].setPer_name(kb.next());
				System.out.println("Enter surname of " + (sequencer) + ". personel: ");
				departments[i].personels[j].setPer_surname(kb.next());
			}
			System.out.println();
			System.out.println("Enter how many projects has that department: ");
			departments[i].projects = new Progetto[kb.nextInt()];
			for(int j = 0; j < departments[i].projects.length; j++)
			{
				sequencer = j + 1;
				departments[i].projects[j] = new Progetto();
				departments[i].projects[j].setProject_id();
				departments[i].projects[j].setDep_no(departments[i].getDep_no());
				System.out.println("Enter " + (sequencer) + ". project name: ");
				departments[i].projects[j].setProject_name(kb.next());
				System.out.println("Enter " + (sequencer) + ". project duration(months): ");
				departments[i].projects[j].setProject_duration(kb.nextInt());
				System.out.println("Enter " + (sequencer) + ". project cost(Tl): ");
				departments[i].projects[j].setProject_cost(kb.nextInt());
			}
			System.out.println("-------------------------------------------------------");
			System.out.println();
		}
			
		while(0 == 0)
		{
			System.out.println("--------------------- Main Menu -----------------------");
			System.out.println("1: Display\n"
						+ "2: Search\n"
						+ "3: Find\n"
						+ "4: Analyse\n"
						+ "0: Exit\n");
			System.out.println("Please make your decision: ");
			choosen = kb.nextInt();
			if(choosen == 0)
			{
				break;
			}
			else if(choosen == 1)
			{
				display(departments);
			}
			else if(choosen == 2)
			{
				search(departments);
			}
			else if(choosen == 3)
			{
				find(departments);
			}
			else if(choosen == 4)
			{
				analysis(departments);
			}
			else
			{
				System.out.println("Wrong keystroke! Please try again.");
			}
		}	
	}
	static void search(DEpartment departments[])
	{
		int choosen, search_control;
		String name;
		
		System.out.println("------------------ Searching Screen -------------------");
		System.out.println("1: Search by department name\n"
				+ "2: Search by personel name\n"
				+ "3: Search by project name\n");
		System.out.println("Please make your decision: ");
		choosen = kb.nextInt();
		search_control = 0;
		if(choosen == 1)//dep name
		{
			int sequencer;
			System.out.println("Enter name of the department: ");
			name = kb.next();
			for(int i = 0; i < departments.length; i++)
			{
				if(departments[i].getDep_name().equals(name))
				{
					System.out.println("Department: " + departments[i].getDep_name());
					System.out.println("Department no: " + departments[i].getDep_no());
					if(departments[i].personels.length > 0)
						System.out.println("\nPersonels:");
					else
						System.out.println("\nNo personels!");
					for(int j = 0; j < departments[i].personels.length; j++)
					{
						sequencer = j + 1;
						System.out.println();
						System.out.println((sequencer) + ". personel: " + departments[i].personels[j].getPer_name() + " " + departments[i].personels[j].getPer_surname());
						System.out.println("Id: " + departments[i].personels[j].getPer_id());
						System.out.println("Age: " + departments[i].personels[j].getPer_age());
					}
					if(departments[i].projects.length > 1)
						System.out.println("\nProjects:");
					else
						System.out.println("\nNo projects!");
					for(int j = 0; j < departments[i].projects.length; j++)
					{
						sequencer = j + 1;
						System.out.println();
						System.out.println((sequencer) + ". project:");
						System.out.println("Project name: " + departments[i].projects[j].getProject_name());
						System.out.println("Project id: " + departments[i].projects[j].getProject_id());
						System.out.println("Project cost(Tl): " + departments[i].projects[j].getProject_cost());
						System.out.println("Project duration(months): " + departments[i].projects[j].getProject_duration());
					}
					System.out.println();
					System.out.println("-------------------------------------------------------");
					System.out.println();
					search_control = 1;
				}
			}
		}
		else if(choosen == 2)//by personel name
		{
			System.out.println("Enter name of the personel: ");
			name = kb.next();
			for(int i = 0; i < departments.length; i++)
			{
					for(int j = 0; j < departments[i].personels.length; j++)
					{
						if(departments[i].personels[j].getPer_name().equals(name))
						{
							System.out.println();
							System.out.println("Department: " + departments[i].getDep_name());
							System.out.println("Department no: " + departments[i].getDep_no());
							System.out.println("\nPersonel: " + departments[i].personels[j].getPer_name() + " " + departments[i].personels[j].getPer_surname() );
							System.out.println("Id: " + departments[i].personels[j].getPer_id());
							System.out.println("Age: " + departments[i].personels[j].getPer_age());	
							search_control = 1;
							System.out.println();
							System.out.println("-------------------------------------------------------");
						}
					}
			}
		}
		else if(choosen == 3)//by project name
		{
			System.out.println("Enter name of the project: ");
			name = kb.next();
			for(int i = 0; i < departments.length; i++)
			{
					for(int j = 0; j < departments[i].projects.length; j++)
					{
						if(departments[i].projects[j].getProject_name().equals(name))
						{
							System.out.println();
							System.out.println("Department: " + departments[i].getDep_name());
							System.out.println("Department no: " + departments[i].getDep_no());
							System.out.println("Project name: " + departments[i].projects[j].getProject_name());
							System.out.println("Project id: " + departments[i].projects[j].getProject_id());
							System.out.println("\nProject cost(Tl): " + departments[i].projects[j].getProject_cost());
							System.out.println("Project duration(months): " + departments[i].projects[j].getProject_duration());
							search_control = 1;
							System.out.println();
							System.out.println("-------------------------------------------------------");
						}
					}
			}
		}
		if(search_control == 0)
			System.out.println("You entered wrong data or data is not existing! Try again.");
	}
	static void display(DEpartment departments[])
	{
		int sequencer;
		System.out.println("------------------ Displaying Screen ------------------");
		for(int i = 0; i <departments.length; i++)
		{
			System.out.println("Department: " + departments[i].getDep_name());
			System.out.println("Department no: " + departments[i].getDep_no());
			if(departments[i].personels.length > 0)
				System.out.println("\nPersonels:");
			else
				System.out.println("\nNo personels!");
			for(int j = 0; j < departments[i].personels.length; j++)
			{
				sequencer = j + 1;
				System.out.println();
				System.out.println((sequencer) +". personel: " + departments[i].personels[j].getPer_name() + " " + departments[i].personels[j].getPer_surname());
				System.out.println("Id: " + departments[i].personels[j].getPer_id());
				System.out.println("Age: " + departments[i].personels[j].getPer_age());
			}
			if(departments[i].projects.length > 0)
				System.out.println("\nProjects:");
			else
				System.out.println("\nNo projects!");
			for(int j = 0; j < departments[i].projects.length; j++)
			{
				sequencer = j + 1;
				System.out.println();
				System.out.println((sequencer) + ". project:");
				System.out.println("Project name: " + departments[i].projects[j].getProject_name());
				System.out.println("Project id: " + departments[i].projects[j].getProject_id());
				System.out.println("Project duration(months): " + departments[i].projects[j].getProject_duration());
				System.out.println("Project cost(Tl): " + departments[i].projects[j].getProject_cost());
			}
			System.out.println("-------------------------------------------------------");
			System.out.println();
		}
	}
	static void find(DEpartment departments[])
	{
		boolean bool = false;
		int choosen, wanted, find_control;
		
		System.out.println("------------------- Finding Screen --------------------");
		System.out.println("1: Find person by age\n"
				+ "2: Find progetto by duration\n"
				+ "3: Find progetto by cost\n");
		System.out.println("Please make your decision: ");
		choosen = kb.nextInt();
		find_control = 0;
		if(choosen == 1)//find per by age info
		{
			System.out.println("Enter age that you want to display: ");
			wanted = kb.nextInt();
			for(int i = 0; i < departments.length; i++)
			{
				for(int j = 0; j < departments[i].personels.length; j++)
				{
					if(departments[i].personels[j].getPer_age() == wanted)
					{
						System.out.println();
						System.out.println("Department: " + departments[i].getDep_name());
						System.out.println("Department no: " + departments[i].getDep_no());
						System.out.println("\nPersonel: " + departments[i].personels[j].getPer_name() + " " + departments[i].personels[j].getPer_surname());
						System.out.println("Id: " + departments[i].personels[j].getPer_id());
						find_control = 1;
						System.out.println();
						System.out.println("-------------------------------------------------------");
					}
				}
			}
		}
		else if(choosen == 2)//find progetto by duration
		{
			System.out.println("Enter project duration that you want to display: ");
			wanted = kb.nextInt();
			for(int i = 0; i < departments.length; i++)
			{
				
				for(int j = 0; j < departments[i].projects.length; j++)
				{
					if(departments[i].projects[j].getProject_duration() == wanted)
					{
						System.out.println();
						System.out.println("Department: " + departments[i].getDep_name());
						System.out.println("Department no: " + departments[i].getDep_no());
						System.out.println("\nProject name: " + departments[i].projects[j].getProject_name());
						System.out.println("Project id: " + departments[i].projects[j].getProject_id());
						System.out.println("Project duration(months): " + wanted);
						System.out.println("Project cost(Tl): " + departments[i].projects[j].getProject_cost());
						find_control = 1;
						System.out.println();
						System.out.println("-------------------------------------------------------");
					}
				}
			}
		}
		else if(choosen == 3)//find progetto by cost
		{
			System.out.println("Enter project cost that you want to display: ");
			wanted = kb.nextInt();
			for(int i = 0; i < departments.length; i++)
			{
				for(int j = 0; j < departments[i].projects.length; j++)
				{
					if(departments[i].projects[j].getProject_cost() == wanted)
					{
						System.out.println();
						System.out.println("Department: " + departments[i].getDep_name());
						System.out.println("Department no: " + departments[i].getDep_no());
						System.out.println("\nProject name: " + departments[i].projects[j].getProject_name());
						System.out.println("Project id: " + departments[i].projects[j].getProject_id());
						System.out.println("Project duration(months): " + departments[i].projects[j].getProject_duration());
						System.out.println("Project cost(Tl): " + departments[i].projects[j].getProject_cost());
						find_control = 1;
						System.out.println();
						System.out.println("-------------------------------------------------------");
					}
				}
			}
		}
		if(find_control == 0)
			System.out.println("You entered wrong data or data is not existing! Try again.");
	}
	static void analysis(DEpartment departments[])
	{
		boolean bool = false;
		int choosen, biggest = Integer.MIN_VALUE, smallest = Integer.MAX_VALUE, frequences[] = new int[4], total_data = 0;
		double average = 0;
		String lowest_temp = "", highest_temp = "";
		//we can make variable like that: Progetto highest;
		
		for(int i = 0; i < frequences.length; i++)
			frequences[i] = 0;
		System.out.println("------------------- Analysis Screen -------------------");
		System.out.println("1: Personel age analysis\n"
				+ "2: Project cost analysis");
		System.out.println("Please make your decision: ");
		choosen = kb.nextInt();
		System.out.println();
		if(choosen == 1)//make analyse of progetto by cost info
		{
			for(int i = 0; i < departments.length; i++)
			{
				for(int j = 0; j < departments[i].personels.length; j++)
				{
					if(departments[i].personels[j].getPer_age() > 20 && departments[i].personels[j].getPer_age() < 30)
						frequences[0]++;
					else if(departments[i].personels[j].getPer_age() > 31 && departments[i].personels[j].getPer_age() < 40)
						frequences[1]++;
					else if(departments[i].personels[j].getPer_age() > 41 && departments[i].personels[j].getPer_age() < 50)
						frequences[2]++;
					else if(departments[i].personels[j].getPer_age() > 50)
						frequences[3]++;
					average += departments[i].personels[j].getPer_age();
					total_data++;
				}
			}
			//Double averge = Double.valueOf(average / total_data);
			System.out.println("Number of staff aged between 20 - 30: " + frequences[0] 
					+ "\nNumber of staff aged between 30 - 40: " + frequences[1] 
					+ "\nNumber of staff aged between 40 - 50: " + frequences[2] 
					+ "\nNumber of staff aged over 50: " + frequences[3]);
			System.out.println("The average age of all personels: " + average / total_data);
		}
		else if(choosen == 2)//make analyse of personel by age info
		{
			for(int i = 0; i < departments.length; i++)
			{
				for(int j = 0; j < departments[i].projects.length; j++)
				{
					if(departments[i].projects[j].getProject_cost() > biggest)
					{
						biggest = departments[i].projects[j].getProject_cost();
						highest_temp = departments[i].projects[j].getProject_name();
					}
					if(departments[i].projects[j].getProject_cost() < smallest)
					{
						smallest = departments[i].projects[j].getProject_cost();
						lowest_temp = departments[i].projects[j].getProject_name();
					}
					average += departments[i].projects[j].getProject_cost();
					total_data++;
				}
			}
			System.out.println("Lowest cost project(Tl): " + lowest_temp
					+ "\nCost(Tl): " + smallest
					+ "\nHighest cost(Tl) project: " + highest_temp
					+ "\nCost(Tl): " + biggest
					+ "\nAverage cost(Tl) of all projects: " + average / total_data);
		}
	}	
	
}
