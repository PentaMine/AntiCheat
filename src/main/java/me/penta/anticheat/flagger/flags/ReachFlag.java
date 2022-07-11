package me.penta.anticheat.flagger.flags;

import me.penta.anticheat.flagger.FlagTypes;

public class ReachFlag extends Flag {
    double reach;
    FlagTypes.ReachType type;
    public ReachFlag(double reach, FlagTypes.ReachType type) {
        this.name = "reach flag";
        this.reach = reach;
        this.type = type;
    }
}
