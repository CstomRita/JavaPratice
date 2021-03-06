package algorithm.offerAlgorithm.stringProblem;

/**
 * @ Author     ：ChangSiteng
 * @ Date       ：Created in 09:37 2019-03-08
 * @ Description：替换空格
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @ Modified By：
 * @Version: $
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        StringBuffer result = new StringBuffer();
        for(char c : str.toString().toCharArray()) {
            if (c == ' ') {
                result.append("%20");
            }else {
                result.append(c);
            }
        }
        return result.toString();
    }

}
