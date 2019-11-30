package com.prueba.desarrollo.service;

import com.prueba.desarrollo.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ApplyAlgorithm implements IApplyAlgorithm {
    private Map<String,Integer> operators;


    @Override
    public String aplyAlgorithm(String input, Map<String,Integer> operators, List<String> characters) throws Exception {
        this.operators=operators;

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
                // is a valid character and not an operator?
            } else if (characters.contains(character)&&!operators.containsKey(character)) {
                output.append(character);
                // if not valid then exception
            } else {
                throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,"Some error ocurred while processing the expression");
            }
        }

        while ( ! stack.isEmpty())
            output.append(stack.pop());

        return output.toString();
    }

    @Override
    public double result(String expresion, Map<String,Integer> operators, List<String> characters) throws Exception {

        //create a stack
        Deque<Integer> stack=new LinkedList<>();

        // Scan all characters one by one
        for(int i=0;i<expresion.length();i++)
        {
            char c=expresion.charAt(i);
            // If the scanned character is an operand (number here),
            // push it to the stack.
            if(characters.contains(String.valueOf(c))&&!operators.containsKey(String.valueOf(c))){
                stack.push(c - '0');
            }
                //  If the scanned character is an operator, pop two
                // elements from stack apply the operator
            else if(operators.containsKey(String.valueOf(c))) {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch(c)
                {
                    case '+':
                        stack.push(val2+val1);
                        break;

                    case '-':
                        stack.push(val2- val1);
                        break;

                    case '/':
                        stack.push(val2/val1);
                        break;

                    case '*':
                        stack.push(val2*val1);
                        break;
                    default:
                        throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,"Some error ocurred while processing the expression");
                }
            }
        }
        return stack.pop();
    }

    private boolean isHigerPrecedence(String character, String initStack){
        return (operators.containsKey(initStack) && operators.get(initStack) >= operators.get(character));
    }
}
