package me.penta.anticheat.utils.utils3d;

import org.bukkit.Location;

public class Utils3d {
    public static double getDistance(Vector3 startPos, Vector3 endPos){
        return Math.sqrt(
                Math.pow(Math.abs(startPos.x - endPos.x), 2) +
                Math.pow(Math.abs(startPos.y - endPos.y), 2) +
                Math.pow(Math.abs(startPos.z - endPos.z), 2)
        );
    }

    public static double getDistance(Location start, Location end){
        Vector3 startPos = new Vector3(start);
        Vector3 endPos = new Vector3(end);
        return Math.sqrt(
                Math.pow(Math.abs(startPos.x - endPos.x), 2) +
                Math.pow(Math.abs(startPos.y - endPos.y), 2) +
                Math.pow(Math.abs(startPos.z - endPos.z), 2)
        );
    }
}
