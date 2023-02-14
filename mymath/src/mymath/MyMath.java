package mymath;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MyMath {

	/**
	 * Computes the square root (rounded down) of the given
	 * nonnegative number.
	 * 
	 * @pre The given number is nonnegative.
	 *     | 0 <= x
	 * @post The result equals the square root (rounded down) of
	 *       the given number.
	 *     | 0 <= result &&
	 *     | result * result <= x &&
	 *     | x < (result + 1) * (result + 1)
	 */
	static int sqrt(int x) {
		int r = 0;
		while ((r + 1) * (r + 1) <= x)
			r++;
		return r;
	}
	
	/**
	 * @pre | numbers != null
	 * @pre | numbers.length >= 1
	 * @post | Arrays.stream(numbers).allMatch(x -> result <= x)
	 * @post | Arrays.stream(numbers).anyMatch(x -> x == result)
	 */
	static int minimum(int[] numbers) {
		int result = numbers[0];
		for (int i = 1; i < numbers.length; i++)
			if (numbers[i] < result)
				result = numbers[i];
		return result;
	}
	
	/**
	 * Finds the index where the given value belongs in the given sorted array.
	 * @pre | numbers != null
	 * @pre | IntStream.range(1, numbers.length).allMatch(i -> numbers[i - 1] <= numbers[i])
	 * @post | 0 <= result && result <= numbers.length
	 * @post | IntStream.range(0, result).allMatch(i -> numbers[i] < value)
	 * @post | IntStream.range(result, numbers.length).allMatch(i -> value <= numbers[i]) 
	 */
	static int binarySearch(int[] numbers, int value) {
		int lo = 0;
		int hi = numbers.length;
		while (lo < hi) {
			int middle = lo + (hi - lo) / 2;
			if (numbers[middle] < value)
				lo = middle + 1;
			else
				hi = middle;
		}
		return lo;
	}
	
	/**
	 * Inserts the given value into the sequence of numbers stored in the given sorted array
	 * at indices 0 (inclusive) through n (exclusive).
	 * @pre | numbers != null
	 * @pre | 0 <= n && n < numbers.length
	 * @pre | IntStream.range(1, n).allMatch(i -> numbers[i - 1] <= numbers[i])
	 * @post | IntStream.range(1, n + 1).allMatch(i -> numbers[i - 1] <= numbers[i])
	 * @post | IntStream.range(0, n + 1).allMatch(i ->
	 *       |     IntStream.range(0, n + 1).filter(j -> numbers[j] == numbers[i]).count() ==
	 *       |     (numbers[i] == value ? 1 : 0) +
	 *       |     IntStream.range(0, n).filter(j -> old(numbers.clone())[j]
	 *       |     == numbers[i]).count()
	 *       | )
	 */
	static void insert(int[] numbers, int n, int value) {
		int i = 0;
		while (i < n && numbers[i] < value)
			i++;
		for (int j = n; i < j; j--)
			numbers[j] = numbers[j - 1];
		numbers[i] = value;
	}
	
	/** Sorts the given array of numbers.
	 * 
	 * TODO: Schrijf volledige formele documentatie.
	 */
	static void insertionSort(int[] numbers) {
		// TODO: Implementeer.
	}

}
