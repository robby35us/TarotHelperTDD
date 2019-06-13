package tarot.helper.entity.card.meanings;

import android.support.annotation.NonNull;
import java.util.List;

public class Meanings {
    private String basic;
    private List<String> keywords;

    public Meanings(@NonNull String basic, @NonNull List<String> keywords) throws IllegalArgumentException {
        setBasic(basic);
        setKeywords(keywords);
    }

    public String getBasic() {
        return basic;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setBasic(@NonNull String basic) throws IllegalArgumentException {
        if(stringIsEmpty(basic))
            throw new IllegalArgumentException();
        this.basic = basic;
    }

    public void setKeywords(@NonNull List<String> keywords) throws  IllegalArgumentException {
        if(keywordsListIsEmpty(keywords))
            throw new IllegalArgumentException();
        this.keywords = keywords;
    }

    private boolean stringIsEmpty(String string) {
        return string.length() == 0;
    }

    private boolean keywordsListIsEmpty(List<String> keywords) {
        return keywords.size() == 0;
    }
}
