package com.hnijad;

import com.hnijad.model.Input;
import com.hnijad.model.PQContainer;
import com.hnijad.model.PitchersState;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    private static final int INF = 1_000_000_000;
    private final Input input;

    public Solution(Input input) {
        this.input = input;
    }

    public int getMinStepsUsingAStar() {
        if (input.getTarget() % getGcdAll() != 0) {
            return -1;
        }

        int n = input.getCapacity().size();

        PitchersState start = new PitchersState(n + 1);

        PriorityQueue<PQContainer> pq = new PriorityQueue<>();

        pq.add(new PQContainer(0, start));

        Map<PitchersState, Integer> minSteps = new HashMap<>();

        minSteps.put(start, 0);

        while (!pq.isEmpty()) {
            var current = pq.poll();
            if (current.getPitcherState().getLastElement() == input.getTarget()) {
                return minSteps.get(current.getPitcherState());
            }

            int newCost = minSteps.get(current.getPitcherState()) + 1;

            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == j) continue;
                    PitchersState nextState = new PitchersState(current.getPitcherState());
                    int x = nextState.getPitchers().get(i);
                    int y = nextState.getPitchers().get(j);
                    int cap = (j < n) ? input.getCapacity().get(j) : INF;
                    nextState.getPitchers().set(i, Math.max(0, x + y - cap));
                    nextState.getPitchers().set(j, Math.min(cap, x + y));

                    if (!minSteps.containsKey(nextState) || newCost < minSteps.get(nextState)) {
                        minSteps.put(nextState, newCost);
                        pq.add(new PQContainer(newCost + heuristic(nextState.getLastElement()), nextState));
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                PitchersState nextState = new PitchersState(current.getPitcherState());
                nextState.getPitchers().set(i, input.getCapacity().get(i));
                if (!minSteps.containsKey(nextState) || newCost < minSteps.get(nextState)) {
                    minSteps.put(nextState, newCost);
                    pq.add(new PQContainer(newCost + heuristic(nextState.getLastElement()), nextState));
                }
            }
        }
        return -1;
    }

    public int heuristic(int current) {
        return (int) ((Math.abs(input.getTarget() - current)) / input.getAvgCapacity());
    }

    public int getGcd(int a, int b) {
        if (b == 0) return a;
        return getGcd(b, a % b);
    }

    public int getGcdAll() {
        return input.getCapacity().stream().reduce(0, this::getGcd);
    }

    public static int log2(int n) {
        return (int)(Math.log(n) / Math.log(2));
    }
}