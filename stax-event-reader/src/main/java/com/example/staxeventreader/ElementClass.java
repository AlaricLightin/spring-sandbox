package com.example.staxeventreader;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "element")
@XmlAccessorType(XmlAccessType.NONE)
public class ElementClass {
    @XmlAttribute(name = "attr")
    private String attr;
    @XmlAttribute(name = "secAttr")
    private String secAttr;
    @XmlElement(name = "subElement")
    private String subElementText;

    public String getAttr() {
        return attr;
    }

    public String getSecAttr() {
        return secAttr;
    }

    public String getSubElementText() {
        return subElementText;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public void setSecAttr(String secAttr) {
        this.secAttr = secAttr;
    }

    public void setSubElementText(String subElementText) {
        this.subElementText = subElementText;
    }

    @Override
    public String toString() {
        return "ElementClass{" +
                "attr='" + attr + '\'' +
                ", secAttr='" + secAttr + '\'' +
                ", subElementText='" + subElementText + '\'' +
                '}';
    }
}
