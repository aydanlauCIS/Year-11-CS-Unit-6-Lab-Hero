import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HeroTester {

    private Hero hero1;
    private Hero hero2;

    public void setUp() {
        hero1 = new Hero("Andrew Tate");
        hero2 = new Hero("Taylor Swift");
    }

    public void tearDown() {
        hero1 = null;
        hero2 = null;
    }

    @Test
    public void TestConstructorName() {
        setUp();
        assertEquals("Andrew Tate", hero1.getName(), "Ensure that your constructor has been implemented correctly!");
        tearDown();
    }

    @Test
    public void TestConstructorHitPoints() {
        setUp();
        assertEquals(100, hero1.getHitPoints(), "Ensure that your constructor has been implemented correctly!");
        tearDown();
    }

    @Test
    public void TestAttack() {
        setUp();
        hero1.attack(hero2);
        assertEquals(false, hero1.getHitPoints() == hero2.getHitPoints(), "Ensure that your attack method has been implemented correctly!");
        tearDown();
    }

    @Test
    public void TestFightToTheDeath() {
        setUp();
        hero1.fightUntilTheDeath(hero2);
        assertTrue(hero1.getHitPoints() != hero2.getHitPoints(), "Ensure that your duelToTheDeath method has been implemented correctly!");
        tearDown();
    }

    @Test
    public void TestFightToTheDeathHpZero() {
        setUp();
        hero1.fightUntilTheDeath(hero2);
        if (hero1.getHitPoints() < hero2.getHitPoints()) assertTrue(hero1.getHitPoints() == 0, "Ensure that your duelToTheDeath method has been implemented correctly!");
        else assertTrue(hero2.getHitPoints() == 0, "Ensure that your duelToTheDeath method has been implemented correctly!");
        tearDown();
    }

    @Test
    public void TestFightToTheDeathNTimes() {
        setUp();

        int numberOfFights = 100;

        String result = hero1.nFightsToTheDeath(hero2, numberOfFights);
        int indexOfFirstColon = result.indexOf(":");
        int indexOfFirstColonEnd = result.indexOf("wins", indexOfFirstColon);
        int indexOfSecondColon = result.indexOf(":", indexOfFirstColon+1);
        int indexOfSecondColonEnd = result.indexOf("wins", indexOfSecondColon);

        int winsHero1 = Integer.parseInt(result.substring(indexOfFirstColon+2, indexOfFirstColonEnd-1));
        int winsHero2 = Integer.parseInt(result.substring(indexOfSecondColon+2, indexOfSecondColonEnd-1));

        assertEquals(numberOfFights, winsHero1+winsHero2, "Ensure that your nFightsToTheDeath method has been implemented correctly!");

        tearDown();
    }

    @Test
    public void TestToString() {
        setUp();
        String expected = "Hero{" +
                "name='" + hero1.getName() + '\'' +
                ", hitPoints=" + hero1.getHitPoints() +
                '}';
        assertEquals(expected, hero1.toString(), "Ensure that your toString method returns a String that is formatted like the document specifies!");
        tearDown();
    }

    @Test
    public void TestSenzuBean() {
        setUp();
        hero1.fightUntilTheDeath(hero2);
        hero1.fightUntilTheDeath(hero2);
        hero1.fightUntilTheDeath(hero2);
        tearDown();
    }

    @Test
    public void TestAllMethodsHaveBeenImplemented() {
        setUp();
        Method[] methods = hero1.getClass().getDeclaredMethods();
        assertEquals(12, methods.length, "Ensure that you have implemented all of the methods that are included in the description!");
        tearDown();
    }

    @Test
    public void TestSenzuBeanMethodHasBeenImplemented() {
        setUp();
        Method[] methods = hero1.getClass().getDeclaredMethods();
        boolean containsSenzuBean = false;
        for (Method method: methods) if (method.getName().equals("senzuBean")) containsSenzuBean = true;
        assertTrue(containsSenzuBean, "Ensure that you have implemented the senzuBean method!");
        tearDown();
    }

    @Test
    public void TestFightUntilTheDeathHelperHasBeenImplemented() {
        setUp();
        Method[] methods = hero1.getClass().getDeclaredMethods();
        boolean containsFightUntilTheDeathHelper = false;
        for (Method method: methods) if (method.getName().equals("fightUntilTheDeathHelper")) containsFightUntilTheDeathHelper = true;
        assertTrue(containsFightUntilTheDeathHelper, "Ensure that you have implemented the fightUntilTheDeathHelper method!");
        tearDown();
    }

    @Test
    public void TestFightUntilTheDeathNTimesHelperHasBeenImplemented() {
        setUp();
        Method[] methods = hero1.getClass().getDeclaredMethods();
        boolean containsNFightsToTheDeathHelper = false;
        for (Method method: methods) if (method.getName().equals("nFightsToTheDeathHelper")) containsNFightsToTheDeathHelper = true;
        assertTrue(containsNFightsToTheDeathHelper, "Ensure that you have implemented the nFightsUntilTheDeathHelper method!");
        tearDown();
    }

}
