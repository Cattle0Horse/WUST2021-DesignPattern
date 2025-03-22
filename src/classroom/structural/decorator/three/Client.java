package classroom.structural.decorator.three;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Cattle_Horse
 * @date : 2023/11/3 14:55
 * @description : 组合模式课堂作业
 */
public class Client {
    static int count = 0;

    public static void main(String[] args) {
        AbstractFile rootFolder = new Folder("C:\\");
        AbstractFile compositeFolder = new Folder("composite");
        AbstractFile windowFolder = new Folder("windows");
        AbstractFile file = new File("TestComposite.java");
        AbstractFile file2 = new File("TestComposite1.java");
        rootFolder.addChild(compositeFolder);
        rootFolder.addChild(windowFolder);
        compositeFolder.addChild(file);
        compositeFolder.addChild(file2);
        printTree(rootFolder);
    }

    private static void print(String str) {
        for (int i = 0; i < count; ++i) {
            System.out.print("\t");
        }
        System.out.print(str);
    }

    private static void println(String str) {
        for (int i = 0; i < count; ++i) {
            System.out.print("\t");
        }
        System.out.println(str);
    }

    private static void printTree(AbstractFile ifile) {
        print(ifile.getName());
        List<AbstractFile> children = ifile.getChildren();
        if (children == null) {
            System.out.println();
            return;
        }
        System.out.println(" {");
        ++count;
        for (AbstractFile file : children) {
            printTree(file);
        }
        --count;
        println("}");
    }
}

abstract class AbstractFile {
    protected String name;

    public String getName() {
        return name;
    }

    public abstract boolean addChild(AbstractFile file);

    public abstract boolean removeChild(AbstractFile file);

    public abstract List<AbstractFile> getChildren();
}

class File extends AbstractFile {
    public File(String name) {
        this.name = name;
    }

    @Override
    public boolean addChild(AbstractFile file) {
        return false;
    }

    @Override
    public boolean removeChild(AbstractFile file) {
        return false;
    }

    @Override
    public List<AbstractFile> getChildren() {
        return null;
    }
}

class Folder extends AbstractFile {
    private List<AbstractFile> childList;

    public Folder(String name) {
        this.name = name;
        this.childList = new ArrayList<>();
    }

    @Override
    public boolean addChild(AbstractFile file) {
        return childList.add(file);
    }

    @Override
    public boolean removeChild(AbstractFile file) {
        return childList.remove(file);
    }

    @Override
    public List<AbstractFile> getChildren() {
        return childList;
    }
}