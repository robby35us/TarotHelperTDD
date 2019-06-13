package tarot.helper.entity.boundary.datatransferobjects.card;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import tarot.helper.entity.boundary.datatransferobjects.info.CardInfo;
import tarot.helper.entity.boundary.datatransferobjects.card.meanings.Meanings;

public class Card {
    private CardInfo info;
    private Meanings uprightMeanings;
    private Meanings reversedMeanings;

    public Card(@NonNull CardInfo info) {
        this.info = info;
    }

    public CardInfo getInfo() {
        return info;
    }

    @Nullable
    public Meanings getUprightMeanings() {
        return uprightMeanings;
    }

    @Nullable
    public Meanings getReversedMeanings() {
        return reversedMeanings;
    }

    public void setUprightMeanings(@NonNull Meanings uprightMeanings) {
        this.uprightMeanings = uprightMeanings;
    }

    public void setReversedMeanings(@NonNull Meanings reversedMeanings) {
        this.reversedMeanings = reversedMeanings;
    }
}
