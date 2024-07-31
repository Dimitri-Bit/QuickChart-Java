import me.dimitri.serializer.ChartSerializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static me.dimitri.serializer.ChartSerializer.serialize;

class ChartSerializerTest {

    @Test
    void testDoubleArraySerialization() throws IllegalAccessException {
        String expect = "[1.23,2.53,3.7]";
        Double[] arr = {1.23, 2.53, 3.7};

        String serializedArr = serialize(arr);
        Assertions.assertEquals(expect, serializedArr);
    }

    @Test
    void testIntegerArraySerialization() throws IllegalAccessException {
        String expect = "[1,2,3]";
        Integer[] arr = {1, 2, 3};

        String serializedArr = serialize(arr);
        Assertions.assertEquals(expect, serializedArr);
    }

    @Test
    void testStringArraySerialization() throws IllegalAccessException {
        String expect = "[\"1\",\"2\",\"3\"]";
        String[] arr = {"1", "2", "3"};

        String serializedArr = serialize(arr);
        Assertions.assertEquals(expect, serializedArr);
    }

    @Test
    void testBooleanArraySerialization() throws IllegalAccessException {
        String expect = "[false,false,true]";
        Boolean[] arr = {false, false, true};

        String serializedArr = serialize(arr);
        Assertions.assertEquals(expect, serializedArr);
    }

    @Test
    void testStringSerialization() throws IllegalAccessException {
        String expect = "\"Hello World!\"";
        String string = "Hello World!";

        String serializedString = serialize(string);
        Assertions.assertEquals(expect, serializedString);
    }

    @Test
    void testIntegerSerialization() throws IllegalAccessException {
        String expect = "420";
        Integer integer = 420;

        String serializedString = serialize(integer);
        Assertions.assertEquals(expect, serializedString);
    }

    @Test
    void testDoubleSerialization() throws IllegalAccessException {
        String expect = "420.52";
        Double aDouble = 420.52;

        String serializedString = serialize(aDouble);
        Assertions.assertEquals(expect, serializedString);
    }

    @Test
    void testBooleanSerialization() throws IllegalAccessException {
        String expect = "false";
        Boolean aBoolean = false;

        String serializedString = serialize(aBoolean);
        Assertions.assertEquals(expect, serializedString);
    }

}
