public class MyRange {
    public static final int ASCII_VALUE = 48;
    private final String input;

    public MyRange(String input) {
        this.input = input;
    }

    public boolean isStartWithInclude() {
        return this.input.startsWith("[");
    }

    public int getStart() {
        if(isStartWithInclude()) {
            return this.input.charAt(1) - ASCII_VALUE;
        }
        return -1;
    }

    public int getEnd() {
        if(isEndWithInclude()) {
            return this.input.charAt(3) - ASCII_VALUE;
        }
        return -1;
    }

    public boolean isEndWithInclude() {
        return this.input.endsWith("]");
    }
}
