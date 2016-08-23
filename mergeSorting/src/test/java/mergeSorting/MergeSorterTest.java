package mergeSorting;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class MergeSorterTest {

	@Test
	public void mergeSortTest() {
		int[] testAry = {4, 99, 13, 82, 24, 45, 10};
		int[] sortedTest = MergeSorter.mergeSort(testAry);
		int[] assertSort = {4, 10, 13, 24, 45, 82, 99};
		assertTrue(Arrays.equals(sortedTest, assertSort));
	}
	
	@Test
	public void mergeSortRandomTest() {
		Random rand = new Random();
		int[] randAry = new int[20];
		boolean sorted = true;
		for (int i = 0; i < randAry.length; i++) {
			randAry[i] = rand.nextInt(500) + 1;
		}
		int[] sortedRand = MergeSorter.mergeSort(randAry);
		for (int j = 0; j < sortedRand.length - 1; j++) {
			if (sortedRand[j] > sortedRand[j+1]) {
				sorted = false;
			}
		}
		assertTrue(sorted);
	}
	
}
