package com.fatto.android.ui.retrofit.api.model;

import java.util.List;

/**
 * TODO
 *
 * @author fattoliu
 * @version V 1.0
 * @date 17/2/8 14:43.
 */

public class TngouCook {

    private boolean status;
    private int total;

    private List<TngouBean> tngou;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<TngouBean> getTngou() {
        return tngou;
    }

    public void setTngou(List<TngouBean> tngou) {
        this.tngou = tngou;
    }

    @Override
    public String toString() {
        return "TngouCook{" +
                "status=" + status +
                ", total=" + total +
                ", tngou=" + tngou +
                '}';
    }

    public static class TngouBean {
        private int count;
        private String description;
        private int fcount;
        private String food;
        private int id;
        private String images;
        private String img;
        private String keywords;
        private String name;
        private int rcount;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getFcount() {
            return fcount;
        }

        public void setFcount(int fcount) {
            this.fcount = fcount;
        }

        public String getFood() {
            return food;
        }

        public void setFood(String food) {
            this.food = food;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRcount() {
            return rcount;
        }

        public void setRcount(int rcount) {
            this.rcount = rcount;
        }

        @Override
        public String toString() {
            return "\nTngouBean{" +
                    "\n     count=" + count +
                    ", \n   description='" + description + '\'' +
                    ", \n   fcount=" + fcount +
                    ", \n   food='" + food + '\'' +
                    ", \n   id=" + id +
                    ", \n   images='" + images + '\'' +
                    ", \n   img='" + img + '\'' +
                    ", \n   keywords='" + keywords + '\'' +
                    ", \n   name='" + name + '\'' +
                    ", \n   rcount=" + rcount + "\n" +
                    '}';
        }
    }
}
