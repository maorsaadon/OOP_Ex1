import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    @Test
    public void test(){

        GroupAdmin ga = new GroupAdmin();
        ConcreteMember m1 = new ConcreteMember();
        ga.register(m1);


        logger.info(()->JvmUtilities.objectFootprint(ga));
        logger.info(()->JvmUtilities.objectFootprint(m1));
        logger.info(()->JvmUtilities.objectFootprint(ga));
        logger.info(()->JvmUtilities.objectTotalSize(ga));
        logger.info(() -> JvmUtilities.jvmInfo());




        ga.append("hello world");
        assertEquals("hello world", m1.getData());

    }
}
