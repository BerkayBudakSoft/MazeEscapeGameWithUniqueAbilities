import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Adam extends Hucre{
    int a;

    public String toString() {
        //represent ö character for display Adam
        return "ö";
    }

    public Adam(Konum konum){
        super(konum);

    }

    public boolean hareketEttir(Hucre hucre){
        //moves Adam to specified cell if its either Zemin or Cikis
        boolean hareketEtti = false;
        if(hucre instanceof Zemin || hucre instanceof Cikis){
            this.getKonum().setX(hucre.getKonum().getX());
            this.getKonum().setY(hucre.getKonum().getY());
            hareketEtti = true;
        }

        return hareketEtti;
    }



}

class Cikis extends Hucre {
    int i;
    public Cikis(Konum konum) {
        super(konum);

    }


    public String toString() {
        //represent © character to display Cikis

        return ""+(char)169;
    }

}

class Duvar extends Hucre {

    public Duvar(Konum konum) {
        super(konum);

    }

    @Override
    public String toString() {
        //represent the character # to display Duvar
        return "#";
    }

}

abstract class Hucre {
    private Konum konum;

    public abstract String toString();
    //abstract method for represent cell as a string on board

    public Hucre(Konum konum){
        this.konum = konum;
    }

    public Konum getKonum() {
        return konum;
    }

    public void setKonum(Konum konum) {
        this.konum = konum;
    }

}

class Konum implements Comparable<Konum>{
    private int x,y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Konum(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int compareTo(Konum k) {
        //compare two Konum for equality
        if ((this.x == k.getX()) && (this.y == k.getY()))
            return 0;
        return -1;
    }

}

class LabirentOyunu extends Oyun{

    public static final int YUKARI = 1;
    public static final int ASAGI = 2;
    public static final int SAGA = 3;
    public static final int SOLA = 4;
    public static final int HATALI = 0;

    //Loads the game board
    public void yukle(){
        int[][] lab={{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2},
                {2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2},
                {2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2},
                {2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2},
                {2, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2},
                {2, 1, 2, 1, 2, 1, 2, 1, 2, 2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2},
                {2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 2, 2, 1, 1, 2},
                {2, 1, 2, 1, 2, 1, 2, 1, 2, 2, 2, 2, 1, 2, 1, 2, 1, 1, 1, 2},
                {2, 1, 2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2},
                {2, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 1, 1, 1, 2},
                {2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 2, 2, 1, 2},
                {2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 2, 1, 2},
                {2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 2, 1, 2},
                {2, 1, 2, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 1, 2},
                {2, 1, 2, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 2, 1, 2},
                {2, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 1, 2},
                {2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 2},
                {2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 4, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}};


        sahne = new LabirentSahnesi(lab);


    }

    public void basla(){
//loop and handle input from user
        while(true){

            System.out.println(this);
            int girdi = kullanicidanYonBilgisiAl();
            guncelle(girdi);
            if(oyunBitti())
            {
                System.out.println("Congratulations, you find the exit!");
                break;
            }

        }

    }

    private int kullanicidanYonBilgisiAl() {
        //get input from user to move the character

        Scanner consol = new Scanner(System.in);

        System.out.print("To move (w = up, s = down, a = left, d = right), choose it: ");

        String secimStr = consol.next();

        char secim = secimStr.charAt(0);
        int yon = HATALI;

        switch(secim){
            case 'w':
            case 'W':
                yon = YUKARI;
                break;

            case 'a':
            case 'A':
                yon = SOLA;
                break;

            case 's':
            case 'S':
                yon = ASAGI;
                break;

            case 'd':
            case 'D':
                yon = SAGA;
                break;

        }

        return yon;

    }

