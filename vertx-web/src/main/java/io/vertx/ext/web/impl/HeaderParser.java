package io.vertx.ext.web.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.vertx.ext.web.ParsedHeaderValue;

/**
 * Build with the intent of following 
 * <a href="https://tools.ietf.org/html/rfc7231#section-5.3.1">rfc7231,section-5.3.1</a>'s specification.<br>
 * 
 */
public class HeaderParser {
  
  
  private static Pattern COMMA_SPLITTER = Pattern.compile(",(?=(?:(?<!\\\\)\"(?:(?!(?<!\\\\)\").)*(?<!\\\\)\"|\\\\.|[^\"])*$)");
  private static final Pattern HYPHEN_SPLITTER = Pattern.compile("-");
  private static final Pattern PARAMETER_FINDER =
      Pattern.compile("\\s*;\\s*(?<key>[a-zA-Z0-9]+)\\s*" +
          "(?:=\\s*(?:(?<value1>[a-zA-Z0-9.@#\\-%_]+)|\"(?<value2>(?:[^\\\\\"]*(?:\\\\.)?)*)\"+))?");
  
  /**
   * Transforms each header value into the given ParsableHeaderValue
   * 
   * @param unparsedHeaderValue The header to split
   * @param objectCreator The type to instantiate for each header
   * @return The list of (unparsed) parsable header value
   */
  public static <T extends ParsedHeaderValue> List<T> convertToParsableHeaderValues(String unparsedHeaderValue,
      Function<String, T> objectCreator){
    
    String[] listedMIMEs = COMMA_SPLITTER.split(unparsedHeaderValue);
    List<T> parsedMIMEs = new ArrayList<>(listedMIMEs.length);
    for (String listedMIME : listedMIMEs) {
      parsedMIMEs.add(objectCreator.apply(quotesRemover(listedMIME)));
    }
    return parsedMIMEs;
  }
  
  static String quotesRemover(String val){
    return val.replace("\\\"", "\"");
  }
  
  static String matchedSelector(String... matches){
    for (String match : matches) {
      if(match != null){
        return match;
      }
    }
    return null;
  }

  /**
   * Parses a header value
   * 
   * @param headerContent 
   * @param valueCallback
   * @param weightCallback
   * @param parameterCallback
   */
  public static void parseHeaderValue(
        String headerContent,
        Consumer<String> valueCallback,
        Consumer<Float> weightCallback,
        BiConsumer<String, String> parameterCallback
      ) {
    int paramIndex = headerContent.indexOf(';');
    
    if(paramIndex < 0){
      valueCallback.accept(headerContent);
    } else {
      valueCallback.accept(headerContent.substring(0, paramIndex));

      Matcher paramFindings = PARAMETER_FINDER.matcher(headerContent);
      
      while(paramFindings.find()){
        String key = paramFindings.group("key");
        String value = matchedSelector(paramFindings.group("value1"), paramFindings.group("value2"));
        // If "q" doesn't have a double as a value, it is ignored on purpose!
        if("q".equalsIgnoreCase(key)){
          try{
            weightCallback.accept(Float.parseFloat(value));
          }catch(NumberFormatException e){
            // MYTODO Log as info this happened
          }
        } else {
          parameterCallback.accept(key, value);
        }
      }
    }
  }
  
  public static void parseMIME(
        String headerContent,
        Consumer<String> componentCallback,
        Consumer<String> subcomponentCallback
      ){

    int slashIndex = headerContent.indexOf('/');
    int paramIndex = headerContent.indexOf(';', slashIndex);
    
    if(slashIndex < 0){
      componentCallback.accept("*");
    } else {
      componentCallback.accept(headerContent.substring(0, slashIndex));
    }

    if(paramIndex < 0){
      subcomponentCallback.accept(headerContent.substring(slashIndex + 1));
    } else {
      subcomponentCallback.accept(headerContent.substring(slashIndex + 1, paramIndex));
    }
  }


  public static String[] parseLanguageValue(String value) {
    // Do not accept more than 9 subtags. Even more than 5 is a lot already!
    return HYPHEN_SPLITTER.split(value.trim(), 9);
  }
}