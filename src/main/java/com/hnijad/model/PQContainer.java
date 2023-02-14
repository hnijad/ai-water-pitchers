package com.hnijad.model;

import java.util.Objects;

public class PQContainer implements Comparable<PQContainer> {
    private final Integer cost;
    private final PitchersState pitchersState;

    public PQContainer(int cost, PitchersState pitchersState) {
        this.cost = cost;
        this.pitchersState = pitchersState;
    }

    @Override
    public int compareTo(PQContainer o) {
        if (!this.cost.equals(o.getCost())) {
            return this.cost.compareTo(o.getCost());
        }
        for (int i = 0; i < this.pitchersState.getPitchers().size(); i++) {
            if (!this.pitchersState.getPitchers().get(i).equals(o.getPitcherState().getPitchers().get(i))) {
                return this.pitchersState.getPitchers().get(i).compareTo(o.getPitcherState().getPitchers().get(i));
            }
        }
        return 0;
    }

    public Integer getCost() {
        return cost;
    }

    public PitchersState getPitcherState() {
        return pitchersState;
    }

    @Override
    public String toString() {
        return "PQContainer{" +
                "cost=" + cost +
                ", pitcherState=" + pitchersState +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PQContainer that = (PQContainer) o;
        return Objects.equals(cost, that.cost) && Objects.equals(pitchersState, that.pitchersState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost, pitchersState);
    }
}