package com.example.maheen.projectsmd;

import java.io.Serializable;
/**
 * Created by mahaamjad on 01/05/2017.
 */

public class prepareItem implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        private String name;

        private String description;

        private String imageName;

        private boolean isSelected;


        public prepareItem() {

        }

        public prepareItem(String name, String description) {

            this.name = name;
            this.description = description;

        }

        public prepareItem(String name, String description, boolean isSelected) {

            this.name = name;
            this.description = description;
            this.isSelected = isSelected;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }



        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean isSelected) {
            this.isSelected = isSelected;
        }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}




