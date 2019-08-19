package apparel.parser;

import parser.DatasetParser;

public class ApparelParser extends DatasetParser {

    public ApparelParser() {
        super();
        addAttributes();
    }

    private void addAttributes() {
        Integer index = 0;
        attributes.put("shirt:white", index++);
        attributes.put("shirt:navy", index++);
        attributes.put("shirt:gray", index++);
        attributes.put("shirt:blue", index++);
        attributes.put("shirt:lilac", index++);
        attributes.put("pants:white", index++);
        attributes.put("pants:black", index++);
        attributes.put("pants:navy", index++);
        attributes.put("pants:gray", index++);
        attributes.put("pants:brown", index++);
        attributes.put("shoes:white", index++);
        attributes.put("shoes:black", index++);
        attributes.put("shoes:navy", index++);
        attributes.put("shoes:gray", index++);
        attributes.put("shoes:brown", index++);
    }

}