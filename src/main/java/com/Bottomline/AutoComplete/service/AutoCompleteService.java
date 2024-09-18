package com.Bottomline.AutoComplete.service;

import com.Bottomline.AutoComplete.model.Employee;
import com.Bottomline.AutoComplete.model.TrieNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutoCompleteService {
    @Autowired
    private TrieNode root;

    public void insertEmployeeNames(List<Employee> employeeNames) {
        //calling the insert method to fill the Trie data structure.
        for (Employee employee:employeeNames ) {
            String name = employee.getName();
            root.insert(name);
        }

    }

    public void findListOfEmployees(TrieNode root, List<String> list, StringBuffer prefixWord) {
        if (root.isWord) {
            list.add(prefixWord.toString());
        }

        if (root.children == null || root.children.isEmpty())
            return;

        for (TrieNode child : root.children.values()) {
            findListOfEmployees(child, list, prefixWord.append(child.c));
            prefixWord.setLength(prefixWord.length() - 1);
        }
    }

    public List<String> findEmployees(String employeeName) {
        List<String> list = new ArrayList<>();
        TrieNode lastNode = root;
        StringBuffer prefixWord = new StringBuffer();
        //Searching the last Node of the prefix or employeeName
        for (char c : employeeName.toCharArray()) {
            lastNode = lastNode.children.get(c);
            if (lastNode == null)
                return list;
            prefixWord.append(c);
        }
        findListOfEmployees(lastNode, list, prefixWord);
        return list;
    }
}
