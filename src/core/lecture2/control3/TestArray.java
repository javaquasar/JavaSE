package core.lecture2.control3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import core.lecture2.control3.JaggedArray.IncorrectParameters;

public class TestArray {

	public static void main(String[] args) {
		
	    /*ArrayList<Integer> df = new ArrayList<>();
	    df.add(0);
	    df.add(1);
	    df.add(2);
	    df.add(3);
	    df.add(1, 23);
	    df.set(0, df.get(0)+1);
	    System.out.println(df);
		System.out.println(df.size());*/
		
		JaggedArray<Integer> integer = null;
		JaggedArray<String> str = null;
		
		TypeArray type = TypeArray.ARRAY;
		switch (type) {
		case OBJECT:
			integer = new ContainerObject<>();
			str = new ContainerObject<>();
			break;
		case DOUBLE_ARRAY:
			integer = new ContainerDoubleArray<>();
			str = new ContainerDoubleArray<>();
			break;
		case ARRAY:
			integer = new ContainerArray<>();
			str = new ContainerArray<>();
			break;
		}
		
		JaggedArray<Integer> res;
		try {
			res = TestArray.getArrayWithNumbers(5, integer);
		
		res.printMyArray();
		//str.addElement(0, "яблоко");
		str.addLine();
		str.addLine();
		str.addLine();
		str.addElement(0, "яблоко");
		str.addElement(2, "конь");
		str.addElement(0, "апельсин");
		str.addElement(0, "конь");
		str.addElement(0, "банан");
		str.addElement(1, "яблоко");
		str.addElement(1, "волк");
		str.addElement(1, "лиса");
		str.addElement(2, "яблоко");
		str.addElement(2, "конь");
		str.printMyArray();
		List<String> vb = getListWithStrings(str);
		System.out.println(vb);
		str.addElement(20, "конь");
		} catch (IncorrectParameters e) {
			System.out.println(e);
			System.out.println("ROW = " + e.getRow());
			System.out.println("COL = " + e.getCol());
		}

	}

	public static JaggedArray<Integer> getArrayWithNumbers(int amount, JaggedArray<Integer> result) throws IncorrectParameters {
		int firstIndex = 0;
		int secondIndex = 10;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < amount; i++) {
			list.clear();
			for (int j = firstIndex; j <= secondIndex; j++) {
				if (j == 0 || j == 1)
					continue;
				boolean flag = true;
				for (int k = 2; k < j; k++) {
					if (j % k == 0) {
						flag = false;
						break;
					}
				}
				if (flag) {
					list.add(j);
				}
			}
			Integer[] resultMas = new Integer[list.size()];
			for (int j = 0; j < list.size(); j++) {
				resultMas[j] = list.get(j);
			}
			result.addLine();
			for (int j = 0; j < resultMas.length; j++) {
				result.addElement(result.getRowsCout() - 1, resultMas[j]);
			}
			firstIndex += 10;
			secondIndex += 10;
		}
		return result;
	}

	public static List<String> getListWithStrings(JaggedArray<String> mainField) throws IncorrectParameters {
		final List<String> temp = new ArrayList<String>();
		for (int i = 0; i < mainField.getRowsCout(); i++) {
			for (int j = 0; j < mainField.getSizeLine(i); j++) {
				temp.add(mainField.getElement(i, j));
			}
		}
		Set<String> set = new HashSet<>(temp);
		List<String> ar = new ArrayList<>(set);
		Collections.sort(ar, new Comparator<String>() {
			@Override
			public int compare(String object0, String object1) {
				return -Integer.compare(Collections.frequency(temp, object0), Collections.frequency(temp, object1));
			}
		});
		return ar;
	}
}
