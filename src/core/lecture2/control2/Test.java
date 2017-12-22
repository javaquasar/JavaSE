package core.lecture2.control2;

import core.lecture2.control2.Route.IncorrectParameters;
import core.lecture2.control2.Route.SameNodes;

public class Test {
	public static void main(String[] args) {
		Station kharkov = new Station("Харьков", 30);
		Station novoselovka = new Station("Новоселовка", 10);
		Station merefa = new Station("Мерефа", 40);
		Station lozovaja = new Station("Лозовая", 8);
		Station lyubotin = new Station("Люботин", 9);
		Station krasnohrad = new Station("Краснодар", 4);
		TransportSystem<Station> ts = new TransportSystem<>();
		try {
			ts.add(new Route<Station>(kharkov, novoselovka, 10, 0.2));
			ts.add(new Route<Station>(novoselovka, merefa, 20, 0.2));
			ts.add(new Route<Station>(merefa, lozovaja, 100, 0.2));
			ts.add(new Route<Station>(merefa, krasnohrad, 30, 0.2));
			ts.add(new Route<Station>(lyubotin, novoselovka, 40, 0.2));
			ts.add(new Route<Station>(lyubotin, merefa, 50, 0.2));
		} catch (SameNodes | IncorrectParameters e) {
			System.err.println(e);
		}
		System.out.println(ts);
		System.out.println(ts.getTheFastestRoute());
		System.out.println();
		System.out.println("Список станций");
		System.out.println(ts.getListOfNodes());
		System.out.println();
		System.out.println(ts.getNode(kharkov));
		System.out.println("Станции сортированные по количеству проходящих маршрутов");
		System.out.println(ts.getSortList());
	}
}
