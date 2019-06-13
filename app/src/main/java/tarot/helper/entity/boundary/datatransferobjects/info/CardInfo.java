package tarot.helper.entity.boundary.datatransferobjects.info;

import android.support.annotation.NonNull;

import tarot.helper.entity.definitions.Arcana;

public abstract class CardInfo implements Comparable<CardInfo>{
    private Arcana arcana;

    public CardInfo(@NonNull Arcana arcana) {
        this.arcana = arcana;
    }

    public Arcana getArcana() {
        return arcana;
    }

    @Override
    public boolean equals(Object o) {
        if(o.getClass().getSuperclass()  == CardInfo.class)
            return this.compareTo((CardInfo) o) == 0;
        return false;
    }
}
