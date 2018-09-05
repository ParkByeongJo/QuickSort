import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	public static void swap(Comparable[] a,int i,int j) {
		Comparable temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}

	public static int partition(Comparable[] a,int start,int end) {
		Comparable value=a[end];
		int i=start-1;
		for(int j=start;j<=end-1;++j) {
			if(a[j].compareTo(value)<0) {
				swap(a,++i,j);
			}
		}
		swap(a,i+1,end);
		return i+1;
	}

	public static void quickSort(Comparable[] a,int start,int end) {
		if(start>=end) {
			return;
		}
		int middle=partition(a,start,end);
		quickSort(a,start,middle-1);
		quickSort(a,middle+1,end);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random=new Random();
		Integer[] a= new Integer[10];
		for(int i=0;i<a.length;++i) {
			a[i]=random.nextInt(20);
		}

		System.out.println(Arrays.toString(a));
		quickSort(a,0,a.length-1);
		System.out.println(Arrays.toString(a));

		//String
		System.out.println("-----------String-----------");

		String[] sa="Pizza Chicken Hamburger FrenchFries Stake".split(" ");
		System.out.println(Arrays.toString(sa));
		quickSort(sa,0,sa.length-1);
		System.out.println(Arrays.toString(sa));

		//Person
		System.out.println("-----------Person-Before-----------");

		String[] data="Minsu Chulsu Junghee Minhee Gyeongsu Jaein Myungho Jaehee Jaehyun Jaeseok".split(" ");
		Person[] p=new Person[data.length];
		for(int i=0;i<p.length;i++) {
			p[i]=new Person(data[i]);
		}

		for(Person aP:p)
			System.out.println(aP.name);

		System.out.println("-----------Person-After-----------");
		quickSort(p,0,p.length-1);

		for(Person aP:p)
			System.out.println(aP.name);
	}

	static class Person implements Comparable{
		String name;

		public Person(String name) {
			this.name=name;
		}
		@Override
		public int compareTo(Object o) {
			return name.compareTo(((Person)o).name);
		}
	}
}
