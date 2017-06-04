package me.wuwenbin.pojo.ztree;

/**
 * zTree树对象，如果需要额外的自定义属性，可继承此类
 * Created by wuwenbin on 2017/6/4.
 */
public class Ztree {

    protected String id;
    protected String pId;
    protected String name;
    protected String url;
    protected String target;
    protected String rel;
    protected boolean open;
    protected boolean isHidden;
    protected boolean isParent;
    protected String click;
    protected boolean checked;
    protected boolean halfCheck;
    protected String selfId;
    protected boolean nocheck;
    protected String resourceId;
    protected String iconOpen;
    protected String iconClose;
    protected String icon;
    protected boolean noR;

    protected boolean drag;//是否允许拖拽
    protected boolean childOuter;//是否允许子节点移走
    protected boolean dropInner;//是否允许成为父节点
    protected boolean dropRoot;//是否允许成为根节点
    protected boolean childOrder;//是否允许子节点排序/增加

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public boolean isParent() {
        return isParent;
    }

    public void setParent(boolean parent) {
        isParent = parent;
    }

    public String getClick() {
        return click;
    }

    public void setClick(String click) {
        this.click = click;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isHalfCheck() {
        return halfCheck;
    }

    public void setHalfCheck(boolean halfCheck) {
        this.halfCheck = halfCheck;
    }

    public String getSelfId() {
        return selfId;
    }

    public void setSelfId(String selfId) {
        this.selfId = selfId;
    }

    public boolean isNocheck() {
        return nocheck;
    }

    public void setNocheck(boolean nocheck) {
        this.nocheck = nocheck;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getIconOpen() {
        return iconOpen;
    }

    public void setIconOpen(String iconOpen) {
        this.iconOpen = iconOpen;
    }

    public String getIconClose() {
        return iconClose;
    }

    public void setIconClose(String iconClose) {
        this.iconClose = iconClose;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isNoR() {
        return noR;
    }

    public void setNoR(boolean noR) {
        this.noR = noR;
    }

    public boolean isDrag() {
        return drag;
    }

    public void setDrag(boolean drag) {
        this.drag = drag;
    }

    public boolean isChildOuter() {
        return childOuter;
    }

    public void setChildOuter(boolean childOuter) {
        this.childOuter = childOuter;
    }

    public boolean isDropInner() {
        return dropInner;
    }

    public void setDropInner(boolean dropInner) {
        this.dropInner = dropInner;
    }

    public boolean isDropRoot() {
        return dropRoot;
    }

    public void setDropRoot(boolean dropRoot) {
        this.dropRoot = dropRoot;
    }

    public boolean isChildOrder() {
        return childOrder;
    }

    public void setChildOrder(boolean childOrder) {
        this.childOrder = childOrder;
    }
}
