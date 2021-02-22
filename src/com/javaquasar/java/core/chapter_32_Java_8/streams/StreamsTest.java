package com.javaquasar.java.core.chapter_32_Java_8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsTest {
	public static void main(String[] args) {
		/*
		Predicate<T>
		Consumer<T>
		Function<T,R>
		Supplier<T>
		UnaryOperator<T>
		BinaryOperator<T>
		 */

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Predicate<Integer> isEvenNumber  = x -> x % 2 == 0;
		list
				.stream()
				.filter(isEvenNumber)
				.forEach(
						System.out::println
				);

		List<String> myList =
				Arrays.asList("a1", "a2", "b1", "c2", "c1");

		myList
				.stream()
				.filter(s -> s.startsWith("c"))
				.map(String::toUpperCase)
				.sorted()
				.forEach(System.out::println);

		Arrays.asList("a1", "a2", "a3")
				.stream()
				.findFirst()
				.ifPresent(System.out::println);  // a1

		Stream.of("a1", "a2", "a3")
				.findFirst()
				.ifPresent(System.out::println);  // a1

		IntStream.range(1, 4)
				.forEach(System.out::println);

		Arrays.stream(new int[] {1, 2, 3})
				.map(n -> 2 * n + 1)
				.average()
				.ifPresent(System.out::println);  // 5.0

		Stream.of("a1", "a2", "a3")
				.map(s -> s.substring(1))
				.mapToInt(Integer::parseInt)
				.max()
				.ifPresent(System.out::println);  // 3

		IntStream.range(1, 4)
				.mapToObj(i -> "a" + i)
				.forEach(System.out::println);

		Stream.of(1.0, 2.0, 3.0)
				.mapToInt(Double::intValue)
				.mapToObj(i -> "a" + i)
				.forEach(System.out::println);

		Stream.of("d2", "a2", "b1", "b3", "c")
				.filter(s -> {
					System.out.println("filter: " + s); // it is lazy blocke code
					return true;
				})
				.forEach(s -> System.out.println("forEach: " + s));
		/*
		filter:  d2
		forEach: d2
		filter:  a2
		forEach: a2
		filter:  b1
		forEach: b1
		filter:  b3
		forEach: b3
		filter:  c
		forEach: c
		 */

		Stream.of("d2", "a2", "b1", "b3", "c")
				.map(s -> {
					System.out.println("map: " + s);
					return s.toUpperCase();
				})
				.anyMatch(s -> {
					System.out.println("anyMatch: " + s);
					return s.startsWith("A");
				});

		// map:      d2
		// anyMatch: D2
		// map:      a2
		// anyMatch: A2

		Stream.of("d2", "a2", "b1", "b3", "c")
				.sorted((s1, s2) -> {
					System.out.printf("sort: %s; %s\n", s1, s2);
					return s1.compareTo(s2);
				})
				.filter(s -> {
					System.out.println("filter: " + s);
					return s.startsWith("a");
				})
				.map(s -> {
					System.out.println("map: " + s);
					return s.toUpperCase();
				})
				.forEach(s -> System.out.println("forEach: " + s));

		/*
		sort:    a2; d2
		sort:    b1; a2
		sort:    b1; d2
		sort:    b1; a2
		sort:    b3; b1
		sort:    b3; d2
		sort:    c; b3
		sort:    c; d2
		filter:  a2
		map:     a2
		forEach: A2
		filter:  b1
		filter:  b3
		filter:  c
		filter:  d2
		 */

		Stream.of("d2", "a2", "b1", "b3", "c")
				.filter(s -> {
					System.out.println("filter: " + s);
					return s.startsWith("a");
				})
				.sorted((s1, s2) -> {
					System.out.printf("sort: %s; %s\n", s1, s2);
					return s1.compareTo(s2);
				})
				.map(s -> {
					System.out.println("map: " + s);
					return s.toUpperCase();
				})
				.forEach(s -> System.out.println("forEach: " + s));

		// filter:  d2
		// filter:  a2
		// filter:  b1
		// filter:  b3
		// filter:  c
		// map:     a2
		// forEach: A2

		Supplier<Stream<String>> streamSupplier =
				() -> Stream.of("d2", "a2", "b1", "b3", "c")
						.filter(s -> s.startsWith("a"));

		streamSupplier.get().anyMatch(s -> true);   // ok
		streamSupplier.get().noneMatch(s -> true);  // ok

		IntStream.range(1, 4)
				.mapToObj(i -> new Foo("Foo" + i))
				.peek(f -> IntStream.range(1, 4)
						.mapToObj(i -> new Bar("Bar" + i + " <- " + f.name))
						.forEach(f.bars::add))
				.flatMap(f -> f.bars.stream())
				.forEach(b -> System.out.println(b.name));
	}
}

class Foo {
	String name;
	List<Bar> bars = new ArrayList<>();

	Foo(String name) {
		this.name = name;
	}
}

class Bar {
	String name;

	Bar(String name) {
		this.name = name;
	}
}
