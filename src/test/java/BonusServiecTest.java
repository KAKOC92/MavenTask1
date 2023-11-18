import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusServiecTest {

    @Test
    public void shouldCalculateForRegisteredUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1_000;
        boolean registred = true;
        long expected = 30;

        long actual = service.calculate(amount, registred);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateForNotRegisteredUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1_000;
        boolean registered = false;
        long expected = 10;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateForNotRegisteredUnderOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);

    }
}
