package core.lecture3_05_IO_Stream.practice.task_5_03_2;

import java.io.*;
import java.util.*;

public class IntSortTester {
	
	public static void main(String[] args) {
		Queue<Integer> queue = new PriorityQueue<>(100,(i1,i2) -> Integer.compare(i2,i1));
		try (DataInputStream in = new DataInputStream(new FileInputStream("./file/lecture_3_05_task_5_03_even.dat"))){
			try{
				while(true){
					int x = in.readInt();
					queue.add(x);
				}
			}
			catch(Exception e){
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		try (DataInputStream in = new DataInputStream(new FileInputStream("./file/lecture_3_05_task_5_03_uneven.dat"))){
			try{
				while(true){
					int x = in.readInt();
					queue.add(x);
				}
			}
			catch(Exception e){
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		try (PrintWriter pw = new PrintWriter("./file/lecture_3_05_task_5_03_sort_dat.txt")) {
			Integer k;
		    while ((k = queue.poll()) != null)
		    {
		      pw.println(k); 
		    }
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
