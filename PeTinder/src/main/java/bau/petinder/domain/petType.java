package bau.petinder.domain;

public enum petType {
    DOG(10),
    CAT(20);

    private final int value;

    private petType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
