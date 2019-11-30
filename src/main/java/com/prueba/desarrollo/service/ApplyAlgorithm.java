package com.prueba.desarrollo.service;

import org.springframework.stereotype.Service;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class ApplyAlgorithm implements IApplyAlgorithm {
    private Map<String,Integer> operators;
    private List<String> characters;

    @Override
    public String aplyAlgorithm(String input, Map<String,Integer> operators, List<String> characters) throws Exception {
        this.operators=operators;
        this.characters=characters;
        StringBuilder output = new StringBuilder();
        Deque<String> stack  = new LinkedList<>();

        char[] charArray  = input.toCharArray();
        for (char char1: charArray) {
            String character = String.valueOf(char1);
            // operator
            if (operators.containsKey(character)) {
                while ( ! stack.isEmpty() && isHigerPrecedence(character, stack.peek()))
                    output.append(stack.pop());
                stack.push(character);
                // is a valid character ?
            } else if (this.characters.contains(character)) {
                output.append(character);
                // if not valid then exception
            } else {
                throw new Exception("The expresion "+input+" is invalid");
            }
        }

        while ( ! stack.isEmpty())
            output.append(stack.pop());

        return output.toString();
    }

    @Override
    public double result(String expresion) {
        return 0;
    }

    private boolean isHigerPrecedence(String character, String initStack){
        return (operators.containsKey(initStack) && operators.get(initStack) >= operators.get(character));
    }
}
