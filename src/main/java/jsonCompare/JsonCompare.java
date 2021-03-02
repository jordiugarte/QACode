package jsonCompare;

public class JsonCompare {

    public static boolean jsonCompare(String json1, String json2) {
        boolean go = true;
        String json1NoBegginingkey = json1.replace("{", "");
        String json1NoEndKey = json1NoBegginingkey.replace("}", "");
        String json2NoBegginingKey = json2.replace("{", "");
        String json2NoEndKey = json2NoBegginingKey.replace("}", "");
        String[] a1 = json1NoEndKey.split(",");
        String[] a2 = json2NoEndKey.split(",");
        for (int i = 0; i < a1.length; i++) {
            String[] b1 = a1[i].split(":");
            String[] b2 = a2[i].split(":");
            if (!b1[1].equals(b2[1]) && !b2[1].equals("\"IGNORE\"")) {
                go = false;
                break;
            }
        }
        return go;
    }
}
