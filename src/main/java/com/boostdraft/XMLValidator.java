package com.boostdraft;

import java.util.Stack;

/**
 * This class provides a method to validate whether a given input string is a valid XML string or not.
 */
public class XMLValidator {
    /**
     * Validates if the provided XML string is well-formed.
     *
     * @param xmlString The input XML string to validate.
     * @return true if the XML is valid, false otherwise.
     */
    public boolean isValidXml(String xmlString) {
        Stack<String> openingTagsStack = new Stack<>();

        try {
            int currentIndex = 0;
            // Loop through the XML string character by character
            while (currentIndex < xmlString.length()) {
                // Find the start of the next opening tag
                int openingTagStart = xmlString.indexOf('<', currentIndex);
                if (openingTagStart == -1)
                    break; // No more opening tags found, exit the loop

                // Find the end of the corresponding closing tag
                int closingTagEnd = xmlString.indexOf('>', openingTagStart);
                if (closingTagEnd == -1)
                    throw new RuntimeException("Invalid XML: Missing closing tag.");

                // Extract the content between the opening '<' and closing '>' characters as the tag
                String currentTagContent = xmlString.substring(openingTagStart + 1, closingTagEnd);

                if (!currentTagContent.startsWith("/")) {
                    // It's an opening tag
                    openingTagsStack.push(currentTagContent);
                } else {
                    // It's a closing tag
                    currentTagContent = currentTagContent.substring(1); // Remove the '/'
                    if (openingTagsStack.isEmpty() || !openingTagsStack.pop().equals(currentTagContent))
                        throw new RuntimeException("Invalid XML: Mismatched closing tag.");
                }

                currentIndex = closingTagEnd + 1;
            }

            if (!openingTagsStack.isEmpty()) {
                throw new RuntimeException("Invalid XML: Missing closing tag for " + openingTagsStack.peek());
            }
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
            return false;
        }

        return true;
    }
}
