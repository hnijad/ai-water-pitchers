package com.hnijad;

import com.hnijad.model.Input;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void getMinStepsUsingAStar_when_there_is_solution() {
        Solution sol = new Solution(new Input(List.of(3, 5), 4));

        assertEquals(sol.getMinStepsUsingAStar(), 7);

        Solution sol2 = new Solution(new Input(List.of(1, 5), 1));
        assertEquals(sol2.getMinStepsUsingAStar(), 2);
    }

    @Test
    void getMinStepsUsingAStar_when_there_is_no_solution() {
        Solution sol = new Solution(new Input(List.of(2, 4), 1));

        assertEquals(sol.getMinStepsUsingAStar(), -1);
    }


    @Test
    void heuristic() {
        Solution sol = new Solution(new Input(List.of(1, 2), 4));

        assertEquals(sol.heuristic(12), 5);
    }

    @Test
    void getGcd() {
        Solution sol = new Solution(new Input(List.of(1, 2), 4));

        assertEquals(sol.getGcd(12, 6), 6);
        assertEquals(sol.getGcd(0, 5), 5);
        assertEquals(sol.getGcd(1, 5), 1);
    }

    @Test
    void getGcdAll() {
        // test gcd of capacities of pitcher
        Solution sol = new Solution(new Input(List.of(2, 2, 4), 4));
        assertEquals(sol.getGcdAll(), 2);
    }
}