import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }
    @Test
    public void countsNumberHoursGameInstalled() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");


        Player player = new Player("Petya");
        player.installGame(game);

        player.play(game, 3);


        int expected = 3;
        int actual = player.play(game,3);
        assertEquals(expected, actual);
    }
    @Test
    public void sumGameTimeGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("quake", "Аркады");


        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game1);
        player.play(game, 5);
        player.play(game1,4);


        int expected = 9;
        int actual = player.sumGenre("Аркады");
        assertEquals(expected, actual);
    }
    @Test
    public void sumGameTwoGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("quake", "Аркады");
        Game game2 = store.publishGame("Total war", "Стратегии");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game1);
        player.installGame(game2);
        player.play(game, 3);
        player.play(game1,4);
        player.play(game2,5);

        int expected = 7;
        int actual = player.sumGenre("Аркады");
        assertEquals(expected, actual);
    }
    @Test
    public void shouldThrowExceptionGameNotInstalled() {

        GameStore store = new GameStore();

        Player player = new Player("Petya");

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertThrows(RuntimeException.class, () -> { player.play(game, 3);});
    }
    @Test
    public void returnMostPlayerByGenre(){
        GameStore store = new GameStore();
        Player player = new Player("Petya");
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("quake", "Аркады");
        Game game2 = store.publishGame("Total war", "Стратегии");


        player.installGame(game);
        player.installGame(game1);
        player.installGame(game2);
        player.play(game, 3);
        player.play(game1,4);
        player.play(game2,5);

        Game[] expected = {game2};
        Game[] actual = player.mostPlayerByGenre("Стратегии");
        assertArrayEquals(expected, actual);

   }
    @Test
    public void returnMostPlayerByGenreNull(){
        GameStore store = new GameStore();
        Player player = new Player("Petya");
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("quake", "Аркады");
        Game game2 = store.publishGame("Total war", "Стратегии");


        player.installGame(game);
        player.installGame(game1);
        player.installGame(game2);
        player.play(game, 3);
        player.play(game1,4);
        player.play(game2,5);

        Game[] expected = null;
        Game[] actual = player.mostPlayerByGenre("Гонки");
        assertArrayEquals(expected, actual);

    }
}