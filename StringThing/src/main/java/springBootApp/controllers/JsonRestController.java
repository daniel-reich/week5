package springBootApp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springBootApp.model.Sentence;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class JsonRestController {
    ArrayList<Sentence> sentences = new ArrayList<>();

    @RequestMapping("/rest/")
    public String index(@RequestParam String sentence) {
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

        for (int i=1; i<=words.size(); i++) {
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
        Sentence newSentence = new Sentence(numberWords,characters,reverse,pigLatin,searchWords);
        sentences.add(newSentence);

        String tableBuilder ="";
        for (Sentence s : sentences){
            tableBuilder = tableBuilder.concat("<tr>");
            tableBuilder = tableBuilder.concat("<td>"+s.getWords()+"</td>");
            tableBuilder = tableBuilder.concat("<td>"+s.getCharacters()+"</td>");
            tableBuilder = tableBuilder.concat("<td>"+s.getReverse()+"</td>");
            tableBuilder = tableBuilder.concat("<td>"+s.getPigLatin()+"</td>");

            tableBuilder = tableBuilder.concat("<td>");
                for (String w : s.getSearchWords()){
                    tableBuilder = tableBuilder.concat("<a href=\"http://www.google.com/search?q="+w+"\">"+w+"</a>&nbsp");
                }
            tableBuilder = tableBuilder.concat("</td>");

            tableBuilder = tableBuilder.concat("</tr>");
        }


        return "<h1>String Thing</h1>\n" +
                "\n" +
                "Enter a sentence:\n" +
                "<form action=\"/jspTest\" >\n" +
                "    <input type=\"text\" placeholder=\"Enter a sentence\" name=\"sentence\">\n" +
                "    <button type=\"submit\">Test</button>\n" +
                "</form>\n" +
                "\n" +
                "<form action=\"/rest/\" >\n" +
                "    <input type=\"text\" placeholder=\"Enter a sentence\" name=\"sentence\">\n" +
                "    <button type=\"submit\">RestTest</button>\n" +
                "</form>\n" +
                "\n"+
                "  " +
                "<table>\n" +
                "    <tr>\n" +
                "        <th># of Words</th>\n" +
                "        <th># of Characters</th>\n" +
                "        <th>Reversed</th>\n" +
                "        <th>Pig Latin</th>\n" +
                "        <th>Googled</th>\n" +
                "    </tr>\n" +
                     tableBuilder +
                "</table>"
                ;
    }

    @RequestMapping("/rest/test")
    public String test() {
        return "<h1>This is a test...</h1>";
    }
    }

