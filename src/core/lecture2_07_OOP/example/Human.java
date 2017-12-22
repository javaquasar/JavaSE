package core.lecture2_07_OOP.example;

public class Human implements Cloneable {
	  private String name;
	  private String surname;
	  
	  public Human(String name, String surname) {
	    super();
	    this.name = name;
	    this.surname = surname;
	  }

	  @Override
	  public boolean equals(Object obj) {
	    Human h = (Human) obj;
	    return name.equals(h.name) && surname.equals(h.surname);
	  }

	  @Override
	  public Human clone() throws CloneNotSupportedException {
	    return (Human) super.clone();
	  }

	  @Override
	  public String toString() {
	    return name + " " + surname;
	  }

	  public static void main(String[] args) throws CloneNotSupportedException {
	    Human human1 = new Human("John", "Smith");
	    Human human2 = human1.clone();
	    System.out.println(human2);
	    human1.name = "Mary";
	    System.out.println(human1);
	    System.out.println(human2);
	    human2.name = new String("Mary");
	    System.out.println(human2);
	    System.out.println(human1.equals(human2)); // true
	  }

	}
