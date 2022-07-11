package me.penta.anticheat.utils.utils3d;


import org.bukkit.Bukkit;

public class Box {
    public Vector3 pos;
    public double width, height, depth;

    public Box(Vector3 pos, double width, double height, double depth) {
        this.pos = pos;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public Vector3 getPos() {
        return pos;
    }

    public void setPos(Vector3 pos) {
        this.pos = pos;
    }

    private boolean isInsideBox(Vector3 point) {
        return pos.x - width / 2 < point.x && pos.x + width / 2 > point.x &&
                pos.y - height / 2 < point.y && pos.y + height / 2 > point.y &&
                pos.z - depth / 2 < point.z && pos.z + depth / 2 > point.z;
    }

    public double getDistanceToBox(Vector3 point) {
        if (isInsideBox(point)) {
            return 0;
        }
        double minX = pos.x - width / 2;
        double maxX = pos.x + width / 2;

        double minY = pos.y - height / 2;
        double maxY = pos.y + height / 2;

        double minZ = pos.z - depth / 2;
        double maxZ = pos.z + depth / 2;

        double distanceX = Math.min(Math.abs(point.x - minX), Math.abs(point.x - maxX));
        double distanceY = Math.min(Math.abs(point.y - minY), Math.abs(point.y - maxY));
        double distanceZ = Math.min(Math.abs(point.z - minZ), Math.abs(point.z - maxZ));

        Bukkit.getLogger().info(String.format("V3(%s, %s, %s)", distanceX, distanceY, distanceZ));

        return Utils3d.getDistance(Vector3.empty, new Vector3(distanceX, distanceY, distanceZ));
    }
}
