import java.util.Random;

public class SdelatColodu {
    private int kolvoPlayers;

    public int getNumberPlayers() {
        return kolvoPlayers;
    }

    public void setNumberPlayers(int kolvoPlayers) {
        if (kolvoPlayers < 10 && kolvoPlayers > 1) {
            this.kolvoPlayers = kolvoPlayers;
        }
        else {
            System.out.println("Игроков не может быть больше десяти или меньше одного");
        }
    }

    private String[] coloda = new String[PlayingCard.RANK_LIST.length * PlayingCard.SUITS_LIST.length];

    public void poluchitColoda() {
        Random rnd = new Random();
        for (int i = 1; i < coloda.length; i++) {
            int j = rnd.nextInt(i);
            String temp = coloda[i];
            coloda[i] = coloda[j];
            coloda[j] = temp;
        }

        int count = 0;
        for (int i = 0; i < kolvoPlayers; i++) {
            System.out.println("\nPlayer № " + (i+1));
            for (int j = 0; j < 5; j++) {
                System.out.println(coloda[count]);
                count = count + 1;
            }
        }
    }


    public SdelatColodu() {
        kolvoPlayers = 0;
        int chetchik = 0;

        for (int i = 0; i <  PlayingCard.SUITS_LIST.length; i++) {
            for (int j = 0; j < PlayingCard.RANK_LIST.length; j++) {
                PlayingCard oneCard = new PlayingCard(PlayingCard.SUITS_LIST[i], PlayingCard.RANK_LIST[j]) ;
                coloda[chetchik] = oneCard.toString();
                chetchik = chetchik + 1;
            }
        }
    }

}