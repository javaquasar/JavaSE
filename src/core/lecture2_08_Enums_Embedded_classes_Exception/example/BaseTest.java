package core.lecture2_08_Enums_Embedded_classes_Exception.example;

public class BaseTest {
	static void showBase(Base b) {
		b.show();
	}

	public static void main(String[] args) {
		showBase(new Base(10) {
			void show() {
				System.out.println(k);
			}
		});
	}

}