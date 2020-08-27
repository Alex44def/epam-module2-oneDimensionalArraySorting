package ru.epam.jonline.module2.d1_array_sort;

public class OneDimensionalArraySorting {

//	Заданы два одномерных массива с различным количеством элементов и натуральное число k. 
//	Объединить их в	один массив, включив /второй массив между k-м и (k+1) - м элементами первого, 
//	при этом не используя дополнительный массив

	public static void firstTask(int[] arr1, int[] arr2, int k) {
		System.out.printf("%nAnswer firstTask: %n");
		printIntArray(arr1);
		printIntArray(arr2);

		int n = 0;
		int[] arr3 = new int[arr1.length + arr2.length];

		for (int i = 0; i < arr3.length; i++) {
			if (i >= k && n < arr2.length) {
				arr3[i] = arr2[i - k];
				n++;
			} else {
				arr3[i] = arr1[i - n];
			}
		}

		printIntArray(arr3);
	}

//	Даны две последовательности. 
//	Образовать из них новую последовательность чисел так, чтобы она тоже была неубывающей. 
//	Примечание. Дополнительный массив не использовать

	public static void secondTask(int[] arr1, int[] arr2) {
		System.out.printf("%nAnswer secondTask: %n");
		printIntArray(arr1);
		printIntArray(arr2);

		int n = 0;
		int p = 0;
		int[] arr3 = new int[arr1.length + arr2.length];

		for (int i = 0; i < arr3.length; i++) {
			if (n >= arr2.length || p < arr1.length && arr1[p] < arr2[n]) {
				arr3[i] = arr1[p];
				p++;
			} else {
				arr3[i] = arr2[n];
				n++;
			}
		}

		printIntArray(arr3);
	}

//    Сортировка выбором. Дана последовательность чисел.Требуется переставить элементы так,
//    чтобы они были расположены по убыванию. Для этого в массиве, начиная с первого, выбирается наибольший
//    элемент и ставится на первое место, а первый - на место наибольшего. Затем, начиная со второго, эта процедура
//    повторяется. Написать алгоритм сортировки выбором

	public static void thirdTask(int[] arr) {
		System.out.printf("%nAnswer thirdTask: %n");
		printIntArray(arr);

		int max;
		int temp;

		for (int i = 0; i < arr.length; i++) {
			max = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[max] < arr[j]) {
					max = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[max];
			arr[max] = temp;
		}

		printIntArray(arr);
	}

//    Сортировка обменами. Дана последовательность чисел.Требуется переставить числа в
//    порядке возрастания. Для этого сравниваются два соседних числа. Если ai > ai+1, то делается
//    перестановка. Так продолжается до тех пор, пока все элементы не станут расположены в порядке возрастания.
//    Составить алгоритм сортировки, подсчитывая при этом количества перестановок

	public static void fourthTask(int[] arr) {
		System.out.printf("%nAnswer fourthTask: %n");
		printIntArray(arr);

		boolean check = true;
		int temp;
		int count = 0;

		while (check) {
			check = false;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					check = true;
					count++;
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}

		printIntArray(arr);
		System.out.printf("Количество перестановок: %d%n", count);
	}

//    Сортировка вставками. Дана последовательность чисел. Требуется переставить числа в порядке
//    возрастания. Делается это следующим образом. Пусть a1, a2,... ,ai - упорядоченная последовательность, т. е.
//    a1 <= a2... <= ai. Берется следующее число ai+1 и вставляется в последовательность так, чтобы новая
//    последовательность была тоже возрастающей. Процесс производится до тех пор, пока все элементы от i+1 до n
//    не будут перебраны. Примечание. Место помещения очередного элемента в отсортированную часть производить
//    с помощью двоичного поиска. Двоичный поиск оформить в виде отдельной функции

