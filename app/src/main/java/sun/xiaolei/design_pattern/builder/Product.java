package sun.xiaolei.design_pattern.builder;

import android.content.Context;

/*
 * @author sun
 * description:建造者模式
 */
public class Product {

    private Context context;

    private String name;

    public Product(Context context, String name) {
        this.context = context;
        this.name = name;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Builder {

        private Context context;

        private String name = "default";

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Product create() {
            Product product = new Product(context, name);
            return product;
        }
    }
}
