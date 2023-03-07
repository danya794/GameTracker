import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.Period;

public class GameStoreTest {

    private Game hours;

    @Test

    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldAddNoGame() {

        GameStore store = new GameStore();
        Game game = null;

        assertFalse(store.containsGame(game));
    }

    @Test
    public void shouldAddGameNull() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game = null;

        assertFalse(store.containsGame(game));
    }


    @Test
    public void shouldAddGameNoNameNoGenre() {

        GameStore store = new GameStore();
        Game game = store.publishGame(null, null);

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldContainsGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("NFS", "Racing");

        assertTrue(store.containsGame(game));

    }

    @Test
    public void shouldAddPlayTime() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("NFS", "Racing");

        store.addPlayTime("Petya", 1);
        store.addPlayTime("Vasya", 2);

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldAddPlayTimeSamePlayers() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("NFS", "Racing");

        store.addPlayTime("Petya", 1);
        store.addPlayTime("Petya", 2);

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldAddPlayTimeSameHours() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("NFS", "Racing");

        store.addPlayTime("Petya", 2);
        store.addPlayTime("Vasya", 2);

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldGetMostPlayer() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        store.addPlayTime("Petya", 1);
        store.addPlayTime("Vasya", 3);

        String[] expected = {"Vasya"};
        String[] actual = store.getMostPlayer();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayerOnePlayer() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        store.addPlayTime("Vasya", 3);

        String[] expected = {"Vasya"};
        String[] actual = store.getMostPlayer();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayerNoPlayers() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        String expected = null;
        String[] actual = store.getMostPlayer();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckWhoPlayMostTime() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        store.addPlayTime("Petya", 1);
        store.addPlayTime("Vasya", 0);

        String[] expected = {"Petya"};
        String[] actual = store.getMostPlayer();

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldGetSumPlayedTime() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        store.addPlayTime("Petya", 2);
        store.addPlayTime("Vasya", 2);

        int expected = 4;
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);

    }

    @Test
    public void shouldGetSumPlayedTimeOnePlayer() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        store.addPlayTime("Petya", 2);

        int expected = 2;
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddCopyOfGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
        assertTrue(store.containsGame(game1));

    }

    @Test
    public void shouldAddCopyOfGames() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("NFS", "Racing");
        Game game3 = store.publishGame("NFS", "Racing");

        assertTrue(store.containsGame(game));
        assertTrue(store.containsGame(game1));
        assertTrue(store.containsGame(game2));
        assertTrue(store.containsGame(game3));

    }
    
}