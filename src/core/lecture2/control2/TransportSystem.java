package core.lecture2.control2;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class TransportSystem<T> {

	private List<Route<T>> route = new ArrayList<Route<T>>();

	public void add(Route<T> newRoute) {
		route.add(newRoute);
	}

	public List<Route<T>> getListOfRoutes() {
		return route;
	}

	public String getTheFastestRoute() {
		@SuppressWarnings("unchecked")
		Route<T> result = (Route<T>) Collections.max(route, new Comparator() {
			@Override
			public int compare(Object arg0, Object arg1) {
				Route<T> first = (Route<T>) arg0;
				Route<T> second = (Route<T>) arg1;
				return Double.compare(first.getSpeed(), second.getSpeed());
			}
		});
		return "Самый быстрый маршрут: " + result.toString();
	}

	public Set<T> getListOfNodes() {
		Set<T> set = new HashSet<T>();
		for (Route<T> rt : getListOfRoutes()) {
			set.add(rt.getFirst());
			set.add(rt.getSecond());
		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Список узлов:\n");
		for (T rt : set) {
			stringBuilder.append(rt + "\n");
		}
		return set;// stringBuilder.toString();
	}

	public String getNode(T node) {
		Set<T> set = new HashSet<T>();
		for (Route<T> rt : getListOfRoutes()) {
			if (rt.getFirst().equals(node)) {
				set.add(rt.getSecond());
				getNode(node, rt.getSecond(), set);
			}
			if (rt.getSecond().equals(node)) {
				set.add(rt.getFirst());
				getNode(node, rt.getFirst(), set);
			}
		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Из пункта " + node
				+ " можно добраться в пункты:\n");
		for (T rt : set) {
			stringBuilder.append(rt.toString() + "\n");
		}
		return stringBuilder.toString();
	}

	private void getNode(T node1, T node2, Set<T> set) {
		for (Route<T> rt : getListOfRoutes()) {
			T first = rt.getFirst();
			T second = rt.getSecond();
			if (first.equals(node2) && !second.equals(node1)) {
				set.add(second);
			}
			if (second.equals(node2) && !first.equals(node1)) {
				set.add(first);
			}
		}
	}

	public List<T> getSortList() {
		final List<T> temp = new ArrayList<T>();
		for (Route<T> x : route) {
			temp.add(x.getFirst());
			temp.add(x.getSecond());
		}
		Set<T> set = getListOfNodes();
		List<T> ar = new ArrayList<T>(set);
		Collections.sort(ar, new Comparator<T>() {
			@Override
			public int compare(T object0, T object1) {
				return -Integer.compare(Collections.frequency(temp, object0),
						Collections.frequency(temp, object1));
			}
		});
		return ar;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Список маршрутов:\n");
		for (Route<T> rt : getListOfRoutes()) {
			stringBuilder.append(rt.toString() + "\n");
		}
		return stringBuilder.toString();
	}
}
