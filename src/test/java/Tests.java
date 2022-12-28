import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility

    GroupAdmin ga = new GroupAdmin();
    ConcreteMember m1 = new ConcreteMember();
    ConcreteMember m2 = new ConcreteMember();

    @Test
    public void memoryTrace(){
        logger.info(()->JvmUtilities.memoryStats(ga));
        logger.info(()->JvmUtilities.memoryStats(m1));
        logger.info(()->JvmUtilities.memoryStats(m2));
        logger.info(() -> JvmUtilities.jvmInfo());
    }

    @Test
    void register(){
        ga.register(m1);
        ga.register(m1);
        assertEquals(1 , ga.getSizeMember());
    }
    @Test
    public void memoryTrace1(){
        logger.info(()->JvmUtilities.memoryStats(ga));
        logger.info(()->JvmUtilities.memoryStats(m1));
        logger.info(()->JvmUtilities.memoryStats(m2));
        logger.info(() -> JvmUtilities.jvmInfo());
    }
    @Test
    void unregister(){
        ga.register(m1);
        ga.register(m2);
        ga.unregister(m2);
        assertEquals(1 , ga.getSizeMember());
    }
    @Test
    public void memoryTrace2(){
        logger.info(()->JvmUtilities.memoryStats(ga));
        logger.info(()->JvmUtilities.memoryStats(m1));
        logger.info(()->JvmUtilities.memoryStats(m2));
        logger.info(() -> JvmUtilities.jvmInfo());
    }

    @Test
    void append(){
        ga.register(m1);
        ga.append("hello world");
        assertEquals("hello world", m1.getData());
    }
    @Test
    public void memoryTrace3(){
        logger.info(()->JvmUtilities.memoryStats(ga));
        logger.info(()->JvmUtilities.memoryStats(m1));
        logger.info(()->JvmUtilities.memoryStats(m2));
        logger.info(() -> JvmUtilities.jvmInfo());
    }
    @Test
    void insert(){
        ga.register(m1);
        ga.append("hello world");
        ga.insert(5," my beautiful");
        assertEquals("hello my beautiful world", m1.getData());
    }
    @Test
    public void memoryTrace4(){
        logger.info(()->JvmUtilities.memoryStats(ga));
        logger.info(()->JvmUtilities.memoryStats(m1));
        logger.info(()->JvmUtilities.memoryStats(m2));
        logger.info(() -> JvmUtilities.jvmInfo());
    }
    @Test
    void delete(){
        ga.register(m1);
        ga.append("hello world");
        ga.insert(5," my beautiful");
        ga.delete(5,8);
        assertEquals("hello beautiful world", m1.getData());
    }
    @Test
    public void memoryTrace5(){
        logger.info(()->JvmUtilities.memoryStats(ga));
        logger.info(()->JvmUtilities.memoryStats(m1));
        logger.info(()->JvmUtilities.memoryStats(m2));
        logger.info(() -> JvmUtilities.jvmInfo());
    }
    @Test
    void undo(){
        ga.register(m1);
        ga.append("hello world");
        ga.insert(5," my beautiful");
        ga.delete(5,7);
        ga.undo();
        assertEquals("hello my beautiful world", m1.getData());
    }
    @Test
    public void memoryTrace6(){
        logger.info(()->JvmUtilities.memoryStats(ga));
        logger.info(()->JvmUtilities.memoryStats(m1));
        logger.info(()->JvmUtilities.memoryStats(m2));
        logger.info(() -> JvmUtilities.jvmInfo());
    }

}
