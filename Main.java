import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.flush();

        String[] numList = initializeGame();

        String CurrentPlayer = "X";
        Scanner PlayerInput = new Scanner(System.in);

        flushOutput();

        int CurrentTurn = 0;
        while (true) {
            CurrentTurn++;
            if (CurrentTurn == 10) {
                flushOutput();
                System.out.println("It's a draw!");
                break;
            }
            if (CurrentPlayer.equals("X")) {
                System.out.println("Current player: " + CurrentPlayer);

                renderMap(numList);

                while (true) {

                    System.out.println("Enter number in map: ");
                    int numReplace = Integer.valueOf(PlayerInput.nextLine());

                    if (!numList[numReplace].equals("X") && !numList[numReplace].equals("O")) {
                        numList[numReplace] = "X";
                        break;
                    } else {
                        System.out.println("Space is occupied");
                    }
                }

                if (checkVictory(numList,CurrentPlayer)){
                    flushOutput();
                    System.out.println(CurrentPlayer + " won!");
                    renderMap(numList);
                    break;
                }

                CurrentPlayer = "O";

                flushOutput();

            } else {
                System.out.println("Current player: " + CurrentPlayer);

                renderMap(numList);

                while (true) {

                    System.out.println("Enter number in map: ");
                    int numReplace = Integer.valueOf(PlayerInput.nextLine());

                    if (!numList[numReplace].equals("X") && !numList[numReplace].equals("O")) {
                        numList[numReplace] = "O";
                        break;
                    } else {
                        System.out.println("Space is occupied");
                    }
                }

                if (checkVictory(numList,CurrentPlayer)){
                    flushOutput();
                    System.out.println(CurrentPlayer + " won!");
                    renderMap(numList);
                    break;
                }

                CurrentPlayer = "X";

                flushOutput();

            }
        }
    }

    public static String[] initializeGame() {
        String[] numDict = new String[10];
        for (int i = 0; i < 10; i++) {
            numDict[i] = String.valueOf(i);
        }
        return numDict;
    }

    public static void renderMap(String[] numList) {
        int y = 0;
        for (int i = 0; i < 3; i++) {
            for (int x = 0; x < 3; x++) {
                y++;
                System.out.print(numList[y] + " ");
            }
            System.out.println(" ");
        }
    }

    public static boolean checkVictory(String[] numList, String Player) {
        int x = 0;

        String[] HorizontalArray1 = new String[3];
        for (int i = 1; i <= 3; i++) {
            HorizontalArray1[x] = numList[i];
            x++;
        }
        x = 0;
        String[] HorizontalArray2 = new String[3];
        for (int i = 4; i <= 6; i++) {
            HorizontalArray2[x] = numList[i];
            x++;
        }
        x = 0;
        String[] HorizontalArray3 = new String[3];
        for (int i = 7; i <= 9; i++) {
            HorizontalArray3[x] = numList[i];
            x++;
        }
        x = 0;

        String[] VerticalArray1 = new String[3];
        for (int i = 1; i <= 7; i += 3) {
            VerticalArray1[x] = numList[i];
            x++;
        }
        x = 0;
        String[] VerticalArray2 = new String[3];
        for (int i = 2; i <= 8; i += 3) {
            VerticalArray2[x] = numList[i];
            x++;
        }
        x = 0;
        String[] VerticalArray3 = new String[3];
        for (int i = 3; i <= 9; i += 3) {
            VerticalArray3[x] = numList[i];
            x++;
        }

        String[] SidewaysArray1 = new String[3];
        SidewaysArray1[0] = numList[1];
        SidewaysArray1[1] = numList[5];
        SidewaysArray1[2] = numList[9];

        String[] SidewaysArray2 = new String[3];
        SidewaysArray2[0] = numList[3];
        SidewaysArray2[1] = numList[5];
        SidewaysArray2[2] = numList[7];

        //Check horizontally

        if (HorizontalArray1[0].equals(Player) && HorizontalArray1[1].equals(Player) && HorizontalArray1[2].equals(Player)) {
            return true;
        } else if (HorizontalArray2[0].equals(Player) && HorizontalArray2[1].equals(Player) && HorizontalArray2[2].equals(Player)) {
            return true;
        } else if (HorizontalArray3[0].equals(Player) && HorizontalArray3[1].equals(Player)  && HorizontalArray3[2].equals(Player)) {
            return true;
        }

        //Check vertically

        if (VerticalArray1[0].equals(Player) && VerticalArray1[1].equals(Player) && VerticalArray1[2].equals(Player)) {
            return true;
        } else if (VerticalArray2[0].equals(Player) && VerticalArray2[1].equals(Player) && VerticalArray2[2].equals(Player)) {
            return true;
        } else if (VerticalArray3[0].equals(Player) && VerticalArray3[1].equals(Player) && VerticalArray3[2].equals(Player)) {
            return true;
        }

        //Check sideways

        if (SidewaysArray1[0].equals(Player) && SidewaysArray1[1].equals(Player) && SidewaysArray1[2].equals(Player)) {
            return true;
        } else if (SidewaysArray2[0].equals(Player) && SidewaysArray2[1].equals(Player) && SidewaysArray2[2].equals(Player)) {
            return true;
        }

        return false;
    }

    public static void flushOutput() {
        for (int i = 0; i <= 40; i++) {
            System.out.println("\n");
        }
    }
}