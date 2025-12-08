package hashmap_exercises;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumConsecutiveCardsTest {

    @Test
    void example1_givenInProblemStatement() {
        MinimumConsecutiveCards solver = new MinimumConsecutiveCards();
        int[] cards = {3, 4, 2, 3, 4, 7};
        int result = solver.minimumCardPickup(cards);
        assertEquals(4, result,
                "Expected minimum subarray length with duplicate cards to be 4");
    }

    @Test
    void noDuplicates_returnsMinusOne() {
        MinimumConsecutiveCards solver = new MinimumConsecutiveCards();
        int[] cards = {1, 2, 3, 4, 5};
        int result = solver.minimumCardPickup(cards);
        assertEquals(-1, result,
                "If all cards are unique, there is no valid subarray, so result should be -1");
    }

    @Test
    void duplicatesAdjacent() {
        MinimumConsecutiveCards solver = new MinimumConsecutiveCards();
        int[] cards = {5, 5};
        int result = solver.minimumCardPickup(cards);
        assertEquals(2, result,
                "Two equal adjacent cards should give a minimum subarray length of 2");
    }

    @Test
    void multiplePossibleSubarrays_chooseMinimum() {
        MinimumConsecutiveCards solver = new MinimumConsecutiveCards();
        int[] cards = {1, 2, 1, 3, 2};
        // Subarrays with duplicates:
        // [1,2,1] -> length 3; [2,1,3,2] -> length 4. Minimum = 3.
        int result = solver.minimumCardPickup(cards);
        assertEquals(3, result);
    }

    @Test
    void singleElementArray() {
        MinimumConsecutiveCards solver = new MinimumConsecutiveCards();
        int[] cards = {42};
        int result = solver.minimumCardPickup(cards);
        assertEquals(-1, result);
    }
}

