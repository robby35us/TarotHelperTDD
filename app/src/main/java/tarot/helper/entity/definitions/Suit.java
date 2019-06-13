package tarot.helper.entity.definitions;

public enum Suit{
    WANDS, CUPS, SWORDS, PENTACLES;

    public static final int NUM_SUITS = 4;

    @Override
    public String toString() {
        switch (this) {
            case WANDS: return "Wands";
            case CUPS: return "Cups";
            case SWORDS: return "Swords";
            case PENTACLES: return "Pentacles";
        }
        return super.toString();
    }
}