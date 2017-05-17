package com.javaquasar.java.core.chapter_22_Reference;

class BigObject {
	private int value;

	public BigObject(Integer pValue) {
		value = pValue;
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("BigObject (" + value + ") finalize()");
	}

	@Override
	public String toString() {
		return value + "";
	}
}
