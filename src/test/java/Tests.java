import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility

    GroupAdmin ga = new GroupAdmin();
    ConcreteMember m1 = new ConcreteMember();
    ConcreteMember m2 = new ConcreteMember();

    //here we check that when a member register twice it's still register him once
    @Test
    void register(){
        ga.register(m1);
        ga.register(m1);
        assertEquals(1 , ga.getSizeMember());

    }

    //here we check that when we unregister member twice it's not affect the size of the GroupAdmin
    @Test
    void unregister(){
        assertEquals(0, ga.getSizeMember());
        ga.register(m1);
        ga.register(m2);
        ga.unregister(m2);
        assertEquals(1 , ga.getSizeMember());

        ga.unregister(m2);
        assertEquals(1 , ga.getSizeMember());

    }

    //in the next 4 tests we check that when the member is unregistered he didn't get the updated data
    //and when he registered he gets the updated date (in the context of all actions)
    @Test
    void append(){
        ga.append("hello world");
        assertNotEquals("hello world", m1.getData());

        ga.register(m1);
        assertEquals("hello world", m1.getData());
    }
    @Test
    void insert(){
        ga.append("hello world");
        ga.insert(5," my beautiful");
        assertNotEquals("hello my beautiful world", m1.getData());

        ga.register(m1);
        assertEquals("hello my beautiful world", m1.getData());
    }
    @Test
    void delete(){
        ga.append("hello my beautiful world");
        ga.delete(5,8);
        assertNotEquals("hello beautiful world", m1.getData());

        ga.register(m1);
        assertEquals("hello beautiful world", m1.getData());
    }
    @Test
    void undo(){
        ga.append("hello my beautiful world");
        ga.delete(5,7);
        ga.undo();
        assertNotEquals("hello my beautiful world", m1.getData());

        ga.register(m1);
        assertEquals("hello my beautiful world", m1.getData());
    }

    //Here we check the memory trace when we do actions on ga, m1, m2
    //we can see that the memory change
    @Test
    void memoryTrace(){
        logger.info(() -> JvmUtilities.jvmInfo());
        logger.info(() -> JvmUtilities.memoryStats(ga));
        logger.info(() -> JvmUtilities.memoryStats(m1));
        logger.info(() -> JvmUtilities.memoryStats(m2));

        ga.register(m1);
        ga.register(m2);
        ga.append("hello world");
        ga.insert(5," my beautiful");
        ga.delete(5,7);
        ga.undo();

        logger.info(() -> JvmUtilities.memoryStats(ga));
        logger.info(() -> JvmUtilities.memoryStats(m1));
        logger.info(() -> JvmUtilities.memoryStats(m2));
    }
}
