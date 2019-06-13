package tarot.helper.entity.deck;

import org.junit.Before;
import org.junit.Test;

import tarot.helper.entity.card.Card;
import tarot.helper.entity.card.info.MajorCardInfo;
import tarot.helper.entity.definitions.Number;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeckTest {
    private Deck deck;
    private Card major17;

    @Before
    public void canConstructDeck() {
        deck = new Deck();
        major17 = new Card(new MajorCardInfo(Number.SEVENTEEN));
    }

    @Test
    public void canAddCard() {
        assertThat(deck.addCard(major17), is(true));
    }

    @Test
    public void cantAddSameCardTwice() {
        deck.addCard(major17);
        assertThat(deck.addCard(major17), is(false));
    }

    @Test
    public void canCheckIfCardAddedByInfo() {
        deck.addCard(major17);
        assertThat(deck.hasCard(major17.getInfo()), is(true));
    }

    @Test
    public void canRetrieveCard() {
        deck.addCard(major17);
        assertThat(deck.getCard(major17.getInfo()), is(major17));
    }

    @Test
    public void canAddMultipleCards() {
        for(Number number: Number.values())
            deck.addCard(new Card(new MajorCardInfo(number)));
        for(Number number: Number.values())
            assertThat(deck.hasCard(new MajorCardInfo(number)), is(true));
    }
}
