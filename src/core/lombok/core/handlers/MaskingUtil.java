package lombok.core.handlers;

import lombok.ToString;
import lombok.core.AnnotationValues;
import lombok.core.LombokNode;
import lombok.javac.JavacNode;
import lombok.javac.handlers.JavacHandlerUtil;

import java.util.ArrayList;
import java.util.List;

public class MaskingUtil {

    public static List<JavacNode> handleToStringMaskingMarking(JavacNode typeNode) {
        List<JavacNode> maskedMembers = new ArrayList<JavacNode>();
        for (JavacNode child : typeNode.down()) {
            JavacNode annotation = JavacHandlerUtil.findAnnotation(ToString.Mask.class, child, false);
            if(annotation!=null)
                maskedMembers.add(child);
        }
        return maskedMembers;
    }

}
