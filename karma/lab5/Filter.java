package karma.lab5;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class Filter implements BlackListFilter {

    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        List<String> filteredComments = new ArrayList<>();

        for (String comment : comments) {
            boolean containsBlacklistedWord = false;
            String[] words = comment.split("\\s+");

            for (String word : words) {
                if (blackList.contains(word)) {
                    containsBlacklistedWord = true;
                    break;
                }
            }

            if (!containsBlacklistedWord) {
                filteredComments.add(comment);
            }
        }

        // Заменяем исходные комментарии отфильтрованными
        comments.clear();
        comments.addAll(filteredComments);
    }
    }
