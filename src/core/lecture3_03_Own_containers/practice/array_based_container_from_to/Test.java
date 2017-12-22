package core.lecture3_03_Own_containers.practice.array_based_container_from_to;

public class Test {

	public static void main(String[] args) throws Exception {
		ArrayBasedContainer<Integer> array = ArrayBasedContainer.getArray(-10, 0);
        Integer[] arr = {1,2,3,4,5,6,3,8,9,10,11};
        array.setArr(arr);
       // System.out.println(myArray.size());
        System.out.println(array.get(-7));
        System.out.println(array);
        array.set(-10,-20);
        System.out.println(array);
        array.remove(-10);
        System.out.println(array);
        System.out.println(array.indexOf(3));
        System.out.println(array.lastIndexOf(3));
        for (Integer integer : array) {
            System.out.print(integer+" ");
        }


	}

}
