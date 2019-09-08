from collections import Counter
class Solution:
    def findAnagrams(self, s: str, p: str):
        window_size = len(p)
        p_word_counter = Counter(p)
        window = Counter(s[:window_size])
        res = list()
        if window == p_word_counter:
            res.append(0)
            
        for idx in range(1,len(s)-window_size + 1):
            minus = {s[idx-1]:1}
            plus = {s[idx+window_size-1]:1}
            window -= minus
            window += plus
            if window == p_word_counter:
                res.append(idx)
        return res