package mergeSorting;

/**
 * Class used to mergesort array of ints.
 * Mergesorting consists of breaking the array into halves, then
 * breaking the halves into halves, until you are left with 
 * groups of 2. By sorting those small groups, it becomes much easier
 * to put the larger and larger groups together efficiently.
 * Mergesorting is O(n log n).
 * @author Samuel Shapiro
 *
 */

public abstract class MergeSorter {
	
	static int[] unsortAry; //input array
	static int[] sortedAry; //sorted version of input array
	
	/**
	 * main function of MergeSorter. Takes in outside array
	 * and sorts it.
	 * 
	 * @param unsortedAry - array to be sorted
	 * @return sorted array
	 */
	public static int[] mergeSort (int[] unsortedAry) {
		unsortAry = unsortedAry;
		
		//sorted array is initialized to be same length as unsorted
		sortedAry = new int[unsortAry.length];
		doSplitMerge(0, unsortAry.length - 1);
		
		
		return sortedAry;
	}
	
	/**
	 * Breaks down unsorted array by focusing on smaller and smaller chunks.
	 * If a chunk is bigger than one int, breaks it in half. Then recursively
	 * sorts the halves and then sorts them together.
	 * @param startPoint - starting point in chunk of unsorted array being looked at
	 * @param endPoint - end point in chunk of array
	 */
	public static void doSplitMerge(int startPoint, int endPoint) {
		if (startPoint < endPoint) {
			//gets the halfway point in the chunk
			int middle = startPoint + ((endPoint - startPoint) / 2);
			
			//looks at the left half of the chunk
			doSplitMerge(startPoint, middle);
			//looks at the right half of the chunk
			doSplitMerge(middle + 1, endPoint);
			
			//sorts the whole chunk by combining the (now sorted) halves
			doSort(startPoint, middle, endPoint);
		}
	}
	
	/**
	 * Because each half of the chunk is sorted, the mergesorter
	 * only needs to compare the "top" int in each half. Once an
	 * int has been added to the sorted array, a counter is used to 
	 * move to the next int in that half.
	 * @param start - start index of chunk
	 * @param middle - middle index of chunk
	 * @param end - end index of chunk
	 */
	public static void doSort(int start, int middle, int end) {
		int aCount = start; //counter for left half
		int bCount = middle + 1; //counter for right half
		int merger = start; //counter for sorted array
		
		//runs through while loop as long as both halves haven't been added
		while (aCount <= middle && bCount <= end) {
			//if current int of left is less than current int of right,
			//add left int to sorted array then move to next int in left
			if (unsortAry[aCount] <= unsortAry[bCount]) {
				sortedAry[merger++] = unsortAry[aCount++];
			}
			//same as above, but with right int less than left int
			else {
				sortedAry[merger++]  = unsortAry[bCount++];
			}
		}
		//if either half is "finished" first, add the rest of the
		//other half to the sorted array
		while (aCount <= middle) {
			sortedAry[merger++] = unsortAry[aCount++];
		}
		while (bCount <= end) {
			sortedAry[merger++] = unsortAry[bCount++];
		}
		
		//once both halves of chunk are sorted together,
		//replace original chunk in unsorted array with sorted chunk
		int j = end - start + 1;
		for (int i = 0; i < j; i++, end--) {
			unsortAry[end] = sortedAry[end];
		}
	}
	
}
