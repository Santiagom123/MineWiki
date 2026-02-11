package com.santiagom123.minewiki.utils;

public class ModData {

    public static ActItemID actItemID = new ActItemID();

    public static class ActItemID {
        private String itemID;

        public void SetID(String id) {
            this.itemID = id;
        }

        public String getID() {
            return this.itemID;
        }
    }
}
