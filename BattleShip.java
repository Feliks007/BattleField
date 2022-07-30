/*
BattleFiels
*/
import java.util.Arrays;

public class BattleShip {
    public static String ship = "🚢";
    public static String wave = "🌊";
    public static String hit = "💥";
    public static int width = 10;
    public static int height = 10;
    public static String[][] sea = new String[height][width];
    public static int[][] bombs = new int[height][width];
    public static int loops = 0;
    public static int shipsLeft=10;

    // Placement of ships
    public  static void shipPlacement(){
        for(int k=0; k< height; k++){
            Arrays.fill(sea[k], wave);
            int x = (int) (Math.random() *width);
            sea[k][x] = ship;
        }
    }

    // Playing field printing
    public static  void printField(){
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                System.out.print(sea[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    // Bomb placement
    public static void bombPlacement(){
        for(int k=0; k< height; k++){
            Arrays.fill(bombs[k], 0);
            for(int i=0; i< 10; i++){
                int x = (int) (Math.random() *width);
                if (bombs[k][x] == 0){
                    bombs[k][x] = 1;
                }
                else{
                    i--;
                }
            }
        }
    }

    // Аttack ships with bombs
    public  static void attack(){
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if ((sea[i][j].equals(ship)) && bombs[i][j] == 1){
                    sea[i][j] = hit;
                    shipsLeft = shipsLeft - 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        shipPlacement();
        printField();
        for(; ostalos > 0; ){
            bombPlacement();
            attack();
            printField();
        }
        //printField();
    }
}}