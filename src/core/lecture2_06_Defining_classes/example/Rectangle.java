package core.lecture2_06_Defining_classes.example;

class Rectangle {
	double width;
	double height;

	Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	Rectangle() {
		this(10, 20); // вызов другого конструктора
	}
}
