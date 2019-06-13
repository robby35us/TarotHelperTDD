package tarot.helper.entity.definitions;

public enum Arcana {
    MAJOR, MINOR;

    private static final int MAJOR_ARCANA_SIZE = 22;
    private static final int MINOR_ARCANA_SIZE = 56;

    public int size() {
        return this == MAJOR ? MAJOR_ARCANA_SIZE : MINOR_ARCANA_SIZE;
    }
}
