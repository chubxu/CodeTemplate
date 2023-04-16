package org.chubxu.helloworld.factory.bean;

public class FirstBean {
    private int attributes;
    public FirstBean() {
    }

    public FirstBean(int attributes) {
        this.attributes = attributes;
    }

    public int getAttributes() {
        return attributes;
    }

    public void setAttributes(int attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "FirstBean{" +
                "attributes=" + attributes +
                '}';
    }
}
