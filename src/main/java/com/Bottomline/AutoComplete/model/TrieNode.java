package com.Bottomline.AutoComplete.model;


import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TrieNode {
    public Map<Character, TrieNode> children;
    public char c;
    public boolean isWord;

    public TrieNode(char c) {
        this.c = c;
        children = new HashMap<>();
    }

    public TrieNode() {
        children = new HashMap<>();
    }

    public void insert(String word) {
        //inserting all the words in the Trie data structure.
        if (word == null || word.isEmpty())
            return;
        char firstChar = word.charAt(0);
        TrieNode child = children.get(firstChar);
        if (child == null) {
            child = new TrieNode(firstChar);
            children.put(firstChar, child);
        }

        if (word.length() > 1)
            child.insert(word.substring(1));
        else
            child.isWord = true;
    }
}
