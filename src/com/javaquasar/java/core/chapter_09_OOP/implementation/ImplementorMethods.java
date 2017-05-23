package com.javaquasar.java.core.chapter_09_OOP.implementation;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class ImplementorMethods {

	public static void main(String[] args) {
		Impl implLikeA = new Impl(Impl.DoSomethingStrategy.InterfaceA);
		Impl implLikeB = new Impl(Impl.DoSomethingStrategy.InterfaceB);
		implLikeA.doSomething();
		implLikeB.doSomething();
	}

	static interface InterfaceA {
		void doSomething();
	}

	static interface InterfaceB {
		void doSomething();
	}

	static class Impl implements InterfaceA, InterfaceB {

		public enum DoSomethingStrategy {
			InterfaceA, InterfaceB
		}

		private DoSomethingStrategy strategy;

		public Impl(DoSomethingStrategy doSomethingStrategy) {
			this.strategy = doSomethingStrategy;
		}

		@Override
		public void doSomething() {
			switch (strategy) {
			case InterfaceA:
				System.out.println("InterfaceA");
				break;
			case InterfaceB:
				System.out.println("InterfaceB");
				break;
			}
		}
	}
}
