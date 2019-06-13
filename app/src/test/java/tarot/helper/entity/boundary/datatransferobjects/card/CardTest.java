package tarot.helper.entity.boundary.datatransferobjects.card;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import tarot.helper.entity.boundary.datatransferobjects.info.MajorCardInfo;
import tarot.helper.entity.boundary.datatransferobjects.info.MinorCardInfo;
import tarot.helper.entity.boundary.datatransferobjects.card.meanings.Meanings;
import tarot.helper.entity.definitions.Number;
import tarot.helper.entity.definitions.Rank;
import tarot.helper.entity.definitions.Suit;

public class CardTest {
    private static final Number MAJOR_CARD_NUMBER = Number.EIGHT;
    private static final Suit MINOR_CARD_SUIT = Suit.SWORDS;
    private static final Rank MINOR_CARD_RANK = Rank.FIVE;
    private static final String TEST_MEANING = "Test Meaning";
    private static final String TEST_KEYWORD = "Test Keyword";

    private Card majorCard;
    private Card minorCard;
    private Meanings uprightMeanings;
    private Meanings reversedMeanings;

    @Before
    public void constructCardWithInfo() {
        majorCard = new Card(new MajorCardInfo(MAJOR_CARD_NUMBER));
        minorCard = new Card(new MinorCardInfo(MINOR_CARD_SUIT, MINOR_CARD_RANK));

        List<String> keywordsList = new ArrayList<>();
        keywordsList.add(TEST_KEYWORD);

        uprightMeanings = new Meanings(TEST_MEANING, keywordsList);
        reversedMeanings = new Meanings(TEST_MEANING, keywordsList);
    }

    @Test
    public void majorCard_ReturnsSameInfo() {
        assertThat(((MajorCardInfo) majorCard.getInfo()).getNumber(), equalTo(MAJOR_CARD_NUMBER));
    }

    @Test
    public void minorCard_ReturnsSameInfo() {
        assertThat(((MinorCardInfo) minorCard.getInfo()).getSuit(), equalTo(MINOR_CARD_SUIT));
        assertThat(((MinorCardInfo) minorCard.getInfo()).getRank(), equalTo(MINOR_CARD_RANK));
    }

    @Test
    public void canSetUprightMeaning() {
        majorCard.setUprightMeanings(uprightMeanings);
        assert(true);
    }

    @Test
    public void canSetReversedMeaning() {
        majorCard.setReversedMeanings(reversedMeanings);
        assert(true);
    }

    @Test
    public void getUprightMeanings_returnsNullIfNotSet() {
        assertThat( majorCard.getUprightMeanings() , is(nullValue()));
    }

    @Test
    public void getReversedMeanings_returnsNullIfNotSet() {
        assertThat(majorCard.getReversedMeanings(), is(nullValue()));
    }

    @Test
    public void uprightMeanings_NotNullOnceSet() {
        minorCard.setUprightMeanings(uprightMeanings);
        assertThat(minorCard.getUprightMeanings(), notNullValue());
    }

    @Test
    public void setReversedMeanings_NotNullOnceSet() {
        minorCard.setReversedMeanings(reversedMeanings);
        assertThat(minorCard.getReversedMeanings(), notNullValue());
    }
}
