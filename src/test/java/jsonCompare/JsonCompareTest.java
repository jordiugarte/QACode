package jsonCompare;

import calculator.Calculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(value = Parameterized.class)
public class JsonCompareTest {

    private String json1;
    private String json2;
    private boolean result;

    public JsonCompareTest(String json1, String json2, boolean result) {
        this.json1 = json1;
        this.json2 = json2;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getData() {
        List<Object[]> objects = new ArrayList<>();
        objects.add(new Object[]{"{ \"name\":\"John\", \"age\":30, \"car\":null }", "{ \"name\":\"John\", \"age\":30, \"car\":null }", true});
        objects.add(new Object[]{"{ \"name\":\"Jonh\", \"age\":30, \"car\":null }", "{ \"name\":\"John\", \"age\":30, \"car\":null }", false});
        objects.add(new Object[]{"{ \"name\":\"Jonh\", \"age\":30, \"car\":null }", "{ \"name\":\"John\", \"age\":30, \"car\":30 }", false});
        objects.add(new Object[]{"{ \"name\":\"Jonh\" }", "{ \"name\":\"John\", \"age\":30, \"car\":30 }", false});
        objects.add(new Object[]{"{ \"name\":\"Jonh\" }", "{ \"name\":\"John\", \"car\":30 }", false});
        objects.add(new Object[]{"{\"widget\": {\n" +
                "    \"debug\": \"on\",\n" +
                "    \"window\": {\n" +
                "        \"title\": \"Sample Konfabulator Widget\",\n" +
                "        \"name\": \"main_window\",\n" +
                "        \"width\": 500,\n" +
                "        \"height\": 500\n" +
                "    },\n" +
                "    \"image\": { \n" +
                "        \"src\": \"Images/Sun.png\",\n" +
                "        \"name\": \"sun1\",\n" +
                "        \"hOffset\": 250,\n" +
                "        \"vOffset\": 250,\n" +
                "        \"alignment\": \"center\"\n" +
                "    },\n" +
                "    \"text\": {\n" +
                "        \"data\": \"Click Here\",\n" +
                "        \"size\": 36,\n" +
                "        \"style\": \"bold\",\n" +
                "        \"name\": \"text1\",\n" +
                "        \"hOffset\": 250,\n" +
                "        \"vOffset\": 100,\n" +
                "        \"alignment\": \"center\",\n" +
                "        \"onMouseUp\": \"sun1.opacity = (sun1.opacity / 100) * 90;\"\n" +
                "    }\n" +
                "}}    ", "{\"widget\": {\n" +
                "    \"debug\": \"on\",\n" +
                "    \"window\": {\n" +
                "        \"title\": \"Sample Konfabulator Widget\",\n" +
                "        \"name\": \"main_window\",\n" +
                "        \"width\": 500,\n" +
                "        \"height\": 500\n" +
                "    },\n" +
                "    \"image\": { \n" +
                "        \"src\": \"Images/Sun.png\",\n" +
                "        \"name\": \"sun1\",\n" +
                "        \"hOffset\": 250,\n" +
                "        \"vOffset\": 250,\n" +
                "        \"alignment\": \"center\"\n" +
                "    },\n" +
                "    \"text\": {\n" +
                "        \"data\": \"Click Here\",\n" +
                "        \"size\": 36,\n" +
                "        \"style\": \"bold\",\n" +
                "        \"name\": \"text1\",\n" +
                "        \"hOffset\": 250,\n" +
                "        \"vOffset\": 100,\n" +
                "        \"alignment\": \"center\",\n" +
                "        \"onMouseUp\": \"sun1.opacity = (sun1.opacity / 100) * 90;\"\n" +
                "    }\n" +
                "}}    ", true});
        objects.add(new Object[]{"{\"widget\": {\n" +
                "    \"debig\": \"on\",\n" +
                "    \"window\": {\n" +
                "        \"title\": \"Sample Konfabulator Widget\",\n" +
                "        \"name\": \"main_window\",\n" +
                "        \"width\": 500,\n" +
                "        \"height\": 500\n" +
                "    },\n" +
                "    \"image\": { \n" +
                "        \"src\": \"Images/Sun.png\",\n" +
                "        \"name\": \"sun1\",\n" +
                "        \"hOffset\": 250,\n" +
                "        \"asdfasdas\": saassaassa,\n" +
                "        \"alignment\": \"center\"\n" +
                "    },\n" +
                "    \"text\": {\n" +
                "        \"data\": \"Click Here\",\n" +
                "        \"size\": 36,\n" +
                "        \"style\": \"bold\",\n" +
                "        \"name\": \"text1\",\n" +
                "        \"hOffset\": 250,\n" +
                "        \"vOffset\": 100,\n" +
                "        \"alignment\": \"center\",\n" +
                "        \"onMouseUp\": \"sun1.opacity = (sun1.opacity / 100) * 90;\"\n" +
                "    }\n" +
                "}}    ", "{\"asdasdasd\": {\n" +
                "    \"debug\": \"on\",\n" +
                "    \"window\": {\n" +
                "        \"title\": \"Sample Konfabulator Widget\",\n" +
                "        \"name\": \"asdasdasd\",\n" +
                "        \"width\": 500,\n" +
                "        \"height\": 500\n" +
                "    },\n" +
                "    \"image\": { \n" +
                "        \"src\": \"Images/Sun.png\",\n" +
                "        \"name\": \"sun1\",\n" +
                "        \"hOffset\": 250,\n" +
                "        \"vOffset\": 250,\n" +
                "        \"alignment\": \"center\"\n" +
                "    },\n" +
                "    \"text\": {\n" +
                "        \"data\": \"Click Here\",\n" +
                "        \"size\": 36,\n" +
                "        \"style\": \"bold\",\n" +
                "        \"name\": \"text1\",\n" +
                "        \"hOffset\": 250,\n" +
                "        \"vOffset\": 100,\n" +
                "        \"alignment\": \"center\",\n" +
                "        \"onMouseUp\": \"sun1.opacity = (sun1.opacity / 100) * 90;\"\n" +
                "    }\n" +
                "}}    ", false});
        objects.add(new Object[]{"{ \"name\":\"John\" }", "{ \"name\":\"John\" }", true});
        objects.add(new Object[]{"{ \"name\":\"John\" }", "{ \"name\":\"Mary\" }", false});
        objects.add(new Object[]{"{ \"name\":\"Juan\" }", "{ \"name\":\"Mary\" }", false});
        objects.add(new Object[]{"{ \"content\":\"f\" }", "{ \"name\":\"true\" }", false});
        objects.add(new Object[]{"{ \"type\":\"true\" }", "{ \"type\":\"true\" }", true});
        objects.add(new Object[]{"{ \"number\":1 }", "{ \"number\":1 }", true});
        objects.add(new Object[]{"{ \"number\":1 }", "{ \"number\":2 }", false});
        objects.add(new Object[]{"{ \"number\":2 }", "{ \"nmber\":1 }", false});
        objects.add(new Object[]{"{ \"val\":true }", "{ \"val\":true }", true});
        objects.add(new Object[]{"{ \"val\":false }", "{ \"val\":true }", false});
        objects.add(new Object[]{"{ \"ffff\":2 }", "{ \"nmbeffr\":1 }", false});

        return objects;
    }

    @Test
    public void verify_comparison_all_values() {
        JsonCompare jsonCompare = new JsonCompare();
        boolean actualResult = jsonCompare.jsonCompare(this.json1, this.json2);
        Assert.assertEquals("ERROR: No son iguales", this.result, actualResult);
    }
}
