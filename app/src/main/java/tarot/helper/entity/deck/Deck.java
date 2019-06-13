package tarot.helper.entity.deck;

import android.support.annotation.NonNull;

import java.util.Map;
import java.util.TreeMap;

import tarot.helper.entity.card.Card;
import tarot.helper.entity.card.info.CardInfo;

public class Deck {
    private Map<CardInfo, Card> cards;

    public Deck() {
        cards = new TreeMap<>();
    }

    public boolean addCard(@NonNull Card card) {
        if(!cards.containsKey(card.getInfo())) {
            cards.put(card.getInfo(), card);
            return true;
        }
        return false;
    }

    public Card getCard(CardInfo info) {
        return cards.get(info);
    }

    public boolean hasCard(CardInfo info) {
        return cards.containsKey(info);
    }
}