    private void guncelle(int girdi){
//get current position of Adam
        Konum adamKonum = ((LabirentSahnesi)sahne).getAdam().getKonum();

        switch(girdi){

            case YUKARI:
//move up(w)
                hareketEttir(adamKonum.getX(), adamKonum.getY()-1);
                break;

            case SOLA:
                //move left(a)
                hareketEttir(adamKonum.getX()-1, adamKonum.getY());
                break;

            case ASAGI:
                //move down (s)
                hareketEttir(adamKonum.getX(), adamKonum.getY()+1);
                break;

            case SAGA:
                //move right (d)
                hareketEttir(adamKonum.getX()+1, adamKonum.getY());
                break;
        }


    }

    private void hareketEttir(int x, int y) {
//get Adam and cell
        Adam adam = ((LabirentSahnesi)sahne).getAdam();
        Hucre hucre = ((LabirentSahnesi)sahne).getHucre(x, y);

        int eskiX = adam.getKonum().getX();
        int eskiY = adam.getKonum().getY();
        //store old coordinates of Adam

        boolean hareketEtti = adam.hareketEttir(hucre);
        //try to move the cell

        if(hareketEtti){
            sahne.setHucre(adam, x, y);
            hucre.getKonum().setX(eskiX);
            hucre.getKonum().setY(eskiY);
            sahne.setHucre(hucre, eskiX, eskiY);
            sahne.setSkor(sahne.getSkor()+1);
            //if moveable , update the stats
        }

    }

    private boolean oyunBitti(){
        //if Adam and exit are equal?
        LabirentSahnesi labs = (LabirentSahnesi)sahne;

        return labs.getAdam().getKonum().compareTo(labs.getCikis().getKonum()) == 0;
    }

    public String toString(){
        String s = "-------------------------\n";
        s += sahne.toString();
        s += "\n All step is: "+sahne.getSkor();
        s += "\n-------------------------\n";

        return s;
    }





}

class LabirentSahnesi extends Sahne{

    public static final int ZEMIN = 1;
    public static final int DUVAR = 2;
    public static final int ADAM = 3;
    public static final int CIKIS = 4;

    public LabirentSahnesi(){
        //default constructor
        super();
    }

    public LabirentSahnesi(int[][] labirent){
        //constructor to create MazeScene with an initial configuration
        super(labirent);
    }

    public void yukle(int[][] labirent){
        //load maze configuraiton

        hucreler = new Hucre[labirent.length][labirent[0].length];
        //2d array

        for (int y = 0; y < labirent.length; y++){
            for(int x = 0; x < labirent[y].length; x++){
                int hucre = labirent[y][x];
                switch(hucre){
                    case ZEMIN:
                        hucreler[y][x] = new Zemin(new Konum(x,y));
                        break;
                    case DUVAR:
                        hucreler[y][x] = new Duvar(new Konum(x,y));
                        break;
                    case ADAM:
                        hucreler[y][x] = new Adam(new Konum(x,y));
                        break;
                    case CIKIS:
                        hucreler[y][x] = new Cikis(new Konum(x,y));
                        break;
                }
            }
        }
    }

    public Adam getAdam() {
        //player object
        Adam adam = null;
        for (Hucre[] hucres : hucreler) {
            for (Hucre hucre : hucres) {
                if (hucre instanceof Adam)
                    adam = (Adam) hucre;
            }
        }

        return adam;
    }


    public Cikis getCikis() {
        //cikis object
        Cikis cikis = null;
        for (Hucre[] hucres : hucreler) {
            for (Hucre hucre : hucres) {
                if (hucre instanceof Cikis)
                    cikis = (Cikis) hucre;
            }
        }

        return cikis;

    }


    public String toString(){
        StringBuilder s = new StringBuilder();
        for (Hucre[] hucres : hucreler) {
            for (Hucre hucre : hucres) {
                s.append(hucre.toString());
            }
            s.append("\n");
        }
        return s.toString();
    }






    @Override
    public void yukle(String dosyaAdi) {
//can be added
    }

}

abstract class Oyun {
    //abstract class Oyun

    protected Sahne sahne;

    public abstract void yukle();
    public abstract void basla();
}
abstract class Sahne {
    //abstract class Sahne
    protected Hucre[][] hucreler;
    protected int skor;

    public Sahne(){
        //default constructor Sahne
        hucreler = null;
        skor = 0;
    }

