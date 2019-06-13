package tarot.helper.entity.card.info;

import android.support.annotation.NonNull;

import tarot.helper.entity.definitions.Arcana;
import tarot.helper.entity.definitions.Rank;
import tarot.helper.entity.definitions.Suit;

public class MinorCardInfo extends CardInfo {

    private Suit suit;
    private Rank rank;

    public MinorCardInfo(@NonNull Suit suit, @NonNull Rank rank) {
        super(Arcana.MINOR);
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public int compareTo(CardInfo cardInfo) {
        if(cardInfo.getClass() == MinorCardInfo.class) {
            int suitComparison = suit.compareTo(((MinorCardInfo) cardInfo).suit);
            if (suitComparison == 0)
                return rank.compareTo(((MinorCardInfo) cardInfo).rank);
            else
                return suitComparison;
        }
        return 1;
    }
}
