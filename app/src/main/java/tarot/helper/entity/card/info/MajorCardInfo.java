package tarot.helper.entity.card.info;

import android.support.annotation.NonNull;

import tarot.helper.entity.definitions.Arcana;
import tarot.helper.entity.definitions.Number;

public class MajorCardInfo extends CardInfo {
    private Number number;

    public MajorCardInfo(@NonNull Number number){
        super(Arcana.MAJOR);
        this.number = number;
    }

    public Number getNumber() {
        return number;
    }

    @Override
    public int compareTo(CardInfo cardInfo) {
        if(cardInfo.getClass() == MajorCardInfo.class)
            return number.compareTo(((MajorCardInfo)cardInfo).number);
        return -1;
    }

}
