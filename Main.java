package ru.epam.jonline.module2.d1_array_sort;

public class Main {

	public static void main(String[] args) {

		System.out.println("Algorithmization. Одномерные массивы. Сортировка");

		int[] arr1 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] arr2 = new int[] { 10, 20, 30, 5, 50, 65, 60, 15, 35 };
		double[] arr3 = new double[] { 11.9, 0.2, 21.1, 50.5, 50.6, 60.5, 60.0, 150, 30.5 };

		OneDimensionalArraySorting.firstTask(arr1, arr1, 4);
		OneDimensionalArraySorting.secondTask(new int[] { 1, 3, 5, 7, 8 }, new int[] { 2, 4, 6, 8 });
		OneDimensionalArraySorting.thirdTask(arr1);
		OneDimensionalArraySorting.fourthTask(arr1);
		OneDimensionalArraySorting.fifthTask(arr2);
		OneDimensionalArraySorting.sixthTask(arr3);
		OneDimensionalArraySorting.seventhTask(arr2, new int[] { 15, 25, 35, 45, 48, 55, 65, 69 });
		OneDimensionalArraySorting.eighthTask(arr1, new int[] { 15, 3, 30, 15, 10, 5, 5, 12, 3 });

	}

}