	public static void fifthTask(int[] arr) {
		System.out.printf("%nAnswer fifthTask: %n");
		printIntArray(arr);

		int i = 0;
		int n = 0;
		int temp;

		while (arr[i] <= arr[i + 1]) {
			i++;
		}

		for (int j = i + 1; j < arr.length; j++) {
			n = binarySearch(arr, 0, j, arr[j]);
			temp = arr[j];
			for (int k = j; k > n + 1; k--) {
				arr[k] = arr[k - 1];
			}
			arr[n + 1] = temp;
		}

		printIntArray(arr);
	}

//    Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.
//    Делается это следующим образом: сравниваются два соседних элемента ai и ai+1 . Если ai <= ai+1, то продвигаются
//    на один элемент вперед. Если ai > ai+1, то производится перестановка и сдвигаются на один элемент назад.
//    Составить алгоритм этой сортировки

	public static double[] sixthTask(double[] arr) {
		System.out.printf("%nAnswer sixthTask: %n");
		printDoubleArray(arr);

		double temp;
		int i = 0;

		while (i < arr.length - 1) {
			if (arr[i] <= arr[i + 1]) {
				i++;
			} else {
				temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
				i = i == 0 ? 0 : i - 1;
			}
		}

		printDoubleArray(arr);
		return arr;
	}

//    Пусть даны две неубывающие последовательности действительных чисел.
//    Требуется указать те места, на которые нужно вставлять элементы второй последовательности в первую так, 
//    чтобы новая последовательность оставалась возрастающей

	public static void seventhTask(int[] arr1, int[] arr3) {
		System.out.printf("%nAnswer seventhTask: %n");
		printIntArray(arr1);
		printIntArray(arr3);

		int[] arr = new int[arr3.length];
		int n;

		for (int j = 0; j < arr3.length; j++) {
			n = binarySearch(arr1, 0, arr1.length - 1, arr3[j]);
			arr[j] = n + j + 1;
		}

		System.out.println("С учетом количества сделанных вставок " + "\nэлементы второго массива надо расположить "
				+ "\nна следующих позициях первого массива: ");
		printIntArray(arr);
	}

//    Даны дроби. Составить программу, которая приводит эти дроби к общему
//    знаменателю и упорядочивает их в порядке возрастания

	public static void eighthTask(int[] arr1, int[] arr2) {
		System.out.printf("%nAnswer eighthTask: %n");
		System.out.print("Числители:   ");
		printIntArray(arr1);
		System.out.print("Знаменатели: ");
		printIntArray(arr2);

		int max = arr2[0];

		for (int i = 1; i < arr2.length; i++) {
			if (max < arr2[i]) {
				max = arr2[i];
			}
		}
		int k = 2;
		for (int i = 0; i < arr2.length; i++) {
			if (max % arr2[i] != 0) {
				max = max * k;
				k++;
				i = 0;
			}
		}
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = arr1[i] * (max / arr2[i]);
			arr2[i] = max;
		}

		System.out.println("Общий знаменатель равен: " + max);
		sortIntegerArray(arr1);
		System.out.print("Числители:   ");
		printIntArray(arr1);
		System.out.print("Знаменатели: ");
		printIntArray(arr2);
	}

	/*-------------------------------*/

	static void printIntArray(int[] arr) {
		for (int elem : arr) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}

	static void printDoubleArray(double[] arr) {
		for (double elem : arr) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}

	static int binarySearch(int arr[], int start, int end, int elem) {

		int mid = start + (end - start) / 2;

		if (elem < arr[start]) {
			return -1;
		}
		if (elem > arr[end]) {
			return end;
		}
		if (arr[mid] < elem && elem <= arr[mid + 1]) {
			return mid;
		}
		if (arr[mid] > elem) {
			return binarySearch(arr, start, mid - 1, elem);
		}
		return binarySearch(arr, mid + 1, end, elem);
	}
	
	public static void sortIntegerArray(int[] arr) {
		
		int max;
		int temp;

		for (int i = 0; i < arr.length; i++) {
			max = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[max] < arr[j]) {
					max = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[max];
			arr[max] = temp;
		}
	
	}
}
