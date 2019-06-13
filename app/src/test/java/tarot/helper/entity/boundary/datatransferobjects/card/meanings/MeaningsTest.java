package tarot.helper.entity.boundary.datatransferobjects.card.meanings;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MeaningsTest {
    private static final String TEST_BASIC = "Test Meaning";
    private static final String TEST_BASIC_OTHER = "Other Test Meaning";
    private static final String TEST_KEYWORD_1 = "Test Keyword 1";
    private static final String TEST_KEYWORD_2 = "Test Keyword 2";
    private static final String TEST_KEYWORD_3 = "Test Keyword 3";
    private static final String TEST_KEYWORD_4 = "Test Keyword 4";
    private static final String TEST_KEYWORD_OTHER_1 = "Test Keyword Other 1";

    private Meanings meanings;
    private List<String> testKeywords;
    private List<String> otherTestKeywords;

    @Before
    public void constructMeaning(){
        testKeywords = new ArrayList<>();
        testKeywords.add(TEST_KEYWORD_1);
        testKeywords.add(TEST_KEYWORD_2);
        testKeywords.add(TEST_KEYWORD_3);
        testKeywords.add(TEST_KEYWORD_4);
        meanings = new Meanings(TEST_BASIC, testKeywords);

        otherTestKeywords = new ArrayList<>();
        otherTestKeywords.add(TEST_KEYWORD_OTHER_1);
    }

    @Test
    public void basic_NonNull(){
        assertThat(meanings.getBasic(), notNullValue());
    }

    @Test
    public void basic_NonEmpty() {
        assertThat(meanings.getBasic().length(), not(equalTo(0)));
    }

    @Test
    public void basic_ReturnsConstructorInput() {
        assertThat(meanings.getBasic(), equalTo(TEST_BASIC));
    }

    @Test
    public void basicCanBeUpdated() {
        meanings.setBasic(TEST_BASIC_OTHER);
        assertThat(meanings.getBasic(), equalTo(TEST_BASIC_OTHER));
    }

    @Test
    public void keywords_ReturnsNonNULL() {
        assertThat(meanings.getKeywords(), notNullValue());
    }

    @Test
    public void keywordsSize_NonZero() {
        assertThat(meanings.getKeywords().size(), not(equalTo(0)));
    }

    @Test
    public void keywordsSize_ReturnsInputSize() {
        assertThat(meanings.getKeywords().size(), equalTo(testKeywords.size()));
    }

    @Test
    public void getKeywords_ReturnsConstructorInput(){
        List<String> keywordsOutPut = meanings.getKeywords();
        for(int i = 0; i < testKeywords.size(); i++) {
            assertThat(testKeywords.get(i), equalTo(keywordsOutPut.get(i)));
        }
    }

    @Test
    public void setKeywords_ReturnsSameSizeAsInput() {
        meanings.setKeywords(otherTestKeywords);
        assertThat(meanings.getKeywords().size(), equalTo(otherTestKeywords.size()));
    }

    @Test
    public void setKeywords_ReturnsSameAsInput() {
        meanings.setKeywords(otherTestKeywords);
        List<String> keywordsOutPut = meanings.getKeywords();
        for(int i = 0; i < otherTestKeywords.size(); i++) {
            assertThat(keywordsOutPut.get(i), equalTo(otherTestKeywords.get(i)));
        }
    }


}
