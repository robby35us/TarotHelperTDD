package tarot.helper.entity.deck;

import android.support.annotation.NonNull;

import java.util.Map;
import java.util.TreeMap;

import tarot.helper.entity.boundary.datatransferobjects.card.Card;
import tarot.helper.entity.boundary.datatransferobjects.info.CardInfo;

public class Deck {
    private static Deck deck;

    private Map<CardInfo, Card> cards;

    public static Deck getInstance() {
        if(deck == null)
            deck = new Deck();
        return deck;
    }

    Deck() {
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
