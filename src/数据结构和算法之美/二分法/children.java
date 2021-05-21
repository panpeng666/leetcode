package 数据结构和算法之美.二分法;

public class children {
    String columnTitle;
    String dataTypeVer;
    String fromType;
    String hasChild;
    String id;
    String isCustomValue;
    String isLeaf;
    String sequence;
    String title;
    String type;
    children children;

    public String getColumnTitle() {
        return columnTitle;
    }

    public void setColumnTitle(String columnTitle) {
        this.columnTitle = columnTitle;
    }

    public String getDataTypeVer() {
        return dataTypeVer;
    }

    public void setDataTypeVer(String dataTypeVer) {
        this.dataTypeVer = dataTypeVer;
    }

    public String getFromType() {
        return fromType;
    }

    public void setFromType(String fromType) {
        this.fromType = fromType;
    }

    public String getHasChild() {
        return hasChild;
    }

    public void setHasChild(String hasChild) {
        this.hasChild = hasChild;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsCustomValue() {
        return isCustomValue;
    }

    public void setIsCustomValue(String isCustomValue) {
        this.isCustomValue = isCustomValue;
    }

    public String getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public 数据结构和算法之美.二分法.children getChildren() {
        return children;
    }

    public void setChildren(数据结构和算法之美.二分法.children children) {
        this.children = children;
    }


    public static void main(String[] args) {
        数据结构和算法之美.二分法.children children = new children();

    }
}
