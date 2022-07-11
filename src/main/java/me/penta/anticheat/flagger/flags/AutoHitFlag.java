package me.penta.anticheat.flagger.flags;

public class AutoHitFlag extends Flag{
    double hitError;
    public AutoHitFlag(double hitError) {
        this.name = "auto hit flag";
        this.hitError = hitError;
    }
}
