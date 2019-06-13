package tarot.helper.entity.card.info;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;

import tarot.helper.entity.card.info.CardInfo;
import tarot.helper.entity.card.info.MajorCardInfo;
import tarot.helper.entity.card.info.MinorCardInfo;
import tarot.helper.entity.definitions.Arcana;
import tarot.helper.entity.definitions.Number;
import tarot.helper.entity.definitions.Rank;
import tarot.helper.entity.definitions.Suit;

public class CardInfoTest {
    private static final Number TEST_NUMBER = Number.EIGHT;
    private static final Number TEST_NUMBER_LESS_THAN = Number.TWO;
    private static final Number TEST_NUMBER_GREATER_THAN = Number.TWENTY_ONE;
    private static final Suit TEST_SUIT = Suit.CUPS;
    private static final Suit TEST_SUIT_LESS_THAN = Suit.WANDS;
    private static final Suit TEST_SUIT_GREATER_THAN = Suit.PENTACLES;
    private static final Rank TEST_RANK = Rank.FOUR;
    private static final Rank TEST_RANK_LESS_THAN = Rank.THREE;
    private static final Rank TEST_RANK_GREATER_THAN = Rank.SEVEN;

    private static final int EQUAL_CODE = 0;

    private CardInfo cardInfo;
    private MajorCardInfo majorCardInfo;
    private MinorCardInfo minorCardInfo;

    @Before
    public void constructCard() {
        majorCardInfo = new MajorCardInfo(TEST_NUMBER);
        minorCardInfo = new MinorCardInfo(TEST_SUIT, TEST_RANK);
        cardInfo = majorCardInfo;
    }

    @Test
    public void getArcana_NonNull() {
        assertThat(cardInfo.getArcana(), notNullValue());
    }

    @Test
    public void constructMajorCardInfo() {
        assertThat(majorCardInfo, notNullValue());
    }

    @Test
    public void majorCardInfo_ReturnsMajorArcana() {
        assertThat(majorCardInfo.getArcana(), equalTo(Arcana.MAJOR));
    }

    @Test
    public void majorCardGetNumber_NonNull() {
        assertThat(majorCardInfo.getNumber(), notNullValue());
    }

    @Test
    public void majorCardGetNumber_ReturnsConstructorInput() {
        assertThat(majorCardInfo.getNumber(), equalTo(TEST_NUMBER));
    }

    @Test
    public void constructMinorCard() {
        assertThat(minorCardInfo, notNullValue());
    }

    @Test
    public void minorCardInfo_ReturnsMinorArcana() {
        assertThat(minorCardInfo.getArcana(), equalTo(Arcana.MINOR));
    }

    @Test
    public void minorCardInfo_ReturnsNonNullSuit() {
        assertThat(minorCardInfo.getSuit(), notNullValue());
    }

    @Test
    public void minorCardInfoGetSuit_ReturnsConstructorValue() {
        assertThat(minorCardInfo.getSuit(), equalTo(TEST_SUIT));
    }

    @Test
    public void minorCardInfoGetRank_ReturnsNonNull() {
        assertThat(minorCardInfo.getRank(), notNullValue());
    }

    @Test
    public void minorCardInfoGetRank_ReturnsConstructorValue() {
        assertThat(minorCardInfo.getRank(), equalTo(TEST_RANK));
    }

    @Test
    public void majorCardCompareTo_WhenEqual() {
        assertThat(majorCardInfo.compareTo(new MajorCardInfo(TEST_NUMBER)), equalTo(EQUAL_CODE));
    }

    @Test
    public void majorCardCompareTo_WithLessThan() {
        assertThat(majorCardInfo.compareTo(new MajorCardInfo(TEST_NUMBER_LESS_THAN)) > 0,
                   is(true));
    }

    @Test
    public void majorCardCompareTo_WithGreaterThan() {
        assertThat(majorCardInfo.compareTo(new MajorCardInfo(TEST_NUMBER_GREATER_THAN)) < 0,
                   is(true));
    }

    @Test
    public void majorCardCompareTo_MinorCard() {
        assertThat( majorCardInfo.compareTo(minorCardInfo) < 0 , is(true));
    }

    @Test
    public void minorCardCompareTo_WhenEqual() {
        assertThat(minorCardInfo.compareTo(new MinorCardInfo(TEST_SUIT, TEST_RANK)), equalTo(EQUAL_CODE));
    }

    @Test
    public void minorCardCompareTo_WithSuitLessThan() {
        assertThat(minorCardInfo.compareTo(new MinorCardInfo(TEST_SUIT_LESS_THAN, TEST_RANK)) > 0,
                   is(true));
    }

    @Test
    public void minorCardCompareTo_WithSuitGreaterThan() {
        assertThat(minorCardInfo.compareTo(new MinorCardInfo(TEST_SUIT_GREATER_THAN, TEST_RANK)) < 0,
                is(true));
    }

    @Test
    public void minorCardCompareTo_SuitsNotEqualRanksNotEqual() {
        assertThat(minorCardInfo.compareTo(new MinorCardInfo(TEST_SUIT_LESS_THAN, TEST_RANK_LESS_THAN)) > 0,
                is(true));
    }

    @Test
    public void minorCardCompareTo_SuitsEqualRankLessThan() {
        assertThat(minorCardInfo.compareTo(new MinorCardInfo(TEST_SUIT, TEST_RANK_LESS_THAN)) > 0,
                is(true));
    }

    @Test
    public void minorCardCompareTo_SuitsEqualRankGreaterThan() {
        assertThat(minorCardInfo.compareTo(new MinorCardInfo(TEST_SUIT, TEST_RANK_GREATER_THAN)) < 0,
                is(true));
    }

    @Test
    public void minorCardCompareTo_MajorCard() {
        assertThat(minorCardInfo.compareTo(majorCardInfo) > 0, is(true));
    }
}