    public Sahne(int[][] grid) {
        //constructor to create scene for initial configuration
        skor = 0;
        yukle(grid);
    }

    public Sahne(String dosyaAdi) {
        //constructor to create scene from folder but not added yet
        skor = 0;
        yukle(dosyaAdi);
    }

    public Hucre getHucre(int x, int y){
        return hucreler[y][x];
    }

    public void setHucre(Hucre h, int x, int y){
        hucreler[y][x] = h;
    }


    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }

    public abstract void yukle(int[][] grid);

    public abstract void yukle(String dosyaAdi);


}

class TestProgram {

    public static void main(String[] args) {

        Oyun labirentOyunu = new LabirentOyunu();
        //create a maze game instance

        labirentOyunu.yukle();//load game

        labirentOyunu.basla();//start game

    }

}

class Zemin extends Hucre {

    public Zemin(Konum konum) {
        super(konum);

    }


    public String toString() {

        return "-";
    }

}



class SettingsManager {
    private static SettingsManager instance;
    private final Map<String, String> controlKeys;
    private String[] characterImages;
    private String mapDataFile;

    private SettingsManager() {
        controlKeys = new HashMap<>();
        characterImages = new String[0];
        mapDataFile = "";
    }

    public static SettingsManager getInstance() {
        if (instance == null) {
            instance = new SettingsManager();
        }
        return instance;
    }

    public void loadSettings() {
        //load settings from settings.txt(not added yet this setting )
        controlKeys.put("up", "W");
        controlKeys.put("down", "S");
        controlKeys.put("left", "A");
        controlKeys.put("right", "D");
        characterImages = new String[] {"image1.png", "image2.png", "image3.png"};
        mapDataFile = "mapdata.txt";
    }

    public Map<String, String> getControlKeys() {
        return controlKeys;
    }

    public String[] getCharacterImages() {
        return characterImages;
    }

    public String getMapDataFile() {
        return mapDataFile;
    }
}

interface Ability {
    void move(Player player);
}

class RunningAbility implements Ability {
    private int stepCounter = 0;

    @Override
    public void move(Player player) {
        stepCounter++;
        if (stepCounter % 10 == 0) {
            player.move(2);
        } else {
            player.move(1);
        }
    }
}

class SkateboardingAbility implements Ability {

    public void move(Player player) {
//implement skateboarding movements from here
        player.moveToWall();
    }
}

class PowerfulPunchAbility {

    public PowerfulPunchAbility(String punchKey) {
    }

    public void punch() {
        // implement powerful punch from here
        System.out.println("Shotted powerful punch!");
    }
}

class PowerfulPushAbility {
    public void push() {
        // implement powerful push from here
        System.out.println("Powerful push!");
    }
}

class PullingAbility {
    public void pull() {
        // implement powerful pull from here
        System.out.println("Powerful pull!");
    }
}

class AbilityStrategy {
    private Ability ability;

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public void move(Player player) {
        if (ability != null) {
            ability.move(player);
        }
    }
}

class Player {
    private int x;
    public AbilityStrategy abilityStrategy;

    public Player() {
        x = 0;
        int y = 0;
        abilityStrategy = new AbilityStrategy();
    }

    public void move(int steps) {
        x += steps;
    }

    public void moveToWall() {
        // implement moving to the wall
        System.out.println("move to wall /impossible .");
    }

    public void punch() {
        abilityStrategy.move(this);
    }

    public void push() {
        abilityStrategy.move(this);
    }

    public void pull() {
        abilityStrategy.move(this);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}

class Main {
    public static void main(String[] args) {
        SettingsManager settingsManager = SettingsManager.getInstance();
        settingsManager.loadSettings();

        Player player = new Player();
        RunningAbility runningAbility = new RunningAbility();
        player.abilityStrategy.setAbility(runningAbility);

        player.move(1); //move 5 units
        player.punch(); // powerful punch
        player.push(); // powerful push
        player.pull(); // powerful pull
    }
}