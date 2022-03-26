package manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.NotRegisteredException;
import ru.netology.domain.Player;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {


    private Game game = new Game();
    private Player firstPlayer = new Player(1, "first", 20);
    private Player secondPlayer = new Player(2, "second", 26);
    private Player thirdPlayer = new Player(3, "third", 26);
    private Player fourthPlayer = new Player(4, "fourth", 5);
    private Player fifthPlayer = new Player(5, "fifth", 100);


    @BeforeEach
    void setUp() {
        game.register(firstPlayer);
        game.register(secondPlayer);
        game.register(thirdPlayer);
        game.register(fourthPlayer);
    }


    @Test
    void round1() {
        int actual = game.round(thirdPlayer.getName(), secondPlayer.getName());

        assertEquals(0, actual);

    }

    @Test
    void round2() {
        int actual = game.round(firstPlayer.getName(), thirdPlayer.getName());

        assertEquals(2, actual);

    }

    @Test
    void round3() {
        int actual = game.round(firstPlayer.getName(), fourthPlayer.getName());

        assertEquals(1, actual);

    }


    @Test
    void roundWithException() {
        assertThrows(NotRegisteredException.class, () -> {
            game.round(firstPlayer.getName(), fifthPlayer.getName());
        });

    }
}