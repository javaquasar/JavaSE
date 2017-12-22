package core.lecture3.control.number_2;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class ApplicantComparator implements Comparator<Applicant> {

	@Override
	public int compare(Applicant arg0, Applicant arg1) {
		Collator collator = Collator.getInstance(new Locale("uk"));
		return collator.compare(arg0.getLastname(), arg1.getLastname());// arg0.getLastname().compareToIgnoreCase(arg1.getLastname());
	}

}
