package core.lecture3.control.number_2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InformationAboutApplicants implements java.io.Serializable {
	
	private static final long serialVersionUID = -3536722853756147665L;
	private Map<String, Applicant> applicants;
	private static final Pattern pattern = Pattern.compile("[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}");
	private static Matcher matcher;
	
	public InformationAboutApplicants() {
		this.applicants = new HashMap<>();
	}
	
	public void add(Applicant applicant) {
		if(!applicants.containsKey(applicant.getLastname() + " " + applicant.getName())) {
			matcher = pattern.matcher(applicant.getEmail());
			if(matcher.matches()) {
				applicants.put((applicant.getLastname() + " " + applicant.getName()), applicant);
				System.out.println("Претендент добавлен!");
			} else {
				System.out.println("Неверный email!");
			}
		} else {
			System.out.println("Пользователь " + applicant.getLastname() + " " + applicant.getName() + " уже добавлен!");
		}
	}
	
	/*public Applicant getApplicant(String s) {
		return applicants.get(s);
	}*/

	public Map<String, Applicant> getApplicants() {
		return applicants;
	}

	public void setApplicants(Map<String, Applicant> applicants) {
		this.applicants = applicants;
	}

	public static void main(String[] args) {
		
		HashSet<String> set = new HashSet<>();
		set.add("java");
		set.add("c++");
		
		Applicant[] applicants = new Applicant[6];
		
		applicants[0] = new Applicant("Артур", "Бузов", 1990, 5, 14, "c0nst@money.simply.net", set);
		applicants[1] = new Applicant("Артур", "Бузов", 1990, 5, 14, "somebody@dev", set);
		applicants[2] = new Applicant("Павел", "Картавкин", 1990, 5, 14, "Name.Sur_name@gmail.com", set);
		applicants[3] = new Applicant("Олег", "Синяговский", 1990, 5, 14, "buzov.artur@gmail.com", set);
		applicants[4] = new Applicant("Кирил", "Подкуйко", 1990, 5, 14, "buzov.artur@yandex.ru", set);
		applicants[5] = new Applicant("Светлана", "Крыжний", 1990, 5, 14, "12b3R33$somewhere.in.the.net", set);
		
		InformationAboutApplicants iaa = new InformationAboutApplicants();
		
		for(Applicant a : applicants) {
			iaa.add(a);
		}
	}
	
	public String toString() {
		Comparator<Applicant> comparator = new ApplicantComparator();
		PriorityQueue<Applicant> priorityQueue = new PriorityQueue<>(comparator);
		for (Map.Entry<String, Applicant> entry : applicants.entrySet())
		{
		    priorityQueue.add(entry.getValue());
		}
		StringBuilder stringBuilder = new StringBuilder();
		while (priorityQueue.size() != 0)
        {
			stringBuilder.append(priorityQueue.remove());
        }
		
		return stringBuilder.toString();
	}

}
