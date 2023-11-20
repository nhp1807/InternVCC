package exercise1.ex4;

import java.io.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Ex4 {
    public static void main(String[] args) {
        Set<Point> setA = generatePoint(8000, 800, 800, 400);
        Set<Point> setB = generatePoint(10000, 4000, 800, 500);
        Set<Point> setC = generatePoint(12000, 2400, 2400, 600);

        Set<Point> allPoints = new HashSet<>();
        allPoints.addAll(setA);
        allPoints.addAll(setB);
        allPoints.addAll(setC);

        String filePath = "src/exercise1/ex4/output4.txt";
        writeToFile(allPoints, filePath);
        readFile(filePath);
    }

    public static Set<Point> generatePoint(int size, int centerX, int centerY, int maxDistance){
        Set<Point> set = new HashSet<>();
        Random random = new Random();

        while (set.size() < size){
            int x = centerX + random.nextInt(maxDistance * 2) + 1 - maxDistance;
            int y = centerY + random.nextInt(maxDistance * 2) + 1 - maxDistance;

            double distance = Math.sqrt((x-centerX)*(x-centerX) + (y-centerY)*(y-centerY));
            if(distance > 400){
                continue;
            }
//            System.out.println(distance);
            Point point = new Point(x, y);

            boolean valid = true;

            for (Point p : set){
                if(p.equals(point)){
                    valid = false;
                    break;
                }
            }

            if(valid){
                set.add(point);
            }
        }

        return set;
    }

    public static void writeToFile(Set<Point> points, String filePath){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Point point : points) {
                writer.write(point.getX() + "," + point.getY() + "\n");
            }
            System.out.println("Successfully wrote points to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile(String filePath){
        int count = 0;
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line=br.readLine()) != null){
//                System.out.print((char) ch);
                count++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("So dong: " + count);
    }
}
