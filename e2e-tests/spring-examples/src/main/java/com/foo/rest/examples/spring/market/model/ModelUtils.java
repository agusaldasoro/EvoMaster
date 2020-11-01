package com.foo.rest.examples.spring.market.model;


/** Common helper methods to facilitate the inner workings of model classes */
public class ModelUtils {
	private static final int[] PRIMES = {13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151};

	private ModelUtils() {
		throw new IllegalAccessError("Utility class");
	}

	/**
	 * @return a hash code obtained by combining the given values; each value is
	 * multiplied by one of the elements in {@link #PRIMES} to improve
	 * the quality of the combined hash value. Note that since 0 is often
	 * used to detect that a cached hash code has not yet been computed
	 * this method will never return 0 as the final value.
	 */
	public static int combineIntHashes(int... hashes) {
		int h = 0;
		for (int i = 0; i < hashes.length; i++)
			h += PRIMES[i % PRIMES.length] * hashes[i];
		return h == 0 ? PRIMES[0] : h;
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	public static String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n		");
	}
}