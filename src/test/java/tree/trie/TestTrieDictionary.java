package tree.trie;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static com.google.common.truth.Truth.assertThat;

@RunWith(JUnit4.class)
public class TestTrieDictionary {

    @Test
    public void testTrieDictionary() {
        AddAndSearchWord wordDic = new AddAndSearchWord();
        wordDic.addWord("bad");
        wordDic.addWord("dad");
        wordDic.addWord("mad");
        wordDic.addWord("pad");
        assertThat(wordDic.search("bad")).isTrue();
        assertThat(wordDic.search(".ad")).isTrue();
        assertThat(wordDic.search("b..")).isTrue();
        assertThat(wordDic.search("t..")).isFalse();
    }

}
