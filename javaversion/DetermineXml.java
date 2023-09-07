import java.util.Stack;

public class DetermineXml {
    public static boolean DetermineXml(String xml) {
        Stack<String> stack = new Stack<>();
        int index = 0;

        while (index < xml.length()) {
            // Find the next opening tag
            int start = xml.indexOf('<', index);

            if (start == -1) {
                break; // No more opening tags found
            }

            // Find the closing tag corresponding to the opening tag
            int end = xml.indexOf('>', start);

            if (end == -1) {
                return false; // No corresponding closing tag
            }

            String openingTag = xml.substring(start + 1, end);

            if (openingTag.startsWith("/")) {
                // Found a closing tag, pop the stack and check if it matches
                openingTag = openingTag.substring(1);

                if (stack.isEmpty() || !stack.pop().equals(openingTag)) {
                    return false; // Mismatched closing tag
                }
            } else {
                // Found an opening tag, push it onto the stack
                stack.push(openingTag);
            }

            index = end + 1;
        }

        // If the stack is empty, all opening tags have a corresponding closing tag
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String xml1 = "<Design><Code>hello world</Code></Design>";
        String xml2 = "<Design><Code>hello world</Code></Design><People>";
        String xml3 = "<People><Design><Code>hello world</People></Code></Design>";
        String xml4 = "<People age=\"1\">hello world</People>";
        String xml5 = "";

        System.out.println(DetermineXml(xml1)); // true
        System.out.println(DetermineXml(xml2)); // false
        System.out.println(DetermineXml(xml3)); // false
        System.out.println(DetermineXml(xml4)); // false
        System.out.println(DetermineXml(xml5)); // true
    }
}
