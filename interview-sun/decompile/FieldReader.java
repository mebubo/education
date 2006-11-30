import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.List;
import java.util.ArrayList;

public class FieldReader extends Reader {

    protected int access_flags;
    protected int name_index;
    protected int descriptor_index;
    protected Reader[] attributes;

    public void readAll() throws IOException {
	access_flags = read2();
	name_index = read2();
	descriptor_index = read2();
        attributes = readTable("AttributeReader");
    }

    public void printAll() {
	System.out.format("access_flags = %d%n", access_flags);
	System.out.format("name_index = %s%n", constant_pool.get(name_index-1));
	System.out.format("descriptor_index = %s%n", constant_pool.get(descriptor_index-1));
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

    /* Field- (and method-) specific get methods */
    public String getType(int descriptor_index) {
        String raw_descriptor = getName(descriptor_index);
        if(raw_descriptor.contains(")"))
            raw_descriptor = raw_descriptor.split("\\)")[1];
        Object[] descs = splitDescriptor(raw_descriptor);
        String result = "";
        for(int i=0; i<descs.length; i++) {
            result = result + transformDescriptor((String)descs[i]) + " ";
        }
        return result;
    }
    
    public String getArgs(int descriptor_index) {
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

    
    /* Utility string manipulation methods */
    public Object[] splitDescriptor(String descriptor) {
            Pattern pattern = Pattern.compile("\\[*(B|C|D|F|I|J|L.*?;|S|Z|V)");
            Matcher matcher = pattern.matcher(descriptor);
            List<Object> list = new ArrayList<Object>();
            while (matcher.find()) {
                list.add(matcher.group());
            }
            return list.toArray();
    }

    public String transformDescriptor(String descriptor) {
        Pattern pattern = Pattern.compile("\\[|(.+)");
        Matcher matcher = pattern.matcher(descriptor);
        String type = "";
        String dimensions = "";
        while (matcher.find()) {
            //            System.out.println("foo " + matcher.group() + " bar " + descriptor);
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
