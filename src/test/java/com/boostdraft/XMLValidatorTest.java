package com.boostdraft; // Update package name as needed

import junit.framework.TestCase;
import org.junit.Test;

public class XMLValidatorTest extends TestCase {

    @Test
    public void testValidXml() {
        XMLValidator validator = new XMLValidator();
        String input = "<Design><Code>hello world</Code></Design>";
        assertTrue(validator.isValidXml(input));
    }

    @Test
    public void testInvalidXml() {
        XMLValidator validator = new XMLValidator();
        String input = "<Design><Code>hello world</Code></Design><People>";
        assertFalse(validator.isValidXml(input));
    }

    @Test
    public void testMismatchedTags() {
        XMLValidator validator = new XMLValidator();
        String input = "<Design><Code>hello world</Design></Code>";
        assertFalse(validator.isValidXml(input));
    }

    @Test
    public void testNestedMismatchedTags() {
        XMLValidator validator = new XMLValidator();
        String input = "<Design><Code>hello world</Design></Code></Design>";
        assertFalse(validator.isValidXml(input));
    }

    @Test
    public void testInvalidXmlWithAttributes() {
        XMLValidator validator = new XMLValidator();
        String input = "<People age=”1”>hello world</People>";
        assertFalse(validator.isValidXml(input));
    }
    @Test
    public void testEmptyXml() {
        XMLValidator validator = new XMLValidator();
        String input = "";
        assertTrue(validator.isValidXml(input)); // Empty XML is considered valid
    }
}
