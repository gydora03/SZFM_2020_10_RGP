package ac.processing;

public class Token {
    private final MathType type;
    private final String value;

    public Token(MathType type, String value) {
        this.type = type;
        this.value = value;
    }

    public MathType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
