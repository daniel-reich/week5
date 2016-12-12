package springBootApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springBootApp.model.Sentence;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class JspController {

    @RequestMapping(value="/")
    public String jspIndex() {
        return "index";
    }

    ArrayList<Sentence> sentences = new ArrayList<>();

    @RequestMapping(value="/jspTest")
    public String jspTest(@RequestParam String sentence, Model model) {

        //PIG LATIN

        //put words into an arraylist
        HashMap<Integer, String> words = new HashMap<>();
        ArrayList<String> searchWords = new ArrayList<>();
        String word ="";
        for (int i = 0; i<sentence.length(); i++){
            char letter = sentence.charAt(i);
            letter = Character.toUpperCase(letter);

            if (i != sentence.length()-1 && letter !=' '){
                word += letter;
            } else if (i == sentence.length()-1 && letter !=' '){
                word += letter;
                words.put(words.size()+1, word);
                word = word.toLowerCase();
                searchWords.add(word);
                word ="";
            } else {
                words.put(words.size()+1, word);
                word = word.toLowerCase();
                searchWords.add(word);
                word ="";
            }

        }

        for (int i=1; i<=words.size(); i++){
            word = words.get(i);
            if (!(word.contains("A") || word.contains("E") || word.contains("I") || word.contains("O") || word.contains("U"))){
                word = word.concat("way");
                word = word.toLowerCase();
                words.replace(i, word);
            } else if (word.charAt(0) == 'A' || word.charAt(0) == 'E' || word.charAt(0) == 'I' || word.charAt(0) == 'O' || word.charAt(0) == 'U'){
                word = word.concat("way");
                word = word.toLowerCase();
                words.replace(i, word);
            } else {
                String suffix = "";
                while (word.charAt(0) != 'A' && word.charAt(0) != 'E' && word.charAt(0) != 'I' && word.charAt(0) != 'O' && word.charAt(0) != 'U'){
                    suffix += word.charAt(0);
                    word = new StringBuilder(word).deleteCharAt(0).toString();
                }
                word = word+suffix+"ay";
                word = word.toLowerCase();
                words.replace(i, word);
            }

        }


        String pigLatin ="";
        for (int i = 1; i<=words.size(); i++){
            if (i == words.size()){
                pigLatin += words.get(i);
            } else {
                pigLatin += words.get(i)+" ";
            }

        }

        int numberWords = searchWords.size();

        int characters = sentence.length();
        String reverse = new StringBuilder(sentence).reverse().toString();
        String text = sentence;
        Sentence newSentence = new Sentence(numberWords,characters,reverse,pigLatin,searchWords);
        sentences.add(newSentence);
        model.addAttribute("sentences", sentences);

        return "index";
    }


}

