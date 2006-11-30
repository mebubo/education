import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.List;
import java.util.ArrayList;

public class FieldReader extends Reader {

    private int access_flags;
    private int name_index;
    private int descriptor_index;
    private Reader[] attributes;

    public void readAll() throws IOException, ClassFileMagicMismatch {
	access_flags = readShort();
	name_index = readShort();
	descriptor_index = readShort();
        attributes = readTable("AttributeReader");
    }

    public void printAll() {
	System.out.format("access_flags = %d%n", access_flags);
	System.out.format("name_index = %s%n", getName(name_index));
	System.out.format("descriptor_index = %s%n", getName(descriptor_index));
        printTable(attributes);
    }

    public void printNice() {
        System.out.print(getAccessString(access_flags));
        //System.out.format("%s ", getName(descriptor_index));
        System.out.format("%s", getType(descriptor_index));
        System.out.format("%s", getName(name_index));
        System.out.format("%s", getArgs(descriptor_index));
        System.out.println(";");
    }

    /*-- Field- (and method-) specific get methods --*/
    
    /* ACC_SYNCHRONIZED (for methods) has the same value as ACC_SUPER
     * (for classes), that's why we need to treat it specially
     */
    protected String getAccessString(int flags) {
        final int ACC_SYNCHRONIZED = 0x0020;
        String string = super.getAccessString(flags);
        if((flags & ACC_SYNCHRONIZED) != 0) string += "syncronized ";
        return string;
    }

    /* Given a descriptor index, return the corresponding type as a
     * string 
     */
    private String getType(int descriptor_index) {
        String raw_descriptor = getName(descriptor_index);
        if(raw_descriptor.contains(")"))
            raw_descriptor = raw_descriptor.split("\\)")[1];
        return transformDescriptor(raw_descriptor) + " ";
    }
    
    /* Given descriptor index, return argument type list as a string */
    private String getArgs(int descriptor_index) {
        String raw_descriptor = getName(descriptor_index);
        if(raw_descriptor.contains(")")) 
            raw_descriptor = raw_descriptor.split("\\)")[0];
        else
            return "";
        Object[] descs = splitDescriptor(raw_descriptor);
        String result = "(";
        for(int i=0; i<descs.length; i++) {
            result = result + transformDescriptor((String)descs[i]);
            if (i < descs.length-1)
                result += ", ";
        }
        return result+")";
    }

    
    /*-- Utility string manipulation methods --*/

    /* Split a string of descriptors written in a row without spaces
     * (as it is in the desriptor of argument list) into an array
     */
    private Object[] splitDescriptor(String descriptor) {
            Pattern pattern = Pattern.compile("\\[*(B|C|D|F|I|J|L.*?;|S|Z|V)");
            Matcher matcher = pattern.matcher(descriptor);
            List<Object> list = new ArrayList<Object>();
            while (matcher.find()) {
                list.add(matcher.group());
            }
            return list.toArray();
    }

    /* Translate descriptor into standard java syntax. For example,
     * [[[D becomes double[][][].
     */
    private String transformDescriptor(String descriptor) {
        Pattern pattern = Pattern.compile("\\[|(.+)");
        Matcher matcher = pattern.matcher(descriptor);
        String type = "";
        String dimensions = "";
        while (matcher.find()) {
            String group = matcher.group();
            if(group.contains("["))
                dimensions = dimensions + "[]";
            else {
                switch(group.charAt(0)) {
                case('L'):
                    type = group.substring(1, group.length()-1).replace("/", ".");
                    break;
                case('B'): type = "byte"; break;
                case('C'): type = "char"; break;
                case('D'): type = "double"; break;
                case('F'): type = "float"; break;
                case('I'): type = "int"; break;
                case('J'): type = "long"; break;
                case('S'): type = "short"; break;
                case('Z'): type = "boolean"; break;
                case('V'): type = "void"; break;
                }
           }
        }    
        return type+dimensions;
    }

}
