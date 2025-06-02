
package hamzakhouli;



import java.util.Scanner;

public class HamzaKhouli {

    public static void main(String[] args) {
        char[][] map = {
            {'#', '!', '.', '.', 'R', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.'},
            {'.', '.', '#', '.', '.', '.', '#', '.', 'H', '.', '.', '.', '.', '.', '!'},
            {'F', '.', '.', '.', '#', '.', '!', '.', '.', 'R', '.', '.', '#', '#', '.'},
            {'.', '.', '#', '.', '.', '#', '.', '.', '.', '.', 'F', '.', '.', '.', '.'},
            {'.', '!', '.', '.', '#', '.', '#', '.', '#', '.', '.', '#', '.', '.', '.'},
            {'.', '.', 'H', '.', '.', '!', '.', '.', 'H', '.', '.', 'F', '.', '.', 'R'},
            {'#', '#', '#', '#', '.', '.', '#', '.', '.', '.', 'T', '.', '.', '.', 'E'},
            {'.', '.', '#', '.', 'F', '.', '#', '#', '.', '#', '#', '#', '#', '.', '.'},
            {'.', '#', '.', '.', '.', '.', '!', '.', '#', '.', '.', '.', '#', '.', '.'},
            {'.', 'T', 'T', '.', '#', '#', '.', '.', '.', '.', 'T', '.', '.', '.', 'R'},
            {'.', '.', '.', '#', '.', '.', '.', '#', '.', '#', '.', '#', '.', 'T', '.'},
            {'B', '.', '#', '.', '.', '!', '.', '!', '.', '.', '.', '.', '.', '.', '#'},
            {'.', '.', '.', 'F', '!', '.', '.', '.', 'H', '.', '.', 'R', '.', '.', '.'},
            {'.', '.', 'H', '.', '.', '.', '!', '.', '.', '.', '#', '.', '.', '#', '.'},
            {'.', '.', '.', '#', '.', '.', '#', '.', '#', '.', '#', '.', '.', '#', '#'}};
        boolean gameIsOver = false;
        int[] konum = new int[2];
        int moves = 0;
        int tempMoves = 0;

        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 'B') {
                    konum[0] = i;
                    konum[1] = j;
                    map[i][j] = 'X';
                }
            }
        }
        int bonusH = 0;
        int bonusT = 0;
        int bonusR = 0;
        int bonusF = 0;
        while (!gameIsOver) {

           
            System.out.println("Maze Game");
            System.out.println("Moves: " + moves);
            System.out.println("Your Mark: ");
            print1DArray(konum);
            System.out.print("Click: W, A, S, D To move Or  + \n"
                    + "To Use A Bonus. To Exit press 'exit' .");
            System.out.println("");
            System.out.println("Avalibal bounese;");
            System.out.println("F:" + bonusF + " R:" + bonusR + " T:" + bonusT + " H:" + bonusH);

            print2DArray(map);

            String girdi = scan.next();

            if (girdi.equals("+")) {
                useBonus(bonusH, bonusT, map, konum, moves);
                continue;
            }

            switch (girdi.toUpperCase()) {
                case "W":
                    movePlayer(map, konum, -1, 0, bonusH, moves, bonusR, bonusF, bonusT, gameIsOver);
                    bonusT += checkForBonusesT(map, konum, -1, 0, bonusH, moves, bonusR, bonusF, bonusT);
                    bonusH += checkForBonusesH(map, konum, -1, 0, bonusH, moves, bonusR, bonusF, bonusT);
                    bonusF += checkForBonusesF(map, konum, -1, 0, bonusH, moves, bonusR, bonusF, bonusT);
                    bonusR += checkForBonusesR(map, konum, -1, 0, bonusH, moves, bonusR, bonusF, bonusT);
                    gameIsOver = checkEnd(map, konum, -1, 0,gameIsOver);
                    break;
                case "A":
                    movePlayer(map, konum, 0, -1, bonusH, moves, bonusR, bonusF, bonusT, gameIsOver);
                    bonusT += checkForBonusesT(map, konum, 0, -1, bonusH, moves, bonusR, bonusF, bonusT);
                    bonusH += checkForBonusesH(map, konum, 0,-1, bonusH, moves, bonusR, bonusF, bonusT);
                    bonusF += checkForBonusesF(map, konum, 0, -1, bonusH, moves, bonusR, bonusF, bonusT);
                    bonusR += checkForBonusesR(map, konum, 0, -1, bonusH, moves, bonusR, bonusF, bonusT);
                                        gameIsOver = checkEnd(map, konum, 0, -1, gameIsOver);

                    break;
                case "S":
                    movePlayer(map, konum, 1, 0, bonusH, moves, bonusR, bonusF, bonusT, gameIsOver);
                      bonusT += checkForBonusesT(map, konum, 1, 0, bonusH, moves, bonusR, bonusF, bonusT);
                    bonusH += checkForBonusesH(map, konum, 1, 0, bonusH, moves, bonusR, bonusF, bonusT);
                    bonusF += checkForBonusesF(map, konum, 1, 0, bonusH, moves, bonusR, bonusF, bonusT);
                    bonusR += checkForBonusesR(map, konum, 1, 0, bonusH, moves, bonusR, bonusF, bonusT);
                                        gameIsOver = checkEnd(map, konum, 1, 0, gameIsOver);

                    break;
                case "D":
                    movePlayer(map, konum, 0, 1, bonusH, moves, bonusR, bonusF, bonusT, gameIsOver);
                      bonusT += checkForBonusesT(map, konum, 0, 1, bonusH, moves, bonusR, bonusF, bonusT);
                    bonusH += checkForBonusesH(map, konum, 0, 1, bonusH, moves, bonusR, bonusF, bonusT);
                    bonusF += checkForBonusesF(map, konum, 0, 1, bonusH, moves, bonusR, bonusF, bonusT);
                    bonusR += checkForBonusesR(map, konum, 0, 1, bonusH, moves, bonusR, bonusF, bonusT);
                                        gameIsOver = checkEnd(map, konum, 0, 1, gameIsOver);

                    break;
                case "EXIT":
                    gameIsOver = true;
                    break;
                default:
                    System.out.println("Invalid input. Please enter W, A, S, D, +, or EXIT.");
            }
             if (tempMoves != 0 || tempMoves % 5 == 0);
            {
                RandomBonuses(map, tempMoves);
            }
            moves++;
            tempMoves++;
            System.out.println("====================================");
        }
        System.out.println("You Won the Game With A total Of: " + moves + " moves!!!");
    }

    public static void movePlayer(char[][] map, int[] konum, int rowChange, int colChange, int bonusH, int moves, int bonusR, int bonusF, int bonusT, boolean gameIsOver) {

        int newRow = konum[0] + rowChange;
        int newCol = konum[1] + colChange;

        if (newRow >= 0 && newRow < map.length && newCol >= 0 && newCol < map[0].length) {
           

            if (map[newRow][newCol] == '#') {
                handleWall(map, konum, newRow, newCol, bonusR);
            } else if (map[newRow][newCol] == '!') {
           moves+=     handleMine(map, konum, newRow, newCol, bonusF, moves);
            } else {
                map[konum[0]][konum[1]] = '.';
                konum[0] = newRow;
                konum[1] = newCol;
                map[konum[0]][konum[1]] = 'X';
            }
        } else {
            System.out.println("Invalid move. Try again.");
        }
    }
    

    public static void handleWall(char[][] map, int[] konum, int newRow, int newCol, int bonusR) {
        if (bonusR > 0) {
            map[newRow][newCol] = '.';
            konum[0] = newRow;
            konum[1] = newCol;
            bonusR--;
        } else {
            System.out.println("You cannot pass through the wall!");
        }
    }

    public static int handleMine(char[][] map, int[] konum, int newRow, int newCol, int bonusF, int moves) {
        int move=0;
        if (bonusF > 0) {
            map[konum[0]][konum[1]] = '.';
            map[newRow][newCol] = 'X';
            konum[0] = newRow;
            konum[1] = newCol;
            bonusF--;
        } else {
            map[konum[0]][konum[1]] = '.';
            map[newRow][newCol] = 'X';
            konum[0] = newRow;
            konum[1] = newCol;
            move += 5;
        }
        return move;
    }

    public static void useBonus(int bonusH, int bonusT, char[][] map, int[] konum, int moves) {
        System.out.print("Choose a bonus to use: ");
        Scanner scan = new Scanner(System.in);
        char chos = scan.next().charAt(0);

        if (chos == 'H') {
            if (bonusH >= 1) {
                moves -= 3;
                bonusH--;
            } else {
                System.out.println("You dont Have The H Bonus!!!");
            }
        } else if (chos == 'T') {
            if (bonusT >= 1) {
                int Trow;
                int Tcol;
                System.out.println("Where Do You Want To Teleport?");
                System.out.println("Enter The Row:");
                Trow = scan.nextInt();
                System.out.println("Enter The Col:");
                Tcol = scan.nextInt();
                if (Trow >= 0 && Trow <= map.length && Tcol >= 0 && Tcol <= map[Trow].length && map[Trow][Tcol]!= '#') {
                    bonusT--;
                    map[konum[0]][konum[1]] = '.';
                    konum[0] = Trow;
                    konum[1] = Tcol;
                    map[Trow][Tcol] = 'X';
                } else {
                    System.out.println("Invalid Move!!");
                }

            } else {
                System.out.println("You dont Have The T Bonus!!!");
            }
        } else {
            System.out.println("Invalid Charecter!!!");
        }
    }

    public static void print2DArray(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void print1DArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static char[][] RandomBonuses(char[][] map, int tempMoves) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (tempMoves == 0 || tempMoves == 1 || tempMoves == 2 || tempMoves == 3 || tempMoves == 4 || tempMoves % 5 != 0) {
                    break;
                }
                if (map[i][j] == 'T') {
                    int ranRow = 0;
                    int ranCol = 0;
                    ranRow = (int) (Math.random() * map.length);
                    ranCol = (int) (Math.random() * map[0].length);
                    if (map[ranRow][ranCol] == '#' || map[ranRow][ranCol] == 'E' || map[ranRow][ranCol] == 'X' || map[ranRow][ranCol] == '!' || map[ranRow][ranCol] == 'B') {
                        map[i][j] = 'T';
                    } else {
                        map[i][j] = '.';
                        map[ranRow][ranCol] = 'T';
                    }
                }
                if (map[i][j] == 'H') {
                    int ranRow = 0;
                    int ranCol = 0;
                    ranRow = (int) (Math.random() * map.length);
                    ranCol = (int) (Math.random() * map[0].length);
                    if (map[ranRow][ranCol] == '#' || map[ranRow][ranCol] == 'E' || map[ranRow][ranCol] == 'X' || map[ranRow][ranCol] == '!' || map[ranRow][ranCol] == 'B') {
                        map[i][j] = 'H';
                    } else {
                        map[i][j] = '.';
                        map[ranRow][ranCol] = 'H';
                    }
                }
                if (map[i][j] == 'R') {
                    int ranRow = 0;
                    int ranCol = 0;
                    ranRow = (int) (Math.random() * map.length);
                    ranCol = (int) (Math.random() * map[0].length);
                    if (map[ranRow][ranCol] == '#' || map[ranRow][ranCol] == 'E' || map[ranRow][ranCol] == 'X' || map[ranRow][ranCol] == '!' || map[ranRow][ranCol] == 'B') {
                        map[i][j] = 'R';
                    } else {
                        map[i][j] = '.';
                        map[ranRow][ranCol] = 'R';
                    }
                }
                if (map[i][j] == 'F') {
                    int ranRow = 0;
                    int ranCol = 0;
                    ranRow = (int) (Math.random() * map.length);
                    ranCol = (int) (Math.random() * map[0].length);
                    if (map[ranRow][ranCol] == '#' || map[ranRow][ranCol] == 'E' || map[ranRow][ranCol] == 'X' || map[ranRow][ranCol] == '!' || map[ranRow][ranCol] == 'B') {
                        map[i][j] = 'F';
                    } else {
                        map[i][j] = '.';
                        map[ranRow][ranCol] = 'F';
                    }
                }

            }
        }
        return map;

    }

    public static int checkForBonusesT(char[][] map, int[] konum, int rowChange, int colChange, int bonusH, int moves, int bonusR, int bonusF, int bonusT) {
int numT = 0;
        int newRow = konum[0] + rowChange;
        int newCol = konum[1] + colChange;
 if (newRow >= 0 && newRow < map.length && newCol >= 0 && newCol < map[0].length) {
     if(map[newRow][newCol] == 'T'){
         numT += 1;
         
     }
 }
        return numT;

    }

    private static int checkForBonusesH(char[][] map, int[] konum, int rowChange, int colChange, int bonusH, int moves, int bonusR, int bonusF, int bonusT) {
        int numT = 0;
        int newRow = konum[0] + rowChange;
        int newCol = konum[1] + colChange;
 if (newRow >= 0 && newRow < map.length && newCol >= 0 && newCol < map[0].length) {
     if(map[newRow][newCol] == 'H'){
         numT += 1;
         
     }
 }
        return numT;
    }

    private static int checkForBonusesF(char[][] map, int[] konum, int rowChange, int colChange, int bonusH, int moves, int bonusR, int bonusF, int bonusT) {
        int numT = 0;
        int newRow = konum[0] + rowChange;
        int newCol = konum[1] + colChange;
 if (newRow >= 0 && newRow < map.length && newCol >= 0 && newCol < map[0].length) {
     if(map[newRow][newCol] == 'F'){
         numT += 1;
         
     }
 }
        return numT;
    }

    private static int checkForBonusesR(char[][] map, int[] konum, int i, int rowChange, int colChange, int moves, int bonusR, int bonusF, int bonusT) {
       int numT = 0;
        int newRow = konum[0] + rowChange;
        int newCol = konum[1] + colChange;
 if (newRow >= 0 && newRow < map.length && newCol >= 0 && newCol < map[0].length) {
     if(map[newRow][newCol] == 'R'){
         numT += 1;
         
     }
 }
        return numT;
    }

    private static boolean checkEnd(char[][] map, int[] konum, int rowChange, int colChange, boolean gameIsOver) {
        boolean End = gameIsOver;
         int newRow = konum[0] + rowChange;
        int newCol = konum[1] + colChange;
         if (newRow >= 0 && newRow < map.length && newCol >= 0 && newCol < map[0].length){
             if(map[newRow][newCol] == 'E'){
                 End = true;
                 
             }
             else
                 End = false;
             
         }
        
        
        return End;
        
        
    }

}

