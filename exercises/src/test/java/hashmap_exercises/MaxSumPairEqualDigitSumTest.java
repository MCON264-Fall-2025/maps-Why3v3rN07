package hashmap_exercises;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxSumPairEqualDigitSumTest {

    @Test
    void exampleFromDescription() {
        MaxSumPairEqualDigitSum solver = new MaxSumPairEqualDigitSum();
        int[] nums = {18, 43, 36, 13, 7};
        int result = solver.maximumSum(nums);
        assertEquals(54, result,
                "Best pair is (18, 36) because both have digit sum 9 and 18+36=54");
    }

    @Test
    void noValidPair_returnsMinusOne() {
        MaxSumPairEqualDigitSum solver = new MaxSumPairEqualDigitSum();
        int[] nums = {10, 21, 32}; // digit sums: 1, 3, 5 -> all distinct
        int result = solver.maximumSum(nums);
        assertEquals(-1, result,
                "If no two numbers share the same digit sum, result should be -1");
    }

    @Test
    void multiplePairs_chooseMaximumSum() {
        MaxSumPairEqualDigitSum solver = new MaxSumPairEqualDigitSum();
        int[] nums = {51, 42, 60, 33};
        // digit sums: 6, 6, 6, 6
        // all pairs share same digit sum 6
        // max pair sum is 60 + 51 = 111
        int result = solver.maximumSum(nums);
        assertEquals(111, result);
    }

    @Test
    void digitSumHelper_basicExamples() {
        MaxSumPairEqualDigitSum solver = new MaxSumPairEqualDigitSum();
        assertEquals(9, solver.digitSum(18));
        assertEquals(7, solver.digitSum(34));
        assertEquals(1, solver.digitSum(10));
        assertEquals(0, solver.digitSum(0));
    }
}

