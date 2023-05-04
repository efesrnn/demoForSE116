import java.util.List;

public class Game { private Deck deck;

    private List<Players> players;
    private PointFileReader pointValueFileReader;

    public Game(String pointValuesFilename, List<Players> players) {
        this.deck = new Deck();
        this.players = players;
        this.pointValueFileReader = new PointFileReader(pointValuesFilename);
    }

    public void play() {
        // Game logic.......
    }
}
