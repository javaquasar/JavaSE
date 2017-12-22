package core.lecture3.control.number_1;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailSrting {

	public static void main(String[] args) {
		MailSrting mailSrting = new MailSrting(10, Collator.getInstance(new Locale("uk")));
		mailSrting.add("в");
		mailSrting.add("о");
		mailSrting.add("ї");
		mailSrting.add("н");
		mailSrting.add("с");
		mailSrting.add("т");
		mailSrting.add("в");
		mailSrting.add("о");
		System.out.println(mailSrting);
		mailSrting.sortPrint();

	}
	
	//private FuncFormat<String> funcFormat;
	private MyQueue<String> queue; 
	private Collator collator;
	
	public MailSrting(int size, Collator collator) {
		this.queue = new MyQueue<>(size);
		this.collator = collator;
		//this.funcFormat = funcFormat;
	}

	public boolean add(String s) {
		Pattern p = Pattern.compile("[^0-9]");
		Matcher m = p.matcher(s);
		if (m.matches()) {
			queue.offer(s);
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		return queue.toString();
	}

	public void sortPrint() {

		// System.out.println(Arrays.asList(words)); // [возити, воля, воїн]
		// Осуществляем сортировку с учетом локализации:
		//Collator collator = Collator.getInstance(new Locale("uk"));
		
		/*String string = queue.toString();
		String[] words = string.split("\\n+");
		Arrays.sort(words, (s1, s2) -> collator.compare(s1, s2));
		System.out.println(Arrays.asList(words));*/

		ArrayList<String> ar = queue.getArray();
		ar.sort((s1, s2) -> collator.compare(s1, s2));
		System.out.println(ar.toString());
	}

}
